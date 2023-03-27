package com.finalproject.turboazdatacollector.repository;

import com.finalproject.turboazdatacollector.entity.ModelIdEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ModelIdRepository extends JpaRepository <ModelIdEntity, String>{
    ArrayList<ModelIdEntity>findAllByModelName(String modelName);
}
