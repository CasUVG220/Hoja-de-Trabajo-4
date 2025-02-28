import java.util.Vector;

/**
 * Implementación de una pila con Vector.
 */
public class SafeStack<T> implements IStack<T> {
    private Vector<T> stack;

    public SafeStack() {
        stack = new Vector<>();
    }

    @Override
    public void push(T item) {
        stack.add(item);
    }

    @Override
    public T pop() {
        return isEmpty() ? null : stack.remove(stack.size() - 1);
    }

    @Override
    public T peek() {
        return isEmpty() ? null : stack.get(stack.size() - 1);
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public int size() {
        return stack.size();
    }
}
