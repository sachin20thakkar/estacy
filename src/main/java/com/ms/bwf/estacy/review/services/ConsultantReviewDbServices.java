package com.ms.bwf.estacy.review.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ms.bwf.estacy.review.jpa.entity.ConsultantReview;
import com.ms.bwf.estacy.review.jpa.repository.ConsultantReviewRepository;
import com.ms.bwf.estacy.review.model.ConsultantReviewResponse;
import com.ms.bwf.estacy.review.model.Details;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Slf4j
@Service
public class ConsultantReviewDbServices {

    public final ConsultantReviewRepository consultantReviewRepository;
    private final ObjectMapper objectMapper;

    public ConsultantReviewDbServices(ConsultantReviewRepository consultantReviewRepository, ObjectMapper objectMapper) {
        this.consultantReviewRepository = consultantReviewRepository;
        this.objectMapper = objectMapper;
    }

    public void getDataFromDbServices(ConsultantReview consultantReview) {

        consultantReviewRepository.save(consultantReview);
    }

    public ConsultantReviewResponse getReviewDataForMsID(String msId) throws JsonProcessingException {
        ConsultantReviewResponse consultantReviewResponse = new ConsultantReviewResponse();
        Optional<ConsultantReview> consultantReview = consultantReviewRepository.findByConsultantMSID(msId);
        if (consultantReview.isPresent()) {
            consultantReviewResponse = mappingToReponseObject(consultantReview.get());
        }

        return consultantReviewResponse;
    }

    private ConsultantReviewResponse mappingToReponseObject(ConsultantReview consultantReview) throws JsonProcessingException {
        ConsultantReviewResponse consultantReviewResponse = ConsultantReviewResponse.builder()
                .AreasOfImporovemtnt(consultantReview.getAreasOfImprovement())
                .consultantMSID(consultantReview.getConsultantMSID())
                .feedback(consultantReview.getFeedback())
                .location(consultantReview.getLocation())
                .rating(consultantReview.getRating())
                .vendor(consultantReview.getVendor())
                .techFamily(consultantReview.getTech_family()).details(getDetailRatings(consultantReview.getDetails()))
                .build();
        return consultantReviewResponse;
    }

    private Details getDetailRatings(String details) throws JsonProcessingException {
        Details detailsObject = new Details();

        if (StringUtils.hasText(details)) {
            detailsObject = objectMapper.readValue(details, Details.class);
        }
        return detailsObject;
    }
}
