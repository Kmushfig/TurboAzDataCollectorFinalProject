package com.finalproject.turboazdatacollector.controller;

import com.finalproject.turboazdatacollector.entity.ModelEntity;
import com.finalproject.turboazdatacollector.service.ModelService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("turbo/")
@SecurityRequirement(name = "Bearer Authentication")
@RequiredArgsConstructor

public class ModelsController {

    private final ModelService modelService;

    @GetMapping("models")
    public String addNewData() throws IOException {
        return modelService.saveServiceModelId();
    }


}
