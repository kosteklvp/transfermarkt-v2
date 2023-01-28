package com.kosteklvp.transfermarkt.model;

import javax.persistence.*;

@Entity
public class Trainer {

  @Id
  private int trainerID;

  @ManyToOne(cascade = CascadeType.REMOVE)
  @JoinColumn(name = "personID")
  private Person person;

}
