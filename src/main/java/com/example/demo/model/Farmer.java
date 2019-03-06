package com.example.demo.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("FARMER")
public class Farmer extends Employee {
}
