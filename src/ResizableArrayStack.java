public class ResizableArrayStack<T> implements StackInterface<T> {
    private T[] stack;
    private int topIndex;
    private static final int DEFAULT_CAPACITY = 10;

    public ResizableArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    public ResizableArrayStack(int initialCapacity) {
        stack = (T[]) new Object[initialCapacity];
        topIndex = -1;
    }

    public void push(T newEntry) {
        ensureCapacity();
        stack[++topIndex] = newEntry;
    }

    public T pop() {
        if (isEmpty()) throw new RuntimeException("Stack is empty");
        T top = stack[topIndex];
        stack[topIndex--] = null;
        return top;
    }

    public T peek() {
        if (isEmpty()) throw new RuntimeException("Stack is empty");
        return stack[topIndex];
    }

    public boolean isEmpty() {
        return topIndex < 0;
    }

    public void clear() {
        while (!isEmpty()) pop();
    }

    private void ensureCapacity() {
        if (topIndex == stack.length - 1) {
            T[] oldStack = stack;
            int newSize = 2 * oldStack.length;
            stack = (T[]) new Object[newSize];
            System.arraycopy(oldStack, 0, stack, 0, oldStack.length);
        }
    }
}

