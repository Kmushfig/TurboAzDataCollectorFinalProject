package com.finalproject.turboazdatacollector.jSoup;

import com.finalproject.turboazdatacollector.dtoCars.DatasDTO;
import com.finalproject.turboazdatacollector.entity.ModelEntity;
import com.finalproject.turboazdatacollector.repository.ModelRepositoryy;
import org.hibernate.service.spi.InjectService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class DatasJsoup {

    @Autowired
    private ModelRepositoryy modelRepositoryy;

    public DatasDTO jsoupDatas() throws IOException {

        DatasDTO datasDTO = new DatasDTO();
//        HashMap<String, String> carIds = new HashMap<>();

        for (int j = 1; j < 2; j++) {

            Document doc = Jsoup.connect("https://turbo.az/autos?page=" + j).get();
            Elements productName = doc.getElementsByClass("products-i");

            for (Element product : productName) {


                Elements carName = product.getElementsByClass("products-i__name products-i__bottom-text");

                // modeli gətir - bmw, mercedes, sən girib baxırsan model table-də id-si neçədir
                String modelText = "Bunun turbo az-dan götür";
                ModelEntity modelEntity = modelRepositoryy.findByModeName(modelText);

                Elements price = product.getElementsByClass("products-i__price products-i__bottom-text");
                Elements dateTimeAndPlace = product.getElementsByClass("products-i__datetime");
                Elements attributes = product.getElementsByClass("products-i__attributes products-i__bottom-text");
                String[] atribittooSplittoo = attributes.get(0).text().split(", ");
                String year = atribittooSplittoo[0];
                String engine = atribittooSplittoo[1];
                String odoMetr = atribittooSplittoo[2];

//                datasOfCarsDTO.setMadelId();  ?????????
                datasDTO.setMakeAndModelName(carName.text());
                datasDTO.setMadelId(modelEntity);
                datasDTO.setProductionYear(year);
                datasDTO.setEngine(engine);
                datasDTO.setOdometer(odoMetr);
                datasDTO.setPrice("123123");
                datasDTO.setDateTimeAndPlace(String.valueOf(dateTimeAndPlace));

//                datasOfCarsDTO.setMakeAndModelName(product.getElementsByClass("products-i__name products-i__bottom-text").text());
//                datasOfCarsDTO.setPrice((product.getElementsByClass("products-i__price products-i__bottom-text").text()));
//                datasOfCarsDTO.setDateTimeAndPlace(product.getElementsByClass("products-i__datetime").text());
            }
//
        }
        return datasDTO;
    }

}
