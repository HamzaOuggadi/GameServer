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

			//playerService.updatePlayerLevelHighScore(1L, "Stage 1", 9999L);

			LevelHighScore levelHighScore2 = LevelHighScore.builder()
					.levelName("Stage 1")
					.currentHighScoreDate(LocalDateTime.now())
					.currentHighScore(1245L)
					.previousHighScore(122L)
					.build();

			Player player2 = Player.builder()
					.gamerTag("Player2")
					.email("player2@email.com")
					.password("1234")
					.highestScore(122L)
					.levelHighScores(List.of(levelHighScore2))
					.build();

			levelHighScore2.setPlayer(player2);


			LevelHighScore levelHighScore3 = LevelHighScore.builder()
					.levelName("Stage 1")
					.currentHighScoreDate(LocalDateTime.now())
					.currentHighScore(1343L)
					.previousHighScore(990L)
					.build();

			Player player3 = Player.builder()
					.gamerTag("Player3")
					.email("player3@gmail.com")
					.password("1234")
					.highestScore(990L)
					.levelHighScores(List.of(levelHighScore3))
					.build();

			levelHighScore3.setPlayer(player3);

			LevelHighScore levelHighScore4 = LevelHighScore.builder()
					.levelName("Stage 1")
					.currentHighScoreDate(LocalDateTime.now())
					.currentHighScore(4563L)
					.previousHighScore(99L)
					.build();

			Player player4 = Player.builder()
					.gamerTag("Player4")
					.email("Player4@gmail.com")
					.password("1234")
					.highestScore(90L)
					.levelHighScores(List.of(levelHighScore4))
					.build();

			levelHighScore4.setPlayer(player4);

			LevelHighScore levelHighScore5 = LevelHighScore.builder()
					.levelName("Stage 1")
					.currentHighScoreDate(LocalDateTime.now())
					.currentHighScore(88L)
					.previousHighScore(0L)
					.build();

			Player player5 = Player.builder()
					.gamerTag("Player5")
					.email("player5@gmail.com")
					.password("1234")
					.highestScore(7876679L)
					.levelHighScores(List.of(levelHighScore5))
					.build();

			levelHighScore5.setPlayer(player5);


			LevelHighScore levelHighScore6 = LevelHighScore.builder()
					.levelName("Stage 1")
					.currentHighScoreDate(LocalDateTime.now())
					.currentHighScore(809L)
					.previousHighScore(1L)
					.build();

			Player player6 = Player.builder()
					.gamerTag("Player6")
					.email("player6@gmail.com")
					.password("1234")
					.highestScore(0L)
					.levelHighScores(List.of(levelHighScore6))
					.build();

			levelHighScore6.setPlayer(player6);


			LevelHighScore levelHighScore7 = LevelHighScore.builder()
					.levelName("Stage 1")
					.currentHighScoreDate(LocalDateTime.now())
					.currentHighScore(99999999L)
					.previousHighScore(100L)
					.build();

			Player player7 = Player.builder()
					.gamerTag("Player7")
					.email("player7@gmail.com")
					.password("1234")
					.highestScore(99999999999L)
					.levelHighScores(List.of(levelHighScore7))
					.build();

			levelHighScore7.setPlayer(player7);


			playerRepository.saveAndFlush(player);
			playerRepository.saveAndFlush(player2);
			playerRepository.saveAndFlush(player3);
			playerRepository.saveAndFlush(player4);
			playerRepository.saveAndFlush(player5);
			playerRepository.saveAndFlush(player6);
			playerRepository.saveAndFlush(player7);


		};
	}

}
