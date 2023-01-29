package com.kosteklvp.transfermarkt.view.player;

import com.kosteklvp.transfermarkt.model.player.Player;
import com.kosteklvp.transfermarkt.model.player.PlayerColumn;
import com.kosteklvp.transfermarkt.repo.PlayerRepo;
import com.kosteklvp.transfermarkt.view.main.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import static com.kosteklvp.transfermarkt.view.component.OperationMode.ADD;

@PageTitle("Players | Transfermarkt")
@Route(value="players", layout = MainLayout.class)
public class PlayerView extends VerticalLayout {

  private final PlayerRepo playerRepo;
  private final Grid<Player> grid = new Grid<>(Player.class);

  public PlayerView(PlayerRepo playerRepo) {
    this.playerRepo = playerRepo;

    initialize();
  }

  private void initialize() {
    setSizeFull();

    configureToolbar();
    configureGrid();
  }

  private void configureGrid() {
    grid.setSizeFull();

    configureColumns();

    add(grid);
  }

  private void configureColumns() {
    for (PlayerColumn column : PlayerColumn.values()) {
      grid.addColumn(column.getValueProvider())
          .setHeader(column.getHeader())
          .setAutoWidth(true);
    }
  }

  private void configureToolbar() {
    Button buttonAdd = new Button("Add", d -> new DialogPlayer(ADD).open());
    Button buttonOpen = new Button("Open");
    Button buttonDelete = new Button("Delete");

    add(new HorizontalLayout(buttonAdd, buttonOpen, buttonDelete));
  }

}
