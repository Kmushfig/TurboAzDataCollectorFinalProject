package com.finalproject.turboazdatacollector.repository;

import com.finalproject.turboazdatacollector.entity.CarsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarsRepository extends JpaRepository<CarsEntity, String> {
}
