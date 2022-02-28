package com.ms.bwf.estacy.review.services;

import com.ms.bwf.estacy.review.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UtilityServices {


    public  String calculateRatings(Details details) {

        int count = 0;
        int total_sum = 0;
        if (!ObjectUtils.isEmpty(details.getCollaborationKT())) {
            CollaborationKT collaborationKT;
            collaborationKT = details.getCollaborationKT();
            if (collaborationKT.getCollaboration() > 0) {
                count++;
                total_sum = total_sum + collaborationKT.getCollaboration();

            }
            if (collaborationKT.getMentoring() > 0) {
                count++;
                total_sum = total_sum + collaborationKT.getMentoring();

            }
            if (collaborationKT.getResourceManagement() > 0) {
                count++;
                total_sum = total_sum + collaborationKT.getResourceManagement();

            }
            if (collaborationKT.getPromotingTeamProductivity() > 0) {
                count++;
                total_sum = total_sum + collaborationKT.getPromotingTeamProductivity();

            }

        }
        if (!ObjectUtils.isEmpty(details.getProblemSolving())) {
            ProblemSolving problemSolving = details.getProblemSolving();
            if (problemSolving.getChallengeStatusQuo() > 0) {
                count++;
                total_sum = total_sum + problemSolving.getChallengeStatusQuo();

            }
            if (problemSolving.getCreativityInnovation() > 0) {
                count++;
                total_sum = total_sum + problemSolving.getCreativityInnovation();

            }
            if (problemSolving.getManagingRoadBlocks() > 0) {
                count++;
                total_sum = total_sum + problemSolving.getManagingRoadBlocks();

            }

        }
        if (!ObjectUtils.isEmpty(details.getSolutionDelivery())) {
            SolutionDelivery solutionDelivery = details.getSolutionDelivery();
            if (solutionDelivery.getDeliveryTime() > 0) {
                count++;
                total_sum = total_sum + solutionDelivery.getDeliveryTime();

            }
            if (solutionDelivery.getDesignSolution() > 0) {
                count++;
                total_sum = total_sum + solutionDelivery.getDesignSolution();

            }
            if (solutionDelivery.getDeliveryQuality() > 0) {
                count++;
                total_sum = total_sum + solutionDelivery.getDeliveryQuality();

            }
            if (solutionDelivery.getUnderstandingBusiness() > 0) {
                count++;
                total_sum = total_sum + solutionDelivery.getUnderstandingBusiness();

            }

        }
        if (!ObjectUtils.isEmpty(details.getProcessAdherence())) {
            ProcessAdherence processAdherence = details.getProcessAdherence();
            if (processAdherence.getProcessCompliance() > 0) {
                count++;
                total_sum = total_sum + processAdherence.getProcessCompliance();

            }
            if (processAdherence.getPromptEscalations() > 0) {
                count++;
                total_sum = total_sum + processAdherence.getPromptEscalations();

            }
            if (processAdherence.getResponsivenessOnProductionIssue() > 0) {
                count++;
                total_sum = total_sum + processAdherence.getResponsivenessOnProductionIssue();

            }

            if (!ObjectUtils.isEmpty(details.getTechnicalProficiency())) {
                TechnicalProficiency technicalProficiency = details.getTechnicalProficiency();
                if (technicalProficiency.getSkillSet() > 0) {
                    count++;
                    total_sum = total_sum + technicalProficiency.getSkillSet();

                }

                if (technicalProficiency.getDomainKnowledge() > 0) {
                    count++;
                    total_sum = total_sum + technicalProficiency.getDomainKnowledge();

                }

            }
        }


        return String.valueOf(total_sum/count);
    }
}
