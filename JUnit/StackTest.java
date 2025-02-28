import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StackTest {
    private FastStack<Integer> fastStack;
    private SafeStack<Integer> safeStack;
    private LinkedStack<Integer> linkedStack;

    @BeforeEach
    void setUp() {
        fastStack = new FastStack<>();
        safeStack = new SafeStack<>();
        linkedStack = new LinkedStack<>();
    }

    @Test
    void testPushAndPop() {
        fastStack.push(10);
        assertEquals(10, fastStack.pop());

        safeStack.push(20);
        assertEquals(20, safeStack.pop());

        linkedStack.push(30);
        assertEquals(30, linkedStack.pop());
    }

    @Test
    void testPeek() {
        fastStack.push(10);
        assertEquals(10, fastStack.peek());

        safeStack.push(20);
        assertEquals(20, safeStack.peek());

        linkedStack.push(30);
        assertEquals(30, linkedStack.peek());
    }

    @Test
    void testIsEmpty() {
        assertTrue(fastStack.isEmpty());
        fastStack.push(1);
        assertFalse(fastStack.isEmpty());

        assertTrue(safeStack.isEmpty());
        safeStack.push(2);
        assertFalse(safeStack.isEmpty());

        assertTrue(linkedStack.isEmpty());
        linkedStack.push(3);
        assertFalse(linkedStack.isEmpty());
    }

    @Test
    void testSize() {
        fastStack.push(1);
        fastStack.push(2);
        assertEquals(2, fastStack.size());

        safeStack.push(3);
        safeStack.push(4);
        safeStack.push(5);
        assertEquals(3, safeStack.size());

        linkedStack.push(6);
        assertEquals(1, linkedStack.size());
    }
}
