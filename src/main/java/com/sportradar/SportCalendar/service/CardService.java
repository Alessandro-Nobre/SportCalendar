package com.sportradar.SportCalendar.service;

import com.sportradar.SportCalendar.converter.CardConverter;
import com.sportradar.SportCalendar.dto.cards.CardResponse;
import com.sportradar.SportCalendar.dto.cards.CardSaveRequest;
import com.sportradar.SportCalendar.entities.CardEntity;
import com.sportradar.SportCalendar.entities.GoalEntity;
import com.sportradar.SportCalendar.entities.PlayerEntity;
import com.sportradar.SportCalendar.entities.ResultEntity;
import com.sportradar.SportCalendar.repository.CardRepository;
import com.sportradar.SportCalendar.repository.GoalRepository;
import com.sportradar.SportCalendar.repository.PlayerRepository;
import com.sportradar.SportCalendar.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CardService {

    private final CardRepository cardRepository;
    private final ResultRepository resultRepository;
    private final PlayerRepository playerRepository;
    private final GoalRepository goalRepository;

    @Autowired
    public CardService(CardRepository cardRepository, ResultRepository resultRepository, PlayerRepository playerRepository, GoalRepository goalRepository) {
        this.cardRepository = cardRepository;
        this.resultRepository = resultRepository;
        this.playerRepository = playerRepository;
        this.goalRepository = goalRepository;
    }

    public List<CardResponse> getAllCards() {
        List<CardEntity> cardList = cardRepository.findAll();

        List<CardResponse> cardResponseList = new ArrayList<>();
        for (int i = 0; i < cardList.size(); i++) {
            cardResponseList.add(CardConverter.convertCardEntitytoCardResponse(cardList.get(i)));
        }
        return cardResponseList;
    }

    public CardResponse addNewCard(CardSaveRequest cardSaveRequest) {
        ResultEntity resultEntity = resultRepository.getReferenceById(cardSaveRequest.getResultId());
        PlayerEntity playerEntity = playerRepository.getReferenceById(cardSaveRequest.getPlayerId());

        CardEntity cardToSave = CardConverter.convertCardSaveRequestToCardEntity(cardSaveRequest, resultEntity, playerEntity);

        CardEntity savedCard = cardRepository.save(cardToSave);

        return CardConverter.convertCardEntitytoCardResponse(savedCard);
    }

    public Optional<CardResponse> getCardById(int cardId) {
        Optional<CardEntity> cardEntity = cardRepository.findById(cardId);

        if (cardEntity.isPresent()) {
            return Optional.ofNullable(CardConverter.convertCardEntitytoCardResponse(cardEntity.get()));
        }

        return Optional.empty();
    }

    public void deleteGoalById(int goalId) {
        Optional<GoalEntity> goal = goalRepository.findById(goalId);

        if (goal.isPresent()) {
            goalRepository.deleteById(goalId);
        }

    }

}
