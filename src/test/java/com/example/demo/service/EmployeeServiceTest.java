package com.example.demo.service;

import com.example.demo.model.Basket;
import com.example.demo.model.Carrot;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.*;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {

    private List<Employee> employees ;

    @Mock
    private EmployeeRepository employeeRepository;
    @InjectMocks
    private EmployeeService employeeService;

    @Before
    public void setUp() throws Exception {
        Basket basketA = new Basket(1);
        basketA.setCarrots(
                new HashSet<>(Arrays.asList(
                        new Carrot(1),
                        new Carrot(2),
                        new Carrot(3),
                        new Carrot(4),
                        new Carrot(5)
                ))
        );

        Basket basketB = new Basket(2);
        basketB.setCarrots(
                new HashSet<>(Arrays.asList(
                        new Carrot(11),
                        new Carrot(22),
                        new Carrot(33)
                ))
        );

        Employee employeeA = new Employee(1, "Esa",
                LocalDate.of(1987, 10, 22), Employee.EmployeeType.STAFF,
                basketA);

        Employee employeeB = new Employee(1, "Rijal",
                LocalDate.of(1987, 10, 21), Employee.EmployeeType.STAFF,
                basketB);

        employees = new ArrayList<>();
        employees.add(employeeA);
        employees.add(employeeB);
    }

    @Test
    public void findAllCarrots_Test(){
        when(employeeRepository.findAll()).thenReturn(employees);

        Map<Employee, Integer> allEmployeesCarrot = employeeService.findAllEmployeesCarrot();
        allEmployeesCarrot.entrySet().forEach(System.out::println);
    }
}
