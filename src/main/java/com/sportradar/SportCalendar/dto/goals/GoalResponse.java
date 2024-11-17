package com.sportradar.SportCalendar.dto.goals;

import com.sportradar.SportCalendar.dto.player.PlayerResponse;
import com.sportradar.SportCalendar.dto.result.ResultResponse;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GoalResponse {
    private int goalId;
    private int time;
    private ResultResponse resultEntity;
    private PlayerResponse playerEntity;
}
