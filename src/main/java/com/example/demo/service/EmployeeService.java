package com.example.demo.service;

import com.example.demo.model.Basket;
import com.example.demo.model.Employee;
import com.example.demo.repository.BasketRepository;
import com.example.demo.repository.StaffRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final BasketRepository basketRepository;
    private final StaffRepository staffRepository;

    public EmployeeService(BasketRepository basketRepository, StaffRepository staffRepository) {
        this.basketRepository = basketRepository;
        this.staffRepository = staffRepository;
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
        return staffRepository.findAll().stream()
                .filter(e -> e.getBasket().getCarrots().size() > 0)
                .collect(Collectors.toMap(e -> e,
                        e -> e.getBasket().getCarrots().size()));
    }
}
