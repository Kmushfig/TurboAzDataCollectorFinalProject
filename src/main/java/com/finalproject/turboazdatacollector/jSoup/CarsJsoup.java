package com.finalproject.turboazdatacollector.jSoup;

import com.finalproject.turboazdatacollector.dtoCars.CarsDTO;
import com.finalproject.turboazdatacollector.entity.CarsEntity;
import com.finalproject.turboazdatacollector.entity.ModelEntity;
import com.finalproject.turboazdatacollector.repository.CarsRepository;
import com.finalproject.turboazdatacollector.repository.ModelRepository;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
@Component
public class CarsJsoup {
    private final CarsRepository carsRepository;
    private final ModelRepository modelRepository;

    public void jsoupDatas() throws IOException {
//    ArrayList<Integer> id= new ArrayList<>();


//        for (int i = 0; i < 2; i++) {
            ArrayList<ModelEntity> all = (ArrayList<ModelEntity>) modelRepository.findAll();

            for (ModelEntity e : all) {
            String link = "https://turbo.az/autos?q[sort]=&q[make][]=" + e.getMakeId() + "&q[model][]=&q[model][]=" + e.getModelId();

            Document doc = Jsoup.connect(link).get();
            Elements productName = doc.getElementsByClass("products-i");

                for (Element product : productName) {

                CarsDTO carsDTO = new CarsDTO();

                Elements carName = product.getElementsByClass("products-i__name products-i__bottom-text");
                Elements price = product.getElementsByClass("products-i__price products-i__bottom-text");
                Elements dateTimeAndPlace = product.getElementsByClass("products-i__datetime");
                Elements attributes = product.getElementsByClass("products-i__attributes products-i__bottom-text");
                if (!attributes.isEmpty() ){

                String[] split = attributes.get(0).text().split(", ");
                String productionYear = split[0];
                String engine = split[1];
                String odoMetr = split[2];

                carsDTO.setProductionYear(productionYear);
                carsDTO.setEngine(engine);
                carsDTO.setOdometer(odoMetr);
                }
                carsDTO.setMakeModelName(carName.text());
                carsDTO.setPrice((price).text());
                carsDTO.setDateTimeAndPlace((dateTimeAndPlace).text());

                CarsEntity carsEntity = CarsEntity.builder()
                        .makeModelName(carsDTO.getMakeModelName())
                        .productionYear(carsDTO.getProductionYear())
                        .engine(carsDTO.getEngine())
                        .odometer(carsDTO.getOdometer())
                        .price(carsDTO.getPrice())
                        .dateTimeAndPlace(carsDTO.getDateTimeAndPlace())
                        .build();

                carsRepository.save(carsEntity);


                }
            }
        }
    }
