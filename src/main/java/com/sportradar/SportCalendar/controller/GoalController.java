package com.sportradar.SportCalendar.controller;


import com.sportradar.SportCalendar.dto.goals.GoalResponse;
import com.sportradar.SportCalendar.dto.goals.GoalSaveRequest;
import com.sportradar.SportCalendar.service.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/goal")
public class GoalController {

    private final GoalService goalService;

    @Autowired
    public GoalController(GoalService goalService) {this.goalService = goalService;}

    @GetMapping
    public ResponseEntity<List<GoalResponse>> getAllGoals() {
        return new ResponseEntity<>(goalService.getAllGoals(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GoalResponse> registerNewGoal(@Valid @RequestBody GoalSaveRequest goalSaveRequest) {

        return new ResponseEntity<>(goalService.addNewGoal(goalSaveRequest), HttpStatus.OK);
    }

    @GetMapping("/{goalId}")
    public ResponseEntity<Optional<GoalResponse>> getGoalById(@PathVariable int goalId) {
        return new ResponseEntity<>(goalService.getGoalById(goalId), HttpStatus.OK);
    }

    @DeleteMapping("/{goalId}")
    public ResponseEntity<Void> deleteGoal(@PathVariable int goalId) {

        try {
            this.goalService.deleteGoalById(goalId);

        } catch (Exception e) {
            throw new RuntimeException("Failed to delete goal ID: " + goalId, e);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
