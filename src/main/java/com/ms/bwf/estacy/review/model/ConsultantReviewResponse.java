package com.ms.bwf.estacy.review.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ConsultantReviewResponse {
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
