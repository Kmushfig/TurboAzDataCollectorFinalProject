package com.finalproject.turboazdatacollector.controller;


import com.finalproject.turboazdatacollector.dtoCars.FilterDTO;
import com.finalproject.turboazdatacollector.entity.CarsEntity;
import com.finalproject.turboazdatacollector.repository.CarsRepository;
import com.finalproject.turboazdatacollector.service.CarsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("turbo/")
@RequiredArgsConstructor
public class CarsController {

    private final CarsService carsService;
//    private final CarsRepository carsRepository;

    @GetMapping("cars")
    public String addNewEssentionalData() throws IOException {
        return carsService.saveServiceCarsOfDatas();
    }

    @PostMapping("filterName")
    public List<CarsEntity> getFilterData(@RequestBody FilterDTO dtoName){
        return carsService.filterService(dtoName);

    }

}
