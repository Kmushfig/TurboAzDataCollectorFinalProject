package com.finalproject.turboazdatacollector.service;

import com.finalproject.turboazdatacollector.dtoCars.FilterMakeModelDTO;
import com.finalproject.turboazdatacollector.entity.CarsEntity;
import com.finalproject.turboazdatacollector.jSoup.CarsJsoup;
import com.finalproject.turboazdatacollector.repository.CarsRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
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

    public List<CarsEntity> filterMakeModelNameService(FilterMakeModelDTO dtoMakeModelName){
        List<CarsEntity> all = repository.findAllBymakeModelName(dtoMakeModelName.getFilterMakeModelName());

          all.stream().filter(str -> str.equals(dtoMakeModelName)).collect(Collectors.toList());
            return all;
        }
    public  List<CarsEntity> getAll()  {
        return repository.findAll();
    }

    }

