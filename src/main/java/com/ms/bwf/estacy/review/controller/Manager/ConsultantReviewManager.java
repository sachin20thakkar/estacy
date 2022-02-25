package com.ms.bwf.estacy.review.controller.Manager;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ms.bwf.estacy.review.jpa.entity.ConsultantReview;
import com.ms.bwf.estacy.review.model.ConsultantReviewRequest;
import com.ms.bwf.estacy.review.model.Details;
import com.ms.bwf.estacy.review.services.ConsultantReviewDbServices;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class ConsultantReviewManager {
    public final ConsultantReviewDbServices consultantReviewDbServices;
    public final ObjectMapper objectMapper;

    @SneakyThrows
    public void submitAndSave(ConsultantReviewRequest consultantReviewRequest) {
        Details details = new Details();
        ConsultantReview consultantReview = ConsultantReview.builder()
                .consultantMSID(consultantReviewRequest.getConsultantMSID())
                .AreasOfImporovemtnt(consultantReviewRequest.getAreasOfImporovemtnt())
                .avgRating(consultantReviewRequest.getAvgRating())
                .details(objectMapper.writeValueAsString(details))
                .id(consultantReviewRequest.getId())
                .feedback(consultantReviewRequest.getFeedback())
                .location(consultantReviewRequest.getLocation())
                .rating(consultantReviewRequest.getRating())
                .last_updated_date(consultantReviewRequest.getLast_updated_date())
                .tech_family(consultantReviewRequest.getTech_family())
                .vendor(consultantReviewRequest.getVendor()).build();

        consultantReviewDbServices.getDataFromDbServices(consultantReview);
    }
}
