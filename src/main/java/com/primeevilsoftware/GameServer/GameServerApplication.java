package com.primeevilsoftware.GameServer;

import com.primeevilsoftware.GameServer.entities.LevelHighScore;
import com.primeevilsoftware.GameServer.entities.Player;
import com.primeevilsoftware.GameServer.repositories.LevelHighScoreRepository;
import com.primeevilsoftware.GameServer.repositories.PlayerRepository;
import com.primeevilsoftware.GameServer.services.PlayerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class GameServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameServerApplication.class, args);
	}

	@Bean
	CommandLineRunner start(PlayerService playerService,
							PlayerRepository playerRepository,
							LevelHighScoreRepository levelHighScoreRepository) {
		return args -> {

			LevelHighScore levelHighScore = LevelHighScore.builder()
					.levelName("Stage 1")
					.currentHighScoreDate(LocalDateTime.now())
					.currentHighScore(999L)
					.previousHighScore(990L)
					.build();

			Player player = Player.builder()
					.gamerTag("Oddest")
					.email("hamza@gmail.com")
					.password("1234")
					.highestScore(990L)
					.levelHighScores(List.of(levelHighScore))
					.build();

			levelHighScore.setPlayer(player);

			playerRepository.saveAndFlush(player);

			playerService.updatePlayerLevelHighScore(1L, "Stage 1", 9999L);



		};
	}

}
