package com.finalproject.turboazdatacollector.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table (name = "Turbo model names")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ModelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String modelId;
    private String modelName;
    private String makeName;
    private int makeNumber;

}
