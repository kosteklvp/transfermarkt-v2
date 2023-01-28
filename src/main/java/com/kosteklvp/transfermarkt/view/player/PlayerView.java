package com.kosteklvp.transfermarkt.view.player;

import com.kosteklvp.transfermarkt.model.player.Player;
import com.kosteklvp.transfermarkt.model.player.PlayerUtils;
import com.kosteklvp.transfermarkt.repo.PlayerRepo;
import com.kosteklvp.transfermarkt.view.main.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Players | Transfermarkt")
@Route(value="players", layout = MainLayout.class)
public class PlayerView extends VerticalLayout {

  private final PlayerRepo playerRepo;

  Grid<Player> grid = new Grid<>(Player.class);
  TextField filterText = new TextField();

  public PlayerView(PlayerRepo playerRepo) {
    this.playerRepo = playerRepo;

    addClassName("list-view");
    setSizeFull();
    configureGrid();

    add(getToolbar(), grid);
  }

  private void configureGrid() {
    grid.setSizeFull();
    grid.setColumns(PlayerUtils.getGridColumns());


    grid.addColumn(contact -> "jeden").setHeader("Status");


    grid.addColumn(contact -> "dwa").setHeader("Company");
    grid.getColumns().forEach(col -> col.setAutoWidth(true));


  }

  private HorizontalLayout getToolbar() {
    filterText.setPlaceholder("Filter by name...");
    filterText.setClearButtonVisible(true);
    filterText.setValueChangeMode(ValueChangeMode.LAZY);



    Button addContactButton = new Button("Add contact");

    HorizontalLayout toolbar = new HorizontalLayout(filterText, addContactButton);


    toolbar.addClassName("toolbar");
    return toolbar;
  }

}
