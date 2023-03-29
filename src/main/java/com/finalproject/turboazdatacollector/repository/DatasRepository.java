package com.finalproject.turboazdatacollector.repository;

import com.finalproject.turboazdatacollector.entity.DatasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatasRepository extends JpaRepository<DatasEntity, String> {

}
