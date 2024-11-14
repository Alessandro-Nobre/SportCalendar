package com.sportradar.SportCalendar.dto.match;

import com.sportradar.SportCalendar.dto.result.ResultResponse;
import com.sportradar.SportCalendar.dto.stage.StageResponse;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class MatchResponse {
    private int matchId;
    private int season;
    private String status;
    private LocalDateTime dateTime;
    private String stadium;
    private String matchGroup;
    private String originCompetitionId;
    private String originCompetitionName;
    private int homeTeamId;
    private int awayTeamId;
    private ResultResponse result;
    private StageResponse stage;
}
