package com.finalproject.turboazdatacollector.dtoCars;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class FilterMakeNameDTO {

    @NotNull(message = "bu yeri bos qoymaq olmaz")
    @Min(value = 0, message = "Zehmet olmasa duzgun deyer daxil edin")
    private String filterMakeName;
}
