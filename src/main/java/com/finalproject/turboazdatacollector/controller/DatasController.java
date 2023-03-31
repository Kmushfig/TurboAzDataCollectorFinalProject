package com.finalproject.turboazdatacollector.controller;

import com.finalproject.turboazdatacollector.dtoCars.DatasDTO;
import com.finalproject.turboazdatacollector.entity.DatasEntity;
import com.finalproject.turboazdatacollector.service.DatasService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("turbo/")
@RequiredArgsConstructor
public class DatasController {

    private final DatasService datasService;

    @GetMapping("turboazinfos")
    public String addNewEssentionalData() throws IOException {
        return datasService.saveServiceCarsOfDatas();
    }

    @GetMapping("model/{id}")
    public List<DatasEntity> getAllByModel(@PathVariable("id") Long id) {
        return datasService.findAllByMadelId(id);
    }
}
