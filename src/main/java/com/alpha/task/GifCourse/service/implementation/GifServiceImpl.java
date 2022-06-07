package com.alpha.task.GifCourse.service.implementation;

import com.alpha.task.GifCourse.Exceptions.GifException;
import com.alpha.task.GifCourse.dto.FullGif;
import com.alpha.task.GifCourse.dto.Gif;
import com.alpha.task.GifCourse.clients.GifClient;
import com.alpha.task.GifCourse.service.GifService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class GifServiceImpl implements GifService {

    @Autowired
    public GifClient gifClient;

    @Value("${feign.url.gifAPI.key}")
    String apiKey;

    @Override
    public Gif getGoodGif() throws GifException {
        FullGif recivedGif = gifClient.getRandGif(apiKey,"rich");
            if (recivedGif.data != null) {
                Gif gifData = recivedGif.data;
                if (gifData.getType().equals("gif")) {
                    return gifData;
                }else throw new GifException("Сервис вернул не гифку: " + recivedGif.meta.getMsg(), recivedGif.meta.getStatus());
            }else throw new GifException("Гифка не найдена: " + recivedGif.meta.getMsg(), recivedGif.meta.getStatus());
    }

    @Override
    public Gif getBadGif() throws GifException{
        FullGif recivedGif = gifClient.getRandGif(apiKey,"broke");
            if (recivedGif.data != null) {
                Gif gifData = recivedGif.data;
                if (gifData.getType().equals("gif")) {
                    return gifData;
                }else throw new GifException("Сервис вернул не гифку: " + recivedGif.meta.getMsg(), recivedGif.meta.getStatus());
            }else throw new GifException("Гифка не найдена: " + recivedGif.meta.getMsg(), recivedGif.meta.getStatus());
    }

}
