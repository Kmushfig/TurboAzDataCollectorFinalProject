package com.finalproject.turboazdatacollector.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table (name = "model_names")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ModelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String modelId;
    private String modelName;
    private int makeNumber;

}
