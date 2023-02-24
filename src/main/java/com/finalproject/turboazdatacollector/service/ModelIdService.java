package com.finalproject.turboazdatacollector.service;

import com.finalproject.turboazdatacollector.dtoCars.ModelIdDTO;
import com.finalproject.turboazdatacollector.entity.ModelIdEntity;
import com.finalproject.turboazdatacollector.jSoup.ModelIdJsoup;
import com.finalproject.turboazdatacollector.repository.ModelIdRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
    public class ModelIdService {

        private final ModelIdJsoup modelIdJsoup;
        private final ModelIdRepository modelIdRepository;


    public ModelIdEntity saveServiceModelId() throws IOException {

        ModelIdDTO modelIdDTO = modelIdJsoup.jsoupModelId();

        ModelIdEntity modelIdEntity = ModelIdEntity.builder()
                .id(modelIdDTO.getId())
                .modelName(modelIdDTO.getModelName())
                .makeNumber(modelIdDTO.getMakeNumber())
                .build();

        
        return modelIdRepository.save(modelIdEntity);
    }
}
