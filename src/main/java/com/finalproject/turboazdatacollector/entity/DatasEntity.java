package com.finalproject.turboazdatacollector.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "turbo_cars")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DatasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "madel_id")
    private ModelEntity model;

    private String makeId;
    private String makeAndModelName;
    private String productionYear;
    private String price;
    private String odometer;
    private String engine;
    private String dateTimeAndPlace;
}
