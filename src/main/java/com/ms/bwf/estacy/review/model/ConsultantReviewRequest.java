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
    String AreasOfImporovemtnt;
    String rating;
    String avgRating;
    String tech_family;
    String last_updated_date;
}
