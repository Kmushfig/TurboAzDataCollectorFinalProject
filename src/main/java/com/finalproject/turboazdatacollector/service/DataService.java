package com.finalproject.turboazdatacollector.service;

import com.finalproject.turboazdatacollector.dtoCars.DatasOfCarsDTO;
import com.finalproject.turboazdatacollector.entity.DatasOfCarsofEntity;
import com.finalproject.turboazdatacollector.jSoup.DatasOfCarsJsoup;
import com.finalproject.turboazdatacollector.repository.DatasOfCarsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class DataService {
    private final DatasOfCarsJsoup datasOfCarsJsoup;
    private final DatasOfCarsRepository datasOfCarsRepository;

    public DatasOfCarsofEntity saveServiceCarsOfDatas() throws IOException {

        DatasOfCarsDTO datasOfCarsDTO = datasOfCarsJsoup.jsoupDatas();

        DatasOfCarsofEntity datasOfCarsofEntity = DatasOfCarsofEntity.builder()
                .madelId(datasOfCarsDTO.getMadelId())
                .makeAndModelName(datasOfCarsDTO.getMakeAndModelName())
                .year(datasOfCarsDTO.getYear())
                .engine(datasOfCarsDTO.getEngine())
                .odometer(datasOfCarsDTO.getOdometer())
                .price(datasOfCarsDTO.getPrice())
                .dateTimeAndPlace(datasOfCarsDTO.getDateTimeAndPlace())
                .build();
        return datasOfCarsRepository.save(datasOfCarsofEntity);
    }

}
