package com.kosteklvp.transfermarkt.view.main;

import com.kosteklvp.transfermarkt.view.player.PlayerView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;

public enum DrawerItem {
  PLAYERS(VaadinIcon.USERS, "Players", PlayerView.class);

  private final VaadinIcon icon;
  private final String title;
  private final Class<? extends Component> navigationTarget;

  private DrawerItem(VaadinIcon icon, String title, Class<? extends Component> navigationTarget) {
    this.icon = icon;
    this.title = title;
    this.navigationTarget = navigationTarget;
  }

  public Icon getIcon() {
    return icon.create();
  }

  public String getTitle() {
    return title;
  }

  public Class<? extends Component> getNavigationTarget() {
    return navigationTarget;
  }

}
