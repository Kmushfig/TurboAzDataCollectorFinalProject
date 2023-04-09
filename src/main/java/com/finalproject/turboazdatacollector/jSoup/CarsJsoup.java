package com.finalproject.turboazdatacollector.jSoup;

import com.finalproject.turboazdatacollector.dtoCars.CarsDTO;
import com.finalproject.turboazdatacollector.entity.CarsEntity;
import com.finalproject.turboazdatacollector.repository.CarsRepository;
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
public class CarsJsoup {
    private final CarsRepository carsRepository;

    public CarsDTO jsoupDatas() throws IOException {

        CarsDTO carsDTO = new CarsDTO();
        HashMap<String, String> carIds = new HashMap<>();

        for (int j = 1; j < 2; j++) {

            Document doc = Jsoup.connect("https://turbo.az/autos?page=" + j).get();
            Elements productName = doc.getElementsByClass("products-i");

            for (Element product : productName) {


                Elements carName = product.getElementsByClass("products-i__name products-i__bottom-text");
                Elements price = product.getElementsByClass("products-i__price products-i__bottom-text");
                Elements dateTimeAndPlace = product.getElementsByClass("products-i__datetime");
                Elements attributes = product.getElementsByClass("products-i__attributes products-i__bottom-text");
                String[] atribittooSplittoo = attributes.get(0).text().split(", ");
                String productionYear = atribittooSplittoo[0];
                String engine = atribittooSplittoo[1];
                String odoMetr = atribittooSplittoo[2];

//                carsDTO.setModelId(carsDTO.getModelId());
                carsDTO.setMakeAndModelName(carName.text());
                carsDTO.setProductionYear(productionYear);
                carsDTO.setEngine(engine);
                carsDTO.setOdometer(odoMetr);
                carsDTO.setPrice((price).text());
                carsDTO.setDateTimeAndPlace((dateTimeAndPlace).text());

                CarsEntity carsEntity = CarsEntity.builder()
//                        .modelId(carsDTO.getModelId())
                        .makeAndModelName(carsDTO.getMakeAndModelName())
                        .productionYear(carsDTO.getProductionYear())
                        .engine(carsDTO.getEngine())
                        .odometer(carsDTO.getOdometer())
                        .price(carsDTO.getPrice())
                        .dateTimeAndPlace(carsDTO.getDateTimeAndPlace())
                        .build();

                carsRepository.save(carsEntity);


            }
//
        }
        return carsDTO;
    }

}
