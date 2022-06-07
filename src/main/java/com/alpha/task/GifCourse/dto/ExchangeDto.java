package com.alpha.task.GifCourse.dto;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
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

    @JsonAnyGetter
    public Map<String,Float> getQuotes(){
        return quotes;
    }
}

