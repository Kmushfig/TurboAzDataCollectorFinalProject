package com.finalproject.turboazdatacollector.service;
import com.finalproject.turboazdatacollector.dtoCars.ModelDTO;
import com.finalproject.turboazdatacollector.jSoup.ModelJsoup;
import com.finalproject.turboazdatacollector.repository.ModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
    public class ModelService {

        private final ModelJsoup modelJsoup;
        private final ModelRepository modelRepository;


    public String saveServiceModelId() throws IOException {

        ModelDTO modelDTO = modelJsoup.jsoupModelId();
        return "Problem solved";
    }

//    String link = "https://turbo.az/autos?q[sort]=&q[make][]=" + a + "&q[model][]=&q[model][]=" + b;

}
