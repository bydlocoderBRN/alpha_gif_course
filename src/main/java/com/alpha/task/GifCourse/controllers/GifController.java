package com.alpha.task.GifCourse.controllers;


import com.alpha.task.GifCourse.Exceptions.ExchangeRateException;
import com.alpha.task.GifCourse.Exceptions.GifException;
import com.alpha.task.GifCourse.dto.ExchangeDto;
import com.alpha.task.GifCourse.clients.GifClient;
import com.alpha.task.GifCourse.service.implementation.ExchangeServiceImpl;
import com.alpha.task.GifCourse.service.implementation.GifServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alpha")
public class GifController {



    @Autowired
    GifServiceImpl gifService;

    @Autowired
    ExchangeServiceImpl exService;



    @GetMapping("/exchange_gif/{currencyCode}")
    public ResponseEntity getTest(@PathVariable String currencyCode){

        try {
            if (exService.isRateGain(currencyCode)){
                return new ResponseEntity(gifService.getGoodGif(),HttpStatus.OK);
            }else
                return new ResponseEntity(gifService.getBadGif(),HttpStatus.OK);
        }catch (ExchangeRateException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.valueOf(e.getCode()));
        }catch (GifException e1){return new ResponseEntity(e1.getMessage(),HttpStatus.valueOf(e1.getCode()));}
    }


}
