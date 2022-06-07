package com.alpha.task.GifCourse.service.implementation;

import com.alpha.task.GifCourse.Exceptions.ExchangeRateException;
import com.alpha.task.GifCourse.dto.ExchangeCodesDto;
import com.alpha.task.GifCourse.dto.ExchangeDto;
import com.alpha.task.GifCourse.clients.ExchangeClient;
import com.alpha.task.GifCourse.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Map;

@Service
public class ExchangeServiceImpl implements ExchangeService {

    @Autowired

    public ExchangeClient exClient;

    @Value("${feign.url.exchangeAPI.key}")
    String apikey;

    @Value("${feign.url.exchangeAPI.baseCode}")
    String source;

    @Value("${feign.url.exchangeAPI.timezone}")
    String timezone;


    @Override
    public ExchangeDto getCourseNow(String curr) throws ExchangeRateException{
        LocalDate currentDate = LocalDate.now(ZoneId.of(timezone));

        ExchangeDto cur = exClient.getCourse(currentDate.toString(),curr,source,apikey);

        if (cur != null){
            if (cur.getSuccess()){
                return cur;
            }else throw new ExchangeRateException("Ошибка при получении текущего курса", 500);
        }else throw new ExchangeRateException("АПИ ничего не вернул", 500);
    }

    @Override
    public ExchangeDto getCourseYesterday(String curr) throws ExchangeRateException {
        LocalDate pastDate = LocalDate.now(ZoneId.of(timezone)).minusDays(1);
        ExchangeDto cur = exClient.getCourse(pastDate.toString(),curr,source,apikey);

        if (cur != null){
            if (cur.getSuccess()){
                return cur;
            }else throw new ExchangeRateException("Ошибка при получении текущего курса", 500);
        }else throw new ExchangeRateException("АПИ ничего не вернул", 500);
    }


    @Override
    public Map<String,String> getCodes() throws ExchangeRateException {
        ExchangeCodesDto fullCodes = exClient.getCodes(apikey);
        if (fullCodes !=null){
            if (fullCodes.isSuccess()){
                return fullCodes.getCurrencies();
            }else throw new ExchangeRateException("Ошибка при получении кодов", 500);
        }else throw new ExchangeRateException("АПИ ничего не вернул", 500);
    }

    public boolean isRateGain(String curr) throws ExchangeRateException{
        try {
            if (getCodes().get(curr)!=null) {
                ExchangeDto nowCur = getCourseNow(curr);
                ExchangeDto lastCur = getCourseYesterday(curr);
                if (nowCur.getQuotes().get(source + curr) >= lastCur.getQuotes().get(source + curr)) {
                    return true;
                } else return false;
            }else throw new ExchangeRateException("Неверный код валюты", 400);
        }catch (ExchangeRateException e){throw e;}

    }
}
