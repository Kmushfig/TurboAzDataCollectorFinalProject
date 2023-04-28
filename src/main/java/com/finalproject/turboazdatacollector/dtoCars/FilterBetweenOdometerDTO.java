package com.finalproject.turboazdatacollector.dtoCars;

import lombok.Data;

@Data
public class FilterBetweenOdometerDTO {
//    @NotBlank(message = "/Zehmet olmasa yuruyusu duzgun daxil edin.")
    private Long minKm;
//    @NotBlank(message = "/Zehmet olmasa yuruyusu duzgun daxil edin.")
    private Long maxKm;
}
