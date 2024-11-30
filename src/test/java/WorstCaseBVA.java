import org.junit.Test;
import static org.junit.Assert.*;

public class WorstCaseBVA {

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
        double min = Double.MIN_VALUE;
        double max = Double.MAX_VALUE;
        double justBelowMin = min - 1e-10;
        double justAboveMin = min + 1e-10;
        double justBelowMax = max - 1e-10;

        assertEquals(justBelowMin + justBelowMin, add(justBelowMin, justBelowMin), 0);
        assertEquals(min + min, add(min, min), 0);
        assertEquals(justAboveMin + justAboveMin, add(justAboveMin, justAboveMin), 0);
        assertEquals(max + max, add(max, max), 0);
        assertEquals(justBelowMax + justBelowMax, add(justBelowMax, justBelowMax), 0);
    }

    @Test
    public void testSubtraction() {
        double min = Double.MIN_VALUE;
        double max = Double.MAX_VALUE;
        double justBelowMin = min - 1e-10;
        double justAboveMin = min + 1e-10;
        double justBelowMax = max - 1e-10;

        assertEquals(justBelowMin - justBelowMin, subtract(justBelowMin, justBelowMin), 0);
        assertEquals(min - min, subtract(min, min), 0);
        assertEquals(justAboveMin - justAboveMin, subtract(justAboveMin, justAboveMin), 0);
        assertEquals(max - max, subtract(max, max), 0);
        assertEquals(justBelowMax - justBelowMax, subtract(justBelowMax, justBelowMax), 0);
    }

    @Test
    public void testMultiplication() {
        double min = Double.MIN_VALUE;
        double max = Double.MAX_VALUE;
        double justBelowMin = min - 1e-10;
        double justAboveMin = min + 1e-10;
        double justBelowMax = max - 1e-10;

        assertEquals(justBelowMin * justBelowMin, multiply(justBelowMin, justBelowMin), 0);
        assertEquals(min * min, multiply(min, min), 0);
        assertEquals(justAboveMin * justAboveMin, multiply(justAboveMin, justAboveMin), 0);
        assertEquals(max * max, multiply(max, max), 0);
        assertEquals(justBelowMax * justBelowMax, multiply(justBelowMax, justBelowMax), 0);
    }

    @Test
    public void testDivision() {
        double min = Double.MIN_VALUE;
        double max = Double.MAX_VALUE;
        double justBelowMin = min - 1e-10;
        double justAboveMin = min + 1e-10;
        double justBelowMax = max - 1e-10;

        try {
            divide(10, 0);
            fail("Expected ArithmeticException for division by zero");
        } catch (ArithmeticException e) {
            assertEquals("Division by zero", e.getMessage());
        }

        assertEquals(justBelowMin / justBelowMin, divide(justBelowMin, justBelowMin), 0);
        assertEquals(min / min, divide(min, min), 0);
        assertEquals(justAboveMin / justAboveMin, divide(justAboveMin, justAboveMin), 0);
        assertEquals(max / max, divide(max, max), 0);
        assertEquals(justBelowMax / justBelowMax, divide(justBelowMax, justBelowMax), 0);
    }

    @Test
    public void testExponentiation() {
        double min = Double.MIN_VALUE;
        double max = Double.MAX_VALUE;
        double justBelowMin = min - 1e-10;
        double justAboveMin = min + 1e-10;
        double justBelowMax = max - 1e-10;

        assertEquals(Math.pow(justBelowMin, 2), exponentiate(justBelowMin, 2), 0);
        assertEquals(Math.pow(min, 2), exponentiate(min, 2), 0);
        assertEquals(Math.pow(justAboveMin, 2), exponentiate(justAboveMin, 2), 0);
        assertEquals(Math.pow(max, 2), exponentiate(max, 2), 0);
        assertEquals(Math.pow(justBelowMax, 2), exponentiate(justBelowMax, 2), 0);
    }

    @Test
    public void testSquareRoot() {
        double min = Double.MIN_VALUE;
        double justBelowMin = min - 1e-10;
        double justAboveMin = min + 1e-10;
        double nominal = 100;

        try {
            sqrt(-1);
            fail("Expected ArithmeticException for square root of negative number");
        } catch (ArithmeticException e) {
            assertEquals("Error: square root of negative number", e.getMessage());
        }

        assertEquals(Math.sqrt(min), sqrt(min), 0);
        assertEquals(Math.sqrt(justAboveMin), sqrt(justAboveMin), 0);
        assertEquals(Math.sqrt(nominal), sqrt(nominal), 0);
    }

    @Test
    public void testFactorial() {
        int min = 0;
        int closeToMin = 1;
        int nominal = 5;
        int max = 20;

        try {
            factorial(-1);
            fail("Expected IllegalArgumentException for negative factorial");
        } catch (IllegalArgumentException e) {
            assertEquals("Error: Factorial of negative number", e.getMessage());
        }

        assertEquals(1, factorial(min));
        assertEquals(1, factorial(closeToMin));
        assertEquals(120, factorial(nominal));
        assertEquals(2432902008176640000L, factorial(max));
    }
}
