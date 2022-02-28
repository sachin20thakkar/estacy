package com.ms.bwf.estacy.dashboard.services;

import com.ms.bwf.estacy.dashboard.model.AverageRatingProjection;
import com.ms.bwf.estacy.dashboard.model.Series;
import com.ms.bwf.estacy.dashboard.model.VendorRatingGraph;
import com.ms.bwf.estacy.review.jpa.repository.ConsultantReviewRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DashboardServices {

    @Autowired
    ConsultantReviewRepository consultantReviewRepository;

    public VendorRatingGraph handleVendorAverageRatingRequest(){

        List<AverageRatingProjection> averageRatingProjections = consultantReviewRepository.findAverageRatingByVendor();

        Series series = Series.builder()
                .name("Rating")
                .type("column")
                .data(averageRatingProjections.stream().map(projection -> projection.getRating()).collect(Collectors.toList()))
                .build();
        return VendorRatingGraph.builder()
                .id("vendor-rating")
                .categories(averageRatingProjections.stream().map(projection -> projection.getVendor()).collect(Collectors.toList()))
                .series(Arrays.asList(series))
                .build();
    }

    public VendorRatingGraph handleVendorAverageRatingRequestByTechnology(String technology){

        List<AverageRatingProjection> averageRatingProjections = consultantReviewRepository.findAverageRatingByVendor(technology);

        Series series = Series.builder()
                .name("Rating")
                .type("column")
                .data(averageRatingProjections.stream().map(projection -> projection.getRating()).collect(Collectors.toList()))
                .build();
        return VendorRatingGraph.builder()
                .id("vendor-rating")
                .categories(averageRatingProjections.stream().map(projection -> projection.getVendor()).collect(Collectors.toList()))
                .series(Arrays.asList(series))
                .build();
    }

    public VendorRatingGraph handleTechnologyAverageRatingRequest(){

        List<AverageRatingProjection> averageRatingProjections = consultantReviewRepository.findAverageRatingByTechnology();

        Series series = Series.builder()
                .name("Rating")
                .type("column")
                .data(averageRatingProjections.stream().map(projection -> projection.getRating()).collect(Collectors.toList()))
                .build();
        return VendorRatingGraph.builder()
                .id("tech-rating")
                .categories(averageRatingProjections.stream().map(projection -> projection.getTechnology()).collect(Collectors.toList()))
                .series(Arrays.asList(series))
                .build();
    }

    public VendorRatingGraph handleTechnologyAverageRatingByVendorRequest(String vendor){

        List<AverageRatingProjection> averageRatingProjections = consultantReviewRepository.findAverageRatingByTechnology(vendor);

        Series series = Series.builder()
                .name("Rating")
                .type("column")
                .data(averageRatingProjections.stream().map(projection -> projection.getRating()).collect(Collectors.toList()))
                .build();
        return VendorRatingGraph.builder()
                .id("tech-rating")
                .categories(averageRatingProjections.stream().map(projection -> projection.getTechnology()).collect(Collectors.toList()))
                .series(Arrays.asList(series))
                .build();
    }
}
