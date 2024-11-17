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

@RestController
@RequestMapping(path = "api/controller")
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

}
