import org.junit.Test;
import static org.junit.Assert.*;

public class RobustBVA {

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
        double closeToMin = 1e-10;
        double closeToMax = 1e308;
        double nominal = 100;

        assertEquals("Min + Min", min + min, add(min, min), 0);
        assertEquals("Close to Min + Close to Min", closeToMin + closeToMin, add(closeToMin, closeToMin), 0);
        assertEquals("Nominal + Nominal", nominal + nominal, add(nominal, nominal), 0);
        assertEquals("Close to Max + Close to Max", closeToMax + closeToMax, add(closeToMax, closeToMax), 0);
        assertEquals("Max + Max", max + max, add(max, max), 0);
    }

    @Test
    public void testSubtraction() {
        double min = Double.MIN_VALUE;
        double max = Double.MAX_VALUE;
        double closeToMin = 1e-10;
        double closeToMax = 1e308;
        double nominal = 100;

        assertEquals("Min - Min", min - min, subtract(min, min), 0);
        assertEquals("Close to Min - Close to Min", closeToMin - closeToMin, subtract(closeToMin, closeToMin), 0);
        assertEquals("Nominal - Nominal", nominal - nominal, subtract(nominal, nominal), 0);
        assertEquals("Close to Max - Close to Max", closeToMax - closeToMax, subtract(closeToMax, closeToMax), 0);
        assertEquals("Max - Max", max - max, subtract(max, max), 0);
    }

    @Test
    public void testMultiplication() {
        double min = Double.MIN_VALUE;
        double max = Double.MAX_VALUE;
        double closeToMin = 1e-10;
        double closeToMax = 1e308;
        double nominal = 100;

        assertEquals("Min * Min", min * min, multiply(min, min), 0);
        assertEquals("Close to Min * Close to Min", closeToMin * closeToMin, multiply(closeToMin, closeToMin), 0);
        assertEquals("Nominal * Nominal", nominal * nominal, multiply(nominal, nominal), 0);
        assertEquals("Close to Max * Close to Max", closeToMax * closeToMax, multiply(closeToMax, closeToMax), 0);
        assertEquals("Max * Max", max * max, multiply(max, max), 0);
    }

    @Test
    public void testDivision() {
        double min = Double.MIN_VALUE;
        double max = Double.MAX_VALUE;
        double closeToMin = 1e-10;
        double closeToMax = 1e308;
        double nominal = 100;

        try {
            divide(10, 0);
            fail("Expected ArithmeticException for division by zero");
        } catch (ArithmeticException e) {
            assertEquals("Division by zero", e.getMessage());
        }

        assertEquals("Nominal / Nominal", nominal / nominal, divide(nominal, nominal), 0);
        assertEquals("Max / Max", max / max, divide(max, max), 0);
    }

    @Test
    public void testExponentiation() {
        double min = Double.MIN_VALUE;
        double max = Double.MAX_VALUE;
        double closeToMin = 1e-10;
        double closeToMax = 1e308;
        double nominal = 2;

        assertEquals("Min ^ 2", Math.pow(min, 2), exponentiate(min, 2), 0);
        assertEquals("Close to Min ^ 2", Math.pow(closeToMin, 2), exponentiate(closeToMin, 2), 0);
        assertEquals("Nominal ^ 3", Math.pow(nominal, 3), exponentiate(nominal, 3), 0);
        assertEquals("Close to Max ^ 2", Math.pow(closeToMax, 2), exponentiate(closeToMax, 2), 0);
        assertEquals("Max ^ 2", Math.pow(max, 2), exponentiate(max, 2), 0);
    }

    @Test
    public void testSquareRoot() {
        double min = Double.MIN_VALUE;
        double closeToMin = 1e-10;
        double nominal = 100;

        assertEquals("Sqrt of Min", Math.sqrt(min), sqrt(min), 0);
        assertEquals("Sqrt of Close to Min", Math.sqrt(closeToMin), sqrt(closeToMin), 0);
        assertEquals("Sqrt of Nominal", Math.sqrt(nominal), sqrt(nominal), 0);
        try {
            sqrt(-1);
            fail("Expected ArithmeticException for negative square root");
        } catch (ArithmeticException e) {
            assertEquals("Error: square root of negative number", e.getMessage());
        }
    }

    @Test
    public void testPercentage() {
        double min = Double.MIN_VALUE;
        double max = Double.MAX_VALUE;
        double nominal = 100;

        assertEquals("Percentage of Min", min / 100, percentage(min), 0);
        assertEquals("Percentage of Nominal", nominal / 100, percentage(nominal), 0);
        assertEquals("Percentage of Max", max / 100, percentage(max), 0);
    }

    @Test
    public void testFactorial() {
        int min = 0;
        int closeToMin = 1;
        int nominal = 5;
        int max = 20;

        assertEquals("Factorial of Min", 1, factorial(min));
        assertEquals("Factorial of Close to Min", 1, factorial(closeToMin));
        assertEquals("Factorial of Nominal", 120, factorial(nominal));
        assertEquals("Factorial of Max", 2432902008176640000L, factorial(max));
        try {
            factorial(-1);
            fail("Expected IllegalArgumentException for negative factorial");
        } catch (IllegalArgumentException e) {
            assertEquals("Error: Factorial of negative number", e.getMessage());
        }
    }
}
