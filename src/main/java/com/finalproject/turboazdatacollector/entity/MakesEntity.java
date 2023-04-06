package com.finalproject.turboazdatacollector.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Entity
@Component
@Data
@Table(name = "Turbo makes")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MakesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String makeName;
    private String makeId;
}
