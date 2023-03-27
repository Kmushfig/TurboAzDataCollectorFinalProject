package com.finalproject.turboazdatacollector.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "turbo_cars")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DatasOfCarsofEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String madelId;
    private String makeId;
    private String makeAndModelName;
    private String year;
    private String price;
    private String odometer;
    private String engine;
    private String dateTimeAndPlace;




}
