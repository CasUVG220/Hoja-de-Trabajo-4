import java.util.ArrayList;

/**
 * Implementación de una pila con ArrayList.
 */
public class FastStack<T> implements IStack<T> {
    private ArrayList<T> stack;

    public FastStack() {
        stack = new ArrayList<>();
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
