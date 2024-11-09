package com.sportradar.SportCalendar.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.joda.time.DateTime;

import java.sql.Timestamp;

@Entity
@Table(name = "match")
public class MatchEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int matchId;

    @Column()
    private String season;

    @Column()
    private String status;

    @Column()
    private DateTime dateTime;

    @Column()
    private String stadium;

    @Column()
    private String matchGroup;

    @Column()
    private String originCompetitionId;

    @Column()
    private String originCompetitionName;

    @Column()
    private Timestamp created_at;

    @ManyToOne()
    @JoinColumn(name = "home_team_id")
    private TeamEntity homeTeam;

    @ManyToOne()
    @JoinColumn(name = "away_team_id")
    private TeamEntity awayTeam;

    @OneToOne()
    @JoinColumn(name = "result_id")
    private ResultEntity resultEntity;

    @OneToOne()
    @JoinColumn(name = "stage_id")
    private StageEntity stageEntity;

    public MatchEntity() {
    }

    public TeamEntity getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(TeamEntity homeTeamEntity) {
        this.homeTeam = homeTeamEntity;
    }

    public TeamEntity getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(TeamEntity awayTeamEntity) {
        this.awayTeam = awayTeamEntity;
    }

    public ResultEntity getResult() {
        return resultEntity;
    }

    public void setResult(ResultEntity resultEntity) {
        this.resultEntity = resultEntity;
    }

    public StageEntity getStage() {
        return stageEntity;
    }

    public void setStage(StageEntity stageEntity) {
        this.stageEntity = stageEntity;
    }

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public DateTime getDate() {
        return dateTime;
    }

    public void setDate(DateTime date) {
        this.dateTime = date;
    }

    public String getMatchGroup() {
        return matchGroup;
    }

    public void setMatchGroup(String group) {
        this.matchGroup = group;
    }

    public String getOriginCompetitionId() {
        return originCompetitionId;
    }

    public void setOriginCompetitionId(String originCompetitionId) {
        this.originCompetitionId = originCompetitionId;
    }

    public String getOriginCompetitionName() {
        return originCompetitionName;
    }

    public void setOriginCompetitionName(String originCompetitionName) {
        this.originCompetitionName = originCompetitionName;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }
}
