package com.kosteklvp.transfermarkt.model.player;

import com.vaadin.flow.function.ValueProvider;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import static org.apache.commons.lang3.StringUtils.SPACE;

@AllArgsConstructor
@Getter
public enum PlayerColumn {
  NAME("", player -> StringUtils.join(player.getFirstName(), SPACE, player.getLastName())),
  VALUE("Value", player -> String.valueOf(player.getValue())),
  CURRENT_CLUB("Current club", Player::getClub),
  COUNTRY("Country", Player::getNation);

  private final String label;

  private final ValueProvider<Player, String> valueProvider;

}
