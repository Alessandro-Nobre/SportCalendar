package com.sportradar.SportCalendar.service;

import com.sportradar.SportCalendar.converter.TeamConverter;
import com.sportradar.SportCalendar.dto.team.TeamResponse;
import com.sportradar.SportCalendar.dto.team.TeamSaveRequest;
import com.sportradar.SportCalendar.entities.TeamEntity;
import com.sportradar.SportCalendar.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public TeamResponse addNewTeam(TeamSaveRequest teamSaveRequest) {
        TeamEntity teamToSave = TeamConverter.convertTeamSaveRequestToTeamEntity(teamSaveRequest);

        TeamEntity savedTeam = teamRepository.save(teamToSave);

        return TeamConverter.convertTeamEntityToTeamResponse(savedTeam);
    }

    public List<TeamResponse> getAllTeams() {
        List<TeamEntity> teamList = teamRepository.findAll();

        List<TeamResponse> teamResponseList = new ArrayList<>();
        for (int i = 0; i < teamList.size(); i++) {
            teamResponseList.add(TeamConverter.convertTeamEntityToTeamResponse(teamList.get(i)));
        }
        return teamResponseList;
    }


    public Optional<TeamResponse> getTeamById(int teamId) {
        Optional<TeamEntity> teamEntity = teamRepository.findById(teamId);

        if (teamEntity.isPresent()) {
            return Optional.ofNullable(TeamConverter.convertTeamEntityToTeamResponse(teamEntity.get()));
        }

        return Optional.empty();
    }

    public void deleteTeamById(int teamId) {
        Optional<TeamEntity> team = teamRepository.findById(teamId);

        if (team.isPresent()) {
            teamRepository.deleteById(teamId);
        }

    }


}
