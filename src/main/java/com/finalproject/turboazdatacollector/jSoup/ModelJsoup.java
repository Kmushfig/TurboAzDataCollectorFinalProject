package com.finalproject.turboazdatacollector.jSoup;

import com.finalproject.turboazdatacollector.dtoCars.ModelDTO;
import com.finalproject.turboazdatacollector.entity.ModelEntity;
import com.finalproject.turboazdatacollector.repository.ModelRepository;
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

    private final ModelRepository modelRepository;

    public ModelDTO jsoupModelId() throws IOException {

        ModelDTO modelDTO = new ModelDTO();

        HashMap<String, String> modelIds = new HashMap<>();

        Document doc = Jsoup.connect("https://turbo.az/").get();

        Elements options = doc.getElementsByClass("js-search-select-model").select("option");
//        Elements options2 = doc.getElementsByClass("select optional form-control js-search-select-make").select("option");

        for (Element carModel : options) {

            modelDTO.setModelName(carModel.text());
            modelDTO.setModelId(carModel.val());
            modelDTO.setMakeNumber(Integer.parseInt(carModel.attr("class")));
            modelDTO.setMakeName(carModel.attr("option"));

            ModelEntity modelEntity = ModelEntity.builder()
                    .modelId(modelDTO.getModelId())
                    .modelName(modelDTO.getModelName())
                    .makeNumber(modelDTO.getMakeNumber())
                    .makeName(modelDTO.getMakeName())
                    .build();

//          String modelName = carModel.text();
//          String modelId = carModel.val();
//          String makeId = carModel.attr("class");

            modelRepository.save(modelEntity);
        }
        return modelDTO;
    }



}
