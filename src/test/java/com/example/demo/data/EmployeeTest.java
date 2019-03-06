package com.example.demo.data;

import com.example.demo.model.Employee;
import com.example.demo.model.Staff;
import com.example.demo.repository.EmployeeRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void testSaveStaff_ok(){
        Staff staff = new Staff("Esa Rijal", LocalDate.of(1985, 10, 21));
        Staff saved = employeeRepository.save(staff);

        Optional<Employee> optStaff = employeeRepository.findById(saved.getId());
        assert optStaff.isPresent();
        Staff result = (Staff) optStaff.get();

        assertEquals(Employee.EmployeeType.STAFF, result.getType());

        result.setType(Employee.EmployeeType.FARMER);
        saved = employeeRepository.save(result);
        optStaff = employeeRepository.findById(saved.getId());
        assert optStaff.isPresent();
        result = (Staff) optStaff.get();

        assertNotEquals(Employee.EmployeeType.STAFF, result.getType());
        assertEquals(Employee.EmployeeType.FARMER, result.getType());
    }
}
