package com.ms.bwf.estacy.positions.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PositionDetailsWrapper {

    List<PositionDetails> positionDetails;
}
