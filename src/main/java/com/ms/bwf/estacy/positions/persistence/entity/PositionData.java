package com.ms.bwf.estacy.positions.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
@Entity
@Table(name = "POSITION_DETAILS")
public class PositionData {

    @Id
    @Column(name = "TRACKER_ID")
    String trackerId;
    @Column(name = "RESOURCE_ID")
    String resourceId;
    @Column(name = "RESOURCE_NAME")
    String resourceName;
    @Column(name = "POSITION_TITLE")
    String title;
    @Column(name = "CITY")
    String city;
    @Column(name = "COST_CENTRE")
    String costCentre;
    @Column(name = "POSITION_TYPE")
    String positionType;
}
