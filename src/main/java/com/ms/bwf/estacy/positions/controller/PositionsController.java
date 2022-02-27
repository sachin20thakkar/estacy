package com.ms.bwf.estacy.positions.controller;

import com.ms.bwf.estacy.positions.model.CandidateProfile;
import com.ms.bwf.estacy.positions.model.CandidateProfileWrapper;
import com.ms.bwf.estacy.positions.model.PositionDetails;
import com.ms.bwf.estacy.positions.model.PositionDetailsWrapper;
import com.ms.bwf.estacy.positions.persistence.entity.CandidateData;
import com.ms.bwf.estacy.positions.services.CandidateProfileService;
import com.ms.bwf.estacy.positions.services.PositionDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class PositionsController {

    private final PositionDetailsService positionDetailsService;
    private final CandidateProfileService candidateProfileService;

    @Autowired
    public PositionsController(PositionDetailsService positionDetailsService,
                               CandidateProfileService candidateProfileService){
        this.positionDetailsService = positionDetailsService;
        this.candidateProfileService = candidateProfileService;
    }

    @GetMapping(value = "/fetchAllMyPositions/{loginId}")
    public ResponseEntity<PositionDetailsWrapper> handleFetchMyPositionsRequest(@PathVariable String loginId){
        return ResponseEntity.ok(positionDetailsService.fetchAllPositions(loginId));
    }

    @PostMapping(value = "/addResumeToPosition")
    public ResponseEntity<CandidateData> handleAddResumeRequest(@RequestBody CandidateData candidateProfile){
        return ResponseEntity.ok(candidateProfileService.addResumeToPosition(candidateProfile));
    }

    @GetMapping(value = "/fetchResumeToPosition/{trackerId}")
    public ResponseEntity<CandidateProfileWrapper> handleFetchResumeRequest(@PathVariable String trackerId){
        return ResponseEntity.ok(candidateProfileService.fetchAllResumeForAPosition(trackerId));
    }
}
