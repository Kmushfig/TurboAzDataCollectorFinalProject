package com.finalproject.turboazdatacollector.repository;

import com.finalproject.turboazdatacollector.entity.CarsEntity;
import com.finalproject.turboazdatacollector.entity.MakesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CarsRepository extends JpaRepository<CarsEntity, String> {
    ArrayList<CarsEntity> findAllBymakeModelName(String dtoName);
    ArrayList<CarsEntity> findAll();
    ArrayList<CarsEntity> findAllByPriceBetween(Long minPrice, Long maxPrice);
    ArrayList<CarsEntity> findAllByOdometerBetween (Long minKm, Long maxKm);
    ArrayList<CarsEntity> findAllByYearBetween (Long minYear, Long mazYear);

    ArrayList<CarsEntity> findAllByEngineBetween (Double minEngine, Double maxEngine);

}
