package com.finalproject.turboazdatacollector.jSoup;

import com.finalproject.turboazdatacollector.dtoCars.ModelDTO;
import com.finalproject.turboazdatacollector.entity.ModelEntity;
import com.finalproject.turboazdatacollector.repository.ModelRepositoryy;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class ModelJsoup {

    private final ModelRepositoryy modelRepositoryy;

    public ModelDTO jsoupModelId() throws IOException {

        ModelDTO modelDTO = new ModelDTO();

        HashMap<String, String> modelIds = new HashMap<>();

        Document doc = Jsoup.connect("https://turbo.az/").get();

        Elements options = doc.getElementsByClass("js-search-select-model").select("option");

        for (Element carModel : options) {

            modelDTO.setModelName(carModel.text());
            modelDTO.setModelId(carModel.val());
            modelDTO.setMakeNumber(Integer.parseInt(carModel.attr("class")));

            ModelEntity modelEntity = ModelEntity.builder()
                    .modelId(modelDTO.getModelId())
                    .modelName(modelDTO.getModelName())
                    .makeNumber(modelDTO.getMakeNumber())
                    .build();

//          String modelName = carModel.text();
//          String modelId = carModel.val();
//          String makeId = carModel.attr("class");

            modelRepositoryy.save(modelEntity);
        }
        return modelDTO;
    }



}
