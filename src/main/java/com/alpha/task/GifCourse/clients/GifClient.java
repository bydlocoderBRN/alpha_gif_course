package com.alpha.task.GifCourse.clients;


import com.alpha.task.GifCourse.dto.FullGif;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@PropertySource("classpath:application.properties")
@FeignClient(name = "gifClient", url = "${feign.url.gifAPI}")
public interface GifClient {

    @GetMapping("${feign.url.gifAPI.random}")
    FullGif getRandGif(@RequestParam("api_key") String api_key, @RequestParam("tag") String tag);
}
