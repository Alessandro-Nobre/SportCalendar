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

    public MatchEntity(int matchId,
                       String season,
                       String status,
                       DateTime dateTime,
                       String stadium,
                       String matchGroup,
                       String originCompetitionId,
                       String originCompetitionName,
                       Timestamp created_at,
                       TeamEntity awayTeam,
                       TeamEntity homeTeam,
                       StageEntity stageEntity,
                       ResultEntity resultEntity) {
        this.matchId = matchId;
        this.season = season;
        this.status = status;
        this.dateTime = dateTime;
        this.stadium = stadium;
        this.matchGroup = matchGroup;
        this.originCompetitionId = originCompetitionId;
        this.originCompetitionName = originCompetitionName;
        this.created_at = created_at;
        this.awayTeam = awayTeam;
        this.homeTeam = homeTeam;
        this.stageEntity = stageEntity;
        this.resultEntity = resultEntity;
    }

    public MatchEntity(String season,
                       String status,
                       DateTime dateTime,
                       StageEntity stageEntity,
                       ResultEntity resultEntity,
                       TeamEntity awayTeam,
                       TeamEntity homeTeam,
                       Timestamp created_at,
                       String originCompetitionName,
                       String originCompetitionId,
                       String matchGroup,
                       String stadium) {
        this.season = season;
        this.status = status;
        this.dateTime = dateTime;
        this.stageEntity = stageEntity;
        this.resultEntity = resultEntity;
        this.awayTeam = awayTeam;
        this.homeTeam = homeTeam;
        this.created_at = created_at;
        this.originCompetitionName = originCompetitionName;
        this.originCompetitionId = originCompetitionId;
        this.matchGroup = matchGroup;
        this.stadium = stadium;
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

    @Override
    public String toString() {
        return "MatchEntity{" +
                "matchId=" + matchId +
                ", season='" + season + '\'' +
                ", status='" + status + '\'' +
                ", dateTime=" + dateTime +
                ", stadium='" + stadium + '\'' +
                ", matchGroup='" + matchGroup + '\'' +
                ", originCompetitionId='" + originCompetitionId + '\'' +
                ", originCompetitionName='" + originCompetitionName + '\'' +
                ", created_at=" + created_at +
                ", homeTeam=" + homeTeam +
                ", awayTeam=" + awayTeam +
                ", resultEntity=" + resultEntity +
                ", stageEntity=" + stageEntity +
                '}';
    }
}
