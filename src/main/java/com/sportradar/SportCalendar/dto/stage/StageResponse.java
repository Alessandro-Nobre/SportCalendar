package com.sportradar.SportCalendar.dto.stage;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StageResponse {
    private int stageId;
    private String name;
    private int ordering;
}
