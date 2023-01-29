package com.kosteklvp.transfermarkt.view.component;

import com.vaadin.flow.component.notification.Notification;

import static com.vaadin.flow.component.notification.NotificationVariant.LUMO_ERROR;

public class NotificationFactory {

  public static final int NOTIFICATION_DURATION_IN_SECONDS = 4;

  public static void error(String message) {
    Notification notification = new Notification();
    notification.setText(message);
    notification.setDuration(NOTIFICATION_DURATION_IN_SECONDS * 1000);
    notification.addThemeVariants(LUMO_ERROR);

    notification.open();
  }

}
