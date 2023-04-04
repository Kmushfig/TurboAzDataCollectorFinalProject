package com.finalproject.turboazdatacollector.service;

import com.finalproject.turboazdatacollector.dtoCars.MakesDTO;
import com.finalproject.turboazdatacollector.entity.MakesEntity;
import com.finalproject.turboazdatacollector.jSoup.MakesJsoup;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class MakesService {

    private final MakesJsoup makesJsoup;
    private final MakesEntity makesEntity;

    public String saveServiceMakes() throws IOException {
        MakesDTO makesDTO = makesJsoup.jsoupMakesId();
        return "Problem solved";
    }
}

