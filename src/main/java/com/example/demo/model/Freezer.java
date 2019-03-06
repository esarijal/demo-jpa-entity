package com.example.demo.model;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Freezer {
    @Id
    @GeneratedValue
    private int id;

    @OneToOne
    private Manager manager;

    @OneToMany(cascade = { CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    },
            mappedBy = "freezer")
    private Set<Carrot> carrots;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
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
}
