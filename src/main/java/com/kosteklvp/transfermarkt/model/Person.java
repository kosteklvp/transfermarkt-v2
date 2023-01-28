package com.kosteklvp.transfermarkt.model;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
public class Person {

  @Id
  private int personID;

  private String firstName;

  private String lastName;

  @ManyToOne()
  @JoinColumn(name = "countryID")
  private Country nation;

  public Country getNation() {
    return nation;
  }

}
