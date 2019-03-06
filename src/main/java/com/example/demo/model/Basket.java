package com.example.demo.model;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Basket {
    @Id
    @GeneratedValue
    private int id;

    @OneToOne
    private Employee employee;

    @OneToMany(cascade = { CascadeType.MERGE,
                            CascadeType.PERSIST,
                            CascadeType.REFRESH
                            },
                mappedBy = "basket")
    private Set<Carrot> carrots;

    public Basket(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Set<Carrot> getCarrots() {
        return carrots;
    }

    public void setCarrots(Set<Carrot> carrots) {
        this.carrots = carrots;
    }

    @Transactional
    public void addCarrot(Carrot carrot){
        if(carrots == null){
            carrots = new HashSet<>();
        }
        carrots.add(carrot);
    }

    @Transactional
    public void removeCarrot(Carrot carrot){
        if(carrots != null){
            carrots.remove(carrot);
        }
    }

    @Transactional
    public void addEmployee(Employee employee){
        this.employee = employee;
    }

    @Transactional
    public void removeEmployee(){
        this.employee = null;
    }
}
