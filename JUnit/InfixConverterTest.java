import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InfixConverterTest {
    private InfixConverter converter;

    @BeforeEach
    void setUp() {
        converter = new InfixConverter(new FastStack<>());
    }

    @Test
    void testSimpleExpression() {
        assertEquals("3 4 +", converter.convert("3+4"));
    }

    @Test
    void testComplexExpression() {
        assertEquals("3 4 + 5 *", converter.convert("(3+4)*5"));
    }

    @Test
    void testNestedParentheses() {
        assertEquals("3 4 5 * + 6 -", converter.convert("3 + (4 * 5) - 6"));
    }
}