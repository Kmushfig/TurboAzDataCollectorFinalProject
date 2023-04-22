package com.finalproject.turboazdatacollector.repository;

import com.finalproject.turboazdatacollector.entity.CarsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CarsRepository extends JpaRepository<CarsEntity, String> {
    ArrayList<CarsEntity> findAllBymakeModelName(String dtoName);
    ArrayList<CarsEntity> findAll();
}
