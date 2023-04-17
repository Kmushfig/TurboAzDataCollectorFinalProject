package com.finalproject.turboazdatacollector.service;

import com.finalproject.turboazdatacollector.dtoCars.FilterDTO;
import com.finalproject.turboazdatacollector.entity.CarsEntity;
import com.finalproject.turboazdatacollector.jSoup.CarsJsoup;
import com.finalproject.turboazdatacollector.repository.CarsRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.thymeleaf.expression.Objects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
//@Component
public class CarsService {
    private final CarsJsoup carsJsoup;
    private final CarsRepository repository;


    public String  saveServiceCarsOfDatas() throws IOException {

        carsJsoup.jsoupDatas();

        return "Problem solved";
    }

    public List<CarsEntity> filterService(FilterDTO dtoName){
        List<CarsEntity> all = repository.findAllBymakeModelName(dtoName.getFilterName());




          all.stream().filter(str -> str.equals(dtoName)).collect(Collectors.toList());
            return all;


        }

    }

