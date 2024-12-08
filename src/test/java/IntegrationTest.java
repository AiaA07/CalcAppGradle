import org.example.Main;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


@RunWith(JUnit4.class)
public class IntegrationTest {
    Main calculator;

    @Before
    public void init(){
        calculator = new Main();
    }
    /*
     * Input: 2 + 3
     * Expected Output: 5.0 */
    @Test
    public void testAdditionIntegration() {
        calculator.textField.setText("2");
        calculator.addButton.doClick();
        calculator.textField.setText("3");
        calculator.equButton.doClick();
        Assert.assertEquals("5.0", calculator.textField.getText());
    }
    /*
     * Input: 5-3
     * Expected Output: 2.0*/
    @Test
    public void testSubtractionIntegration() {
        calculator.textField.setText("5");
        calculator.subButton.doClick();
        calculator.textField.setText("3");
        calculator.equButton.doClick();
        Assert.assertEquals("2.0", calculator.textField.getText());
    }
    /*
     * Input: 2*4
     * Expected Output: 8.0*/
    @Test
    public void testMultiplicationIntegration() {
        calculator.textField.setText("4");
        calculator.mulButton.doClick();
        calculator.textField.setText("2");
        calculator.equButton.doClick();
        Assert.assertEquals("8.0", calculator.textField.getText());
    }
    /*
     * Input: 9/3
     * Expected Output: 3.0*/
    @Test
    public void testDivisionIntegration() {
        calculator.textField.setText("9");
        calculator.divButton.doClick();
        calculator.textField.setText("3");
        calculator.equButton.doClick();
        Assert.assertEquals("3.0", calculator.textField.getText());
    }
    /*
     * Input: 3!
     * Expected Output: 6.0 */
    @Test
    public void testFactorialIntegration() {
        calculator.textField.setText("3");
        calculator.factButton.doClick();
        calculator.equButton.doClick();
        Assert.assertEquals("6.0", calculator.textField.getText());
    }
    /*
     * Input: 3^2
     * Expected Output: 9.0 */
    @Test
    public void testExponentIntegration() {
        calculator.textField.setText("3");
        calculator.expoButton.doClick();
        calculator.textField.setText("2");
        calculator.equButton.doClick();
        Assert.assertEquals("9.0", calculator.textField.getText());

    }
    /*
     * Input: 5%
     * Expected Output: 0.05 */
    @Test
    public void testPercentageIntegration() {
        calculator.textField.setText("5");
        calculator.percButton.doClick();
        calculator.equButton.doClick();
        Assert.assertEquals("0.05",calculator.textField.getText());
    }
    /*
     * Input: sqrt(16)
     * Expected Output: 4 */
    @Test
    public void testSquareRootIntegration() {
        calculator.textField.setText("16");
        calculator.sqrtButton.doClick();
        calculator.equButton.doClick();
        Assert.assertEquals("4.0",calculator.textField.getText());
    }
    /*
     * Input: sqrt(-16)
     * Expected Output: Invalid square root */
    @Test
    public void testNegativeSquareRoot() {
        calculator.textField.setText("16");
        calculator.negButton.doClick();
        calculator.sqrtButton.doClick();
        Assert.assertEquals("Invalid square root of a negative", calculator.textField.getText());
    }

    //TESTING COMBINATIONS OF DIFFERENT OPERATIONS.

    /*
     * Input: 20% + 3
     * Expected Output: 3,60 */
    @Test
    public void testAdditionThenPercentage() {
        calculator.textField.setText("20");
        calculator.percButton.doClick();
        calculator.addButton.doClick();
        calculator.textField.setText("3");
        calculator.equButton.doClick();
        Assert.assertEquals("3.2",calculator.textField.getText());
    }
    /*
     * Input: 2^3-4
     * Expected Output: 4.0 */
    @Test
    public void testExponentThenSubtraction() {
        calculator.textField.setText("2");
        calculator.expoButton.doClick();
        calculator.textField.setText("3");
        calculator.equButton.doClick();
        calculator.subButton.doClick();
        calculator.textField.setText("4");
        calculator.equButton.doClick();
        Assert.assertEquals("4.0",calculator.textField.getText());
    }
    /*
     * Input: sqrt(16) + 5
     * Expected Output: 9.0 */
    @Test
    public void testSquareRootThenAddition() {
        calculator.textField.setText("16");
        calculator.sqrtButton.doClick();
        calculator.addButton.doClick();
        calculator.textField.setText("5");
        calculator.equButton.doClick();
        Assert.assertEquals("9.0",calculator.textField.getText());
    }
    /*
     * Input: 4!-2
     * Expected Output: 22.0 */
    @Test
    public void testFactorialThenSubtraction() {
        calculator.textField.setText("4");
        calculator.factButton.doClick();
        calculator.subButton.doClick();
        calculator.textField.setText("2");
        calculator.equButton.doClick();
        Assert.assertEquals("22.0",calculator.textField.getText());
    }

    @Test
    public void testClear() {
        calculator.textField.setText("123");
        calculator.clrButton.doClick();
        Assert.assertEquals("",calculator.textField.getText());
    }
    @Test
    public void testDelete() {
        calculator.textField.setText("123");
        calculator.delButton.doClick();
        Assert.assertEquals("12",calculator.textField.getText());
    }

}


