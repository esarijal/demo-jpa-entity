package com.example.demo.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("STAFF")
public class Staff extends Employee {

    public Staff() {
    }

    public Staff(int id, String name, LocalDate dob) {
        super(id, name, dob);
    }

    public Staff(int id, String name, LocalDate dob, Basket basket) {
        super(id, name, dob, basket);
    }
}
