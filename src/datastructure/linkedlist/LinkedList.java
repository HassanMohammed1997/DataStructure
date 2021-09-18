package datastructure.linkedlist;

import java.util.NoSuchElementException;

public class LinkedList {
    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int size;

    public void addFirst(int value) {
        Node node = new Node(value);
        if (isEmpty()) {
            first = last = node;
        } else {
            node.next = first;
            first = node;
        }

        size++;
    }

    public void addLast(int value) {
        Node node = new Node(value);
        if (isEmpty()) {
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }

        size++;
    }

    public void reverse() {
        if (isEmpty())
            return;

        Node previous = first;
        Node current = first.next;
        while (current != null) {
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        last = first;
        last.next = null;
        first = previous;

    }

    public int getKthFromTheEnd(int k) {
        if (isEmpty()) throw new IllegalStateException();
        Node a = first;
        Node b = first;
        for (int i = 0; i < k - 1; i++) {
            b = b.next;
            if (b == null) throw new IllegalArgumentException();
        }

        while (b != last) {
            a = a.next;
            b = b.next;
        }

        return a.value;
    }

    public int indexOf(int item) {
        int index = 0;
        Node current = first;

        while (current != null) {
            if (current.value == item) {
                return index;
            }

            current = current.next;
            index++;
        }

        return -1;
    }

    public void removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException();

        if (hasSingleNode()) {
            first = last = null;
            size = 0;
            return;
        }

        Node second = first.next;
        first.next = null;
        first = second;
        size--;
    }

    public void removeLast() {
        if (isEmpty())
            throw new NoSuchElementException();

        if (hasSingleNode()) {
            first = last = null;
            size = 0;
            return;
        }
        Node previous = getPreviousNode(last);
        last = previous;
        last.next = null;
        size--;
    }

    private Node getPreviousNode(Node node) {
        Node current = first;
        while (current != null) {
            if (current.next == node) return current;
            current = current.next;
        }

        return null;
    }

    public int size() {
        return size;
    }

    public int[] toArray() {
        int[] array = new int[size];
        Node current = first;
        int index = 0;
        while (current != null) {
            array[index] = current.value;
            index++;
            current = current.next;
        }

        return array;
    }

    public boolean contains(int item) {
        return indexOf(item) != -1;
    }

    private boolean isEmpty() {
        return first == null;
    }

    private boolean hasSingleNode() {
        return first == last;
    }
}
