package com.finalproject.turboazdatacollector.repository;

import com.finalproject.turboazdatacollector.entity.MakesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface MakesRepository extends JpaRepository <MakesEntity, String> {
    ArrayList<MakesEntity> findAllByMakeName(String dtoMakeName);
}
