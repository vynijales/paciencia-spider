package DoublyLinkedList;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

import InterfaceList.InterfaceList;

public class DoublyLinkedList<T> implements InterfaceList<T> {
    class Node {
        T data;
        Node next;
        Node prev;

        public Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }

    }

    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void addFirst(T value) {
        Node novo = new Node(value);
        if (size == 0) {
            head = novo;
            tail = novo;
        } else {
            novo.next = head;
            head.prev = novo;
            head = novo;
        }
        size++;

    }

    @Override
    public void addLast(T value) {
        Node novo = new Node(value);
        if (size == 0) {
            head = novo;
            tail = novo;
        } else {
            novo.prev = tail;
            tail.next = novo;
            tail = novo;
        }
        size++;
    }

    @Override
    public boolean addAfter(T data, T crit) throws Exception {
        Node p = searchNode(crit);
        if (p == null) {
            System.out.println("Invalid criteria");
            return false;
        } else {
            Node novo = new Node(data);
            novo.next = p.next;
            novo.prev = p;
            p.next = novo;
            if (novo.next != null) {
                novo.next.prev = novo;
            } else {
                tail = novo;
            }
            size++;
            return true;
        }
    }

    public boolean addBefore(T data, T crit) throws Exception {
        Node p = searchNode(crit);
        if (p == null) {
            System.out.println("Invalid criteria");
            return false;
        } else {
            Node novo = new Node(data);
            novo.prev = p.prev;
            novo.next = p;
            p.prev = novo;
            if (novo.prev != null) {
                novo.prev.next = novo;
            } else {
                head = novo;
            }
            size++;
            return true;
        }
    }

    @Override
    public T peekFirst() throws Exception {
        if (size == 0) {
            throw new Exception("Empty list");
        }
        return head.data;
    }

    @Override
    public T peekLast() throws Exception {
        if (size == 0) {
            throw new Exception("Empty list");
        }
        return tail.data;
    }

    @Override
    public T search(T crit) {
        Node p = searchNode(crit);
        if (p == null) {
            System.out.println("Invalid criteria");
            return null;
        }
        return p.data;
    }

    @Override
    public T removeFirst() throws Exception {
        if (size == 0) {
            throw new Exception("Empty list");
        }
        Node p = head;
        T dadoRetorno = p.data;
        head = p.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }
        size--;
        return dadoRetorno;
    }

    @Override
    public T removeLast() throws Exception {
        if (size == 0) {
            throw new Exception("Empty list");
        }
        Node p = tail;
        T dadoRetorno = p.data;
        tail = p.prev;
        if (tail != null) {
            tail.next = null;
        } else {
            head = null;
        }
        size--;
        return dadoRetorno;
    }

    @Override
    public boolean remove(Object crit) {
        @SuppressWarnings("unchecked")
        Node p = searchNode((T) crit);
        if (p == null) {
            System.out.println("Invalid criteria");
            return false;
        }
        // T dadoRetorno = p.data;
        if (p == head) {
            try {
                removeFirst();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (p == tail) {
            try {
                removeLast();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        p.prev.next = p.next;
        p.next.prev = p.prev;
        size--;
        return true;
    }

    @Override
    public void show() {
        Node p = head;
        System.out.printf("List: ");
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    @Override
    public void showReverse() {
        Node p = tail;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.prev;
        }
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

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @SuppressWarnings("deprecation")
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public T removeElement(T crit) {
        return null;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public int indexOf(Object o) {
        Node aux = head;
        int i = 0;
        while (aux != null) {
            if (aux.data.equals(o)) {
                return i;
            }
            aux = aux.next;
            i++;
        }
        return -1;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public int lastIndexOf(Object o) {
        Node aux = tail;
        int i = size - 1;
        while (aux != null) {
            if (aux.data.equals(o)) {
                return i;
            }
            aux = aux.prev;
            i--;
        }
        return -1;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public void replaceAll(UnaryOperator<T> operator) {
        InterfaceList.super.replaceAll(operator);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public T set(int index, T element) {
        Node aux = head;

        if (index < 0 || index >= size) {
            return null;
        }

        for (int i = 0; i < index; i++) {
            aux = aux.next;
        }
        T old = aux.data;
        aux.data = element;
        return old;
    }

    @Override
    public void sort(Comparator<? super T> c) {
        // TODO Auto-generated method stub
        InterfaceList.super.sort(c);
    }

    @Override
    public Spliterator<T> spliterator() {
        // TODO Auto-generated method stub
        return InterfaceList.super.spliterator();
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object[] toArray() {
        // TODO Auto-generated method stub
        return null;
    }

    @SuppressWarnings("hiding")
    @Override
    public <T> T[] toArray(T[] a) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Stream<T> parallelStream() {
        // TODO Auto-generated method stub
        return InterfaceList.super.parallelStream();
    }

    @Override
    public boolean removeIf(Predicate<? super T> filter) {
        // TODO Auto-generated method stub
        return InterfaceList.super.removeIf(filter);
    }

    @Override
    public Stream<T> stream() {
        // TODO Auto-generated method stub
        return InterfaceList.super.stream();
    }

    @SuppressWarnings("hiding")
    @Override
    public <T> T[] toArray(IntFunction<T[]> generator) {
        // TODO Auto-generated method stub
        return InterfaceList.super.toArray(generator);
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        // TODO Auto-generated method stub
        InterfaceList.super.forEach(action);
    }

    @Override
    public boolean add(T e) {
        try {
            addAfter(e, tail.data);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public void add(int index, T element) {
        // This is a simple implementation and does not handle index out of bounds
        Node current = head;
        for (int i = 0; i < index && current != null; i++) {
            current = current.next;
        }
        if (current != null) {
            Node newNode = new Node(element);
            newNode.next = current.next;
            newNode.prev = current;
            current.next = newNode;
            if (newNode.next != null) {
                newNode.next.prev = newNode;
            }
        }
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean isAllAdded = true;
        for (T element : c) {
            isAllAdded &= add(element);
        }
        return isAllAdded;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean contains(Object o) {
        return search((T) o) != null;
    }

    @Override
    public T get(int index) {
        Node current = head;
        for (int i = 0; i < index && current != null; i++) {
            current = current.next;
        }
        return current != null ? current.data : null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

}
