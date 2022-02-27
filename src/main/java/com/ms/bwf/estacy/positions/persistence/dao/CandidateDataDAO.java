package com.ms.bwf.estacy.positions.persistence.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ms.bwf.estacy.positions.model.CandidateProfile;
import com.ms.bwf.estacy.positions.model.CandidateProfileWrapper;
import com.ms.bwf.estacy.positions.model.PositionDetails;
import com.ms.bwf.estacy.positions.persistence.entity.CandidateData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.net.URL;

@Component
@Slf4j
public class CandidateDataDAO {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public CandidateData addCandidateResumeToPosition(CandidateData candidateProfile){
        log.info("Candidate Resume Added successfully to position id {}", candidateProfile.getPosTrackerId());
        return candidateProfile;
    }

    public CandidateProfileWrapper fetchAllResumeByPositionId(String trackerId) throws IOException {

        log.info("Querying database to retrieve all resume for position id {}", trackerId);
        URL url = getClass().getResource("/stubs/RetrieveAllResumeData.json");
        File file = new File(url.getPath());
        return objectMapper.readValue(file, CandidateProfileWrapper.class);
    }
}
