package com.kosteklvp.transfermarkt.model.player;

import java.util.Arrays;

public class PlayerUtils {

  public static String[] getGridColumns() {
    return Arrays.stream(PlayerColumn.values()).map(PlayerColumn::getHeader).toArray(String[]::new);
  }

}
