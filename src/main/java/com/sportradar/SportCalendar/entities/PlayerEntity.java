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
@Table(name= "player")
public class PlayerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int playerId;

    @Column
    private String name;

    @Column
    private int birthday;

    @Column
    private int jerseyNumber;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private TeamEntity teamEntity;

    @OneToMany(mappedBy = "playerEntity", cascade = CascadeType.ALL)
    private List<CardEntity> cards;

    @OneToMany(mappedBy = "playerEntity", cascade = CascadeType.ALL)
    private List<GoalEntity> goals;

    @Override
    public String toString() {
        return "PlayerEntity{" +
                "playerId=" + playerId +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", jerseyNumber=" + jerseyNumber +
                ", teamEntity=" + teamEntity +
                '}';
    }
}
