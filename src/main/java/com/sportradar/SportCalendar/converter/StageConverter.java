package com.sportradar.SportCalendar.converter;

import com.sportradar.SportCalendar.dto.stage.StageResponse;
import com.sportradar.SportCalendar.dto.stage.StageSaveRequest;
import com.sportradar.SportCalendar.entities.StageEntity;
import lombok.Builder;

public class StageConverter {
    
    @Builder
    public static StageEntity convertStageSaveRequestToStageEntity(StageSaveRequest stageSaveRequest) {
        return StageEntity.builder()
                .name(stageSaveRequest.getName())
                .ordering(stageSaveRequest.getOrdering())
                .build();
    }
    
    @Builder
    public static StageResponse convertStageEntityToStageResponse(StageEntity stageEntity ){
        return StageResponse.builder()
                .stageId(stageEntity.getStageId())
                .name(stageEntity.getName())
                .ordering(stageEntity.getOrdering())
                .build();
    }

}
