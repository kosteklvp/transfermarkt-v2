package com.kosteklvp.transfermarkt.view.player;

import com.kosteklvp.transfermarkt.repo.PlayerRepo;
import com.kosteklvp.transfermarkt.view.component.ActionDialog;
import com.kosteklvp.transfermarkt.view.component.OperationMode;
import org.springframework.beans.factory.ObjectProvider;

public class DialogPlayer extends ActionDialog {

  private final PlayerLayout playerLayout =;
  private final PlayerRepo playerRepo;

  public DialogPlayer(OperationMode mode, PlayerRepo playerRepo) {
    super(mode);
    this.playerRepo = playerRepo;
    this.playerLayoutProvider = playerLayoutProvider;

    initialize();
  }

  private void initialize() {
    configureByOperationMode();

    add(playerLayoutProvider.getObject());
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

    setAcceptAction(click -> playerRepo.save(playerLayout.getPlayer()));
  }

  private void configureForOpenMode() {
    setHeaderTitle("Modify player");
  }

}
