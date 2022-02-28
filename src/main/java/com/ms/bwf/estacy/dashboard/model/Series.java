package com.ms.bwf.estacy.dashboard.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Series {

    String name;
    String type;
    List<String> data;
}
