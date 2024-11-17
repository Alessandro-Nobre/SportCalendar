package com.sportradar.SportCalendar.controller;


import com.sportradar.SportCalendar.dto.goals.GoalResponse;
import com.sportradar.SportCalendar.dto.goals.GoalSaveRequest;
import com.sportradar.SportCalendar.entities.GoalEntity;
import com.sportradar.SportCalendar.service.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "api/Goal")
public class GoalController {

    private final GoalService goalService;

    @Autowired
    public GoalController(GoalService goalService) {this.goalService = goalService;}

    @GetMapping
    public List<GoalEntity> getGoals() {return goalService.getGoals();}

    @PostMapping
    public ResponseEntity<GoalResponse> registerNewGoal(@Valid @RequestBody GoalSaveRequest goalSaveRequest) {

        return new ResponseEntity<>(goalService.addNewGoal(goalSaveRequest), HttpStatus.OK);
    }

}
