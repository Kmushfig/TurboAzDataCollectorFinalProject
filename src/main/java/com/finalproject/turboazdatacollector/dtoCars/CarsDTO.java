package com.finalproject.turboazdatacollector.dtoCars;

import lombok.Data;

@Data
public class CarsDTO {

    private String makeModelName;
    private String productionYear;
    private String price;
    private Long odometer;
    private Double engine;
    private String dateTimeAndPlace;
    private String announceId;


}
