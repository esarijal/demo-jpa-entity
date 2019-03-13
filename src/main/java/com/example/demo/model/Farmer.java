package com.example.demo.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("FARMER")
public class Farmer extends Employee {
    public Farmer() {
    }

    public Farmer(int id, String name, LocalDate dob) {
        super(id, name, dob);
    }

    public Farmer(int id, String name, LocalDate dob, Basket basket) {
        super(id, name, dob, basket);
    }
}
