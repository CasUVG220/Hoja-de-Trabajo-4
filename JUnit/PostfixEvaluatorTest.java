import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PostfixEvaluatorTest {
    private PostfixEvaluator evaluator;

    @BeforeEach
    void setUp() {
        evaluator = new PostfixEvaluator(new FastStack<>());
    }

    @Test
    void testSimpleEvaluation() {
        assertEquals(7.0, evaluator.evaluate("3 4 +"));
    }

    @Test
    void testComplexEvaluation() {
        assertEquals(35.0, evaluator.evaluate("3 4 + 5 *"));
    }

    @Test
    void testDivision() {
        assertEquals(2.0, evaluator.evaluate("10 5 /"));
    }

    @Test
    void testExponentiation() {
        assertEquals(8.0, evaluator.evaluate("2 3 ^"));
    }
}