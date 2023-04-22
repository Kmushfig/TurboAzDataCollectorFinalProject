package com.finalproject.turboazdatacollector.controller;

import com.finalproject.turboazdatacollector.dtoCars.FilterMakeNameDTO;
import com.finalproject.turboazdatacollector.entity.MakesEntity;
import com.finalproject.turboazdatacollector.service.MakesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("turbo/")
@RequiredArgsConstructor
public class MakesController {
    private final MakesService makesService;
    @GetMapping("makes")
    public String addNewMakes() throws IOException {
        return makesService.saveServiceMakes();
    }

    @PostMapping("filterMakeName")
    public List<MakesEntity> getFilterMakeNameData(@RequestBody FilterMakeNameDTO dtoMakeName){
        return makesService.filterMakeNameService(dtoMakeName);

    }
}
