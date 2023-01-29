package com.kosteklvp.transfermarkt.view.component;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;

public abstract class ActionDialog extends Dialog {

  private static final String DEFAULT_DIALOG_WIDTH = "600px";
  private static final String DEFAULT_DIALOG_HEIGHT = "400px";

  protected final OperationMode mode;

  protected ActionDialog(OperationMode mode) {
    this.mode = mode;

    initialize();
  }

  private void initialize() {
    setHeight(DEFAULT_DIALOG_WIDTH);
    setWidth(DEFAULT_DIALOG_HEIGHT);

    configureFooter();
  }

  private void configureFooter() {
    Button cancelButton = new Button("Cancel");
    cancelButton.addClickListener(click -> close());
    getFooter().add(cancelButton);

    Button acceptButton = new Button("Accept");
    acceptButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
    getFooter().add(acceptButton);
  }

}
