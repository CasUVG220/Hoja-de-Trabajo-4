/**
 * Implementación de una pila utilizando listas enlazadas.
 */
public class LinkedStack<T> implements IStack<T> {
    private Node<T> top;
    private int count;

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public LinkedStack() {
        top = null;
        count = 0;
    }

    @Override
    public void push(T item) {
        Node<T> newNode = new Node<>(item);
        newNode.next = top;
        top = newNode;
        count++;
    }

    @Override
    public T pop() {
        if (isEmpty()) return null;
        T data = top.data;
        top = top.next;
        count--;
        return data;
    }

    @Override
    public T peek() {
        return isEmpty() ? null : top.data;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int size() {
        return count;
    }
}
