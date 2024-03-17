package LinkedList;
// package LinkedList;

// public class DoubleLinkedList<T> implements InterfaceList<T> {
//     class Node{
//         T data;
//         Node next;
//         Node prev;
        
//         public Node(T data) {
//             this.data = data;
//             this.next = null;
//             this.prev = null;
//         }
        
//     }
//     private Node head;
//     private Node tail;
//     private int size;
    
//     public DoubleLinkedList() {
//         head = null;
//         tail = null;
//         size = 0;
//     }
    
//     @Override
//     public void addFirst(T value) {
//         Node novo = new Node(value);
//         if(size == 0) {
//             head = novo;
//             tail = novo;
//         }
//         else {
//             novo.next = head;
//             head.prev = novo;
//             head = novo;
//         }
//         size++;
        
//     }

//     @Override
//     public void addLast(T value) {
//         Node novo = new Node(value);
//         if(size == 0) {
//             head = novo;
//             tail = novo;
//         }
//         else {
//             novo.prev = tail;
//             tail.next = novo;
//             tail = novo;
//         }
//         size++;
//     }

//     @Override
//     public boolean addAfter(T data, T crit) throws Exception {
//         Node p = searchNode(crit);
//         if(p == null) {
//             System.out.println("Invalid criteria");
//             return false;
//         }
//         else {
//             Node novo = new Node(data);
//             novo.next = p.next;
//             novo.prev = p;
//             p.next = novo;
//             if(novo.next != null) {
//                 novo.next.prev = novo;
//             }
//             else {
//                 tail = novo;
//             }
//             size++;
//             return true;
//         }
//     }

//     @Override
//     public T peekFirst() throws Exception {
//         if(size == 0) {
//             throw new Exception("Empty list");
//         }
//         return head.data;
//     }

//     @Override
//     public T peekLast() throws Exception {
//         if(size == 0) {
//             throw new Exception("Empty list");
//         }
//         return tail.data;
//     }

//     @Override
//     public T search(T crit) throws Exception {
//         Node p = searchNode(crit);
//         if(p == null) {
//             throw new Exception("Invalid criteria");
//         }
//         return p.data;
//     }

//     @Override
//     public T removeFirst() throws Exception {
//         if(size == 0) {
//             throw new Exception("Empty list");
//         }
//         Node p = head;
//         T dadoRetorno = p.data;
//         head = p.next;
//         if(head != null) {
//             head.prev = null;
//         }
//         else {
//             tail = null;
//         }
//         size--;
//         return dadoRetorno;
//     }

//     @Override
//     public T removeLast() throws Exception {
//         if(size == 0) {
//             throw new Exception("Empty list");
//         }
//         Node p = tail;
//         T dadoRetorno = p.data;
//         tail = p.prev;
//         if(tail != null) {
//             tail.next = null;
//         }
//         else {
//             head = null;
//         }
//         size--;
//         return dadoRetorno;
//     }

//     @Override
//     public T remove(T crit) throws Exception {
//         Node p = searchNode(crit);
//         if(p == null) {
//             throw new Exception("Invalid criteria");
//         }
//         T dadoRetorno = p.data;
//         if(p == head) {
//             return removeFirst();
//         }
//         if(p == tail) {
//             return removeLast();
//         }
//         p.prev.next = p.next;
//         p.next.prev = p.prev;
//         size--;
//         return dadoRetorno;
//     }

//     @Override
//     public void show() {
//         Node p = head;
//         while(p != null) {
//             System.out.print(p.data + " ");
//             p = p.next;
//         }
//     }

//     @Override
//     public void showReverse() {
//         Node p = tail;
//         while(p != null) {
//             System.out.print(p.data + " ");
//             p = p.prev;
//         }
//     }

//     private Node searchNode(T crit) {
//         Node p = head;
//         while(p != null) {
//             if(p.data.equals(crit)) {
//                 return p;
//             }
//             p = p.next;
//         }
//         return null;
//     }
// }