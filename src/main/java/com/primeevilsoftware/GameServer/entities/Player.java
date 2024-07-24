package com.primeevilsoftware.GameServer.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Player {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String gamerTag;
    private String email;
    private String password;
    private Long highestScore;
    @OneToMany(mappedBy = "player")
    private List<LevelHighScore> levelHighScores;
}
