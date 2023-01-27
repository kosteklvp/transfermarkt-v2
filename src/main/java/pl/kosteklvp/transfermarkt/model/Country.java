package pl.kosteklvp.transfermarkt.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Country {

  @Id
  private int countryID;

  private String name;

}
