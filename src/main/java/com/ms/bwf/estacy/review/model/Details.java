package com.ms.bwf.estacy.review.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Details {
    SolutionDelivery solutionDelivery;
    ProblemSolving problemSolving;
    ProcessAdherence processAdherence;
    CollaborationKT collaborationKT;
    TechnicalProficiency technicalProficiency;
}
