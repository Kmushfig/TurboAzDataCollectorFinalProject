package com.finalproject.turboazdatacollector.service;

import com.finalproject.turboazdatacollector.dtoCars.DatasDTO;
import com.finalproject.turboazdatacollector.entity.DatasEntity;
import com.finalproject.turboazdatacollector.jSoup.DatasJsoup;
import com.finalproject.turboazdatacollector.repository.DatasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class DatasService {
    private final DatasJsoup datasJsoup;
    private final DatasRepository datasRepository;

    public DatasEntity saveServiceCarsOfDatas() throws IOException {

        DatasDTO datasDTO = datasJsoup.jsoupDatas();

        DatasEntity datasEntity = DatasEntity.builder()
                .madelId(datasDTO.getMadelId())
                .makeAndModelName(datasDTO.getMakeAndModelName())
                .productionYear(datasDTO.getProductionYear())
                .engine(datasDTO.getEngine())
                .odometer(datasDTO.getOdometer())
                .price(datasDTO.getPrice())
                .dateTimeAndPlace(datasDTO.getDateTimeAndPlace())
                .build();
        return datasRepository.save(datasEntity);
    }

}
