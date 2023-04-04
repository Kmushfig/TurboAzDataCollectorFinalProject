package com.finalproject.turboazdatacollector.repository;

import com.finalproject.turboazdatacollector.entity.MakesEntity;
import com.finalproject.turboazdatacollector.entity.ModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MakesRepository extends JpaRepository <MakesEntity, String> {
}
