package com.ms.bwf.estacy.positions.services;

import com.ms.bwf.estacy.positions.model.CandidateProfile;
import com.ms.bwf.estacy.positions.model.CandidateProfileWrapper;
import com.ms.bwf.estacy.positions.model.PositionDetails;
import com.ms.bwf.estacy.positions.persistence.dao.CandidateDataDAO;
import com.ms.bwf.estacy.positions.persistence.dao.CandidateRepository;
import com.ms.bwf.estacy.positions.persistence.entity.CandidateData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CandidateProfileService {

    private final CandidateDataDAO candidateDataDAO;
    private final CandidateRepository candidateRepository;

    public CandidateData addResumeToPosition(CandidateData candidateProfile){
        //return candidateDataDAO.addCandidateResumeToPosition(candidateProfile);
        return  candidateRepository.save(candidateProfile);
    }

    public CandidateProfileWrapper fetchAllResumeForAPosition(String trackerId){
        try {
            //return candidateDataDAO.fetchAllResumeByPositionId(trackerId);
            List<CandidateData> candidateData = candidateRepository.findByPosTrackerId(trackerId);
            return new CandidateProfileWrapper(candidateData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
