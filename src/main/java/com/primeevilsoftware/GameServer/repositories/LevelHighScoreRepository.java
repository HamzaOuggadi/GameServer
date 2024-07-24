package com.primeevilsoftware.GameServer.repositories;

import com.primeevilsoftware.GameServer.entities.LevelHighScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LevelHighScoreRepository extends JpaRepository<LevelHighScore, Long> {

}
