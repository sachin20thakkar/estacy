package com.ms.bwf.estacy.review.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CollaborationKT {
    int collaboration;
    int mentoring;
    int promotingTeamProductivity;
    int resourceManagement;
}
