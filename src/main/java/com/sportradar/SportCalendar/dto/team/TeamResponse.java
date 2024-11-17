package com.sportradar.SportCalendar.dto.team;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TeamResponse {
    private int teamId;
    private String name;
    private String officialName;
    private String slug;
    private String abbreviation;
    private String teamCountryCode;
    private String stagePosition;

}
