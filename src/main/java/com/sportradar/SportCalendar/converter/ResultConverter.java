package com.sportradar.SportCalendar.converter;

import com.sportradar.SportCalendar.dto.result.ResultResponse;
import com.sportradar.SportCalendar.dto.result.ResultSaveRequest;
import com.sportradar.SportCalendar.entities.ResultEntity;
import lombok.Builder;

public class ResultConverter {
    @Builder
    public static ResultEntity convertResultSaveRequestToResultEntity(ResultSaveRequest resultSaveRequest) {
        return ResultEntity.builder()
                .homeGoals(resultSaveRequest.getHomeGoals())
                .awayGoals(resultSaveRequest.getAwayGoals())
                .winner(resultSaveRequest.getWinner())
                .message(resultSaveRequest.getMessage())
                .build();
    }


@Builder
public static ResultResponse convertResultEntityToResultResponse(ResultEntity resultEntity) {
    return ResultResponse.builder()
            .resultId(resultEntity.getResultId())
            .homeGoals(resultEntity.getHomeGoals())
            .awayGoals(resultEntity.getAwayGoals())
            .winner(resultEntity.getWinner())
            .message(resultEntity.getMessage())
            .build();
}
}



