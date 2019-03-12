package com.example.demo;

import com.example.demo.service.EmployeeServiceTest;
import com.example.demo.suite.FibonacciTest;
import com.example.demo.suite.PrimeNumberCheckerTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        FibonacciTest.class,
        PrimeNumberCheckerTest.class,
        EmployeeServiceTest.class
})
public class TestSuite {
}
