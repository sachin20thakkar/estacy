package com.ms.bwf.estacy.review.controller.Manager;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ms.bwf.estacy.review.jpa.entity.ConsultantReview;
import com.ms.bwf.estacy.review.model.ConsultantReviewRequest;
import com.ms.bwf.estacy.review.services.ConsultantReviewDbServices;
import com.ms.bwf.estacy.review.services.UtilityServices;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
@AllArgsConstructor
public class ConsultantReviewManager {
    private final ConsultantReviewDbServices consultantReviewDbServices;
    private final ObjectMapper objectMapper;
    private final UtilityServices utilityServices;


    @SneakyThrows
    public void submitAndSave(ConsultantReviewRequest consultantReviewRequest) {
        ConsultantReview consultantReview = ConsultantReview.builder()
                .consultantMSID(consultantReviewRequest.getConsultantMSID())
                .comment(consultantReviewRequest.getComment())
                .details(objectMapper.writeValueAsString(consultantReviewRequest.getDetails()))
                .id(consultantReviewRequest.getId())
                .feedback(consultantReviewRequest.getFeedback())
                .location(consultantReviewRequest.getLocation())
                .rating(utilityServices.calculateRatings(consultantReviewRequest.getDetails()))
                .last_updated_date(String.valueOf(LocalDateTime.now()))
                .tech_family(consultantReviewRequest.getTechFamily())
                .status(consultantReviewRequest.getStatus())
                .vendor(consultantReviewRequest.getVendor()).build();

        consultantReviewDbServices.saveDataToDb(consultantReview);
    }
}
