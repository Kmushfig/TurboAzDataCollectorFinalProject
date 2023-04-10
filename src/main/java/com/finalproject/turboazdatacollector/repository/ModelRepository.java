package com.finalproject.turboazdatacollector.repository;

import com.finalproject.turboazdatacollector.entity.ModelEntity;
import org.h2.engine.Mode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ModelRepository extends JpaRepository <ModelEntity, String>{
//    ArrayList<ModelEntity>findAllByModelName(String modelName);
//    ModelEntity findByModelName(String name);
    ArrayList<ModelEntity> findAllByMakeId();
    ArrayList<ModelEntity> findAllByModelId();
}
