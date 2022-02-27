package com.ms.bwf.estacy.positions.model;

import com.ms.bwf.estacy.positions.persistence.entity.CandidateData;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CandidateProfileWrapper {

    List<CandidateData> candidateProfiles;
}
