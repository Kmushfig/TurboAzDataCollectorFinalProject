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
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
@Component
public class CarsJsoup {
    private final CarsRepository carsRepository;
    private final ModelRepository modelRepository;

    @Scheduled(fixedRate = 3000)
    public void jsoupDatas() throws IOException {
        ArrayList<ModelEntity> all = (ArrayList<ModelEntity>) modelRepository.findAll();


        for (int i = 5; i < 6; i++) {

            ModelEntity e = all.get(i);
//            for (ModelEntity e : all) {
            String link = "https://turbo.az/autos?q[sort]=&q[make][]=" + e.getMakeId() + "&q[model][]=&q[model][]=" + e.getModelId();

            Document doc = Jsoup.connect(link).get();
            Elements productName = doc.getElementsByClass("products-i");

            for (Element product : productName) {
                CarsDTO carsDTO = new CarsDTO();

                Elements href = product.getElementsByAttribute("href");
                String link1 = href.attr("abs:href");
                Document document = Jsoup.connect(link1).get();


                //Elanın nömrəsi: 7043450


                Elements carName = product.getElementsByClass("products-i__name products-i__bottom-text");
                String prices = product.getElementsByClass("products-i__price products-i__bottom-text").text();
                Elements dateTimeAndPlace = product.getElementsByClass("products-i__datetime");
                Elements attributes = product.getElementsByClass("products-i__attributes products-i__bottom-text");
                Elements idNumber = document.getElementsByClass("product-actions__id");

                if (!attributes.isEmpty()) {

                    String[] split = attributes.get(0).text().split(", ");
                    Long productionYear = Long.valueOf(split[0]);
                    String enginesp = split[1];
                    String engine = enginesp.replaceAll(" L", "");
                    String odoMetrsp = split[2];
                    String odoMetr1 = odoMetrsp.replaceAll(" km", "");
                    String odoMetr = odoMetr1.replaceAll(" ", "");

                    carsDTO.setProductionYear(productionYear);
                    carsDTO.setEngine(Double.valueOf(engine));
                    carsDTO.setOdometer(Long.valueOf(odoMetr));
                }

                String splitsss = prices.replaceAll(" ", "");
                String priceString = splitsss.replaceAll("\\D", "");
                Double priceDouble = null;

                try {
                    priceDouble = Double.parseDouble(priceString);
                }catch (Exception r){
                priceDouble=null;
                    }


//                System.out.println(priceDouble);


                if (priceDouble != null && splitsss.contains("$")) {
                    priceDouble = priceDouble * 1.7;
                    carsDTO.setPrice(priceDouble);
                } else if (priceDouble != null && splitsss.contains("AZN")) {
                    carsDTO.setPrice(priceDouble);




//                System.out.println(a);?
//                System.out.println(splitsss);
//                String qiynet = splitsss.substring(0,splitsss.length()-3);

//                System.out.println(qiynet);


//                String price = splitsss[0];
//                String pricePart2= splitsss[1];
//                String lastPrice = price+pricePart2;
//                System.out.println(lastPrice);
////                DecimalFormat format = new DecimalFormat("#.##");
////                Double pricesss = Double.parseDouble(format.format(Double.parseDouble(price)));
//                Double lastPrice11 = Double.parseDouble(lastPrice);
//                boolean usd = prices.contains("USD");
//
//                if(usd){
//                    lastPrice11 = lastPrice11 * 1.7;
//                }
////                System.out.println(price1);
//                carsDTO.setPrice(lastPrice11);
//                System.out.println(carsDTO.getPrice());
                    carsDTO.setMakeModelName(carName.text());
                    carsDTO.setDateTimeAndPlace((dateTimeAndPlace).text());
                    carsDTO.setAnnounceId(idNumber.text());


                    CarsEntity carsEntity = CarsEntity.builder()
                            .makeModelName(carsDTO.getMakeModelName())
                            .productionYear(carsDTO.getProductionYear())
                            .engine(carsDTO.getEngine())
                            .odometer(carsDTO.getOdometer())
                            .price(carsDTO.getPrice())
                            .dateTimeAndPlace(carsDTO.getDateTimeAndPlace())
                            .announceId(carsDTO.getAnnounceId())
                            .build();

                    carsRepository.save(carsEntity);

                    if (carsEntity.getEngine() != null || carsEntity.getOdometer() != null ||
                            carsEntity.getProductionYear() != null) {

                        if (carsEntity.getAnnounceId() == null) {
                            carsRepository.save(carsEntity);

                        }
                    }
                }
            }
        }
    }
}