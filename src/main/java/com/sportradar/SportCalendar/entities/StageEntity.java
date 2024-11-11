package com.sportradar.SportCalendar.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
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

    @Override
    public String toString() {
        return "StageEntity{" +
                "stageId=" + stageId +
                ", name='" + name + '\'' +
                ", ordering=" + ordering +
                '}';
    }
}
