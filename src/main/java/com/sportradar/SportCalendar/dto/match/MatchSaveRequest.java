package com.sportradar.SportCalendar.dto.match;

import com.sportradar.SportCalendar.dto.result.ResultSaveRequest;
import com.sportradar.SportCalendar.dto.stage.StageSaveRequest;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class MatchSaveRequest {
    @NotBlank(message = "Must have a status")
    private String status;
    @NotNull(message = "Must have a season")
    private int season;
    @NotNull(message = "Must have a date and time")
    private LocalDateTime dateTime;
    @NotBlank(message = "Must have a stadium")
    private String stadium;
    @NotBlank(message = "Must have a matchGroup")
    private String matchGroup;
    @NotBlank(message = "Must have a originCompetitionId")
    private String originCompetitionId;
    @NotBlank(message = "Must have a originCompetitionName")
    private String originCompetitionName;
    @NotNull(message = "Must have a homeTeamId")
    private int homeTeamId;
    @NotNull(message = "Must have a awayTeamId")
    private int awayTeamId;
    @NotNull(message = "Must have a stage")
    private StageSaveRequest stage;
    @NotNull(message = "Must have a result")
    private ResultSaveRequest result;
}
