package com.example.demo.repository;

import com.example.demo.model.Staff;

import javax.transaction.Transactional;

@Transactional
public interface StaffRepository extends EmployeeRepository<Staff> {
}
