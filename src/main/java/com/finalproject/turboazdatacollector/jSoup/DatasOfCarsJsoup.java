package com.finalproject.turboazdatacollector.jSoup;

import com.finalproject.turboazdatacollector.dtoCars.DatasOfCarsDTO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

@Service
public class DatasOfCarsJsoup {

    public void jsoupDatas() throws IOException {

        DatasOfCarsDTO datasOfCarsDTO = new DatasOfCarsDTO();
//        HashMap<String, String> carIds = new HashMap<>();

        for (int j = 1; j < 2; j++) {

            Document doc = Jsoup.connect("https://turbo.az/autos?page=" + j).get();
            Elements productName = doc.getElementsByClass("products-i");

            for (Element product : productName) {

                datasOfCarsDTO.setMakeAndModelName(product.getElementsByClass("products-i__name products-i__bottom-text").text());
                datasOfCarsDTO.setPrice(Integer.parseInt(product.getElementsByClass("products-i__price products-i__bottom-text").text()));
                datasOfCarsDTO.setDateTimeAndPlace(product.getElementsByClass("products-i__datetime").text());

                datasOfCarsDTO.setYear(Arrays.stream(Arrays.stream(product.getElementsByClass("products-i__attributes products-i__bottom-text")
                        .get(0)
                        .text().split(" ,")).toArray();



//                Elements carName = product.getElementsByClass("products-i__name products-i__bottom-text");
                Elements attributes = product.getElementsByClass("products-i__attributes products-i__bottom-text");
                String[] atribittooSplittoo = attributes.get(0).text().split(", ");
                String year = atribittooSplittoo[0];
                String engine = atribittooSplittoo[1];
                String odoMetr = atribittooSplittoo[2];



                Elements price = product.getElementsByClass("products-i__price products-i__bottom-text");
                Elements dateTimeAndPlace = product.getElementsByClass("products-i__datetime");

            }
        }
    }

}
