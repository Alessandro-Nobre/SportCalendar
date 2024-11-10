package com.sportradar.SportCalendar.entities;

import jakarta.persistence.*;

@Entity
@Table(name= "stage")
public class StageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stageId;

    @Column
    private String name;

    @Column
    private int ordering;

    public StageEntity(){
    }

    public StageEntity(String name,
                       int ordering) {
        this.name = name;
        this.ordering = ordering;
    }

    public StageEntity(int stageId,
                       String name,
                       int ordering) {
        this.stageId = stageId;
        this.name = name;
        this.ordering = ordering;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStageId() {
        return stageId;
    }

    public void setStageId(int stageId) {
        this.stageId = stageId;
    }

    public int getOrdering() {
        return ordering;
    }

    public void setOrdering(int ordering) {
        this.ordering = ordering;
    }

    @Override
    public String toString() {
        return "StageEntity{" +
                "stageId=" + stageId +
                ", name='" + name + '\'' +
                ", ordering=" + ordering +
                '}';
    }
}
