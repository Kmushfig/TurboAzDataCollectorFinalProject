package com.finalproject.turboazdatacollector.entity;

//import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "Turbo_cars")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
public class CarsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    private String modelId;
//    private String makeId;
    private String makeModelName;
    private String productionYear;
    private String price;
    private String odometer;
    private String engine;
    private String dateTimeAndPlace;
    private String announceId;
}
