//package com.finalproject.turboazdatacollector.jSoup;
//
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//
//public class DatasOfCarsJsoup {
//
//    public void jsoupDatas
//
//    for (int j = 1; j < 2 ; j++) {
//
//    }
//        Document doc = Jsoup.connect("https://turbo.az/autos?page=" + j).get();
//        Elements productName = doc.getElementsByClass("products-i");
//
//        for (Element product : productName) {
//
//            Elements carName = product.getElementsByClass("products-i__name products-i__bottom-text");
//            Elements attributes = product.getElementsByClass("products-i__attributes products-i__bottom-text");
//            String[] atribittooSplittoo = attributes.get(0).text().split(", ");
//            String year = atribittooSplittoo[0];
//            String engine = atribittooSplittoo[1];
//            String odoMetr = atribittooSplittoo[2];
//            Elements price = product.getElementsByClass("products-i__price products-i__bottom-text");
//            Elements dateTimeAndPlace = product.getElementsByClass("products-i__datetime");
//
//
//
//}
