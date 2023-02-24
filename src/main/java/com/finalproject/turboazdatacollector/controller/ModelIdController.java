package com.finalproject.turboazdatacollector.controller;

import com.finalproject.turboazdatacollector.entity.ModelIdEntity;
import com.finalproject.turboazdatacollector.service.ModelIdService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("turbo/")
@RequiredArgsConstructor

public class ModelIdController {

    private final ModelIdService modelIdService;

    @GetMapping("turboaz.data")
    public ModelIdEntity addNewData() throws IOException {
        return modelIdService.saveServiceModelId();
    }


}
