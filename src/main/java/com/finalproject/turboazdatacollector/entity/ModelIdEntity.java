package com.finalproject.turboazdatacollector.entity;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.*;

@Entity
@Data
@Table (name = "model_names")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ModelIdEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String modelId;
    private String modelName;
    private int makeNumber;

}
