package com.finalproject.turboazdatacollector.jSoup;

import com.finalproject.turboazdatacollector.dtoCars.ModelDTO;
import com.finalproject.turboazdatacollector.entity.ModelEntity;
import com.finalproject.turboazdatacollector.repository.ModelRepository;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class ModelJsoup {

    private final ModelRepository modelRepository;
    @Scheduled(fixedRate = 3000)

    public ModelDTO jsoupModelId() throws IOException {

        ModelDTO modelDTO = new ModelDTO();

        HashMap<String, String> modelIds = new HashMap<>();

        Document doc = Jsoup.connect("https://turbo.az/").get();

        Elements model = doc.getElementsByClass("js-search-select-model").select("option");

        for (Element carModel : model) {

            modelDTO.setModelName(carModel.text());
            modelDTO.setModelId(carModel.val());
            modelDTO.setMakeId(carModel.attr("class"));

            ModelEntity modelEntity = ModelEntity.builder()
                    .modelId(modelDTO.getModelId())
                    .modelName(modelDTO.getModelName())
                    .makeId(modelDTO.getMakeId())
                    .build();
            modelRepository.save(modelEntity);
        }


        return modelDTO;
    }
}
