package com.example.demo.repository;

import com.example.demo.model.Manager;

import javax.transaction.Transactional;

@Transactional
public interface ManagerRepository extends EmployeeRepository<Manager> {
}
