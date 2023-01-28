package com.kosteklvp.transfermarkt.model;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Country {

  @Id
  private int countryID;

  private String name;

}
