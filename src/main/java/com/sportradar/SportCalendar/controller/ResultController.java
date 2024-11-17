package com.sportradar.SportCalendar.controller;

import com.sportradar.SportCalendar.dto.result.ResultResponse;
import com.sportradar.SportCalendar.dto.result.ResultSaveRequest;
import com.sportradar.SportCalendar.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "api/result")
public class ResultController {

    private final ResultService resultService;

    @Autowired
    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }

    @GetMapping
    public ResponseEntity<List<ResultResponse>> getResults() {
        return new ResponseEntity<>(resultService.getResults(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ResultResponse> registerNewResult(@Valid @RequestBody ResultSaveRequest resultSaveRequest) {

        return new ResponseEntity<>(resultService.addNewResult(resultSaveRequest), HttpStatus.OK);
    }
}
