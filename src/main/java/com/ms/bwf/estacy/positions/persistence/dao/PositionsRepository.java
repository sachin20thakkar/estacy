package com.ms.bwf.estacy.positions.persistence.dao;

import com.ms.bwf.estacy.positions.persistence.entity.PositionData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PositionsRepository extends CrudRepository<PositionData, String> {
    List<PositionData> findByManagerId(String loginId);
    List<PositionData> findAll();
    List<PositionData> findByCity(String city);
}
