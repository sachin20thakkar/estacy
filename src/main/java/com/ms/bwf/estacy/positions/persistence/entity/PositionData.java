package com.ms.bwf.estacy.positions.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
@Entity
@Table(name = "position_details")
@JsonIgnoreProperties(ignoreUnknown = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PositionData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TRACKER_ID")
    String trackerId;
    @Column(name = "MANAGER_ID")
    String managerId;
    @Column(name = "RESOURCE_ID")
    String resourceId;
    @Column(name = "RESOURCE_NAME")
    String resourceName;
    @Column(name = "RESOURCE_STATUS")
    String resourceStatus;
    @Column(name = "TITLE")
    String title;
    @Column(name = "CITY")
    String city;
    @Column(name = "COST_CENTRE")
    String costCentre;
    @Column(name = "POSITION_TYPE")
    String positionType;
}
