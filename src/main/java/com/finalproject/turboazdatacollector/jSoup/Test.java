package com.finalproject.turboazdatacollector.jSoup;

import com.finalproject.turboazdatacollector.dtoCars.CarsDTO;
import com.finalproject.turboazdatacollector.entity.ModelEntity;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class Test {


    public static void main(String[] args) {
        String prices = "25000 USD";
        String[] splitsss = prices.split(" ");
        String price = splitsss[0];
//                DecimalFormat format = new DecimalFormat("#.##");
//                Double pricesss = Double.parseDouble(format.format(Double.parseDouble(price)));
        Double price1 = Double.parseDouble(price);
        boolean usd = prices.contains("USD");

        if(usd){
            price1 = price1 * 1.7;
            System.out.println(price1);

        }
        System.out.println(price1);
    }

    }