package com.example.demo.repository;

import com.example.demo.model.Freezer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FreezerRepository extends JpaRepository<Freezer, Integer> {
}
