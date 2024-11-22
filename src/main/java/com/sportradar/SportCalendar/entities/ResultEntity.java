package com.sportradar.SportCalendar.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
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

    @OneToMany(mappedBy = "resultEntity", cascade = CascadeType.ALL)
    private List<GoalEntity> goals;

    @OneToMany(mappedBy = "resultEntity", cascade = CascadeType.ALL)
    private List<CardEntity> cards;

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
