package com.sportradar.SportCalendar.service;

import com.sportradar.SportCalendar.converter.ResultConverter;
import com.sportradar.SportCalendar.dto.result.ResultResponse;
import com.sportradar.SportCalendar.dto.result.ResultSaveRequest;
import com.sportradar.SportCalendar.entities.ResultEntity;
import com.sportradar.SportCalendar.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResultService {
    private ResultRepository resultRepository;

    @Autowired
    public ResultService(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    public ResultResponse addNewResult(ResultSaveRequest resultSaveRequest) {
        ResultEntity resultToSave = ResultConverter.convertResultSaveRequestToResultEntity(resultSaveRequest);

        ResultEntity savedResult = resultRepository.save(resultToSave);

        return ResultConverter.convertResultEntityToResultResponse(savedResult);
    }

    public List<ResultResponse> getResults() {
        List<ResultEntity> resultEntityList = resultRepository.findAll();

        List<ResultResponse> playerResponseList = new ArrayList<>();
        for (int i = 0; i < resultEntityList.size(); i++) {
            playerResponseList.add(ResultConverter.convertResultEntityToResultResponse(resultEntityList.get(i)));
        }
        return playerResponseList;
    }
}
