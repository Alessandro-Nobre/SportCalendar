package com.sportradar.SportCalendar.dto.cards;

import com.sportradar.SportCalendar.dto.player.PlayerResponse;
import com.sportradar.SportCalendar.dto.result.ResultResponse;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CardResponse {
    private int cardId;
    private String cardType;
    private String reason;
    private int time;
    private ResultResponse result;
    private PlayerResponse player;

}
