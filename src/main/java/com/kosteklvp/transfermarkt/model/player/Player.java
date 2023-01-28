package com.kosteklvp.transfermarkt.model.player;

import com.kosteklvp.transfermarkt.model.Club;
import com.kosteklvp.transfermarkt.model.Person;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Player {

  @Id
  private int playerID;

  private BigDecimal value;

  @OneToOne()
  @JoinColumn(name = "personID")
  private Person person;

  @ManyToOne()
  @JoinColumn(name = "clubID")
  private Club club;

  String getFirstName() {
    return person.getFirstName();
  }

  String getLastName() {
    return person.getLastName();
  }

  String getClub() {
    return club.getName();
  }

  String getNation() {
    return person.getNation().getName();
  }

  public BigDecimal getValue() {
    return value;
  }

}
