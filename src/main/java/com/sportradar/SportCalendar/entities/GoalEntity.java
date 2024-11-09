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
    @JoinColumn(name = "result_Id")
    private ResultEntity resultEntity;

    @ManyToOne
    @JoinColumn(name = "player_Id")
    private PlayerEntity playerEntity;

    public GoalEntity(){
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
}
