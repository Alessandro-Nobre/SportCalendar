package com.sportradar.SportCalendar.dto.team;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TeamSaveRequest {
        private String name;
        private String officialName;
        private String slug;
        private String abbreviation;
        private String teamCountryCode;
        private String stagePosition;
}
