package com.kosteklvp.transfermarkt.view.main;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.RouterLink;

import java.util.Arrays;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.STRETCH;

public class MainLayout extends AppLayout {

  public MainLayout() {
    initialize();
  }

  private void initialize() {
    createHeader();
    addDrawers();
  }

  private void createHeader() {
    H1 logo = new H1("Transfermarkt");
    logo.addClassNames("text-l", "m-m");

    HorizontalLayout header = new HorizontalLayout(new DrawerToggle(), logo);

    header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);

    header.setWidth("100%");
    header.addClassNames("py-0", "px-m");

    addToNavbar(header);
  }

  private void addDrawers() {
    Arrays.stream(DrawerItem.values()).forEach(this::addDrawer);
  }

  private void addDrawer(DrawerItem drawerItem) {
    RouterLink routerLink = new RouterLink(drawerItem.getTitle(), drawerItem.getNavigationTarget());

    routerLink.setHighlightCondition(HighlightConditions.sameLocation());

    HorizontalLayout drawerLayout = new HorizontalLayout();
    drawerLayout.setAlignItems(STRETCH);

    drawerLayout.add(drawerItem.getIcon().create(), routerLink);

    addToDrawer(drawerLayout);
  }

}
