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
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public List<GoalResponse> getAllGoals(){
        List<GoalEntity> goalList = goalRepository.findAll();

        List<GoalResponse> goalResponseList = new ArrayList<>();
        for (int i = 0; i < goalList.size(); i++) {
            goalResponseList.add(GoalConverter.convertGoalEntityToGoalResponse(goalList.get(i)));
        }
        return goalResponseList;
    }

    public Optional<GoalResponse> getGoalById(int goalId) {
        Optional<GoalEntity> goalEntity = goalRepository.findById(goalId);

        if (goalEntity.isPresent()) {
            return Optional.ofNullable(GoalConverter.convertGoalEntityToGoalResponse(goalEntity.get()));
        }

        return Optional.empty();
    }

    @Transactional
    public void deleteGoalById(int goalId) throws Exception {
        GoalEntity goalEntity = goalRepository.getReferenceById(goalId);

        if (goalEntity == null) {
            throw new Exception("Goal not found");
        }

        goalRepository.delete(goalEntity);
    }

}
