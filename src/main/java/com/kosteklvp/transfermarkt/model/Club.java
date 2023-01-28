package com.kosteklvp.transfermarkt.model;

import javax.persistence.*;

@Entity
public class Club {

  @Id
  private int clubID;

  private String name;

  @ManyToOne(cascade = CascadeType.REMOVE)
  @JoinColumn(name = "leagueID")
  private League league;

  public String getName() {
    return name;
  }

}
