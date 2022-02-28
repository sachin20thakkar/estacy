package com.ms.bwf.estacy.review.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ConsultantReviewRequest {
    Long id;
    String consultantMSID;
    String vendor ;
    String location;
    Details details;
    String feedback;
    String comment;
    String rating;
    String techFamily;
    String status;
}
