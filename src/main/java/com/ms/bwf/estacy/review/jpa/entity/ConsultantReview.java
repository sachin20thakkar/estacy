package com.ms.bwf.estacy.review.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Slf4j
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Consultant_review")
public class ConsultantReview {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Column(name = "comment")
    String comment;
    @Column(name = "rating")
    String rating;
    @Column(name = "tech_family")
    String tech_family;
    @Column(name = "status")
    String status;
    @Column(name = "last_updated_date")
    String last_updated_date;

}
