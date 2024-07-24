package com.primeevilsoftware.GameServer.services.impl;

import com.primeevilsoftware.GameServer.entities.LevelHighScore;
import com.primeevilsoftware.GameServer.entities.Player;
import com.primeevilsoftware.GameServer.exceptions.LevelHighScoreException;
import com.primeevilsoftware.GameServer.exceptions.PlayerException;
import com.primeevilsoftware.GameServer.repositories.PlayerRepository;
import com.primeevilsoftware.GameServer.services.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;

    @Override
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @Override
    public Player getPlayerByGamerTag(String gamerTag) {
        Optional<Player> playerOptional = playerRepository.findByGamerTag(gamerTag);
        if (playerOptional.isPresent()) {
            return playerOptional.get();
        } else {
            throw new PlayerException("Player not found with GameTag : " + gamerTag, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Player getPlayerByID(Long playerID) {
        Optional<Player> playerOptional = playerRepository.findById(playerID);
        if (playerOptional.isPresent()) {
            return playerOptional.get();
        } else {
            throw new PlayerException("Player not found with ID : " + playerID, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public LevelHighScore getPlayerHighScoreByLevelName(Long playerID, String levelName) {
        Optional<LevelHighScore> optionalLevelHighScore = getAllPlayerHighScores(playerID)
                .stream()
                .filter(levelHighScore -> levelName.equals(levelHighScore.getLevelName()))
                .findFirst();
        if (optionalLevelHighScore.isPresent()) {
            return optionalLevelHighScore.get();
        } else {
            throw new LevelHighScoreException("Couldn't find the HighScore for the level : " + levelName + " for player ID : " + playerID,
                    HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public List<LevelHighScore> getAllPlayerHighScores(Long playerID) {
        return getPlayerByID(playerID).getLevelHighScores();
    }

    /**
     * Used to set and update the player's highs core for a specific level
     * @param playerID
     * @param levelName
     * @param newHighScore
     */
    @Override
    public void updatePlayerLevelHighScore(Long playerID, String levelName, Long newHighScore) {
        LevelHighScore levelHighScore = getPlayerHighScoreByLevelName(playerID, levelName);
        if (newHighScore > levelHighScore.getCurrentHighScore()) {
            levelHighScore.setPreviousHighScore(levelHighScore.getCurrentHighScore());
            levelHighScore.setCurrentHighScore(newHighScore);
        }
    }
}
