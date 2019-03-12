package com.example.demo.helper;

public class PrimeNumberChecker {
   public static boolean validate(final Integer primeNumber) {
      int factors = 0;
      int j = 1;

      while(j <= primeNumber)
      {
         if(primeNumber % j == 0)
         {
            factors++;
         }
         j++;
      }
      return (factors == 2);
   }
}