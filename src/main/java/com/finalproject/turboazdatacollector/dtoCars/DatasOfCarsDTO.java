package com.finalproject.turboazdatacollector.dtoCars;

import lombok.Data;

@Data
public class DatasOfCarsDTO {

    private int moldeId;
//    private int modelId;
    private String makeAndModelName;
//    private String modelName;
    private int year;
    private int price;
    private int odometer;
    private double engine;
    private String dateTimeAndPlace;


}
