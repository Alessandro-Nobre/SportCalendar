package com.sportradar.SportCalendar.controller;

import com.sportradar.SportCalendar.dto.match.MatchResponse;
import com.sportradar.SportCalendar.dto.match.MatchSaveRequest;
import com.sportradar.SportCalendar.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/match")
public class MatchController {

    private final MatchService matchService;

    @Autowired
    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping
    public ResponseEntity<List<MatchResponse>> getMatches() {
        return new ResponseEntity<>(matchService.getMatches(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MatchResponse> registerNewMatch(@Valid @RequestBody MatchSaveRequest matchSaveRequest) {

        return new ResponseEntity<>(matchService.addNewMatch(matchSaveRequest), HttpStatus.CREATED);
    }

    @GetMapping("/{matchId}")
    public ResponseEntity<Optional<MatchResponse>> getMatchById(@PathVariable int matchId) {
        return new ResponseEntity<>(matchService.getMatchById(matchId), HttpStatus.OK);
    }

    @DeleteMapping("/{matchId}")
    public ResponseEntity<Void> deleteMatch(@PathVariable int matchId) {
        matchService.deleteMatchById(matchId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
