package LinkedList;

import java.util.List;

public interface InterfaceList <E> extends List<E>{

	void addFirst(E value);
	void addLast(E value);
	boolean addAfter(E dado, E crit) throws Exception;
	
	E peekFirst() throws Exception;
	E peekLast() throws Exception;
	
	E search(E crit) throws Exception;
	
	E removeFirst() throws Exception;
	E removeLast() throws Exception;
	E removeElement(E crit) throws Exception;
	
	void show();
	void showReverse();

}