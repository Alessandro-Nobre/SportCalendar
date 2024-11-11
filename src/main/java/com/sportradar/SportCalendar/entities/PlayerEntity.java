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
    @JoinColumn(name = "team_id")
    private TeamEntity teamEntity;

    @Override
    public String toString() {
        return "PlayerEntity{" +
                "playerId=" + playerId +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", jersyNumber=" + jersyNumber +
                ", teamEntity=" + teamEntity +
                '}';
    }
}
