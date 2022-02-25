package com.ms.bwf.estacy.review.jpa.repository;

import com.ms.bwf.estacy.review.jpa.entity.ConsultantReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConsultantReviewRepository extends JpaRepository<ConsultantReview,String> {
Optional<ConsultantReview> findByConsultantMSID(String msId);
}
