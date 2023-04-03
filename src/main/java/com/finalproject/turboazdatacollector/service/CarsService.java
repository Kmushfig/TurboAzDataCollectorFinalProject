package com.finalproject.turboazdatacollector.service;

import com.finalproject.turboazdatacollector.dtoCars.CarsDTO;
import com.finalproject.turboazdatacollector.jSoup.CarsJsoup;
import com.finalproject.turboazdatacollector.repository.CarsRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class CarsService {
    private final CarsRepository carsRepository;
    private final CarsJsoup carsJsoup;


    public String  saveServiceCarsOfDatas() throws IOException {

        CarsDTO carsDTO = carsJsoup.jsoupDatas();

        return "Problem solved";
    }
}
