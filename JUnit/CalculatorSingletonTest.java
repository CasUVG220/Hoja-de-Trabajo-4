import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculatorSingletonTest {
    @Test
    void testSingletonInstance() {
        CalculatorSingleton instance1 = CalculatorSingleton.getInstance();
        CalculatorSingleton instance2 = CalculatorSingleton.getInstance();
        assertSame(instance1, instance2);
    }

    @Test
    void testEvaluation() {
        CalculatorSingleton calculator = CalculatorSingleton.getInstance();
        assertEquals(7.0, calculator.evaluate("3 4 +"));
        assertEquals(35.0, calculator.evaluate("3 4 + 5 *"));
    }
}