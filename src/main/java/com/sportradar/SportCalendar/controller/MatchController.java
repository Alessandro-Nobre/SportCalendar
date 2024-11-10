package com.sportradar.SportCalendar.controller;



import com.sportradar.SportCalendar.entities.MatchEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "api/match")
public class MatchController {


    @GetMapping
    public List<MatchEntity> getMatches() {
        return List.of(
                MatchEntity.builder()
                        .matchId(1)
                        .season(2024)
                        .status("played")
                        .dateTime(LocalDateTime.parse("2019-03-27T10:15:30"))
                        .stadium(null)
                        .matchGroup(null)
                        .originCompetitionId("afc-champions-league")
                        .originCompetitionName("AFC Champions League")
                        .created_at(new Timestamp(System.currentTimeMillis()))
                        .awayTeam(null)
                        .homeTeam(null)
                        .stageEntity(null)
                        .resultEntity(null)
                        .build()

        );
    }
}
