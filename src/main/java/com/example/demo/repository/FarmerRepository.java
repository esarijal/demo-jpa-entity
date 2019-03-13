package com.example.demo.repository;

import com.example.demo.model.Farmer;

import javax.transaction.Transactional;

@Transactional
public interface FarmerRepository extends EmployeeRepository<Farmer> {
}
