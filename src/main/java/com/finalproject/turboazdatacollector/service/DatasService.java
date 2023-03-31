package com.finalproject.turboazdatacollector.service;

import com.finalproject.turboazdatacollector.dtoCars.DatasDTO;
import com.finalproject.turboazdatacollector.entity.DatasEntity;
import com.finalproject.turboazdatacollector.jSoup.DatasJsoup;
import com.finalproject.turboazdatacollector.repository.DatasRepository;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class DatasService {
    private final DatasRepository datasRepository;
    private final DatasJsoup datasJsoup;


    public String  saveServiceCarsOfDatas() throws IOException {

        DatasDTO datasDTO = datasJsoup.jsoupDatas();


        return "Problem solved";
    }

    public List<DatasEntity> findAllByMadelId(Long id) {

        return datasRepository.findAllByMadelId(id);
    }

}
