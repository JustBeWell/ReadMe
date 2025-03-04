package factorial;
/*
  Test cases
  1. factorial 0 -> 1
  2. factorial 1 -> 1
*/

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FactorialTest {
  Factorial factorial  ;

  @BeforeEach
  void setup() {
    factorial = new Factorial() ;
  }


  @Test
  @DisplayName("factorial de cero es 1")
  void factorialOfZeroIsOne() {
    int obtainedValue = factorial.factorial(0) ;
    int expectedValue = 1 ;

    assertEquals(expectedValue, obtainedValue) ;
  }

  @Test
  @DisplayName("1️⃣❗ = 1️⃣")
  void factorialOfOneIsOne() {
    int obtainedValue = factorial.factorial(1) ;
    int expectedValue = 1 ;

    assertEquals(expectedValue, obtainedValue) ;
  }

  @Test
  @DisplayName("Factorial de 2")
  void factorialOfTwoIsThree() {
    int obtainedValue = factorial.factorial(2) ;
    int expectedValue = 2;

    assertEquals(expectedValue, obtainedValue) ;
  }
}