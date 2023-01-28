package pl.kosteklvp.transfermarkt.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Person {

  @Id
  private int personID;

  private String firstName;

  private String lastName;

}
