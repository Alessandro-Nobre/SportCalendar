package com.sportradar.SportCalendar.entities;

public class Goal {

    private int goalId;
    private Result resultId;
    private Player playerId;
    private int time;

    public Goal(){
    }

    public Result getResultId() {
        return resultId;
    }

    public void setResultId(Result resultId) {
        this.resultId = resultId;
    }

    public int getGoalId() {
        return goalId;
    }

    public void setGoalId(int goalId) {
        this.goalId = goalId;
    }

    public Player getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Player playerId) {
        this.playerId = playerId;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
