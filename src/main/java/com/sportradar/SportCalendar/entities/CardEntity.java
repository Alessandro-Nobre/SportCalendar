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
@Table(name = "card")
public class CardEntity {

    @Id
    @PrimaryKeyJoinColumn
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cardId;

    @Column
    private String cardType;

    @Column
    private String reason;

    @Column
    private int time;

    @ManyToOne
    @JoinColumn(name = "result_id")
    private ResultEntity resultEntity;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private PlayerEntity playerEntity;

    @Override
    public String toString() {
        return "CardEntity{" +
                "cardId=" + cardId +
                ", cardType='" + cardType + '\'' +
                ", reason='" + reason + '\'' +
                ", time=" + time +
                ", resultEntity=" + resultEntity +
                ", playerEntity=" + playerEntity +
                '}';
    }
}
