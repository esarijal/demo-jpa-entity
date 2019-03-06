package com.example.demo.service;

import com.example.demo.model.Basket;
import com.example.demo.model.Employee;
import com.example.demo.repository.BasketRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class EmployeeService {

    private BasketRepository basketRepository;

    public EmployeeService(BasketRepository basketRepository) {
        this.basketRepository = basketRepository;
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
}
