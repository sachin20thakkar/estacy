package com.ms.bwf.estacy.positions.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PositionDetails {

    @JsonProperty("pTrackerId")
    String pTrackerId;
    String posName;
    String resourceId;
    String resourceName;
    String posTitle;
    String posCity;
    String posCostCentre;
    String posType;

}
