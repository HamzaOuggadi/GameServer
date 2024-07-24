package com.primeevilsoftware.GameServer.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlayerDTO {
    private Long id;
    private String gamerTag;
    private String email;
    private String password;
    private Long highestScore;
}
