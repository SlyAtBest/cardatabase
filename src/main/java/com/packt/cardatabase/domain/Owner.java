package com.packt.cardatabase.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Owner {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long ownerId;
  private String firstName, lastName;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
  @JsonIgnore
  private List<Car> cars;

  public Owner(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }
}
