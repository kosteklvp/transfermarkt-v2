package com.kosteklvp.transfermarkt.view.component;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;

public abstract class ActionDialog extends Dialog {

  private static final String DEFAULT_DIALOG_WIDTH = "600px";
  private static final String DEFAULT_DIALOG_HEIGHT = "400px";

  private final Button acceptButton = new Button("Accept");
  private final Button cancelButton = new Button("Cancel");

  protected final OperationMode mode;

  protected ActionDialog(OperationMode mode) {
    this.mode = mode;

    initialize();
  }

  private void initialize() {
    setHeight(DEFAULT_DIALOG_HEIGHT);
    setWidth(DEFAULT_DIALOG_WIDTH);

    configureFooter();
  }

  private void configureFooter() {
    cancelButton.addClickListener(click -> close());
    getFooter().add(cancelButton);

    acceptButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
    getFooter().add(acceptButton);
  }

  protected void setAcceptAction(ComponentEventListener<ClickEvent<Button>> listener) {
    acceptButton.addClickListener(listener);
  }

}
