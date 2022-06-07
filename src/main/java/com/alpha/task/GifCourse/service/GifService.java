package com.alpha.task.GifCourse.service;

import com.alpha.task.GifCourse.Exceptions.GifException;
import com.alpha.task.GifCourse.dto.FullGif;
import com.alpha.task.GifCourse.dto.Gif;
import org.springframework.stereotype.Service;


public interface GifService {
    Gif getGoodGif() throws GifException;
    Gif getBadGif() throws GifException;
}