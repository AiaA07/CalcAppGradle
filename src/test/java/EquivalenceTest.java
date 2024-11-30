import org.junit.Test;
import static org.junit.Assert.*;

public class EquivalenceTest {

    private double add(double x, double y) {
        return x + y;
    }
    private double subtract(double x, double y) {
        return x - y;
    }
    private double multiply(double x, double y) {
        return x * y;
    }
    private double divide(double x, double y) {
        if (y == 0) throw new ArithmeticException("Division by zero");
        return x / y;
    }
    private double exponentiate(double x, double y) {
        return Math.pow(x, y);
    }
    private double sqrt(double x) {
        if (x < 0) throw new ArithmeticException("Error: square root of negative number");
        return Math.sqrt(x);
    }
    private double percentage(double x) {
        return x / 100;
    }
    private long factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("Error: Factorial of negative number");
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    @Test
    public void testAddition() {

        assertEquals(5 + 3, add(5, 3), 0);
        assertEquals(-5 + -3, add(-5, -3), 0);
        assertEquals(0 + 0, add(0, 0), 0);

        try {
            add(Double.MAX_VALUE, Double.MAX_VALUE);
        } catch (Exception e) {
            assertTrue(e instanceof ArithmeticException);
        }

        assertEquals(100 + -50, add(100, -50), 0);
    }

    @Test
    public void testSubtraction() {
        assertEquals(8 - 3, subtract(8, 3), 0);
        assertEquals(-8 - (-3), subtract(-8, -3), 0);
        assertEquals(0 - 0, subtract(0, 0), 0);

        try {
            subtract(Double.MAX_VALUE, Double.MIN_VALUE);
        } catch (Exception e) {
            assertTrue(e instanceof ArithmeticException);
        }

        assertEquals(10 - 0, subtract(10, 0), 0);
    }

    @Test
    public void testMultiplication() {
        assertEquals(5 * 3, multiply(5, 3), 0);
        assertEquals(-5 * -3, multiply(-5, -3), 0);
        assertEquals(0 * 5, multiply(0, 5), 0);

        try {
            multiply(Double.MAX_VALUE, Double.MAX_VALUE);
        } catch (Exception e) {
            assertTrue(e instanceof ArithmeticException);
        }

        assertEquals(0 * 0, multiply(0, 0), 0);
    }

    @Test
    public void testDivision() {
        assertEquals(10 / 2, divide(10, 2), 0);
        assertEquals(-10 / -2, divide(-10, -2), 0);
        assertEquals(0 / 10, divide(0, 10), 0);

        try {
            divide(10, 0);
        } catch (Exception e) {
            assertTrue(e instanceof ArithmeticException);
        }

        assertEquals(1e308 / 1e-308, divide(1e308, 1e-308), 0);
    }

    @Test
    public void testExponentiation() {
        assertEquals(Math.pow(2, 3), exponentiate(2, 3), 0);
        assertEquals(Math.pow(-2, 3), exponentiate(-2, 3), 0);
        assertEquals(Math.pow(0, 3), exponentiate(0, 3), 0);

        try {
            exponentiate(2, 1024);
        } catch (Exception e) {
            assertTrue(e instanceof ArithmeticException);
        }

        try {
            exponentiate(-2, 0.5);
        } catch (Exception e) {
            assertTrue(e instanceof ArithmeticException);
        }
    }

    @Test
    public void testSquareRoot() {
        assertEquals(Math.sqrt(16), sqrt(16), 0);
        assertEquals(Math.sqrt(0), sqrt(0), 0);

        try {
            sqrt(-1);
        } catch (Exception e) {
            assertTrue(e instanceof ArithmeticException);
        }

        assertEquals(Math.sqrt(1e308), sqrt(1e308), 0);
    }

    @Test
    public void testFactorial() {
        assertEquals(1, factorial(0));
        assertEquals(1, factorial(1));
        assertEquals(120, factorial(5));

        try {
            factorial(21);
        } catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
        }

        try {
            factorial(-5);
        } catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
    }
}
