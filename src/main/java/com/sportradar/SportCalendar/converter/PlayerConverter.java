package com.sportradar.SportCalendar.converter;

import com.sportradar.SportCalendar.dto.player.PlayerResponse;
import com.sportradar.SportCalendar.dto.player.PlayerSaveRequest;
import com.sportradar.SportCalendar.entities.PlayerEntity;
import com.sportradar.SportCalendar.entities.TeamEntity;
import lombok.Builder;

public class PlayerConverter {

    @Builder
    public static PlayerEntity convertPlayerSaveRequestToPlayerEntity(PlayerSaveRequest playerSaveRequest, TeamEntity teamEntity) {
        return PlayerEntity.builder()
                .name(playerSaveRequest.getName())
                .birthday(playerSaveRequest.getBirthday())
                .jerseyNumber(playerSaveRequest.getJerseyNumber())
                .teamEntity(teamEntity)
                .build();
    }

    @Builder
    public static PlayerResponse convertPlayerEntityToPlayerResponse(PlayerEntity playerEntity) {
        return PlayerResponse.builder()
                .playerId(playerEntity.getPlayerId())
                .name(playerEntity.getName())
                .birthday(playerEntity.getBirthday())
                .jerseyNumber(playerEntity.getJerseyNumber())
                .team(TeamConverter.convertTeamEntityToTeamResponse(playerEntity.getTeamEntity()))
                .build();
    }
}
