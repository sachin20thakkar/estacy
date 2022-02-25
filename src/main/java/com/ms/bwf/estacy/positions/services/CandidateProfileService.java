package com.ms.bwf.estacy.positions.services;

import com.ms.bwf.estacy.positions.model.CandidateProfile;
import com.ms.bwf.estacy.positions.model.CandidateProfileWrapper;
import com.ms.bwf.estacy.positions.model.PositionDetails;
import com.ms.bwf.estacy.positions.persistence.dao.CandidateDataDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Slf4j
public class CandidateProfileService {

    private final CandidateDataDAO candidateDataDAO;

    @Autowired
    public CandidateProfileService(CandidateDataDAO candidateDataDAO){
        this.candidateDataDAO = candidateDataDAO;
    }

    public CandidateProfile addResumeToPosition(CandidateProfile candidateProfile){
        return candidateDataDAO.addCandidateResumeToPosition(candidateProfile);
    }

    public CandidateProfileWrapper fetchAllResumeForAPosition(PositionDetails positionDetails){
        try {
            return candidateDataDAO.fetchAllResumeByPositionId(positionDetails);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
