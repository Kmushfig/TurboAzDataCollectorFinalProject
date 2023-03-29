package com.finalproject.turboazdatacollector.controller;

import com.finalproject.turboazdatacollector.entity.ModelEntity;
import com.finalproject.turboazdatacollector.service.ModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("turbo/")
@RequiredArgsConstructor

public class ModelsController {

    private final ModelService modelService;

    @GetMapping("turboazdata")
    public ModelEntity addNewData() throws IOException {
        return modelService.saveServiceModelId();
    }


}
