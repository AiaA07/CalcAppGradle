import org.example.Main;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import javax.swing.*;
import java.awt.event.ActionEvent;

@RunWith(JUnit4.class)
public class UnitTesting {

    Main os;

    @Before
    public void init() throws Exception {
        SwingUtilities.invokeAndWait(new Runnable() {
            @Override
            public void run() {
                os = new Main();
            }
        });
    }

    private void setNumber(double number) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                System.out.println("Setting number: " + number);  // Debugging line
                if (number == (int) number) {
                    os.textField.setText(String.valueOf((int) number));
                } else {
                    os.textField.setText(String.format("%.1f", number));
                }
            }
        });
    }

    //Tests addition button
    @Test
    public void testAddition() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                setNumber(10);
                os.addButton.doClick();
                setNumber(5);
                os.equButton.doClick();
                Assert.assertEquals("Addition failed", "15.0", os.textField.getText());
            }
        });
    }

    //Tests subtraction button
    @Test
    public void testSubtraction() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                setNumber(10);
                os.subButton.doClick();
                setNumber(5);
                os.equButton.doClick();
                Assert.assertEquals("Subtraction failed", "5.0", os.textField.getText());
            }
        });
    }

    //Tests multiplication button
    @Test
    public void testMultiplication() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                setNumber(10);
                os.mulButton.doClick();
                setNumber(5);
                os.equButton.doClick();
                Assert.assertEquals("Multiplication failed", "50.0", os.textField.getText());
            }
        });
    }

    //Tests division button
    @Test
    public void testDivision() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                setNumber(10);
                os.divButton.doClick();
                setNumber(5);
                os.equButton.doClick();
                Assert.assertEquals("Division failed", "2.0", os.textField.getText());
            }
        });
    }

    //Tests exponent button
    @Test
    public void testExponentiation() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                setNumber(2);
                os.expoButton.doClick();
                setNumber(3);
                os.equButton.doClick();
                Assert.assertEquals("Exponentiation failed", "8.0", os.textField.getText());
            }
        });
    }

    //Tests square root button
    @Test
    public void testSquareRoot() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                setNumber(16);
                os.sqrtButton.doClick();
                os.equButton.doClick();
                Assert.assertEquals("Square root failed", "4.0", os.textField.getText());
            }
        });
    }

    //Tests Clear button
    @Test
    public void testClear() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                setNumber(123);
                os.clrButton.doClick();
                Assert.assertEquals("Clear failed", "", os.textField.getText());
            }
        });
    }

    // Tests delete button
    @Test
    public void testDelete() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                setNumber(12345);
                os.delButton.doClick();
                Assert.assertEquals("Delete failed", "1234", os.textField.getText());
            }
        });
    }

    //Tests negative button
    @Test
    public void testNegate() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                setNumber(123.1);
                os.negButton.doClick();
                Assert.assertEquals("Negation failed", "-123.1", os.textField.getText());
            }
        });
    }

    //Tests percentage button
    @Test
    public void testPercent() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                setNumber(56);
                os.percButton.doClick();
                Assert.assertEquals("Percentage failed", "0.56", os.textField.getText());
            }
        });
    }

    //Tests factorial button
    @Test
    public void testFact() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                setNumber(5);
                os.factButton.doClick();
                Assert.assertEquals("Factorial failed", "120.0", os.textField.getText());
            }
        });
    }

    //Tests decimal button
    @Test
    public void testDec() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                setNumber(5);
                os.decButton.doClick();
                os.textField.setText(os.textField.getText().concat("1"));
                Assert.assertEquals("Decimal failed", "5.1", os.textField.getText());
            }
        });
    }

    // Edge cases

    //Tests square root for a negative number
    @Test
    public void testSquareRootOfNegative() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                setNumber(-16);
                os.sqrtButton.doClick();
                Assert.assertTrue("Square root of negative number did not handle properly",
                        os.textField.getText().equals("NaN") || os.textField.getText().contains("Invalid"));
            }
        });
    }

    //Tests division by zero
    @Test
    public void testDivisionByZero() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                setNumber(10);
                os.divButton.doClick();
                setNumber(0);
                os.equButton.doClick();
                Assert.assertTrue("Division by zero did not handle properly",
                        os.textField.getText().equals("Infinity") || os.textField.getText().equals("NaN"));
            }
        });
    }

    //Tests square root of zero
    @Test
    public void testSquareRootOfZero() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                setNumber(0);
                os.sqrtButton.doClick();
                Assert.assertEquals("Square root of zero failed", "0.0", os.textField.getText());
            }
        });
    }
}
