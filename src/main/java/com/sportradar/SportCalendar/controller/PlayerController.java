package com.sportradar.SportCalendar.controller;

import com.sportradar.SportCalendar.dto.player.PlayerResponse;
import com.sportradar.SportCalendar.dto.player.PlayerSaveRequest;
import com.sportradar.SportCalendar.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/player")
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {this.playerService = playerService;}

    @GetMapping
    public ResponseEntity<List<PlayerResponse>> getPlayers() {
        return new ResponseEntity<>(playerService.getPlayers(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PlayerResponse> registerNewPlayer(@Valid @RequestBody PlayerSaveRequest playerSaveRequest) {
        return new ResponseEntity<>(playerService.addNewPlayer(playerSaveRequest), HttpStatus.OK);
    }

    @GetMapping("/{playerId}")
    public ResponseEntity<Optional<PlayerResponse>> getPlayerById(@PathVariable int playerId) {
        return new ResponseEntity<>(playerService.getPlayerById(playerId), HttpStatus.OK);
    }

    @DeleteMapping("/{playerId}")
    public ResponseEntity<Void> deletePlayer(@PathVariable int playerId) {
        playerService.deletePlayerById(playerId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
