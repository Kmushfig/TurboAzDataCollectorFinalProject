package com.finalproject.turboazdatacollector.dtoCars;

import com.finalproject.turboazdatacollector.entity.ModelEntity;
import lombok.Data;

@Data
public class DatasDTO {

    private ModelEntity model;
    private String makeAndModelName;
    private String productionYear;
    private String price;
    private String odometer;
    private String engine;
    private String dateTimeAndPlace;


}
