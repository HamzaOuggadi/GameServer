package com.primeevilsoftware.GameServer.controllers;

import com.primeevilsoftware.GameServer.entities.LevelHighScore;
import com.primeevilsoftware.GameServer.entities.Player;
import com.primeevilsoftware.GameServer.services.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/players")
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService playerService;


    @GetMapping
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/by-gamertag/{gamerTag}")
    public Player getPlayerByGamerTag(@PathVariable String gamerTag) {
        return playerService.getPlayerByGamerTag(gamerTag);
    }

    @GetMapping("/by-id/{playerID}")
    public Player getPlayerByID(@PathVariable Long playerID) {
        return playerService.getPlayerByID(playerID);
    }

    @GetMapping("/all-highscores-by-player-id/{playerID}")
    public List<LevelHighScore> getAllPlayerHighScore(@PathVariable Long playerID) {
        return playerService.getAllPlayerHighScores(playerID);
    }
}
