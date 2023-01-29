package com.kosteklvp.transfermarkt.view.player;

import com.kosteklvp.transfermarkt.repo.PlayerRepo;
import com.kosteklvp.transfermarkt.view.component.ActionDialog;
import com.kosteklvp.transfermarkt.view.component.OperationMode;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.data.binder.ValidationException;

public class DialogPlayer extends ActionDialog {

  private final PlayerLayout playerLayout = new PlayerLayout();
  private final PlayerRepo playerRepo;

  public DialogPlayer(OperationMode mode, PlayerRepo playerRepo) {
    super(mode);
    this.playerRepo = playerRepo;

    initialize();
  }

  private void initialize() {
    configureByOperationMode();

    add(playerLayout);
  }

  private void configureByOperationMode() {
    switch (mode) {
      case ADD:
        configureForAddMode();
        break;
      case OPEN:
        configureForOpenMode();
        break;
      default:
        throw new IllegalStateException("Unexpected operation mode: " + mode);
    }
  }

  private void configureForAddMode() {
    setHeaderTitle("Add new player");

    setAcceptAction(click -> {
      try {
        playerRepo.save(playerLayout.getPlayer());
      } catch (ValidationException e) {
        new Notification("bbb").open();
      }

      new Notification("Suer").open();
    });
  }

  private void configureForOpenMode() {
    setHeaderTitle("Modify player");
  }

}
