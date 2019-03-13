package com.example.demo.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("MANAGER")
public class Manager extends Employee {
    public Manager() {
    }

    public Manager(int id, String name, LocalDate dob) {
        super(id, name, dob);
    }

    public Manager(int id, String name, LocalDate dob, Basket basket) {
        super(id, name, dob, basket);
    }
}
