package com.ms.bwf.estacy.positions.services;

import com.ms.bwf.estacy.positions.model.PositionDetailsWrapper;
import com.ms.bwf.estacy.positions.persistence.dao.PositionDataDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Slf4j
public class PositionDetailsService {

    private final PositionDataDAO positionDataDAO;

    @Autowired
    public PositionDetailsService(PositionDataDAO positionDataDAO){
        this.positionDataDAO = positionDataDAO;
    }

    public PositionDetailsWrapper fetchAllPositions(String msId){
        try {
            return positionDataDAO.fetchAllPositionsByMsId(msId);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
