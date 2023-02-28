package com.finalproject.turboazdatacollector.repository;

import com.finalproject.turboazdatacollector.entity.CarsofEntity;
import com.finalproject.turboazdatacollector.entity.ModelIdEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatasOfCarsRepository extends JpaRepository<CarsofEntity, String> {

}
