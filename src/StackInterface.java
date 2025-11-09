public interface StackInterface<T> {
    /*Create ADT methods.*/
    void push(T item);
    T pop();
    T peek();
    boolean isEmpty();
    void clear();
}
