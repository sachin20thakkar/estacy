package com.ms.bwf.estacy.review.services;

import com.ms.bwf.estacy.review.jpa.entity.ConsultantReview;
import com.ms.bwf.estacy.review.jpa.repository.ConsultantReviewRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Optional;

@Slf4j
@Service
public class ConsultantReviewDbServices {

    public final ConsultantReviewRepository consultantReviewRepository;

    public ConsultantReviewDbServices(ConsultantReviewRepository consultantReviewRepository) {
        this.consultantReviewRepository = consultantReviewRepository;
    }

    public void getDataFromDbServices(ConsultantReview consultantReview)
    {

        consultantReviewRepository.save(consultantReview);
    }

    public ConsultantReview getReviewDataForMsID(String msId)
    {
        Optional<ConsultantReview> consultantReview = consultantReviewRepository.findByConsultantMSID(msId);

        return  consultantReview.orElse(new ConsultantReview());
    }
}
