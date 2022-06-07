package com.alpha.task.GifCourse.dto;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Data;

import java.util.Map;

@Data
public class ExchangeCodesDto {
    boolean success;
    Map<String,String> currencies;

    @JsonAnyGetter
    public Map<String,String> getCurrencies(){
        return currencies;
    }
}
