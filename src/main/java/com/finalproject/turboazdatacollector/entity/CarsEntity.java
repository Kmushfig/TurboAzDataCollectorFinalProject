package com.finalproject.turboazdatacollector.entity;

//import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "Turbonewcars")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
public class CarsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String makeModelName;
    private String productionYear;
    private String price;
    private Long odometer;
    private Double engine;
    private String dateTimeAndPlace;
    private String announceId;
}
