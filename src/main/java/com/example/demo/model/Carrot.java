package com.example.demo.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

@Entity
public class Carrot {
    @Id
    @GeneratedValue
    private int id;
    private LocalDate expiryDate;

    @ManyToOne
    private Basket basket;
    @ManyToOne
    private Freezer freezer;

    public Carrot() {
        expiryDate = LocalDate.now()
                .with(TemporalAdjusters.lastDayOfYear());
    }

    public Carrot(int id) {
        super();
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public Freezer getFreezer() {
        return freezer;
    }

    public void setFreezer(Freezer freezer) {
        this.freezer = freezer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Carrot carrot = (Carrot) o;

        if (id != carrot.id) return false;
        return expiryDate != null ? expiryDate.equals(carrot.expiryDate) : carrot.expiryDate == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (expiryDate != null ? expiryDate.hashCode() : 0);
        return result;
    }
}
