package com.alpha.task.GifCourse.dto;

import org.apache.commons.io.input.ReaderInputStream;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.*;

@JsonTest
class FullGifTest {

    @Autowired
    private JacksonTester<FullGif> gifJacksonTester;

    private final String gifDtoInput =
                         """
                                         {
                                             "data": {
                                                 "type": "gif",
                                                 "id": "dDXxH6Nmit9QZsDFp9",
                                                 "url": "https://giphy.com/gifs/love-money-peace-dDXxH6Nmit9QZsDFp9",
                                                 "slug": "love-money-peace-dDXxH6Nmit9QZsDFp9",
                                                 "bitly_gif_url": "https://gph.is/g/ZY0wxRr",
                                                 "bitly_url": "https://gph.is/g/ZY0wxRr",
                                                 "embed_url": "https://giphy.com/embed/dDXxH6Nmit9QZsDFp9",
                                                 "username": "systaime",
                                                 "source": "https://www.utip.io/systaime",
                                                 "title": "Money Love GIF by systaime",
                                                 "rating": "g",
                                                 "content_url": "",
                                                 "source_tld": "www.utip.io",
                                                 "source_post_url": "https://www.utip.io/systaime",
                                                 "is_sticker": 0,
                                                 "import_datetime": "2021-01-03 20:19:06",
                                                 "trending_datetime": "0000-00-00 00:00:00",
                                                 "images": {
                                                     "fixed_width_still": {
                                                         "height": "200",
                                                         "size": "19607",
                                                         "url": "https://media0.giphy.com/media/dDXxH6Nmit9QZsDFp9/200w_s.gif?cid=6b2d2b89c980e2c1c2defd6396480a28f8edc2dc9c275cb1&rid=200w_s.gif&ct=g",
                                                         "width": "200"
                                                     },
                                                     "preview_gif": {
                                                         "height": "91",
                                                         "size": "48651",
                                                         "url": "https://media0.giphy.com/media/dDXxH6Nmit9QZsDFp9/giphy-preview.gif?cid=6b2d2b89c980e2c1c2defd6396480a28f8edc2dc9c275cb1&rid=giphy-preview.gif&ct=g",
                                                         "width": "91"
                                                     },
                                                     "fixed_height_downsampled": {
                                                         "height": "200",
                                                         "size": "136955",
                                                         "url": "https://media0.giphy.com/media/dDXxH6Nmit9QZsDFp9/200_d.gif?cid=6b2d2b89c980e2c1c2defd6396480a28f8edc2dc9c275cb1&rid=200_d.gif&ct=g",
                                                         "webp": "https://media0.giphy.com/media/dDXxH6Nmit9QZsDFp9/200_d.webp?cid=6b2d2b89c980e2c1c2defd6396480a28f8edc2dc9c275cb1&rid=200_d.webp&ct=g",
                                                         "webp_size": "81786",
                                                         "width": "200"
                                                     },
                                                     "preview": {
                                                         "height": "320",
                                                         "mp4": "https://media0.giphy.com/media/dDXxH6Nmit9QZsDFp9/giphy-preview.mp4?cid=6b2d2b89c980e2c1c2defd6396480a28f8edc2dc9c275cb1&rid=giphy-preview.mp4&ct=g",
                                                         "mp4_size": "33122",
                                                         "width": "320"
                                                     },
                                                     "fixed_height_small": {
                                                         "height": "100",
                                                         "mp4": "https://media0.giphy.com/media/dDXxH6Nmit9QZsDFp9/100.mp4?cid=6b2d2b89c980e2c1c2defd6396480a28f8edc2dc9c275cb1&rid=100.mp4&ct=g",
                                                         "mp4_size": "60691",
                                                         "size": "310789",
                                                         "url": "https://media0.giphy.com/media/dDXxH6Nmit9QZsDFp9/100.gif?cid=6b2d2b89c980e2c1c2defd6396480a28f8edc2dc9c275cb1&rid=100.gif&ct=g",
                                                         "webp": "https://media0.giphy.com/media/dDXxH6Nmit9QZsDFp9/100.webp?cid=6b2d2b89c980e2c1c2defd6396480a28f8edc2dc9c275cb1&rid=100.webp&ct=g",
                                                         "webp_size": "215778",
                                                         "width": "100"
                                                     },
                                                     "downsized": {
                                                         "height": "320",
                                                         "size": "1847601",
                                                         "url": "https://media0.giphy.com/media/dDXxH6Nmit9QZsDFp9/giphy-downsized.gif?cid=6b2d2b89c980e2c1c2defd6396480a28f8edc2dc9c275cb1&rid=giphy-downsized.gif&ct=g",
                                                         "width": "320"
                                                     },
                                                     "fixed_width_downsampled": {
                                                         "height": "200",
                                                         "size": "136955",
                                                         "url": "https://media0.giphy.com/media/dDXxH6Nmit9QZsDFp9/200w_d.gif?cid=6b2d2b89c980e2c1c2defd6396480a28f8edc2dc9c275cb1&rid=200w_d.gif&ct=g",
                                                         "webp": "https://media0.giphy.com/media/dDXxH6Nmit9QZsDFp9/200w_d.webp?cid=6b2d2b89c980e2c1c2defd6396480a28f8edc2dc9c275cb1&rid=200w_d.webp&ct=g",
                                                         "webp_size": "81786",
                                                         "width": "200"
                                                     },
                                                     "fixed_width": {
                                                         "height": "200",
                                                         "mp4": "https://media0.giphy.com/media/dDXxH6Nmit9QZsDFp9/200w.mp4?cid=6b2d2b89c980e2c1c2defd6396480a28f8edc2dc9c275cb1&rid=200w.mp4&ct=g",
                                                         "mp4_size": "157047",
                                                         "size": "915614",
                                                         "url": "https://media0.giphy.com/media/dDXxH6Nmit9QZsDFp9/200w.gif?cid=6b2d2b89c980e2c1c2defd6396480a28f8edc2dc9c275cb1&rid=200w.gif&ct=g",
                                                         "webp": "https://media0.giphy.com/media/dDXxH6Nmit9QZsDFp9/200w.webp?cid=6b2d2b89c980e2c1c2defd6396480a28f8edc2dc9c275cb1&rid=200w.webp&ct=g",
                                                         "webp_size": "444314",
                                                         "width": "200"
                                                     },
                                                     "downsized_still": {
                                                         "height": "320",
                                                         "size": "35563",
                                                         "url": "https://media0.giphy.com/media/dDXxH6Nmit9QZsDFp9/giphy-downsized_s.gif?cid=6b2d2b89c980e2c1c2defd6396480a28f8edc2dc9c275cb1&rid=giphy-downsized_s.gif&ct=g",
                                                         "width": "320"
                                                     },
                                                     "downsized_medium": {
                                                         "height": "400",
                                                         "size": "3901841",
                                                         "url": "https://media0.giphy.com/media/dDXxH6Nmit9QZsDFp9/giphy.gif?cid=6b2d2b89c980e2c1c2defd6396480a28f8edc2dc9c275cb1&rid=giphy.gif&ct=g",
                                                         "width": "400"
                                                     },
                                                     "original_mp4": {
                                                         "height": "400",
                                                         "mp4": "https://media0.giphy.com/media/dDXxH6Nmit9QZsDFp9/giphy.mp4?cid=6b2d2b89c980e2c1c2defd6396480a28f8edc2dc9c275cb1&rid=giphy.mp4&ct=g",
                                                         "mp4_size": "271699",
                                                         "width": "400"
                                                     },
                                                     "downsized_large": {
                                                         "height": "400",
                                                         "size": "3901841",
                                                         "url": "https://media0.giphy.com/media/dDXxH6Nmit9QZsDFp9/giphy.gif?cid=6b2d2b89c980e2c1c2defd6396480a28f8edc2dc9c275cb1&rid=giphy.gif&ct=g",
                                                         "width": "400"
                                                     },
                                                     "preview_webp": {
                                                         "height": "114",
                                                         "size": "38800",
                                                         "url": "https://media0.giphy.com/media/dDXxH6Nmit9QZsDFp9/giphy-preview.webp?cid=6b2d2b89c980e2c1c2defd6396480a28f8edc2dc9c275cb1&rid=giphy-preview.webp&ct=g",
                                                         "width": "114"
                                                     },
                                                     "original": {
                                                         "frames": "78",
                                                         "hash": "3b2bab64ac816d82d66ae792db6aa046",
                                                         "height": "400",
                                                         "mp4": "https://media0.giphy.com/media/dDXxH6Nmit9QZsDFp9/giphy.mp4?cid=6b2d2b89c980e2c1c2defd6396480a28f8edc2dc9c275cb1&rid=giphy.mp4&ct=g",
                                                         "mp4_size": "271699",
                                                         "size": "3901841",
                                                         "url": "https://media0.giphy.com/media/dDXxH6Nmit9QZsDFp9/giphy.gif?cid=6b2d2b89c980e2c1c2defd6396480a28f8edc2dc9c275cb1&rid=giphy.gif&ct=g",
                                                         "webp": "https://media0.giphy.com/media/dDXxH6Nmit9QZsDFp9/giphy.webp?cid=6b2d2b89c980e2c1c2defd6396480a28f8edc2dc9c275cb1&rid=giphy.webp&ct=g",
                                                         "webp_size": "803020",
                                                         "width": "400"
                                                     },
                                                     "original_still": {
                                                         "height": "400",
                                                         "size": "80101",
                                                         "url": "https://media0.giphy.com/media/dDXxH6Nmit9QZsDFp9/giphy_s.gif?cid=6b2d2b89c980e2c1c2defd6396480a28f8edc2dc9c275cb1&rid=giphy_s.gif&ct=g",
                                                         "width": "400"
                                                     },
                                                     "fixed_height_small_still": {
                                                         "height": "100",
                                                         "size": "6932",
                                                         "url": "https://media0.giphy.com/media/dDXxH6Nmit9QZsDFp9/100_s.gif?cid=6b2d2b89c980e2c1c2defd6396480a28f8edc2dc9c275cb1&rid=100_s.gif&ct=g",
                                                         "width": "100"
                                                     },
                                                     "fixed_width_small": {
                                                         "height": "100",
                                                         "mp4": "https://media0.giphy.com/media/dDXxH6Nmit9QZsDFp9/100w.mp4?cid=6b2d2b89c980e2c1c2defd6396480a28f8edc2dc9c275cb1&rid=100w.mp4&ct=g",
                                                         "mp4_size": "49631",
                                                         "size": "310789",
                                                         "url": "https://media0.giphy.com/media/dDXxH6Nmit9QZsDFp9/100w.gif?cid=6b2d2b89c980e2c1c2defd6396480a28f8edc2dc9c275cb1&rid=100w.gif&ct=g",
                                                         "webp": "https://media0.giphy.com/media/dDXxH6Nmit9QZsDFp9/100w.webp?cid=6b2d2b89c980e2c1c2defd6396480a28f8edc2dc9c275cb1&rid=100w.webp&ct=g",
                                                         "webp_size": "215778",
                                                         "width": "100"
                                                     },
                                                     "looping": {
                                                         "mp4": "https://media0.giphy.com/media/dDXxH6Nmit9QZsDFp9/giphy-loop.mp4?cid=6b2d2b89c980e2c1c2defd6396480a28f8edc2dc9c275cb1&rid=giphy-loop.mp4&ct=g",
                                                         "mp4_size": "1464383"
                                                     },
                                                     "downsized_small": {
                                                         "height": "272",
                                                         "mp4": "https://media0.giphy.com/media/dDXxH6Nmit9QZsDFp9/giphy-downsized-small.mp4?cid=6b2d2b89c980e2c1c2defd6396480a28f8edc2dc9c275cb1&rid=giphy-downsized-small.mp4&ct=g",
                                                         "mp4_size": "156812",
                                                         "width": "272"
                                                     },
                                                     "fixed_width_small_still": {
                                                         "height": "100",
                                                         "size": "6932",
                                                         "url": "https://media0.giphy.com/media/dDXxH6Nmit9QZsDFp9/100w_s.gif?cid=6b2d2b89c980e2c1c2defd6396480a28f8edc2dc9c275cb1&rid=100w_s.gif&ct=g",
                                                         "width": "100"
                                                     },
                                                     "fixed_height_still": {
                                                         "height": "200",
                                                         "size": "19607",
                                                         "url": "https://media0.giphy.com/media/dDXxH6Nmit9QZsDFp9/200_s.gif?cid=6b2d2b89c980e2c1c2defd6396480a28f8edc2dc9c275cb1&rid=200_s.gif&ct=g",
                                                         "width": "200"
                                                     },
                                                     "fixed_height": {
                                                         "height": "200",
                                                         "mp4": "https://media0.giphy.com/media/dDXxH6Nmit9QZsDFp9/200.mp4?cid=6b2d2b89c980e2c1c2defd6396480a28f8edc2dc9c275cb1&rid=200.mp4&ct=g",
                                                         "mp4_size": "157047",
                                                         "size": "915614",
                                                         "url": "https://media0.giphy.com/media/dDXxH6Nmit9QZsDFp9/200.gif?cid=6b2d2b89c980e2c1c2defd6396480a28f8edc2dc9c275cb1&rid=200.gif&ct=g",
                                                         "webp": "https://media0.giphy.com/media/dDXxH6Nmit9QZsDFp9/200.webp?cid=6b2d2b89c980e2c1c2defd6396480a28f8edc2dc9c275cb1&rid=200.webp&ct=g",
                                                         "webp_size": "444314",
                                                         "width": "200"
                                                     },
                                                     "480w_still": {
                                                         "url": "https://media0.giphy.com/media/dDXxH6Nmit9QZsDFp9/480w_s.jpg?cid=6b2d2b89c980e2c1c2defd6396480a28f8edc2dc9c275cb1&rid=480w_s.jpg&ct=g",
                                                         "width": "480",
                                                         "height": "480"
                                                     }
                                                 },
                                                 "user": {
                                                     "avatar_url": "https://media3.giphy.com/avatars/systaime/uMoTIzr92us6.gif",
                                                     "banner_image": "https://media3.giphy.com/headers/systaime/Mc27J7GtRHjO.gif",
                                                     "banner_url": "https://media3.giphy.com/headers/systaime/Mc27J7GtRHjO.gif",
                                                     "profile_url": "https://giphy.com/systaime/",
                                                     "username": "systaime",
                                                     "display_name": "systaime",
                                                     "description": "Systaime Loves You",
                                                     "is_verified": true,
                                                     "website_url": "https://direct.me/systaime",
                                                     "instagram_url": "https://instagram.com/systaime"
                                                 }
                                             },
                                             "meta": {
                                                 "msg": "OK",
                                                 "status": 200,
                                                 "response_id": "c980e2c1c2defd6396480a28f8edc2dc9c275cb1"
                                             }
                                         }
                                 """;

    private final String gifDtoInput2 =
            """
                            {
                                "data": {
                                    "type": "gif",
                                    "id": "dDXxH6Nmit9QZsDFp9",
                                    "url": "https://giphy.com/gifs/love-money-peace-dDXxH6Nmit9QZsDFp9",
                                    "slug": "love-money-peace-dDXxH6Nmit9QZsDFp9",
                                    "bitly_gif_url": "https://gph.is/g/ZY0wxRr",
                                    "bitly_url": "https://gph.is/g/ZY0wxRr",
                                    "embed_url": "https://giphy.com/embed/dDXxH6Nmit9QZsDFp9",
                                    "username": "systaime",
                                    "source": "https://www.utip.io/systaime",
                                    "title": "Money Love GIF by systaime",
                                    "rating": "g",
                                    "content_url": "",
                                    "source_tld": "www.utip.io",
                                    "source_post_url": "https://www.utip.io/systaime"},
                                "meta": {
                                    "msg": "OK",
                                    "status": 200,
                                    "response_id": "c980e2c1c2defd6396480a28f8edc2dc9c275cb1"
                                }
                            }
                    """;


    @Test
    void jsonToObj() throws IOException {
        FullGif gifDtoObj = new FullGif(){{
            setData(new Gif(){{
                setType("gif");
                setId("dDXxH6Nmit9QZsDFp9");
                setUrl("https://giphy.com/gifs/love-money-peace-dDXxH6Nmit9QZsDFp9");
                setSlug("love-money-peace-dDXxH6Nmit9QZsDFp9");
                setBitly_gif_url("https://gph.is/g/ZY0wxRr");
                setBitly_url("https://gph.is/g/ZY0wxRr");
                setEmbed_url("https://giphy.com/embed/dDXxH6Nmit9QZsDFp9");
                setUsername("systaime");
                setSource("https://www.utip.io/systaime");
                setTitle("Money Love GIF by systaime");
                setRating("g");
                setContent_url("");
                setSource_tld("www.utip.io");
                setSource_post_url("https://www.utip.io/systaime");

            }});
            setMeta(new GifMeta(){{
                setResponse_id("c980e2c1c2defd6396480a28f8edc2dc9c275cb1");
                setStatus(200);
                setMsg("OK");
            }});
        }};


        FullGif gifFromJson = gifJacksonTester.readObject(new StringReader(gifDtoInput));

        assertEquals(gifDtoObj,gifFromJson);

    }

    @Test
    void objToJson() throws IOException {
        FullGif gifDtoObj = new FullGif(){{
            setData(new Gif(){{
                setType("gif");
                setId("dDXxH6Nmit9QZsDFp9");
                setUrl("https://giphy.com/gifs/love-money-peace-dDXxH6Nmit9QZsDFp9");
                setSlug("love-money-peace-dDXxH6Nmit9QZsDFp9");
                setBitly_gif_url("https://gph.is/g/ZY0wxRr");
                setBitly_url("https://gph.is/g/ZY0wxRr");
                setEmbed_url("https://giphy.com/embed/dDXxH6Nmit9QZsDFp9");
                setUsername("systaime");
                setSource("https://www.utip.io/systaime");
                setTitle("MoneyLoveGIFbysystaime"); //Я убрал все пробелы и табуляции при проверке, так что тут тоже без них
                setRating("g");
                setContent_url("");
                setSource_tld("www.utip.io");
                setSource_post_url("https://www.utip.io/systaime");

            }});
            setMeta(new GifMeta(){{
                setResponse_id("c980e2c1c2defd6396480a28f8edc2dc9c275cb1");
                setStatus(200);
                setMsg("OK");
            }});
        }};

        String jsonGif = gifJacksonTester.write(gifDtoObj).getJson();

        assertEquals(gifDtoInput2.replaceAll("\\s",""), jsonGif);


    }

}