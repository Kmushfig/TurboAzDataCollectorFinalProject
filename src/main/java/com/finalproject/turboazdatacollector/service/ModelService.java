package com.finalproject.turboazdatacollector.service;

import com.finalproject.turboazdatacollector.dtoCars.ModelDTO;
import com.finalproject.turboazdatacollector.entity.ModelEntity;
import com.finalproject.turboazdatacollector.jSoup.ModelJsoup;
import com.finalproject.turboazdatacollector.repository.ModelRepositoryy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
    public class ModelService {

        private final ModelJsoup modelJsoup;
        private final ModelRepositoryy modelRepositoryy;


    public ModelEntity saveServiceModelId() throws IOException {

        ModelDTO modelDTO = modelJsoup.jsoupModelId();

        ModelEntity modelEntity = ModelEntity.builder()
                .modelId(modelDTO.getModelId())
                .modelName(modelDTO.getModelName())
                .makeNumber(modelDTO.getMakeNumber())
                .build();

        
        return modelRepositoryy.save(modelEntity);
    }

    String link = "https://turbo.az/autos?q[sort]=&q[make][]= {***}&q[model][]=&q[model][]={***}";
}
