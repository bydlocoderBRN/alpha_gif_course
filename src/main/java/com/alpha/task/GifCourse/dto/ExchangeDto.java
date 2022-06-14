package com.alpha.task.GifCourse.dto;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@Data
public class ExchangeDto {
    Boolean success;
    Boolean historical;
    String date;
    Long timestamp;
    String source;
    Map<String,Float> quotes;
    @JsonAnySetter
    public void add(String key, Float val){
        quotes.put(key,val);
    }

}

