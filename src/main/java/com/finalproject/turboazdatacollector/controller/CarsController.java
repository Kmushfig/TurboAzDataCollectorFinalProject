package com.finalproject.turboazdatacollector.controller;


import com.finalproject.turboazdatacollector.dtoCars.FilterMakeModelDTO;
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

    @PostMapping("filterMakeModelName")
    public List<CarsEntity> getFilterData(@RequestBody FilterMakeModelDTO dtoName){
        return carsService.filterMakeModelNameService(dtoName);
    }
    @GetMapping("/get-all")
    public List<CarsEntity> getAllCont(){
        return carsService.getAll();
    }
}
