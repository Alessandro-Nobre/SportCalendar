package com.sportradar.SportCalendar.dto.goals;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GoalSaveRequest {
    private int time;
    private int resultId;
    private int playerId;
}
