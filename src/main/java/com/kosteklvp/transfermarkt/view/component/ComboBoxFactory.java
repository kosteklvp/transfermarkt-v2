package com.kosteklvp.transfermarkt.view.component;

import com.kosteklvp.transfermarkt.model.Club;
import com.vaadin.flow.component.combobox.ComboBox;
import lombok.NoArgsConstructor;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class ComboBoxFactory {

  public static ComboBox<Club> createComboBoxClub(List<Club> clubs) {
    ComboBox<Club> comboBox = new ComboBox<>();
    comboBox.setAllowCustomValue(true);
    comboBox.setItemLabelGenerator(Club::getName);
    comboBox.setItems(clubs);

    comboBox.addCustomValueSetListener(e -> {
      Club club = new Club();
      club.setName(e.getDetail());

      List<Club> newClubs = clubs;
      newClubs.add(club);

      comboBox.setItems(newClubs);
      comboBox.setValue(club);
    });

    return comboBox;
  }

}
