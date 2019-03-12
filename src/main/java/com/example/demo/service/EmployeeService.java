package com.example.demo.service;

import com.example.demo.model.Basket;
import com.example.demo.model.Employee;
import com.example.demo.repository.BasketRepository;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final BasketRepository basketRepository;
    private final EmployeeRepository employeeRepository;

    public EmployeeService(BasketRepository basketRepository, EmployeeRepository employeeRepository) {
        this.basketRepository = basketRepository;
        this.employeeRepository = employeeRepository;
    }

    @Transactional
    public void addBasketForAnEmployee(Basket basket, Employee employee){
        basket.addEmployee(employee);
        basketRepository.save(basket);
    }

    @Transactional
    public void removeBasketFromAnEmployee(Basket basket){
        basket.removeEmployee();
        basketRepository.save(basket);
    }

    public Map<Employee, Integer> findAllEmployeesCarrot(){
        return employeeRepository.findAll().stream()
                .filter(e -> e.getBasket().getCarrots().size() > 0)
                .collect(Collectors.toMap(e -> e,
                        e -> e.getBasket().getCarrots().size()));
    }
}
