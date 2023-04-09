package com.finalproject.turboazdatacollector.entity;

//import jakarta.persistence.*;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Turbo_models")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ModelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String modelId;
    private String modelName;
    private String makeId;

}
