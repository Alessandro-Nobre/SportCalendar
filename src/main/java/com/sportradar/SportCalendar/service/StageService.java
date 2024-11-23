package com.sportradar.SportCalendar.service;

import com.sportradar.SportCalendar.converter.StageConverter;
import com.sportradar.SportCalendar.dto.stage.StageResponse;
import com.sportradar.SportCalendar.dto.stage.StageSaveRequest;
import com.sportradar.SportCalendar.entities.StageEntity;
import com.sportradar.SportCalendar.repository.StageRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

        List<StageResponse> stageResponseList = new ArrayList<>();
        for (int i = 0; i < stageEntityList.size(); i++) {
            stageResponseList.add(StageConverter.convertStageEntityToStageResponse(stageEntityList.get(i)));
        }
        return stageResponseList;
    }

    public Optional<StageResponse> getStageById(int stageId) {
        Optional<StageEntity> stageEntity = stageRepository.findById(stageId);

        if (stageEntity.isPresent()) {
            return Optional.ofNullable(StageConverter.convertStageEntityToStageResponse(stageEntity.get()));
        }

        return Optional.empty();
    }

    @Transactional
    public void deleteStageById(int stageId) throws Exception {

        StageEntity stageEntity= stageRepository.getReferenceById(stageId);

        if (stageEntity == null) {
            throw new Exception("Stage Not Found");
        }

        stageRepository.delete(stageEntity);
    }


}
