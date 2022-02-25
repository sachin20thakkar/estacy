package com.ms.bwf.estacy.positions.persistence.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ms.bwf.estacy.positions.model.PositionDetailsWrapper;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.net.URL;

@Component
public class PositionDataDAO {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public PositionDetailsWrapper fetchAllPositionsByMsId(String msId) throws IOException {
        URL url = getClass().getResource("/stubs/RetrieveAllPositionsData.json");
        File file = new File(url.getPath());
        return objectMapper.readValue(file, PositionDetailsWrapper.class);
    }
}
