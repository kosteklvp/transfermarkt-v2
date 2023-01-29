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
  CURRENT_CLUB("Current club", player -> player.getClub().getName()),
  COUNTRY("Country", player -> player.getNationality().getName());

  private final String header;

  private final ValueProvider<Player, String> valueProvider;

}
