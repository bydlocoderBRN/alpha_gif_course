package com.alpha.task.GifCourse.Exceptions;

public class ExchangeRateException extends Exception{

    public int code;
    public ExchangeRateException(String message, int code){
        super(message);
        this.code = code;
    }


    public int getCode(){return this.code;}
    public void setCode(int code){this.code = code;}
}
