package com.sportradar.SportCalendar.dto.player;

import com.sportradar.SportCalendar.dto.team.TeamResponse;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlayerResponse {
    private int playerId;
    private String name;
    private int birthday;
    private int jersyNumber;
    private TeamResponse team;
}
