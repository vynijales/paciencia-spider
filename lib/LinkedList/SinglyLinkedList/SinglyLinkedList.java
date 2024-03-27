package SinglyLinkedList;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import InterfaceList.InterfaceList;

public class SinglyLinkedList<T> implements InterfaceList<T> {

	class Node {
		T data;
		Node next;

		public Node(T data) {
			this.data = data;
			this.next = null;
		}

	}

	private Node head;
	private Node tail;
	private int size;

	public SinglyLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}

	@Override
	public void addFirst(T value) {
		Node newNode = new Node(value);
		if (size == 0) {
			head = newNode;
			tail = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
		size++;

	}

	@Override
	public void addLast(T value) {
		Node newNode = new Node(value);
		if (size == 0) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
		size++;
	}

	@Override
	public boolean addAfter(T data, T crit) {
		Node p = searchNode(crit);
		if (p == null) {
			System.out.println("Invalid criteria");
			return false;
		} else {
			Node newNode = new Node(data);

			if (p.next == null) {
				tail = newNode;
			}
			newNode.next = p.next;
			p.next = newNode;

			size++;
			return true;
		}
	}

	@Override
	public T peekFirst() throws Exception {
		if (head == null) {
			throw new Exception("There are no elements in the list");
		} else {
			return head.data;
		}
	}

	@Override
	public T peekLast() throws Exception {
		if (head == null) {
			throw new Exception("There are no elements in the list");
		} else {
			return tail.data;
		}
	}

	@Override
	public T search(T crit) {
		Node p = searchNode(crit);
		if (p == null) {
			return null;
		} else {
			return p.data;
		}
	}

	@Override
	public T removeFirst() throws Exception {
		Node p = head;
		T returnData = null;

		if (head == null) {
			throw new RuntimeException("Empty List!!! \n");
		} else {
			returnData = head.data;

			if (head == tail) {
				System.out.println("Remove unique element\n");
				head = null;
				tail = null;
			} else {
				System.out.println("Remove first element, but there are others\n");
				head = head.next;
				p.next = null; // isolate removed element
			}
			size--;
		}
		return returnData;
	}

	@Override
	public T removeLast() {
		T returnData = null;

		if (tail == null) {
			throw new RuntimeException("Empty List!!! \n");
		} else {
			returnData = tail.data;

			if (head == tail) {
				System.out.println("Remove unique element\n");
				head = null;
				tail = null;
			} else {
				System.out.println("Remove last element, but there are others\n");
				Node p = head;
				// Search for the penultimate element
				while (p.next != tail) {
					p = p.next;
				}

				tail = p;
				tail.next = null;
			}

			// NOTE: no need to isolate element as the next of the tail is always null.

			size--;
		}

		return returnData;
	}

	public T removeElement(T crit) {
		Node previous = null;
		Node removed = null;

		if (head == null) {
			System.out.println("Empty List! \n");
		}

		previous = searchBefore(crit); // null: ID does not exist OR ID is in the 1st element

		if (previous == null) {
			if (head.data.equals(crit) == false) {
				System.out.println("criteria does not exist!!! \n");
				return null;
			} else {
				try {
					return removeFirst();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		} else {
			System.out.println("Remove element middle or last \n");

			removed = previous.next;

			if (removed == tail) {
				System.out.println("Remove last \n");
				return removeLast();
			} else {
				System.out.println("Remove middle \n");
				previous.next = removed.next; // disconnects from the removed element
				removed.next = null; // isolate removed element
				size--;

				return removed.data;
			}
		}
		return crit;
	}

	@Override
	public void show() {
		Node p = head;
		while (p != null) {
			System.out.print(p.data + " ");
			p = p.next;
		}
	}

	@Override
	public void showReverse() {
		// TODO Auto-generated method stub

	}

	private Node searchNode(T crit) {
		Node p = head;

		while (p != null) {
			if (p.data.equals(crit)) {
				return p;
			}
			p = p.next;
		}
		return null;
	}

	private Node searchBefore(T criteria) {
		Node p = head; // temporary pointer
		Node previous = null; // previous pointer

		while (p != null) {
			previous = p;
			p = p.next;

			if (p != null && p.data.equals(criteria)) {
				return previous;
			}
		}

		return null;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean contains(Object o) {
		@SuppressWarnings("unchecked")
		T element = (T) o;
		Node p = head;
		while (p != null) {
			if (p.data.equals(element)) {
				return true;
			}
			p = p.next;
		}
		return false;
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			Node current = head;

			@Override
			public boolean hasNext() {
				return current != null;
			}

			@Override
			public T next() {
				T data = current.data;
				current = current.next;
				return data;
			}
		};
	}

	@Override
	public Object[] toArray() {
		@SuppressWarnings("unchecked")
		T array[] = (T[]) new Object[size];
		Node p = head;
		int i = 0;
		while (p != null) {
			array[i] = p.data;
			p = p.next;
			i++;
		}
		return array;
	}

	@SuppressWarnings("hiding")
	@Override
	public <T> T[] toArray(T[] a) {
		return toArray(a);
	}

	@Override
	public boolean add(T e) {
		if (isEmpty()) {
			addFirst(e);
		} else {
			addLast(e);
		}
		return true;
	}

	@Override
	public boolean remove(Object o) {
		@SuppressWarnings("unchecked")
		T element = (T) o;
		Object target = searchNode(element);
		if (target != null) {
			try {
				removeElement(element);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		for (Object o : c) {
			if (!contains(o)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		for (T element : c) {
			add(element);
		}
		return true;

	}

	@Override
	public boolean addAll(int index, Collection<? extends T> c) {
		for (T element : c) {
			add(index, element);
		}
		index++;
		return true;

	}

	@Override
	public boolean removeAll(Collection<?> c) {
		boolean modified = false;
		for (Object o : c) {
			if (remove(o)) {
				modified = true;
			}
		}
		return modified;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		boolean modified = false;
		Iterator<T> iterator = iterator();
		while (iterator.hasNext()) {
			T element = iterator.next();
			if (!c.contains(element)) {
				iterator.remove();
				modified = true;
			}
		}
		return modified;
	}

	@Override
	public void clear() {
		while (head != null) {
			Node p = head;
			head = head.next;
			p.next = null;
		}
		head = null;
		tail = null;
		size = 0;
	}

	@Override
	public T get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		}
		for (int i = 0; i < index; i++) {
			head = head.next;
		}
		return head.data;
	}

	@Override
	public T set(int index, T element) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		}
		Node p = head;
		for (int i = 0; i < index; i++) {
			p = p.next;
		}
		T oldData = p.data;
		p.data = element;
		return oldData;
	}

	@Override
	public void add(int index, T element) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		}
		if (index == 0) {
			addFirst(element);
		} else if (index == size) {
			addLast(element);
		} else {
			Node p = head;
			for (int i = 0; i < index - 1; i++) {
				p = p.next;
			}
			Node newNode = new Node(element);
			newNode.next = p.next;
			p.next = newNode;
			size++;
		}
	}

	@Override
	public T remove(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		}
		if (index == 0) {
			try {
				return removeFirst();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (index == size - 1) {
			return removeLast();
		} else {
			Node p = head;
			for (int i = 0; i < index - 1; i++) {
				p = p.next;
			}
			Node removed = p.next;
			p.next = removed.next;
			removed.next = null;
			size--;
			return removed.data;
		}
		return null;
	}

	@Override
	public int indexOf(Object o) {
		int index = 0;
		@SuppressWarnings("unchecked")
		T element = (T) o;
		Node p = head;
		while (p != null) {
			if (p.data.equals(element)) {
				return index;
			}
			p = p.next;
			index++;
		}
		return -1;
	}

	@Override
	public int lastIndexOf(Object o) {
		int index = 0;
		int lastIndex = -1;
		@SuppressWarnings("unchecked")
		T element = (T) o;
		Node p = head;
		while (p != null) {
			if (p.data.equals(element)) {
				lastIndex = index;
			}
			p = p.next;
			index++;
		}
		return lastIndex;
	}

	@Override
	public ListIterator<T> listIterator() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'listIterator'");
	}

	@Override
	public ListIterator<T> listIterator(int index) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'listIterator'");
	}

	@Override
	public List<T> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'subList'");
	}

}
