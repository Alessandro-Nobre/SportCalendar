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

    public ResultEntity(byte homeGoals,
                        byte awayGoals,
                        String winner,
                        String message) {
        this.homeGoals = homeGoals;
        this.awayGoals = awayGoals;
        this.winner = winner;
        this.message = message;
    }

    public ResultEntity(int resultId,
                        byte homeGoals,
                        byte awayGoals,
                        String winner,
                        String message) {
        this.resultId = resultId;
        this.homeGoals = homeGoals;
        this.awayGoals = awayGoals;
        this.winner = winner;
        this.message = message;
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

    @Override
    public String toString() {
        return "ResultEntity{" +
                "resultId=" + resultId +
                ", homeGoals=" + homeGoals +
                ", awayGoals=" + awayGoals +
                ", winner='" + winner + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
