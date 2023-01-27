package pl.kosteklvp.transfermarkt.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Player {

  @Id
  private int playerID;

  @ManyToOne(cascade = CascadeType.REMOVE)
  @JoinColumn(name = "personID")
  private Person person;

}
