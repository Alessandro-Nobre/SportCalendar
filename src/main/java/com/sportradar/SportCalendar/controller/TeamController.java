package com.sportradar.SportCalendar.controller;

import com.sportradar.SportCalendar.dto.team.TeamResponse;
import com.sportradar.SportCalendar.dto.team.TeamSaveRequest;
import com.sportradar.SportCalendar.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "api/team")
public class TeamController {

    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {this.teamService = teamService;}

    @GetMapping
    public ResponseEntity<List<TeamResponse>> getAllTeams() {
        return new ResponseEntity<>(teamService.getAllTeams(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TeamResponse> registerNewTeam(@Valid @RequestBody TeamSaveRequest teamSaveRequest) {

        return new ResponseEntity<>(teamService.addNewTeam(teamSaveRequest), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{teamId}")
    public ResponseEntity<TeamResponse> getTeamById(@PathVariable int teamId) {
        return new ResponseEntity<>(teamService.getTeamById(teamId), HttpStatus.OK);
    }
}
