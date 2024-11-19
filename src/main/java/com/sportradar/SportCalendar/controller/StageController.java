package com.sportradar.SportCalendar.controller;

import com.sportradar.SportCalendar.dto.stage.StageResponse;
import com.sportradar.SportCalendar.dto.stage.StageSaveRequest;
import com.sportradar.SportCalendar.service.StageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/stage")
public class StageController {

    private final StageService stageService;

    @Autowired
    public StageController(StageService stageService) { this.stageService = stageService;}

    @GetMapping
    public ResponseEntity<List<StageResponse>> getStages() {
        return new ResponseEntity<>(stageService.getStages(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StageResponse> registerNewStage(@Valid @RequestBody StageSaveRequest stageSaveRequest){

        return new ResponseEntity<>(stageService.addNewStage(stageSaveRequest), HttpStatus.OK);
    }

    @GetMapping("/{stageId}")
    public ResponseEntity<Optional<StageResponse>> getStageById(@PathVariable int stageId) {
        return new ResponseEntity<>(stageService.getStageById(stageId), HttpStatus.OK);
    }

    @DeleteMapping("/{stageId}")
    public ResponseEntity<Void> deleteStage(@PathVariable int stageId) {
        stageService.deleteStageById(stageId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
