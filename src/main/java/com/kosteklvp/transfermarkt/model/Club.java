package pl.kosteklvp.transfermarkt.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Club {

  @Id
  private int clubID;

  private String name;

  @ManyToOne(cascade = CascadeType.REMOVE)
  @JoinColumn(name = "leagueID")
  private League league;

}
