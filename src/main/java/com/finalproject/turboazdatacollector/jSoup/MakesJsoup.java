package com.finalproject.turboazdatacollector.jSoup;

import com.finalproject.turboazdatacollector.dtoCars.MakesDTO;
import com.finalproject.turboazdatacollector.entity.MakesEntity;
import com.finalproject.turboazdatacollector.entity.ModelEntity;
import com.finalproject.turboazdatacollector.repository.MakesRepository;
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
public class MakesJsoup {

    private final MakesRepository makesRepository;
    @Scheduled(fixedRate = 3000)
    public MakesDTO jsoupMakesId() throws IOException {
        MakesDTO makesDTO = new MakesDTO();

        HashMap<String, String> makes = new HashMap<>();

        Document doc = Jsoup.connect("https://turbo.az/").get();
        Elements make = doc.getElementsByClass("js-search-select-make").select("option");

        for (Element carMake : make) {
            makesDTO.setMakeName(carMake.text());
            makesDTO.setMakeId(carMake.val());

            MakesEntity makesEntity = MakesEntity.builder()
                    .makeName(makesDTO.getMakeName())
                    .makeId(makesDTO.getMakeId())
                    .build();
            makesRepository.save(makesEntity);
        }
        return makesDTO;
    }
}
