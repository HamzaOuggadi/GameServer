package com.primeevilsoftware.GameServer.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class LevelHighScore {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String levelName;
    private Long previousHighScore;
    private Long currentHighScore;
    private LocalDateTime currentHighScoreDate;
    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;
}
