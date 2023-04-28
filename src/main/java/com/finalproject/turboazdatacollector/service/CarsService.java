package com.finalproject.turboazdatacollector.service;

import com.finalproject.turboazdatacollector.dtoCars.*;
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
    public List<CarsEntity> getElementsByPrice(FilterBetweenPriceDTO dtoPrice){
        return repository.findAllByPriceBetween(dtoPrice.getMinPrice(), dtoPrice.getMaxPrice());
    }
    public List<CarsEntity> getElementsByOdometer(FilterBetweenOdometerDTO dtoOdometer){
        return repository.findAllByOdometerBetween(dtoOdometer.getMinKm(), dtoOdometer.getMaxKm());
    }
    public List<CarsEntity> getElementsByYear(FilterYearDTO dtoProductionYear){
        return repository.findAllByYearBetween(dtoProductionYear.getMinProductionYear(), dtoProductionYear.getMaxProductionYear());
    }
    public List<CarsEntity> getElementsByEngine(FilterEngineDTO dtoEngineSize){
        return repository.findAllByEngineBetween(dtoEngineSize.getMinEngine(), dtoEngineSize.getMaxEngine());
    }

    }

