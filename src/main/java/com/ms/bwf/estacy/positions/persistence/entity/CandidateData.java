package com.ms.bwf.estacy.positions.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
//import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "candidate_data")
@JsonIgnoreProperties(ignoreUnknown = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CandidateData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CANDIDATE_ID")
    int candidateId;
    @Column(name = "POS_TRACKER_ID")
    String posTrackerId;
    @Column(name = "CANDIDATE_NAME")
    String candidateName;
    @Column(name = "CONTACT_NUM")
    String contactNum;
    @Column(name = "INTERVIEWER_ID")
    String interviewerId;
    @Column(name = "INTERVIEWER_NAME")
    String interviewerName;
    @Column(name = "INTERVIEWED_DATE")
    String interviewedDate;
    @Column(name = "VENDOR")
    String vendor;
    @Column(name = "OUTCOME")
    String outcome;
    @Column(name = "JOINED")
    String joined;
}
