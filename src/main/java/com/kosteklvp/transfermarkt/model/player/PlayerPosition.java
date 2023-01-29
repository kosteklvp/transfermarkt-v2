package com.kosteklvp.transfermarkt.model.player;

import lombok.Getter;

@Getter
public enum PlayerPosition {
  GOALKEEPER("Goalkeeper"),
  DEFENDER("Defender"),
  MIDFIELDER("Midfielder"),
  ATTACKER("Attacker");

  private final String name;

  PlayerPosition(String name) {
    this.name = name;
  }

}
