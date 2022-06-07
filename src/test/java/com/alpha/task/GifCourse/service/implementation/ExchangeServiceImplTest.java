package com.alpha.task.GifCourse.service.implementation;

import com.alpha.task.GifCourse.Exceptions.ExchangeRateException;
import com.alpha.task.GifCourse.clients.ExchangeClient;
import com.alpha.task.GifCourse.dto.ExchangeCodesDto;
import com.alpha.task.GifCourse.dto.ExchangeDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;



import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Map;
import java.util.TreeMap;




@SpringBootTest
class ExchangeServiceImplTest {

    @Autowired
    @InjectMocks
    private ExchangeServiceImpl exchangeService;

    @Mock
    private ExchangeClient exClientMock;

    @Value("${feign.url.exchangeAPI.key}")
    String apikey;

    @Value("${feign.url.exchangeAPI.baseCode}")
    String source;

    @Value("${feign.url.exchangeAPI.timezone}")
    String timezone;

    @BeforeEach
    public void initMocks(){
        MockitoAnnotations.openMocks(this);
    }

    private ExchangeDto getExchangeDtoObject(String quoteKey, float quoteVal, boolean success){
        ExchangeDto testExchangeDto = new ExchangeDto();
        testExchangeDto.setDate("2022-06-06");
        testExchangeDto.setHistorical(true);
        testExchangeDto.setSource("USD");
        testExchangeDto.setSuccess(success);
        testExchangeDto.setTimestamp(123456534L);
        Map<String, Float> quotesMap = new TreeMap<String, Float>();
        quotesMap.put(quoteKey, quoteVal);
        testExchangeDto.setQuotes(quotesMap);
        return testExchangeDto;
    }


    @Test
    void getCourseNowExceptionSuccessFalse()  {

        ExchangeDto testExchangeDtoUnSuccess = getExchangeDtoObject("USDRUB", (float)13.3,false);
        String curr = "RUB";

        LocalDate currentDate = LocalDate.now(ZoneId.of(timezone));
        Mockito.when(exClientMock.getCourse(currentDate.toString(),curr,source,apikey)).thenReturn(testExchangeDtoUnSuccess);
        try {
           ExchangeDto recivedDto = exchangeService.getCourseNow(curr);
           Assertions.fail("Ожидалось исключение");
        }catch (ExchangeRateException e){
            Assertions.assertEquals("Ошибка при получении текущего курса", e.getMessage());
            Assertions.assertEquals(500,e.getCode());
        }

    }

    @Test
    void getCourseNowExceptionNoneReturned()  {

        LocalDate currentDate = LocalDate.now(ZoneId.of(timezone));
        Mockito.when(exClientMock.getCourse(currentDate.toString(),"RUB",source,apikey)).thenReturn(null);
        try {
            ExchangeDto recivedDto = exchangeService.getCourseNow("RUB");
        }catch (ExchangeRateException e){
            Assertions.assertEquals("АПИ ничего не вернул", e.getMessage());
            Assertions.assertEquals(500,e.getCode());
        }
    }

    @Test
    void getCourseNow()  {

        ExchangeDto testExchangeDtoGood = getExchangeDtoObject("USDRUB", (float)13.3,true);

        String curr = "RUB";

        LocalDate currentDate = LocalDate.now(ZoneId.of(timezone));
        Mockito.when(exClientMock.getCourse(currentDate.toString(),curr,source,apikey)).thenReturn(testExchangeDtoGood);
        try {
            ExchangeDto recivedDto = exchangeService.getCourseNow(curr);
            Assertions.assertEquals(testExchangeDtoGood,recivedDto);
        }catch (ExchangeRateException e){
            Assertions.fail("Исключение не ожидалось");
        }

    }

    @Test
    void isRateGain() {
        ExchangeCodesDto codes = new ExchangeCodesDto();
        codes.setSuccess(true);
        Map<String,String> codeMap = new TreeMap<String,String>();
        codeMap.put("RUB","Российский рубль");
        codeMap.put("USD", "Доллар США");
        codes.setCurrencies(codeMap);
        Mockito.when(exClientMock.getCodes(apikey)).thenReturn(codes);

        ExchangeDto nowExchangeDto = getExchangeDtoObject("USDRUB", (float)13.6, true);
        ExchangeDto pastExchangeDto = getExchangeDtoObject("USDRUB", (float)11.6,true);




        String curr = "RUB";

        LocalDate currentDate = LocalDate.now(ZoneId.of(timezone));
        Mockito.when(exClientMock.getCourse(currentDate.toString(),curr,source,apikey)).thenReturn(nowExchangeDto);

        LocalDate pastDate = LocalDate.now(ZoneId.of(timezone)).minusDays(1);
        Mockito.when(exClientMock.getCourse(pastDate.toString(),curr,source,apikey)).thenReturn(pastExchangeDto);

        try {
            boolean isGain = exchangeService.isRateGain("RUB");
            Assertions.assertTrue(isGain);
        }catch (ExchangeRateException e){
            Assertions.fail("Ошибка не ожидалась");
        }
    }

    @Test
    void isRateGainInvalidCurrency() {
        ExchangeCodesDto codes = new ExchangeCodesDto();
        codes.setSuccess(true);
        Map<String,String> codeMap = new TreeMap<String,String>();
        codeMap.put("RUB","Российский рубль");
        codeMap.put("USD", "Доллар США");
        codes.setCurrencies(codeMap);
        Mockito.when(exClientMock.getCodes(apikey)).thenReturn(codes);

        try {
            boolean isGain = exchangeService.isRateGain("asd");
            Assertions.fail("Ожидалась ошибка");
        }catch (ExchangeRateException e){
            Assertions.assertEquals("Неверный код валюты", e.getMessage());
            Assertions.assertEquals(400, e.getCode());
        }
    }
}
