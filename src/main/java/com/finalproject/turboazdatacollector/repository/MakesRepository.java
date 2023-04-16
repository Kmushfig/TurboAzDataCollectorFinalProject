package com.finalproject.turboazdatacollector.repository;

import com.finalproject.turboazdatacollector.entity.MakesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MakesRepository extends JpaRepository <MakesEntity, String> {
}
