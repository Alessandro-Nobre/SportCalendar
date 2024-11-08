package com.sportradar.SportCalendar.entities;

public class MatchInfo {

    private int matchId;
    private String season;
    private String status;
    private int timeVenueUTC;
    private int date;
    private String stadium;
    private int homeTeam;
    private int awayTeam;
    private int result;
    private String group;
    private String originCompetitionId;
    private String originCompetitionName;
    private int created_at;

    public MatchInfo() {
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

    public int getTimeVenueUTC() {
        return timeVenueUTC;
    }

    public void setTimeVenueUTC(int timeVenueUTC) {
        this.timeVenueUTC = timeVenueUTC;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public int getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(int homeTeam) {
        this.homeTeam = homeTeam;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(int awayTeam) {
        this.awayTeam = awayTeam;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
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

    public int getCreated_at() {
        return created_at;
    }

    public void setCreated_at(int created_at) {
        this.created_at = created_at;
    }
}
