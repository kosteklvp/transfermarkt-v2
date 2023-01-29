package com.kosteklvp.transfermarkt.view.player;

import com.kosteklvp.transfermarkt.model.Club;
import com.kosteklvp.transfermarkt.model.Country;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.BigDecimalField;
import com.vaadin.flow.component.textfield.TextField;

import static com.vaadin.flow.component.textfield.TextFieldVariant.LUMO_ALIGN_RIGHT;

public class PlayerLayout extends FormLayout {

  private final TextField textFieldFirstName = new TextField("First name");
  private final TextField textFieldLastName = new TextField("Last name");
  private final BigDecimalField bigDecimalFieldValue = new BigDecimalField("Value");
  private final ComboBox<Country> comboBoxNationality = new ComboBox<>("Nationality");
  private final ComboBox<Club> comboBoxClub = new ComboBox<>("Club");

  public PlayerLayout() {
    initialize();
  }

  private void initialize() {


    Div euroSuffix = new Div();
    euroSuffix.setText("€");
    bigDecimalFieldValue.setSuffixComponent(euroSuffix);
    bigDecimalFieldValue.addThemeVariants(LUMO_ALIGN_RIGHT);
//    bigDecimalFieldValue.set

    add(textFieldFirstName, textFieldLastName);
    add(bigDecimalFieldValue);
    add(comboBoxNationality, comboBoxClub);
  }

}
