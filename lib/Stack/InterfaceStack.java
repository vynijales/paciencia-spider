package Stack;

public interface InterfaceStack <T> {
    void push(T number) throws Exception;
    T pop() throws Exception;
    T peek();

    void show();
    boolean isEmpty();
    boolean isFull();
}
