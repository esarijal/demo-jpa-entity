package com.example.demo.data;

import com.example.demo.model.Farmer;
import com.example.demo.model.Manager;
import com.example.demo.model.Staff;
import com.example.demo.repository.FarmerRepository;
import com.example.demo.repository.ManagerRepository;
import com.example.demo.repository.StaffRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeTest {

    @Autowired
    private StaffRepository staffRepository;
    @Autowired
    private FarmerRepository farmerRepository;
    @Autowired
    private ManagerRepository managerRepository;

    @Test
    public void testSaveEmployee_ok(){
        Staff staff = new Staff(1, "Esa Rijal", LocalDate.of(1985, 10, 21));
        staffRepository.save(staff);

        assertEquals(1, staffRepository.count());
        staffRepository.findAll().forEach(System.out::println);

        Farmer farmer = new Farmer(2, "Farmer 1", LocalDate.of(1985, 10, 21));
        farmerRepository.save(farmer);

        assertEquals(1, farmerRepository.count());
        farmerRepository.findAll().forEach(System.out::println);

        Manager manager = new Manager(3, "Manager 1", LocalDate.of(1985, 10, 21));
        managerRepository.save(manager);
        manager = new Manager(4, "Manager 2", LocalDate.of(1985, 10, 21));
        managerRepository.save(manager);

        assertEquals(2, managerRepository.count());
        managerRepository.findAll().forEach(System.out::println);


    }
}
