package com.kosteklvp.transfermarkt.model;

import javax.persistence.*;

@Entity
public class Player {

  @Id
  private int playerID;

  @ManyToOne(cascade = CascadeType.REMOVE)
  @JoinColumn(name = "personID")
  private Person person;

}
