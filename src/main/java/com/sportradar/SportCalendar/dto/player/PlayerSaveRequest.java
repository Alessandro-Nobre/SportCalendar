package com.sportradar.SportCalendar.dto.player;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlayerSaveRequest {
    private String name;
    private int birthday;
    private int jerseyNumber;
    private int teamId;
}
