package com.sportradar.SportCalendar.service;


import com.sportradar.SportCalendar.converter.MatchConverter;
import com.sportradar.SportCalendar.converter.ResultConverter;
import com.sportradar.SportCalendar.converter.StageConverter;
import com.sportradar.SportCalendar.dto.match.MatchResponse;
import com.sportradar.SportCalendar.dto.match.MatchSaveRequest;
import com.sportradar.SportCalendar.dto.result.ResultSaveRequest;
import com.sportradar.SportCalendar.dto.stage.StageSaveRequest;
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

import java.util.List;


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
        StageEntity stageEntity = saveStageEntity(matchSaveRequest.getStage());
        ResultEntity resultEntity = saveResultEntity(matchSaveRequest.getResult());
        TeamEntity homeTeam = teamRepository.getByTeamId(matchSaveRequest.getHomeTeamId());
        TeamEntity awayTeam = teamRepository.getByTeamId(matchSaveRequest.getAwayTeamId());

        MatchEntity matchToSave = MatchConverter.convertMatchSaveRequestToMatchEntity(matchSaveRequest, stageEntity, homeTeam, awayTeam, resultEntity);

        MatchEntity savedMatch = matchRepository.save(matchToSave);

        return MatchConverter.convertMatchEntityToMatchResponse(savedMatch);
    }

    private StageEntity saveStageEntity(StageSaveRequest stageSaveRequest) {
        StageEntity stageEntity = StageConverter.convertStageSaveRequestToStageEntity(stageSaveRequest);
       return stageRepository.save(stageEntity);
    }

    private ResultEntity saveResultEntity(ResultSaveRequest resultSaveRequest) {
            ResultEntity resultEntity = ResultConverter.convertResultSaveRequestToResultEntity(resultSaveRequest);
           return resultRepository.save(resultEntity);
        }

    public List<MatchEntity> getMatches() {
        return matchRepository.findAll();
    }

}
