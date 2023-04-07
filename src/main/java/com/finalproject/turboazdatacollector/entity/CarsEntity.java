package com.finalproject.turboazdatacollector.entity;

//import jakarta.persistence.*;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Turbo cars")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String modelId;
    private String makeId;
    private String makeAndModelName;
    private String productionYear;
    private String price;
    private String odometer;
    private String engine;
    private String dateTimeAndPlace;
}
