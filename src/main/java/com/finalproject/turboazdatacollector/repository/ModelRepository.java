package com.finalproject.turboazdatacollector.repository;

import com.finalproject.turboazdatacollector.entity.ModelEntity;
import org.dom4j.rule.Mode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


@Repository
public interface ModelRepository extends JpaRepository <ModelEntity, String>{

}
