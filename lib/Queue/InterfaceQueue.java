package Queue;

public interface InterfaceQueue <T> {
	void add(T element) throws Exception;
	T remove() throws Exception;
	T peek() throws Exception; //consulta o início (primeiro elemento)
	
	boolean isEmpty();
	boolean isFull();
	
	void show();
}
