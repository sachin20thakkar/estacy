package com.ms.bwf.estacy.positions.controller;

import com.ms.bwf.estacy.positions.model.CandidateProfile;
import com.ms.bwf.estacy.positions.model.CandidateProfileWrapper;
import com.ms.bwf.estacy.positions.model.PositionDetails;
import com.ms.bwf.estacy.positions.model.PositionDetailsWrapper;
import com.ms.bwf.estacy.positions.services.CandidateProfileService;
import com.ms.bwf.estacy.positions.services.PositionDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping(value = "/fetchAllMyPositions", produces = "application/json")
    public ResponseEntity<PositionDetailsWrapper> handleFetchMyPositionsRequest(){
        return ResponseEntity.ok(positionDetailsService.fetchAllPositions("XXXX"));
    }

    @PostMapping(value = "/addResumeToPosition", consumes = "application/json", produces = "application/json")
    public ResponseEntity<CandidateProfile> handleAddResumeRequest(@RequestBody CandidateProfile candidateProfile){
        return ResponseEntity.ok(candidateProfileService.addResumeToPosition(candidateProfile));
    }

    @PostMapping(value = "/fetchResumeToPosition", consumes = "application/json", produces = "application/json")
    public ResponseEntity<CandidateProfileWrapper> handleFetchResumeRequest(@RequestBody PositionDetails positionDetails){
        return ResponseEntity.ok(candidateProfileService.fetchAllResumeForAPosition(positionDetails));
    }
}
