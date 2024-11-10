package com.sportradar.SportCalendar.entities;

import jakarta.persistence.*;

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


    public CardEntity(){
    }

    public CardEntity(String cardType,
                      String reason,
                      int time,
                      ResultEntity resultEntity,
                      PlayerEntity playerEntity) {
        this.cardType = cardType;
        this.reason = reason;
        this.time = time;
        this.resultEntity = resultEntity;
        this.playerEntity = playerEntity;
    }

    public CardEntity(int cardId,
                      String cardType,
                      String reason,
                      int time,
                      ResultEntity resultEntity,
                      PlayerEntity playerEntity) {
        this.cardId = cardId;
        this.cardType = cardType;
        this.reason = reason;
        this.time = time;
        this.resultEntity = resultEntity;
        this.playerEntity = playerEntity;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public ResultEntity getResult() {
        return resultEntity;
    }

    public void setResult(ResultEntity resultEntity) {
        this.resultEntity = resultEntity;
    }

    public PlayerEntity getPlayer() {
        return playerEntity;
    }

    public void setPlayer(PlayerEntity playerEntityId) {
        this.playerEntity = playerEntityId;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

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
