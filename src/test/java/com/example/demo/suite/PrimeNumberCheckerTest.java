package com.example.demo.suite;

import com.example.demo.helper.PrimeNumberChecker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class PrimeNumberCheckerTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
                {2, true},
                {3, true},
                {4, false},
                {14, false},
                {17, true},
                {21, false},
                {23, true},
                {24, false},
                {37, true}
        });
    }

    @Parameterized.Parameter
    public int input;
    @Parameterized.Parameter(1)
    public boolean output;

    @Test
    public void test(){
        assertEquals(output, PrimeNumberChecker.validate(input));
    }

}
