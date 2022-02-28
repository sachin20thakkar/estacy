package com.ms.bwf.estacy.review.controller.Manager;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ms.bwf.estacy.review.jpa.entity.ConsultantReview;
import com.ms.bwf.estacy.review.model.ConsultantReviewRequest;
import com.ms.bwf.estacy.review.services.ConsultantReviewDbServices;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Slf4j
@Service
@AllArgsConstructor
public class ConsultantReviewManager {
    public final ConsultantReviewDbServices consultantReviewDbServices;
    public final ObjectMapper objectMapper;

    @SneakyThrows
    public void submitAndSave(ConsultantReviewRequest consultantReviewRequest) {
        ConsultantReview consultantReview = ConsultantReview.builder()
                .consultantMSID(consultantReviewRequest.getConsultantMSID())
                .AreasOfImprovement(consultantReviewRequest.getAreasOfImporovemtnt())
                .details(objectMapper.writeValueAsString(consultantReviewRequest.getDetails()))
                .id(consultantReviewRequest.getId())
                .feedback(consultantReviewRequest.getFeedback())
                .location(consultantReviewRequest.getLocation())
                .rating(consultantReviewRequest.getRating())
                .last_updated_date(String.valueOf(LocalDateTime.now()))
                .tech_family(consultantReviewRequest.getTechFamily())
                .vendor(consultantReviewRequest.getVendor()).build();

        consultantReviewDbServices.getDataFromDbServices(consultantReview);
    }
}
