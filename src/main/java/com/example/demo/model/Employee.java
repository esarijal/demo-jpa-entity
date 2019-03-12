package com.example.demo.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public class Employee {
    public enum EmployeeType {STAFF, MANAGER, FARMER}

    @Id
    @GeneratedValue
    protected int id;
    protected String name;
    protected LocalDate dob;
    @Column(insertable = false, updatable = false)
    protected EmployeeType type;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    protected Basket basket;

    public Employee() {
        type = EmployeeType.STAFF;
    }

    public Employee(int id, String name, LocalDate dob, EmployeeType type) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.type = type;
    }

    public Employee(int id, String name, LocalDate dob, EmployeeType type, Basket basket) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.type = type;
        this.basket = basket;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public EmployeeType getType() {
        return type;
    }

    public void setType(EmployeeType type) {
        this.type = type;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }
}
