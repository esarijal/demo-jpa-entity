package com.example.demo.repository;

import com.example.demo.model.Carrot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarrotRepository extends JpaRepository<Carrot, Integer> {
}
