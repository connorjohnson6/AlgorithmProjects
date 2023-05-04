package linkedList;

import java.util.Iterator;

            //generic types
public class linkedList<T> implements Iterable<T> {
    private Node<T> head = null;
    private Node<T> tail = null;
    private int size = 0;

    public void add(T data) {
        Node<T> newNode = new Node<T>(data);

        if (head == null) { //if node is empty
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        size++;
    }

    public T get(int index) {
        Node<T> current = head;
        for (int i = 0; i < index; i++) { //traverse list
            current = current.next;
        }

        return current.data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator<T>(head);
    }

    //chatgpt suggested code
    private static class ListIterator<T> implements Iterator<T> {
        private Node<T> current;

        public ListIterator(Node<T> head) {
            current = head;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }

            T data = current.data;
            current = current.next;
            return data;
        }
    }

    private static class Node<T> {
        private T data;
        private Node<T> prev;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }
}

