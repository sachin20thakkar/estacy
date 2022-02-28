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
    String comment;
    String rating;
    String techFamily;
    String status;
    Timestamp lastUpdatedDate;
}
