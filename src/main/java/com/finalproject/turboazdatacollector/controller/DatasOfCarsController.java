package com.finalproject.turboazdatacollector.controller;

import com.finalproject.turboazdatacollector.entity.DatasOfCarsofEntity;
import com.finalproject.turboazdatacollector.service.DataService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("turbo/")
@RequiredArgsConstructor
public class DatasOfCarsController {

    private final DataService dataService;

    @GetMapping("turboaz.infos")
    public DatasOfCarsofEntity addNewEssentionalData() throws IOException {
        return dataService.saveServiceCarsOfDatas();
    }


}
