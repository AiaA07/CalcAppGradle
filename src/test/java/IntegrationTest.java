import org.example.Main;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import javax.swing.*;
import java.awt.*;

@RunWith(JUnit4.class)
public class IntegrationTest {
    Main calculator;

    @Before
    public void init() throws Exception {
        SwingUtilities.invokeAndWait(new Runnable() {
            @Override
            public void run() {
                calculator = new Main();
            }
        });
    }

    @Test
    public void testAdditionIntegration() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                calculator.textField.setText("2");
                calculator.addButton.doClick();
                calculator.textField.setText("3");
                calculator.equButton.doClick();
                Assert.assertEquals("5.0", calculator.textField.getText());
            }
        });
    }

    @Test
    public void testSubtractionIntegration() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                calculator.textField.setText("5");
                calculator.subButton.doClick();
                calculator.textField.setText("3");
                calculator.equButton.doClick();
                Assert.assertEquals("2.0", calculator.textField.getText());
            }
        });
    }

    @Test
    public void testMultiplicationIntegration() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                calculator.textField.setText("4");
                calculator.mulButton.doClick();
                calculator.textField.setText("2");
                calculator.equButton.doClick();
                Assert.assertEquals("8.0", calculator.textField.getText());
            }
        });
    }

    @Test
    public void testDivisionIntegration() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                calculator.textField.setText("9");
                calculator.divButton.doClick();
                calculator.textField.setText("3");
                calculator.equButton.doClick();
                Assert.assertEquals("3.0", calculator.textField.getText());
            }
        });
    }

    @Test
    public void testFactorialIntegration() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                calculator.textField.setText("3");
                calculator.factButton.doClick();
                calculator.equButton.doClick();
                Assert.assertEquals("6.0", calculator.textField.getText());
            }
        });
    }

    @Test
    public void testExponentIntegration() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                calculator.textField.setText("3");
                calculator.expoButton.doClick();
                calculator.textField.setText("2");
                calculator.equButton.doClick();
                Assert.assertEquals("9.0", calculator.textField.getText());
            }
        });
    }

    @Test
    public void testPercentageIntegration() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                calculator.textField.setText("5");
                calculator.percButton.doClick();
                calculator.equButton.doClick();
                Assert.assertEquals("0.05", calculator.textField.getText());
            }
        });
    }

    @Test
    public void testSquareRootIntegration() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                calculator.textField.setText("16");
                calculator.sqrtButton.doClick();
                calculator.equButton.doClick();
                Assert.assertEquals("4.0", calculator.textField.getText());
            }
        });
    }

    @Test
    public void testNegativeSquareRoot() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                calculator.textField.setText("16");
                calculator.negButton.doClick();
                calculator.sqrtButton.doClick();
                Assert.assertEquals("Invalid square root of a negative", calculator.textField.getText());
            }
        });
    }

    @Test
    public void testClear() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                calculator.textField.setText("123");
                calculator.clrButton.doClick();
                Assert.assertEquals("", calculator.textField.getText());
            }
        });
    }

    @Test
    public void testDelete() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                calculator.textField.setText("123");
                calculator.delButton.doClick();
                Assert.assertEquals("12", calculator.textField.getText());
            }
        });
    }
}
