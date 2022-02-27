package com.ms.bwf.estacy.positions.services;

import com.ms.bwf.estacy.positions.model.PositionDetailsWrapper;
import com.ms.bwf.estacy.positions.persistence.dao.PositionDataDAO;
import com.ms.bwf.estacy.positions.persistence.dao.PositionsRepository;
import com.ms.bwf.estacy.positions.persistence.entity.PositionData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PositionDetailsService {

    private final PositionDataDAO positionDataDAO;
    private final PositionsRepository positionsRepository;


    public PositionDetailsWrapper fetchAllPositions(String msId){
        try {
            //return positionDataDAO.fetchAllPositionsByMsId(msId);
            System.out.println("Fetch positions for "+ msId);
            List<PositionData> positionData = positionsRepository.findByManagerId(msId);
            //List<PositionData> positionData = positionsRepository.findByCity("Mumbai");
            System.out.println("Positions data fetched "+ positionData);
            return new PositionDetailsWrapper(positionData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
