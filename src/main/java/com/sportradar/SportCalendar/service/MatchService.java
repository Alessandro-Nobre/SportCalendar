package com.sportradar.SportCalendar.service;


import com.sportradar.SportCalendar.converter.MatchConverter;
import com.sportradar.SportCalendar.dto.match.MatchResponse;
import com.sportradar.SportCalendar.dto.match.MatchSaveRequest;
import com.sportradar.SportCalendar.entities.MatchEntity;
import com.sportradar.SportCalendar.entities.ResultEntity;
import com.sportradar.SportCalendar.entities.StageEntity;
import com.sportradar.SportCalendar.entities.TeamEntity;
import com.sportradar.SportCalendar.repository.MatchRepository;
import com.sportradar.SportCalendar.repository.ResultRepository;
import com.sportradar.SportCalendar.repository.StageRepository;
import com.sportradar.SportCalendar.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class MatchService {

    private final MatchRepository matchRepository;
    private final TeamRepository teamRepository;
    private final StageRepository stageRepository;
    private final ResultRepository resultRepository;

    @Autowired
    public MatchService(MatchRepository matchRepository, TeamRepository teamRepository, StageRepository stageRepository, ResultRepository resultRepository) {
        this.matchRepository = matchRepository;
        this.teamRepository = teamRepository;
        this.stageRepository = stageRepository;
        this.resultRepository = resultRepository;
    }

    public MatchResponse addNewMatch(MatchSaveRequest matchSaveRequest) {
        StageEntity stageEntity = stageRepository.getReferenceById(matchSaveRequest.getStageId());
        ResultEntity resultEntity = resultRepository.getReferenceById(matchSaveRequest.getResultId());
        TeamEntity homeTeam = teamRepository.getReferenceById(matchSaveRequest.getHomeTeamId());
        TeamEntity awayTeam = teamRepository.getReferenceById(matchSaveRequest.getAwayTeamId());

        MatchEntity matchToSave = MatchConverter.convertMatchSaveRequestToMatchEntity(matchSaveRequest, stageEntity, homeTeam, awayTeam, resultEntity);

        MatchEntity savedMatch = matchRepository.save(matchToSave);

        return MatchConverter.convertMatchEntityToMatchResponse(savedMatch);
    }

    public List<MatchResponse> getMatches() {
        List<MatchEntity> matchList = matchRepository.findAll();

        List<MatchResponse> matchResponseList = new ArrayList<>();
        for (int i = 0; i < matchList.size(); i++) {
            matchResponseList.add(MatchConverter.convertMatchEntityToMatchResponse(matchList.get(i)));
        }
        return matchResponseList;
    }

    public Optional<MatchResponse> getMatchById(int matchId) {
        Optional<MatchEntity> matchEntity = matchRepository.findById(matchId);

        if (matchEntity.isPresent()) {
            return Optional.ofNullable(MatchConverter.convertMatchEntityToMatchResponse(matchEntity.get()));
        }

        return Optional.empty();
    }

    public void deleteMatchById(int matchId) {
        Optional<MatchEntity> match = matchRepository.findById(matchId);

        if (match.isPresent()) {
            matchRepository.deleteById(matchId);
        }

    }


}
