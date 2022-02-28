package com.ms.bwf.estacy.review.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

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
    String techFamily;
    Timestamp lastUpdatedDate;
}
