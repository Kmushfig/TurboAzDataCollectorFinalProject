package com.finalproject.turboazdatacollector.dtoCars;

import lombok.Data;

@Data
public class FilterYearDTO {
    private Long minProductionYear;
    private Long maxProductionYear;
}

