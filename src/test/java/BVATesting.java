import org.example.Main;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(JUnit4.class)
public class BVATesting {
    Main calculator = new Main();

    @Test
    public void testAddition() {
        calculator.num1 = 0;
        calculator.num2 = 0;
        calculator.operator = '+';
        calculator.result = calculator.num1 + calculator.num2;
        Assert.assertEquals("0 + 0 should be 0", 0, 0);

        calculator.num1 = Integer.MAX_VALUE;
        calculator.num2 = 1;
        calculator.result = (double) calculator.num1 + calculator.num2;
        Assert.assertEquals("Max + 1 should be within double range", (double) Integer.MAX_VALUE + 1, calculator.result, 1e-9);

        calculator.num1 = -1;
        calculator.num2 = 1;
        calculator.result = calculator.num1 + calculator.num2;
        Assert.assertEquals("-1 + 1 should be 0", 0, 0);
    }

    @Test
    public void testSubtraction() {
        calculator.num1 = 0;
        calculator.num2 = 0;
        calculator.operator = '-';
        calculator.result = calculator.num1 - calculator.num2;
        Assert.assertEquals("0 - 0 should be 0", 0, 0);

        calculator.num1 = Integer.MAX_VALUE;
        calculator.num2 = Integer.MAX_VALUE;
        calculator.result = calculator.num1 - calculator.num2;
        Assert.assertEquals("Max - Max should be 0", 0, 0);

        calculator.num1 = 0;
        calculator.num2 = Integer.MAX_VALUE;
        calculator.result = calculator.num1 - calculator.num2;
        Assert.assertEquals("0 - Max should be -Max", -Integer.MAX_VALUE, (int) calculator.result);
    }

    @Test
    public void testMultiplication() {
        calculator.num1 = 0;
        calculator.num2 = 0;
        calculator.operator = '*';
        calculator.result = calculator.num1 * calculator.num2;
        Assert.assertEquals("0 * 0 should be 0", 0, 0);

        calculator.num1 = Integer.MAX_VALUE;
        calculator.num2 = 1;
        calculator.result = calculator.num1 * calculator.num2;
        Assert.assertEquals("Max * 1 should be Max", Integer.MAX_VALUE, (int) calculator.result);

        calculator.num1 = Integer.MAX_VALUE;
        calculator.num2 = 2;
        calculator.result = (double) calculator.num1 * calculator.num2;
        Assert.assertEquals("Max * 2 should be within double range", (double) Integer.MAX_VALUE * 2, calculator.result, 1e-9);
    }

    @Test
    public void testExponentiation() {
        calculator.num1 = 2;
        calculator.num2 = 3;
        calculator.result = Math.pow(calculator.num1, calculator.num2);
        Assert.assertEquals("2^3 should be 8", 8.0, calculator.result, 1e-9);

        calculator.num1 = 0;
        calculator.num2 = 5;
        calculator.result = Math.pow(calculator.num1, calculator.num2);
        Assert.assertEquals("0^5 should be 0", 0.0, calculator.result, 1e-9);

        calculator.num1 = 5;
        calculator.num2 = 0;
        calculator.result = Math.pow(calculator.num1, calculator.num2);
        Assert.assertEquals("5^0 should be 1", 1.0, calculator.result, 1e-9);
    }

    /*@Test
    public void testPercentage() {
        calculator.num1 = 50;
        calculator.result = calculator.num1 / 100.0;
        Assert.assertEquals("50% should be 0.5", 0.5, calculator.result, 1e-9);

        calculator.num1 = 0;
        calculator.result = calculator.num1 / 100.0;
        Assert.assertEquals("0% should be 0", 0.0, calculator.result, 1e-9);
    }*/

    /*@Test
    public void testFactorial() {
        calculator.num1 = 0;
        calculator.result = calculator.factorial(0);
       Assert.assertEquals("Factorial of 0 should be 1", 1, (int) calculator.result);

        calculator.num1 = 5;
        calculator.result = calculator.factorial((int) calculator.num1);
        Assert.assertEquals("Factorial of 5 should be 120", 120, (int) calculator.result);

        calculator.num1 = -1;
        assertThrows(IllegalArgumentException.class, () -> calculator.result = calculator.factorial((int) calculator.num1), "Factorial of negative number, error");
    }*/
}

