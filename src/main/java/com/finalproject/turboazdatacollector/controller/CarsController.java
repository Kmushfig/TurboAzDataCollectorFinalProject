package com.finalproject.turboazdatacollector.controller;

import com.finalproject.turboazdatacollector.service.CarsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("turbo/")
@RequiredArgsConstructor
public class CarsController {

    private final CarsService carsService;

    @GetMapping("cars")
    public String addNewEssentionalData() throws IOException {
        return carsService.saveServiceCarsOfDatas();
    }

}
