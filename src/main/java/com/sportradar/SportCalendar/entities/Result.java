package com.sportradar.SportCalendar.entities;

public class Result {

    private int resultId;
    private byte homeGoals;
    private byte awayGoals;
    private String winner;
    private String message;

    public Result(){
    }

    public int getResultId() {
        return resultId;
    }

    public void setResultId(int resultId) {
        this.resultId = resultId;
    }

    public byte getHomeGoals() {
        return homeGoals;
    }

    public void setHomeGoals(byte homeGoals) {
        this.homeGoals = homeGoals;
    }

    public byte getAwayGoals() {
        return awayGoals;
    }

    public void setAwayGoals(byte awayGoals) {
        this.awayGoals = awayGoals;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
