package com.ms.bwf.estacy.positions.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "CANDIDATE_DATA")
public class CandidateData {

    @Id
    @Column(name = "CANDIDATE_ID")
    String candidateId;
    @Column(name = "POSITION_ID")
    String posTrackerId;
    @Column(name = "CANDIDATE_NAME")
    String candidateName;
    @Column(name = "CONTACT_NO")
    String contactNum;
    @Column(name = "INTERVIEWED_BY_ID")
    String interviewerId;
    @Column(name = "INTERVIEWED_BY_NAME")
    String interviewerName;
    @Column(name = "INTERVIEWED_DATE")
    Timestamp interviewedDate;
    @Column(name = "VENDOR")
    String vendor;
    @Column(name = "OUTCOME")
    String outcome;
    @Column(name = "JOINED_INDICATOR")
    boolean joined;
}
