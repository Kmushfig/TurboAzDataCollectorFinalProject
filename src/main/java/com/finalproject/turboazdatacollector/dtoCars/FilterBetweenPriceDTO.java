package com.finalproject.turboazdatacollector.dtoCars;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class FilterBetweenPriceDTO {

    @NotNull(message = "bu yeri bos qoymaq olmaz")
    @Min(value = 0, message = "Zehmet olmasa duzgun deyer daxil edin")
    private Double minPrice;

    @NotNull(message = "bu yeri bos qoymaq olmaz")
    @Min(value = 0, message = "Zehmet olmasa duzgun deyer daxil edin")
    private Double maxPrice;

}
