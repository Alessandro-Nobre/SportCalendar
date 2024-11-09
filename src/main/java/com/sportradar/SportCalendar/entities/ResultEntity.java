package com.sportradar.SportCalendar.entities;

import jakarta.persistence.*;

@Entity
@Table(name= "result")
public class ResultEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int resultId;

    @Column
    private byte homeGoals;

    @Column
    private byte awayGoals;

    @Column
    private String winner;

    @Column
    private String message;

    public ResultEntity(){
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
