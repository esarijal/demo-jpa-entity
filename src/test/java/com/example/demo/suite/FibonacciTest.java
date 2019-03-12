package com.example.demo.suite;

import com.example.demo.helper.Fibonacci;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FibonacciTest {

//    public FibonacciTest(int input, int expected) {
//        this.input = input;
//        this.expected = expected;
//    }

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][] {
                { 0, 0 }, { 1, 1 }, { 2, 1 }, { 3, 2 }, { 4, 3 }, { 5, 5 }, { 6, 8 }
        });
    }

    @Parameterized.Parameter
    public int input;
    @Parameterized.Parameter(1)
    public int expected;

    @Test
    public void test(){
        assertEquals(expected, Fibonacci.compute(input));
    }
}
