package com.finalproject.turboazdatacollector.jSoup;

import com.finalproject.turboazdatacollector.dtoCars.ModelIdDTO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;

@Service
public class ModelIdJsoup {

    public ModelIdDTO jsoupModelId() throws IOException {

        ModelIdDTO modelIdDTO = new ModelIdDTO();

        HashMap<String, String> modelIds = new HashMap<>();

        Document doc = Jsoup.connect("https://turbo.az/").get();

        Elements options = doc.getElementsByClass("js-search-select-model").select("option");

        for (Element carModel : options) {

            modelIdDTO.setModelName(carModel.text());
            modelIdDTO.setId(carModel.val());
            modelIdDTO.setMakeNumber(Integer.parseInt(carModel.attr("class")));


//            String modelName = carModel.text();
//          String modelId = carModel.val();
//          String makeId = carModel.attr("class");

        }
        return modelIdDTO;
    }



}
