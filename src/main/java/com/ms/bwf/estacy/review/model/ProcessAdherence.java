package com.ms.bwf.estacy.review.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ProcessAdherence {
    int processCompliance;
    int promptEscalations;
    int responsivenessOnProductionIssue;
}
