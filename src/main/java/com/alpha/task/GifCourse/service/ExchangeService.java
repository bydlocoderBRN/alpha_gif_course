package com.alpha.task.GifCourse.service;


import com.alpha.task.GifCourse.Exceptions.ExchangeRateException;
import com.alpha.task.GifCourse.dto.ExchangeCodesDto;
import com.alpha.task.GifCourse.dto.ExchangeDto;
import org.springframework.stereotype.Service;

import java.util.Map;


public interface ExchangeService {

    ExchangeDto getCourseNow(String curr) throws ExchangeRateException;
    ExchangeDto getCourseYesterday(String curr) throws ExchangeRateException;
    Map<String,String> getCodes() throws ExchangeRateException;
}
