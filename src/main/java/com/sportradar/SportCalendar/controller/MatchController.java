package com.sportradar.SportCalendar.controller;

import com.sportradar.SportCalendar.dto.match.MatchResponse;
import com.sportradar.SportCalendar.dto.match.MatchSaveRequest;
import com.sportradar.SportCalendar.entities.MatchEntity;
import com.sportradar.SportCalendar.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "api/match")
public class MatchController {

    private final MatchService matchService;

    @Autowired
    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping
    public List<MatchEntity> getMatches() {
        return matchService.getMatches();
    }

    @PostMapping
    public ResponseEntity<MatchResponse> registerNewMatch(@Valid @RequestBody MatchSaveRequest matchSaveRequest) {

        return new ResponseEntity<>(matchService.addNewMatch(matchSaveRequest), HttpStatus.CREATED);
    }
}
