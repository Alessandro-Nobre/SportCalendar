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
@Table(name = "goal")
public class GoalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int goalId;

    @Column
    private int time;

    @ManyToOne
    @JoinColumn(name = "result_id")
    private ResultEntity resultEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id")
    private PlayerEntity playerEntity;

    @Override
    public String toString() {
        return "GoalEntity{" +
                "goalId=" + goalId +
                ", time=" + time +
                ", resultEntity=" + resultEntity +
                ", playerEntity=" + playerEntity +
                '}';
    }
}
