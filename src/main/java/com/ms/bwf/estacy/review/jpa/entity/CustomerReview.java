package com.ms.bwf.estacy.review.jpa.entity;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Slf4j
@Data
@Entity
@Table(name = "Consultant_review")
public class CustomerReview {
    @Column(name = "id")
    Long id;
    @Id
    @Column(name = "consultant_MSID")
    String consultantMSID;
    @Column(name = "vendor")
    String vendor ;
    @Column(name = "location")
    String location;
    @Column(name = "details")
    String details;
    @Column(name = "feedback")
    String feedback;
    @Column(name = "AreasOfImporovemtnt")
    String AreasOfImporovemtnt;
    @Column(name = "rating")
    String rating;
    @Column(name = "tech_family")
    String tech_family;
    @Column(name = "last_updated_date")
    String last_updated_date;

}
