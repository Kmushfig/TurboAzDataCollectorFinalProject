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
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class CarsJsoup {
    private final CarsRepository carsRepository;
    private final ModelRepository modelRepository;
    public CarsDTO jsoupDatas() throws IOException {


        CarsDTO carsDTO = new CarsDTO();
        HashMap<String, String> carIds = new HashMap<>();
        ArrayList<ModelEntity> makeIdFromDB = modelRepository.findAllByMakeId();
        ArrayList<ModelEntity> modelIdFromDB = modelRepository.findAllByModelId();
        for (int i = 0; i < makeIdFromDB.size(); i++) {
            for(int j = 0; j< modelIdFromDB.size();j++){

            }
        }
            Document doc = Jsoup.connect("https://turbo.az/autos?q%5Bsort%5D=&q%5Bmake%5D%5B%5D=3&q%5Bmodel%5D%5B%5D=&q%5Bmodel%5D%5B%5D=35").get();
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
        return carsDTO;
    }

}
