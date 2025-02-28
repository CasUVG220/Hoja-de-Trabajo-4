import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StackFactoryTest {
    @Test
    void testCreateStack() {
        assertTrue(StackFactory.createStack("fast") instanceof FastStack);
        assertTrue(StackFactory.createStack("safe") instanceof SafeStack);
        assertTrue(StackFactory.createStack("linked") instanceof LinkedStack);
    }

    @Test
    void testInvalidStackType() {
        assertThrows(IllegalArgumentException.class, () -> StackFactory.createStack("invalid"));
    }
}