package Stack;

public interface InterfaceStack <T> {
    void push(T number) throws Exception;
    T pop() throws Exception;
    T peek() throws Exception;

    void show();
    boolean isEmpty();
    boolean isFull();
}
