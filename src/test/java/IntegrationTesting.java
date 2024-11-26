import org.example.Main;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import java.awt.event.ActionEvent;


@RunWith(JUnit4.class)
public class IntegrationTesting {
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
    @org.junit.jupiter.api.Test
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

}