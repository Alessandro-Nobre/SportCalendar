package com.sportradar.SportCalendar.converter;

import com.sportradar.SportCalendar.dto.goals.GoalResponse;
import com.sportradar.SportCalendar.dto.goals.GoalSaveRequest;
import com.sportradar.SportCalendar.entities.GoalEntity;
import com.sportradar.SportCalendar.entities.PlayerEntity;
import com.sportradar.SportCalendar.entities.ResultEntity;
import lombok.Builder;

public class GoalConverter {

    @Builder
    public static GoalEntity convertGoalSaveRequestToGoalEntity(GoalSaveRequest goalSaveRequest, ResultEntity resultEntity, PlayerEntity playerEntity) {
        return GoalEntity.builder()
                .time(goalSaveRequest.getTime())
                .resultEntity(resultEntity)
                .playerEntity(playerEntity)
                .build();
    }

    @Builder
    public static GoalResponse convertGoalEntityToGoalResponse(GoalEntity goalEntity) {
        return GoalResponse.builder()
                .goalId(goalEntity.getGoalId())
                .time(goalEntity.getTime())
                .resultEntity(ResultConverter.convertResultEntityToResultResponse(goalEntity.getResultEntity()))
                .playerEntity(PlayerConverter.convertPlayerEntityToPlayerResponse(goalEntity.getPlayerEntity()))
                .build();
    }
}
