package com.ms.bwf.estacy.review.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class SolutionDelivery {
    int understandingBusiness;
    int designSolution;
    int deliveryTime;
    int deliveryQuality;
}
