package com.packt.cardatabase.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Car {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String brand, model, color, registrationNumber;
  private int year, price;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "owner")
  private Owner owner;

  public Car(String brand, String model, String color, String registrationNumber, int year, int price, Owner owner) {
    this.brand = brand;
    this.model = model;
    this.color = color;
    this.registrationNumber = registrationNumber;
    this.year = year;
    this.price = price;
    this.owner = owner;
  }
}
