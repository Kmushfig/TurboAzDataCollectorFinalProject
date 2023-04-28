package com.finalproject.turboazdatacollector.controller;


import com.finalproject.turboazdatacollector.dtoCars.*;
import com.finalproject.turboazdatacollector.entity.CarsEntity;
import com.finalproject.turboazdatacollector.service.CarsService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("turbo/")
@SecurityRequirement(name = "Bearer Authentication")
@RequiredArgsConstructor
public class CarsController {

    private final CarsService carsService;

    @GetMapping("cars")
    public String addNewEssentionalData() throws IOException {
        return carsService.saveServiceCarsOfDatas();
    }

    @PostMapping("filter-make-model-name")
    public List<CarsEntity> getFilterData(@RequestBody FilterMakeModelDTO dtoName){
        return carsService.filterMakeModelNameService(dtoName);
    }
    @GetMapping("/get-all")
    public List<CarsEntity> getAllCont(){
        return carsService.getAll();
    }

    @PostMapping("/filter-between-price")
    public List<CarsEntity> getAllBetweenPrice(@RequestBody FilterBetweenPriceDTO dtoPrice){
        return carsService.getElementsByPrice(dtoPrice);
    }
    @PostMapping("/filter-between-odometer")
    public List<CarsEntity> getAllBetweenOdometer(@RequestBody FilterBetweenOdometerDTO dtoOdometerKm){
        return carsService.getElementsByOdometer(dtoOdometerKm);
    }
    @PostMapping("/filter-between-year")
    public List<CarsEntity> getAllBetweenYear(@RequestBody FilterYearDTO dtoYearyy){
        return carsService.getElementsByYear(dtoYearyy);
    }
    @PostMapping("/filter-between-engine")
    public List<CarsEntity> getAllBetweenEngine(@RequestBody FilterEngineDTO dtoEngine){
        return carsService.getElementsByEngine(dtoEngine);
    }

}
