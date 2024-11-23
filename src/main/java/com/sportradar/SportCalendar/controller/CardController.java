package com.sportradar.SportCalendar.controller;

import com.sportradar.SportCalendar.dto.cards.CardResponse;
import com.sportradar.SportCalendar.dto.cards.CardSaveRequest;
import com.sportradar.SportCalendar.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/card")
public class CardController {

    private final CardService cardService;

    @Autowired
    public CardController(CardService cardService) {this.cardService = cardService;}

    @GetMapping
    public ResponseEntity<List<CardResponse>> getAllCards() {
        return new ResponseEntity<>(cardService.getAllCards(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CardResponse> registerNewCard(@Valid @RequestBody CardSaveRequest cardSaveRequest ) {
        return new ResponseEntity<>(cardService.addNewCard(cardSaveRequest), HttpStatus.OK);
    }

    @GetMapping("/{cardId}")
    public ResponseEntity<Optional<CardResponse>> getCardById(@PathVariable int cardId) {
        return new ResponseEntity<>(cardService.getCardById(cardId), HttpStatus.OK);
    }

    @DeleteMapping("/{cardId}")
    public ResponseEntity<Void> deleteCard(@PathVariable int cardId) {

        try {
            this.cardService.deleteCardById(cardId);

        }  catch (Exception e) {
            throw new RuntimeException("Failed to delete card ID: " + cardId, e);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
