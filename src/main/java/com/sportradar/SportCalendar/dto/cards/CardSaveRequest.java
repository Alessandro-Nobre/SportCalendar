package com.sportradar.SportCalendar.dto.cards;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CardSaveRequest {

    private String cardType;
    private String reason;
    private int time;
    private int resultId;
    private int playerId;



}
