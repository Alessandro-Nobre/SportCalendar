package com.sportradar.SportCalendar.converter;

import com.sportradar.SportCalendar.dto.team.TeamResponse;
import com.sportradar.SportCalendar.dto.team.TeamSaveRequest;
import com.sportradar.SportCalendar.entities.TeamEntity;
import lombok.Builder;

public class TeamConverter {

    @Builder
    public static TeamEntity convertTeamSaveRequestToTeamEntity(TeamSaveRequest teamSaveRequest){
        return TeamEntity.builder()
                .name(teamSaveRequest.getName())
                .officialName(teamSaveRequest.getOfficialName())
                .slug(teamSaveRequest.getSlug())
                .abbreviation(teamSaveRequest.getAbbreviation())
                .teamCountryCode(teamSaveRequest.getTeamCountryCode())
                .stagePosition(teamSaveRequest.getStagePosition())
                .build();
    }

    @Builder
    public static TeamResponse convertTeamEntityToTeamResponse(TeamEntity teamEntity){
        return TeamResponse.builder()
                .teamId(teamEntity.getTeamId())
                .name(teamEntity.getName())
                .officialName(teamEntity.getOfficialName())
                .slug(teamEntity.getSlug())
                .abbreviation(teamEntity.getAbbreviation())
                .teamCountryCode(teamEntity.getTeamCountryCode())
                .stagePosition(teamEntity.getStagePosition())
                .build();
    }
}
