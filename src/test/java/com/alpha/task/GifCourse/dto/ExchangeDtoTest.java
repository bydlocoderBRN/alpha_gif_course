package com.alpha.task.GifCourse.dto;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

@JsonTest
class ExchangeDtoTest {

    @Autowired
    private JacksonTester<ExchangeDto> exchangeDtoJacksonTester;


    private final String jsonDto = """
            {
                "success": true,
                "historical": true,
                "date": "2022-05-02",
                "timestamp": 1651535999,
                "source": "USD",
                "quotes": {
                    "USDRUB": 70.5922
                }
            }""";

    private final Reader jsonInputStream = new StringReader(jsonDto);

    @Test
    void jsonToObj() throws IOException {

        ExchangeDto dtoObj = new ExchangeDto(){{
            setSuccess(true);
            setHistorical(true);
            setDate("2022-05-02");
            setTimestamp(1651535999L);
            setSource("USD");
            setQuotes(
                    new TreeMap<>() {{
                        put("USDRUB", (float) 70.5922);
                    }});

        }};

        ExchangeDto readDto = exchangeDtoJacksonTester.readObject(jsonInputStream);
        assertEquals(dtoObj,readDto);

    }

    @Test
    void objToJson() throws IOException {
        ExchangeDto dtoObj = new ExchangeDto(){{
            setSuccess(true);
            setHistorical(true);
            setDate("2022-05-02");
            setTimestamp(1651535999L);
            setSource("USD");
            setQuotes(
                    new TreeMap<>() {{
                        put("USDRUB", (float) 70.5922);
                    }});

        }};
        String jsonDtoLocal = exchangeDtoJacksonTester.write(dtoObj).getJson();

        assertEquals(jsonDto.replaceAll("\\s",""),jsonDtoLocal);
    }
}