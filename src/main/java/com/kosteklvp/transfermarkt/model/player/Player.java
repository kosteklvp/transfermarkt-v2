package com.kosteklvp.transfermarkt.model.player;

import com.kosteklvp.transfermarkt.model.Club;
import com.kosteklvp.transfermarkt.model.Country;
import com.kosteklvp.transfermarkt.model.Person;

import javax.persistence.*;

@Entity
public class Player {

  @Id
  private int playerID;

  private int value;

  @OneToOne()
  @JoinColumn(name = "personID")
  private Person person;

  @ManyToOne()
  @JoinColumn(name = "clubID")
  private Club club;

  private PlayerPosition position;

  public String getFirstName() {
    return person.getFirstName();
  }

  public void setFirstName(String firstName) {
    this.person.setFirstName(firstName);
  }

  public String getLastName() {
    return person.getLastName();
  }

  public void setLastName(String lastName) {
    this.person.setLastName(lastName);
  }

  public Club getClub() {
    return club;
  }

  public void setClub(Club club) {
    this.club = club;
  }

  public Country getNationality() {
    return person.getNationality();
  }

  public void setNationality(Country nationality) {
    this.person.setNationality(nationality);
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public PlayerPosition getPosition() {
    return position;
  }

  public void setPosition(PlayerPosition position) {
    this.position = position;
  }

}
