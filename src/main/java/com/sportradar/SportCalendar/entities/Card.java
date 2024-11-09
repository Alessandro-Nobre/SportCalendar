package com.sportradar.SportCalendar.entities;

public class Card {


    private int cardId;
    private Result resultId;
    private Player playerId;
    private String cardType;
    private String reason;
    private int time;

    public Card(){
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public Result getResultId() {
        return resultId;
    }

    public void setResultId(Result resultId) {
        this.resultId = resultId;
    }

    public Player getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Player playerId) {
        this.playerId = playerId;
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
}
