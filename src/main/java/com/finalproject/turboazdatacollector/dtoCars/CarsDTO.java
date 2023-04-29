package com.finalproject.turboazdatacollector.dtoCars;

import lombok.Data;

@Data
public class CarsDTO {

    private String makeModelName;
    private Long productionYear;
    private Double price;
    private Long odometer;
    private Double engine;
    private String dateTimeAndPlace;
    private String announceId;


}
