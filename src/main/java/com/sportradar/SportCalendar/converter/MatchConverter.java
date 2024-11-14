package com.sportradar.SportCalendar.converter;

import com.sportradar.SportCalendar.dto.match.MatchResponse;
import com.sportradar.SportCalendar.dto.match.MatchSaveRequest;
import com.sportradar.SportCalendar.entities.MatchEntity;
import com.sportradar.SportCalendar.entities.ResultEntity;
import com.sportradar.SportCalendar.entities.StageEntity;
import com.sportradar.SportCalendar.entities.TeamEntity;
import lombok.Builder;

public class MatchConverter {

    @Builder
    public static MatchEntity convertMatchSaveRequestToMatchEntity(MatchSaveRequest matchSaveRequest, StageEntity stageEntity, TeamEntity homeTeam, TeamEntity awayTeam, ResultEntity resultEntity) {
        return MatchEntity.builder()
                .season(matchSaveRequest.getSeason())
                .status(matchSaveRequest.getStatus())
                .dateTime(matchSaveRequest.getDateTime())
                .stadium(matchSaveRequest.getStadium())
                .matchGroup(matchSaveRequest.getMatchGroup())
                .originCompetitionId(matchSaveRequest.getOriginCompetitionId())
                .originCompetitionName(matchSaveRequest.getOriginCompetitionName())
                .homeTeam(homeTeam)
                .awayTeam(awayTeam)
                .stageEntity(stageEntity)
                .resultEntity(resultEntity)
                .build();
    }

    @Builder
    public static MatchResponse convertMatchEntityToMatchResponse(MatchEntity matchEntity) {
        return MatchResponse.builder()
                .matchId(matchEntity.getMatchId())
                .season(matchEntity.getSeason())
                .dateTime(matchEntity.getDateTime())
                .stadium(matchEntity.getStadium())
                .matchGroup(matchEntity.getMatchGroup())
                .originCompetitionId(matchEntity.getOriginCompetitionId())
                .originCompetitionName(matchEntity.getOriginCompetitionName())
                .homeTeamId(matchEntity.getHomeTeam().getTeamId())
                .awayTeamId(matchEntity.getAwayTeam().getTeamId())
                .result(ResultConverter.convertResultEntityToResultResponse(matchEntity.getResultEntity()))
                .stage(StageConverter.convertStageEntityToStageResponse(matchEntity.getStageEntity()))    
                .build();

    }

}
