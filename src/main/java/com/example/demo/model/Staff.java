package com.example.demo.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("STAFF")
public class Staff extends Employee {

    public Staff() {
        super();
    }

    public Staff(String name, LocalDate dob) {
        this.name = name;
        this.dob = dob;
        this.type = EmployeeType.STAFF;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", type=" + type +
                ", basket=" + basket +
                '}';
    }
}
