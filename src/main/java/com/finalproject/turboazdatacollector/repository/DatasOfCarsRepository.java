package com.finalproject.turboazdatacollector.repository;

import com.finalproject.turboazdatacollector.entity.DatasOfCarsofEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatasOfCarsRepository extends JpaRepository<DatasOfCarsofEntity, String> {

}
