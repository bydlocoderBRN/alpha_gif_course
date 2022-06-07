package com.alpha.task.GifCourse.Exceptions;

public class GifException extends Exception {
    public int code;
    public GifException(String message, int code){
        super(message);
        this.code = code;
    }

    public int getCode(){return this.code;}
    public void setCode(int code){this.code = code;}
}
