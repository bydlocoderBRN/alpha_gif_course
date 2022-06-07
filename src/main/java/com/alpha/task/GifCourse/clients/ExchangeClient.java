package com.alpha.task.GifCourse.clients;

import com.alpha.task.GifCourse.dto.ExchangeCodesDto;
import com.alpha.task.GifCourse.dto.ExchangeDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "exchangeClient", url = "${feign.url.exchangeAPI}")
@PropertySource("classpath:application.properties")
public interface ExchangeClient {

    @GetMapping("${feign.url.exchangeAPI.dateUrl}")
    ExchangeDto getCourse(@RequestParam(name = "date") String date,
                          @RequestParam(name = "currencies") String curr,
                          @RequestParam("source") String source,
                          @RequestHeader(name = "apikey") String apikey);


    @GetMapping("${feign.url.exchangeAPI.listURL}")
    ExchangeCodesDto getCodes(@RequestHeader(name = "apikey") String apikey);
}
