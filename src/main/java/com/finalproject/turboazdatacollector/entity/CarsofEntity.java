package com.finalproject.turboazdatacollector.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "turbo_cars")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarsofEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int makeId;
    //    private int modelId;
    private String makeAndModelName;
    //    private String modelName;
    private int year;
    private int price;
    private int odometer;
    private double engine;
    private String dateTimeAndPlace;




}
