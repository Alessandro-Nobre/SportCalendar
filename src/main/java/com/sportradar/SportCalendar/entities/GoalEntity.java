package com.sportradar.SportCalendar.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "goal")
public class GoalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int goalId;

    @Column
    private int time;

    @ManyToOne
    @JoinColumn(name = "result_id")
    private ResultEntity resultEntity;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private PlayerEntity playerEntity;

    public GoalEntity(){
    }

    public GoalEntity(int time,
                      ResultEntity resultEntity,
                      PlayerEntity playerEntity) {
        this.time = time;
        this.resultEntity = resultEntity;
        this.playerEntity = playerEntity;
    }

    public GoalEntity(int goalId,
                      PlayerEntity playerEntity,
                      ResultEntity resultEntity,
                      int time) {
        this.goalId = goalId;
        this.playerEntity = playerEntity;
        this.resultEntity = resultEntity;
        this.time = time;
    }

    public ResultEntity getResultId() {
        return resultEntity;
    }

    public void setResultId(ResultEntity resultEntityId) {
        this.resultEntity = resultEntityId;
    }

    public int getGoalId() {
        return goalId;
    }

    public void setGoalId(int goalId) {
        this.goalId = goalId;
    }

    public PlayerEntity getPlayer() {
        return playerEntity;
    }

    public void setPlayer(PlayerEntity playerEntity) {
        this.playerEntity = playerEntity;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "GoalEntity{" +
                "goalId=" + goalId +
                ", time=" + time +
                ", resultEntity=" + resultEntity +
                ", playerEntity=" + playerEntity +
                '}';
    }
}
