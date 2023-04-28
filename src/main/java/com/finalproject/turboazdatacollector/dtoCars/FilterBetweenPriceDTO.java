package com.finalproject.turboazdatacollector.dtoCars;

import lombok.Data;

@Data
public class FilterBetweenPriceDTO {
    private Long minPrice;
    private Long maxPrice;

}
