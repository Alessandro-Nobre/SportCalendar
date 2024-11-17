package com.sportradar.SportCalendar.converter;

import com.sportradar.SportCalendar.dto.cards.CardResponse;
import com.sportradar.SportCalendar.dto.cards.CardSaveRequest;
import com.sportradar.SportCalendar.entities.CardEntity;
import com.sportradar.SportCalendar.entities.PlayerEntity;
import com.sportradar.SportCalendar.entities.ResultEntity;
import lombok.Builder;


public class CardConverter {

    @Builder
    public static CardEntity convertCardSaveRequestToCardEntity(CardSaveRequest cardSaveRequest, ResultEntity resultEntity, PlayerEntity playerEntity) {
        return CardEntity.builder()
                .cardType(cardSaveRequest.getCardType())
                .reason(cardSaveRequest.getReason())
                .time(cardSaveRequest.getTime())
                .resultEntity(resultEntity)
                .playerEntity(playerEntity)
                .build();

    }


    @Builder
    public static CardResponse convertCardEntitytoCardResponse(CardEntity cardEntity) {
        return CardResponse.builder()
                .cardId(cardEntity.getCardId())
                .cardType(cardEntity.getCardType())
                .reason(cardEntity.getReason())
                .time(cardEntity.getTime())
                .result(ResultConverter.convertResultEntityToResultResponse(cardEntity.getResultEntity()))
                .player(PlayerConverter.convertPlayerEntityToPlayerResponse(cardEntity.getPlayerEntity()))
                .build();
    }

}