package com.finalproject.turboazdatacollector.repository;

import com.finalproject.turboazdatacollector.entity.ModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ModelRepository extends JpaRepository <ModelEntity, String>{
}
