package com.primeevilsoftware.GameServer.services;

import com.primeevilsoftware.GameServer.entities.LevelHighScore;
import com.primeevilsoftware.GameServer.entities.Player;

import java.util.List;

public interface PlayerService {

    List<Player> getAllPlayers();
    Player getPlayerByGamerTag(String gamerTag);
    Player getPlayerByID(Long playerID);

    LevelHighScore getPlayerHighScoreByLevelName(Long playerID, String levelName);
    List<LevelHighScore> getAllPlayerHighScores(Long playerID);

    void updatePlayerLevelHighScore(Long playerID, String levelName, Long newHighScore);

}
