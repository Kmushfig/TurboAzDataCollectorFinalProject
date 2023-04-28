package com.finalproject.turboazdatacollector.controller;

import com.finalproject.turboazdatacollector.dtoCars.FilterMakeNameDTO;
import com.finalproject.turboazdatacollector.entity.MakesEntity;
import com.finalproject.turboazdatacollector.service.MakesService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("turbo/")
@SecurityRequirement(name = "Bearer Authentication")
@RequiredArgsConstructor
public class MakesController {
    private final MakesService makesService;
    @GetMapping("makes")
    public String addNewMakes() throws IOException {
        return makesService.saveServiceMakes();
    }

    @PostMapping("filter-make-name")
    public List<MakesEntity> getFilterMakeNameData(@RequestBody FilterMakeNameDTO dtoMakeName){
        return makesService.filterMakeNameService(dtoMakeName);

    }
}
