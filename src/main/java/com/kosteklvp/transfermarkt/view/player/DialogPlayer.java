package com.kosteklvp.transfermarkt.view.player;

import com.kosteklvp.transfermarkt.view.component.ActionDialog;
import com.kosteklvp.transfermarkt.view.component.OperationMode;

public class DialogPlayer extends ActionDialog {

  public DialogPlayer(OperationMode mode) {
    super(mode);

    initialize();
  }

  private void initialize() {
    configureByOperationMode();

    add(new PlayerLayout());
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
  }

  private void configureForOpenMode() {
    setHeaderTitle("Modify player");
  }

}
