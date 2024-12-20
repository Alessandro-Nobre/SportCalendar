package com.sportradar.SportCalendar.service;

import com.sportradar.SportCalendar.converter.PlayerConverter;
import com.sportradar.SportCalendar.dto.player.PlayerResponse;
import com.sportradar.SportCalendar.dto.player.PlayerSaveRequest;
import com.sportradar.SportCalendar.entities.PlayerEntity;
import com.sportradar.SportCalendar.entities.TeamEntity;
import com.sportradar.SportCalendar.repository.PlayerRepository;
import com.sportradar.SportCalendar.repository.TeamRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository, TeamRepository teamRepository) {
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
    }

    public PlayerResponse addNewPlayer(PlayerSaveRequest playerSaveRequest) {
        TeamEntity teamEntity = teamRepository.getReferenceById(playerSaveRequest.getTeamId());

        PlayerEntity playerEntity = PlayerConverter.convertPlayerSaveRequestToPlayerEntity(playerSaveRequest, teamEntity);

        PlayerEntity playerSaved = playerRepository.save(playerEntity);

        return PlayerConverter.convertPlayerEntityToPlayerResponse(playerSaved);
    }

    public List<PlayerResponse> getPlayers() {
        List<PlayerEntity> playerEntityList = playerRepository.findAll();

        List<PlayerResponse> playerResponseList = new ArrayList<>();
        for (int i = 0; i < playerEntityList.size(); i++) {
            playerResponseList.add(PlayerConverter.convertPlayerEntityToPlayerResponse(playerEntityList.get(i)));
        }
        return playerResponseList;
    }

    public Optional<PlayerResponse> getPlayerById(int playerId) {
        Optional<PlayerEntity> playerEntity = playerRepository.findById(playerId);

      if (playerEntity.isPresent()) {
          return Optional.ofNullable(PlayerConverter.convertPlayerEntityToPlayerResponse(playerEntity.get()));
      }

      return Optional.empty();
    }

    @Transactional
    public void deletePlayerById(int playerId) throws Exception {

        PlayerEntity playerEntity= playerRepository.getReferenceById(playerId);

        if (playerEntity == null) {
            throw new Exception("Player Not Found");
        }

        playerRepository.delete(playerEntity);

    }

}
