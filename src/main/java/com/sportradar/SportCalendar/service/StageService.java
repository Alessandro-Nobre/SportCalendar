package com.sportradar.SportCalendar.service;

import com.sportradar.SportCalendar.converter.StageConverter;
import com.sportradar.SportCalendar.dto.stage.StageResponse;
import com.sportradar.SportCalendar.dto.stage.StageSaveRequest;
import com.sportradar.SportCalendar.entities.StageEntity;
import com.sportradar.SportCalendar.repository.StageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StageService {

    private StageRepository stageRepository;

    @Autowired
    public StageService(StageRepository stageRepository) {
        this.stageRepository = stageRepository;
    }

    public StageResponse addNewStage(StageSaveRequest stageSaveRequest) {
        StageEntity stageToSave = StageConverter.convertStageSaveRequestToStageEntity(stageSaveRequest);

        StageEntity savedStage = stageRepository.save(stageToSave);

        return StageConverter.convertStageEntityToStageResponse(savedStage);
    }

    public List<StageResponse> getStages() {
        List<StageEntity> stageEntityList = stageRepository.findAll();

        List<StageResponse> playerResponseList = new ArrayList<>();
        for (int i = 0; i < stageEntityList.size(); i++) {
            playerResponseList.add(StageConverter.convertStageEntityToStageResponse(stageEntityList.get(i)));
        }
        return playerResponseList;
    }
}
