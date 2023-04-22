package com.finalproject.turboazdatacollector.service;

import com.finalproject.turboazdatacollector.dtoCars.FilterMakeModelDTO;
import com.finalproject.turboazdatacollector.dtoCars.FilterMakeNameDTO;
import com.finalproject.turboazdatacollector.dtoCars.MakesDTO;
import com.finalproject.turboazdatacollector.entity.CarsEntity;
import com.finalproject.turboazdatacollector.entity.MakesEntity;
import com.finalproject.turboazdatacollector.jSoup.MakesJsoup;
import com.finalproject.turboazdatacollector.repository.MakesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MakesService {

    private final MakesJsoup makesJsoup;
    private final MakesRepository makesRepository;

    public String saveServiceMakes() throws IOException {
        MakesDTO makesDTO = makesJsoup.jsoupMakesId();
        return "Problem solved";
    }
    public List<MakesEntity> filterMakeNameService (FilterMakeNameDTO dtoMakeName){

        List<MakesEntity> all = makesRepository.findAllByMakeName(dtoMakeName.getFilterMakeName());

        all.stream().filter(str -> str.equals(dtoMakeName)).collect(Collectors.toList());
        return all;
    }
}

