package com.ms.bwf.estacy.review.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ms.bwf.estacy.review.controller.Manager.ConsultantReviewManager;
import com.ms.bwf.estacy.review.jpa.entity.ConsultantReview;
import com.ms.bwf.estacy.review.model.ConsultantReviewRequest;
import com.ms.bwf.estacy.review.services.ConsultantReviewDbServices;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping(value = "/estacy")
public class ConsultantReviewController {
    private final ConsultantReviewDbServices consultantReviewDbServices;
    private final ConsultantReviewManager consultantReviewManager ;
    private final ObjectMapper objectMapper;
    @PostMapping(value = "/submit",consumes = "application/json")
    public ResponseEntity<String> saveAndSubmitConsultantReview(@RequestBody ConsultantReviewRequest consultantReviewRequest) throws JsonProcessingException {
        log.info("request object for submit {}",objectMapper.writeValueAsString(consultantReviewRequest));
        consultantReviewManager.submitAndSave(consultantReviewRequest);
        return new ResponseEntity<>("Success",HttpStatus.OK);
    }

    @GetMapping (value = "/retrieve")
    public ResponseEntity<ConsultantReview> retrieveConsultantReview(@RequestParam String msID)
    {
        return ResponseEntity.ok(consultantReviewDbServices.getReviewDataForMsID(msID));
    }
}
