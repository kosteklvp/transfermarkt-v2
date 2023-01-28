package com.kosteklvp.transfermarkt.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Person {

  @Id
  private int personID;

  private String firstName;

  private String lastName;

}
