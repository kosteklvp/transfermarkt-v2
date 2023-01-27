package pl.kosteklvp.transfermarkt.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

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
