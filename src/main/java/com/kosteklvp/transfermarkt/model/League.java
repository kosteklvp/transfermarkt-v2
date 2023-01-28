package com.kosteklvp.transfermarkt.model;


import javax.persistence.*;

@Entity
public class League {

  @Id
  private int leagueID;

  private String name;

  private int level;

  private int numberOfTeams;

  @ManyToOne(cascade = CascadeType.REMOVE)
  @JoinColumn(name = "countryID")
  private Country country;

}
