package com.kosteklvp.transfermarkt.model;

import javax.persistence.*;

@Entity
public class Country {
  @Id
  private int countryID;

  private String name;

}
