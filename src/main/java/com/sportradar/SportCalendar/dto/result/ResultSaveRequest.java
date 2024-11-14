package com.sportradar.SportCalendar.dto.result;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResultSaveRequest {
    private byte homeGoals;
    private byte awayGoals;
    private String winner;
    private String message;
}
