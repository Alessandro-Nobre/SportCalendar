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
}
