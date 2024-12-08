import org.example.Main;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

@RunWith(JUnit4.class)
public class UnitTesting {

    Main os;

    @Before
    public void init() {
        os = new Main();

        if (os.textField == null) {
            os.textField = new JTextField();
        }
    }

    private void setNumber(double number) {
        System.out.println("Setting number: " + number);
        if (number == (int) number) {
            os.textField.setText(String.valueOf((int) number));
        } else {
            os.textField.setText(String.format("%.1f", number));
        }
    }

    @Test
    public void testAddition() {
        setNumber(10);
        os.actionPerformed(new ActionEvent(os.addButton, ActionEvent.ACTION_PERFORMED, ""));
        setNumber(5);
        os.actionPerformed(new ActionEvent(os.equButton, ActionEvent.ACTION_PERFORMED, ""));
        Assert.assertEquals("Addition failed", 15.0, Double.parseDouble(os.textField.getText()), 0.001);
    }

    @Test
    public void testSubtraction() {
        setNumber(10);
        os.actionPerformed(new ActionEvent(os.subButton, ActionEvent.ACTION_PERFORMED, ""));
        setNumber(5);
        os.actionPerformed(new ActionEvent(os.equButton, ActionEvent.ACTION_PERFORMED, ""));
        Assert.assertEquals("Subtraction failed", 5.0, Double.parseDouble(os.textField.getText()), 0.001);
    }

    @Test
    public void testMultiplication() {
        setNumber(10);
        os.actionPerformed(new ActionEvent(os.mulButton, ActionEvent.ACTION_PERFORMED, ""));
        setNumber(5);
        os.actionPerformed(new ActionEvent(os.equButton, ActionEvent.ACTION_PERFORMED, ""));
        Assert.assertEquals("Multiplication failed", 50.0, Double.parseDouble(os.textField.getText()), 0.001);
    }

    @Test
    public void testDivision() {
        setNumber(10);
        os.actionPerformed(new ActionEvent(os.divButton, ActionEvent.ACTION_PERFORMED, ""));
        setNumber(5);
        os.actionPerformed(new ActionEvent(os.equButton, ActionEvent.ACTION_PERFORMED, ""));
        Assert.assertEquals("Division failed", 2.0, Double.parseDouble(os.textField.getText()), 0.001);
    }

    @Test
    public void testSquareRootOfNegative() {
        setNumber(-16);
        os.actionPerformed(new ActionEvent(os.sqrtButton, ActionEvent.ACTION_PERFORMED, ""));
        Assert.assertTrue("Square root of negative number did not handle properly",
                os.textField.getText().equals("NaN") || os.textField.getText().contains("Invalid"));
    }

    @Test
    public void testDivisionByZero() {
        setNumber(10);
        os.actionPerformed(new ActionEvent(os.divButton, ActionEvent.ACTION_PERFORMED, ""));
        setNumber(0);
        os.actionPerformed(new ActionEvent(os.equButton, ActionEvent.ACTION_PERFORMED, ""));
        Assert.assertTrue("Division by zero did not handle properly",
                os.textField.getText().equals("Infinity") || os.textField.getText().equals("NaN"));
    }

    @Test
    public void testSquareRootOfZero() {
        setNumber(0);
        os.actionPerformed(new ActionEvent(os.sqrtButton, ActionEvent.ACTION_PERFORMED, ""));
        Assert.assertEquals("Square root of zero failed", "0.0", os.textField.getText());
    }
}
