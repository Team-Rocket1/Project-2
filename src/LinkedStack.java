public class LinkedStack<T> implements StackInterface<T> {
/* Use StackInterface to create linked stack ADT implementation.*/
    private static class Node<E> {
        E data;
        Node<E> next;
        Node(E data, Node<E> next) { this.data = data; this.next = next; }
    }

    private Node<T> head;
    private int size;

    @Override
    public void push(T item) {
        head = new Node<>(item, head);
        size++;
    }

    @Override
    public T pop() {
        if (isEmpty()) throw new IllegalStateException("pop from empty stack");
        T val = head.data;
        head = head.next;
        size--;
        return val;
    }

    @Override
    public T peek() {
        if (isEmpty()) throw new IllegalStateException("peek from empty stack");
        return head.data;
    }

    @Override
    public boolean isEmpty() { return head == null; }

    @Override
    public void clear() { head = null; size = 0; }

    public int size() { return size; }
}
