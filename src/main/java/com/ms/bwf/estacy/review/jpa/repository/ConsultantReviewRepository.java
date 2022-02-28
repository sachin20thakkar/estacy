package com.ms.bwf.estacy.review.jpa.repository;

import com.ms.bwf.estacy.dashboard.model.AverageRatingProjection;
import com.ms.bwf.estacy.review.jpa.entity.ConsultantReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConsultantReviewRepository extends JpaRepository<ConsultantReview,String> {

    Optional<ConsultantReview> findByConsultantMSID(String msId);

    @Query(value = "SELECT avg(cast(rating as int)) as rating, vendor FROM [dbo].[Consultant_review]\n" +
            "group by vendor\n" +
            "having avg(cast(rating as int)) > 0\n" +
            "order by avg(cast(rating as int)) desc", nativeQuery = true)
    List<AverageRatingProjection> findAverageRatingByVendor();

    @Query(value = "SELECT avg(cast(rating as int)) as rating, vendor FROM [dbo].[Consultant_review]\n" +
            "where tech_family = :technology\n" +
            "group by vendor\n" +
            "having avg(cast(rating as int)) > 0\n" +
            "order by avg(cast(rating as int)) desc;", nativeQuery = true)
    List<AverageRatingProjection> findAverageRatingByVendor(@Param("technology") String technology);

    @Query(value = "SELECT avg(cast(rating as int)) as rating, tech_family as technology FROM [dbo].[Consultant_review]\n" +
            "group by tech_family\n" +
            "having avg(cast(rating as int)) > 0\n" +
            "order by avg(cast(rating as int)) desc;", nativeQuery = true)
    List<AverageRatingProjection> findAverageRatingByTechnology();

    @Query(value = "SELECT avg(cast(rating as int)) as rating, tech_family as technology FROM [dbo].[Consultant_review]\n" +
            "where vendor= :vendor \n" +
            "group by tech_family\n" +
            "having avg(cast(rating as int)) > 0\n" +
            "order by avg(cast(rating as int)) desc;", nativeQuery = true)
    List<AverageRatingProjection> findAverageRatingByTechnology(@Param("vendor") String vendor);

}
