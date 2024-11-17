package com.sportradar.SportCalendar.service;

import com.sportradar.SportCalendar.converter.TeamConverter;
import com.sportradar.SportCalendar.dto.team.TeamResponse;
import com.sportradar.SportCalendar.dto.team.TeamSaveRequest;
import com.sportradar.SportCalendar.entities.TeamEntity;
import com.sportradar.SportCalendar.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public TeamResponse getTeamById(int teamId) {

        TeamEntity getTeamById = teamRepository.getReferenceById(teamId);

        return TeamConverter.convertTeamEntityToTeamResponse(getTeamById);
    }
}
