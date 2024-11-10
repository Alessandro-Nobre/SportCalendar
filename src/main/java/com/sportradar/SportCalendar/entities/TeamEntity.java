package com.sportradar.SportCalendar.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name= "team")
public class TeamEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int teamId;

    @Column()
    private String name;

    @Column()
    private String status;

    @Column()
    private String officialName;

    @Column()
    private String slug;

    @Column()
    private String abbreviation;

    @Column()
    private String stagePosition;

    @Column()
    private int playersId;

    public TeamEntity(){
    }

    public TeamEntity(String name,
                      String status,
                      String officialName,
                      String slug,
                      String abbreviation,
                      String stagePosition,
                      int playersId) {
        this.name = name;
        this.status = status;
        this.officialName = officialName;
        this.slug = slug;
        this.abbreviation = abbreviation;
        this.stagePosition = stagePosition;
        this.playersId = playersId;
    }

    public TeamEntity(int teamId,
                      String name,
                      String status,
                      String officialName,
                      String slug,
                      String abbreviation,
                      String stagePosition,
                      int playersId) {
        this.teamId = teamId;
        this.name = name;
        this.status = status;
        this.officialName = officialName;
        this.slug = slug;
        this.abbreviation = abbreviation;
        this.stagePosition = stagePosition;
        this.playersId = playersId;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getOfficialName() {
        return officialName;
    }

    public void setOfficialName(String officialName) {
        this.officialName = officialName;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getStagePosition() {
        return stagePosition;
    }

    public void setStagePosition(String stagePosition) {
        this.stagePosition = stagePosition;
    }

    public int getPlayersId() {
        return playersId;
    }

    public void setPlayersId(int playersId) {
        this.playersId = playersId;
    }

    @Override
    public String toString() {
        return "TeamEntity{" +
                "teamId=" + teamId +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", officialName='" + officialName + '\'' +
                ", slug='" + slug + '\'' +
                ", abbreviation='" + abbreviation + '\'' +
                ", stagePosition='" + stagePosition + '\'' +
                ", playersId=" + playersId +
                '}';
    }


}
