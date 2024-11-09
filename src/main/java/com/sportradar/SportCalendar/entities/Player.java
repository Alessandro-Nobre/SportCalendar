package com.sportradar.SportCalendar.entities;

public class Player {

    private int playersId;
    private Team teamId;
    private String name;
    private int birthday;
    private int jersyNumber;

    public Player(){
    }

    public int getPlayersId() {
        return playersId;
    }

    public void setPlayersId(int playersId) {
        this.playersId = playersId;
    }

    public Team getTeamId() {
        return teamId;
    }

    public void setTeamId(Team teamId) {
        this.teamId = teamId;
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
