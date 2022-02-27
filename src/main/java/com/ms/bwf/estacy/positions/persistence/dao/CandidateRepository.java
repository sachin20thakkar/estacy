package com.ms.bwf.estacy.positions.persistence.dao;

import com.ms.bwf.estacy.positions.persistence.entity.CandidateData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateRepository extends CrudRepository<CandidateData, Integer> {
    List<CandidateData> findByPosTrackerId(String trackerId);
}
