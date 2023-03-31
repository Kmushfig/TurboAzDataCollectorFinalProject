package com.finalproject.turboazdatacollector.jSoup;

import com.finalproject.turboazdatacollector.dtoCars.DatasDTO;
import com.finalproject.turboazdatacollector.entity.DatasEntity;
import com.finalproject.turboazdatacollector.entity.ModelEntity;
import com.finalproject.turboazdatacollector.repository.DatasRepository;
import com.finalproject.turboazdatacollector.repository.ModelRepository;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class DatasJsoup {
    private final DatasRepository datasRepository;

    @Autowired
    private ModelRepository modelRepository;

    public DatasDTO jsoupDatas() throws IOException {

        DatasDTO datasDTO = new DatasDTO();
//        HashMap<String, String> carIds = new HashMap<>();

        for (int j = 1; j < 2; j++) {

            Document doc = Jsoup.connect("https://turbo.az/autos?page=" + j).get();
            Elements productName = doc.getElementsByClass("products-i");

            for (Element product : productName) {


                Elements carName = product.getElementsByClass("products-i__name products-i__bottom-text");

                // modeli gətir - bmw, mercedes, sən girib baxıram model table-də id-si neçədir
                String modelText = "Bmw";
                ModelEntity modelEntity = modelRepository.findByModelName(modelText);

                Elements price = product.getElementsByClass("products-i__price products-i__bottom-text");
                Elements dateTimeAndPlace = product.getElementsByClass("products-i__datetime");
                Elements attributes = product.getElementsByClass("products-i__attributes products-i__bottom-text");
                String[] atribittooSplittoo = attributes.get(0).text().split(", ");
                String year = atribittooSplittoo[0];
                String engine = atribittooSplittoo[1];
                String odoMetr = atribittooSplittoo[2];

//                datasOfCarsDTO.setMadelId();  ?????????
                datasDTO.setMakeAndModelName(carName.text());
                datasDTO.setModelId(modelEntity);
                datasDTO.setProductionYear(year);
                datasDTO.setEngine(engine);
                datasDTO.setOdometer(odoMetr);
                datasDTO.setPrice("123123");
                datasDTO.setDateTimeAndPlace(String.valueOf(dateTimeAndPlace));

                DatasEntity datasEntity = DatasEntity.builder()
                        .modelId(datasDTO.getModelId())
                        .makeAndModelName(datasDTO.getMakeAndModelName())
                        .productionYear(datasDTO.getProductionYear())
                        .engine(datasDTO.getEngine())
                        .odometer(datasDTO.getOdometer())
                        .price(datasDTO.getPrice())
                        .dateTimeAndPlace(datasDTO.getDateTimeAndPlace())
                        .build();

                datasRepository.save(datasEntity);


            }
//
        }
        return datasDTO;
    }

}
