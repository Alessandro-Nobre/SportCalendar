package com.sportradar.SportCalendar.entities;

import jakarta.persistence.*;

@Entity
@Table(name= "player")
public class PlayerEntity {

    @Id
    @PrimaryKeyJoinColumn
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int playerId;
    @Column
    private String name;
    @Column
    private int birthday;
    @Column
    private int jersyNumber;

    @ManyToOne
    @JoinColumn(name = "teamId")
    private TeamEntity teamEntity;

    public PlayerEntity(){
    }

    public int getPlayersId() {
        return playerId;
    }

    public void setPlayersId(int playersId) {
        this.playerId = playersId;
    }

    public TeamEntity getTeam() {
        return teamEntity;
    }

    public void setTeam(TeamEntity teamEntity) {
        this.teamEntity = teamEntity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthday() {
        return birthday;
    }

    public void setBirthday(int birthday) {
        this.birthday = birthday;
    }

    public int getJersyNumber() {
        return jersyNumber;
    }

    public void setJersyNumber(int jersyNumber) {
        this.jersyNumber = jersyNumber;
    }
}
