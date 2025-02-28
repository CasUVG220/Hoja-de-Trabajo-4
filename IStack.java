/**
 * Interfaz que define las operaciones Stack.
 */
public interface IStack<T> {
    void push(T item);
    T pop();
    T peek();
    boolean isEmpty();
    int size();
}
