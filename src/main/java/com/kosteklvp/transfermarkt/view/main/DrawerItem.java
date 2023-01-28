package com.kosteklvp.transfermarkt.view.main;

import com.kosteklvp.transfermarkt.view.player.PlayerView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.icon.VaadinIcon;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DrawerItem {
  PLAYERS(VaadinIcon.USERS, "Players", PlayerView.class);

  private final VaadinIcon icon;
  private final String title;
  private final Class<? extends Component> navigationTarget;

}
