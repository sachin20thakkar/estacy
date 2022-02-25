package com.ms.bwf.estacy.positions.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CandidateProfile {

    String posTrackerId;
    String candidateId;
    String candidateName;
    String contactNumber;
    String interviewedById;
    String interviewedByName;
    String interviewedDate;
    String vendor;
    String outcome;
    boolean joined;
}
