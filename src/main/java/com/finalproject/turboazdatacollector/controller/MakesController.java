package com.finalproject.turboazdatacollector.controller;

import com.finalproject.turboazdatacollector.service.MakesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("turbo/")
@RequiredArgsConstructor
public class MakesController {
    private final MakesService makesService;
    @GetMapping("/makes")
    public String addNewMakes() throws IOException {
        return makesService.saveServiceMakes();
    }
}
