package com.kosteklvp.transfermarkt.view.player;

import com.kosteklvp.transfermarkt.model.Club;
import com.kosteklvp.transfermarkt.model.Country;
import com.kosteklvp.transfermarkt.model.player.Player;
import com.kosteklvp.transfermarkt.model.player.PlayerPosition;
import com.kosteklvp.transfermarkt.repo.ClubRepo;
import com.kosteklvp.transfermarkt.repo.CountryRepo;
import com.kosteklvp.transfermarkt.view.component.ComboBoxFactory;
import com.kosteklvp.transfermarkt.view.component.NotificationFactory;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;

import static com.vaadin.flow.component.textfield.TextFieldVariant.LUMO_ALIGN_RIGHT;

public class PlayerLayout extends FlexLayout {

  private TextField textFieldFirstName = new TextField("First name");
  private TextField textFieldLastName = new TextField("Last name");
  private IntegerField integerFieldValue = new IntegerField("Value");
  private ComboBox<Club> comboBoxClub;
  private Select<PlayerPosition> selectPosition = new Select<>();
  private ComboBox<Country> comboBoxNationality = new ComboBox<>("Nationality");

  private final Binder<Player> binder = new Binder<>();

  private final ClubRepo clubRepo;
  private final CountryRepo countryRepo;

  public PlayerLayout(ClubRepo clubRepo, CountryRepo countryRepo) {
    this.clubRepo = clubRepo;
    this.countryRepo = countryRepo;

    initialize();
    configureBinder();
  }

  private void initialize() {
    setFlexDirection(FlexDirection.COLUMN);

    textFieldFirstName.setWidth("40%");
    textFieldLastName.setWidth("60%");

    comboBoxClub = ComboBoxFactory.createComboBoxClub(clubRepo.findAll());
    comboBoxClub.setWidth("100%");

    comboBoxNationality.setWidth("100%");
    comboBoxNationality.setAllowCustomValue(true);

    Div euroSuffix = new Div();
    euroSuffix.setText("€");
    integerFieldValue.setSuffixComponent(euroSuffix);
    integerFieldValue.addThemeVariants(LUMO_ALIGN_RIGHT);
    integerFieldValue.setWidth("150px");

    selectPosition.setItems(PlayerPosition.values());
    selectPosition.setLabel("Position");
    selectPosition.setItemLabelGenerator(PlayerPosition::getName);
    selectPosition.setWidth("150px");

    add(new HorizontalLayout(textFieldFirstName, textFieldLastName));
    add(new HorizontalLayout(integerFieldValue, comboBoxClub));
    add(new HorizontalLayout(comboBoxNationality, selectPosition));
  }

  private void configureBinder() {
    binder.forField(textFieldFirstName)
            .asRequired()
            .bind(Player::getFirstName, Player::setFirstName);

    binder.forField(textFieldLastName)
            .asRequired()
            .bind(Player::getLastName, Player::setLastName);

    binder.forField(integerFieldValue)
            .asRequired()
            .bind(Player::getValue, Player::setValue);

    binder.forField(comboBoxClub)
            .asRequired()
            .bind(Player::getClub, Player::setClub);

    binder.forField(comboBoxNationality)
            .asRequired()
            .bind(Player::getNationality, Player::setNationality);

    binder.forField(selectPosition)
            .asRequired()
            .bind(Player::getPosition, Player::setPosition);
  }

  Player getPlayer() {
    Player player = new Player();

    try {
      binder.writeBean(player);
    } catch (ValidationException e) {
      NotificationFactory.error("All required fields must be filled");
      throw new RuntimeException(e);
    }

    return player;
  }

}
