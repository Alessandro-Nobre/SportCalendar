package com.sportradar.SportCalendar.service;

import com.sportradar.SportCalendar.converter.GoalConverter;
import com.sportradar.SportCalendar.dto.goals.GoalResponse;
import com.sportradar.SportCalendar.dto.goals.GoalSaveRequest;
import com.sportradar.SportCalendar.entities.GoalEntity;
import com.sportradar.SportCalendar.entities.PlayerEntity;
import com.sportradar.SportCalendar.entities.ResultEntity;
import com.sportradar.SportCalendar.repository.GoalRepository;
import com.sportradar.SportCalendar.repository.PlayerRepository;
import com.sportradar.SportCalendar.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoalService {

    private final GoalRepository goalRepository;
    private final ResultRepository resultRepository;
    private final PlayerRepository playerRepository;

    @Autowired
    public GoalService(GoalRepository goalRepository, ResultRepository resultRepository, PlayerRepository playerRepository) {
        this.goalRepository = goalRepository;
        this.resultRepository = resultRepository;
        this.playerRepository = playerRepository;
    }

    public GoalResponse addNewGoal(GoalSaveRequest goalSaveRequest) {
        ResultEntity resultEntity = resultRepository.getReferenceById(goalSaveRequest.getResultId());
        PlayerEntity playerEntity = playerRepository.getReferenceById(goalSaveRequest.getPlayerId());

        GoalEntity goalToSave = GoalConverter.convertGoalSaveRequestToGoalEntity(goalSaveRequest, resultEntity, playerEntity);

        GoalEntity savedMatch = goalRepository.save(goalToSave);

        return GoalConverter.convertGoalEntityToGoalResponse(savedMatch);
    }

    public List<GoalEntity> getGoals(){
        return goalRepository.findAll();
    }

}
