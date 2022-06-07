package com.alpha.task.GifCourse.service.implementation;

import com.alpha.task.GifCourse.Exceptions.GifException;
import com.alpha.task.GifCourse.clients.GifClient;
import com.alpha.task.GifCourse.dto.FullGif;
import com.alpha.task.GifCourse.dto.Gif;
import com.alpha.task.GifCourse.dto.GifMeta;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;


class GifServiceImplTest {

    @Autowired
    @InjectMocks
    private GifServiceImpl gifService;

    @Mock
    private GifClient gifClientMock;

    @Value("${feign.url.gifAPI.key}")
    String apiKey;

    @BeforeEach
    public void initMocks(){
        MockitoAnnotations.openMocks(this);
    }

    private FullGif getFullGifObject(String tag, String metaMsg, int metaCode, String type){
        FullGif fullGif = new FullGif();

        Gif gif = new Gif();

        GifMeta gifMeta = new GifMeta();


        gif.setBitly_gif_url("https://gph.is/g/aN8PAro");
        gif.setBitly_url("https://gph.is/g/aN8PAro");
        gif.setContent_url("");
        gif.setEmbed_url("https://giphy.com/embed/lRvKtEtkeqMNVUYEPb");
        gif.setRating("g");
        gif.setId("lRvKtEtkeqMNVUYEPb");
        gif.setSlug("cbc-schitts-creek-lRvKtEtkeqMNVUYEPb");
        gif.setSource("http://www.twitter.com/schittscreek");
        gif.setSource_post_url("http://www.twitter.com/schittscreek");
        gif.setSource_tld("www.twitter.com");
        gif.setTitle(tag);
        gif.setType(type);
        gif.setUrl("https://giphy.com/gifs/cbc-schitts-creek-lRvKtEtkeqMNVUYEPb");
        gif.setUsername("cbc");


        gifMeta.setMsg(metaMsg);
        gifMeta.setStatus(metaCode);
        gifMeta.setResponse_id("fksjdlfasdas");

        fullGif.setData(gif);
        fullGif.setMeta(gifMeta);
        return fullGif;
    }


    @Test
    void getGoodGif() {

        FullGif fullGif = getFullGifObject("rich", "OK", 200, "gif");
        Mockito.when(gifClientMock.getRandGif(apiKey,"rich")).thenReturn(fullGif);

        try {
            Gif gif = gifService.getGoodGif();
            Assertions.assertEquals(fullGif.getData(),gif);
        }catch (GifException e){
            Assertions.fail("Ошибка не ожидалась");
        }

    }

    @Test
    void getGoodGifNullGif() {

        FullGif fullGifWithNullData = getFullGifObject("rich", "OK", 524, "gif");
        fullGifWithNullData.setData(null);

        Mockito.when(gifClientMock.getRandGif(apiKey,"rich")).thenReturn(fullGifWithNullData);

        try {
            Gif gif = gifService.getGoodGif();
            Assertions.fail("Ожидалась ошибка");
        }catch (GifException e){
            Assertions.assertEquals("Гифка не найдена: " + fullGifWithNullData.meta.getMsg(),e.getMessage());
            Assertions.assertEquals(524, e.getCode());
        }

    }

    @Test
    void getGoodNotAGif() {

        FullGif fullGifNotAGif = getFullGifObject("rich", "OK", 777, "notGIF");
        Mockito.when(gifClientMock.getRandGif(apiKey,"rich")).thenReturn(fullGifNotAGif);

        try {
            Gif gif = gifService.getGoodGif();
            Assertions.fail("Ошибка ожидалась");
        }catch (GifException e){
            Assertions.assertEquals("Сервис вернул не гифку: " + fullGifNotAGif.meta.getMsg(),e.getMessage());
            Assertions.assertEquals(777, e.getCode());
        }

    }
}