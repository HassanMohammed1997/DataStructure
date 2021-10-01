package datastructure.linkedlist;

public class GenericLinkedList<T> {
    private class Node<T> {
        private T value;
        private Node next;

        public Node(T value) {
            this.value = value;
        }
    }

    private Node<T> first;
    private Node<T> last;
    private int size;

    public void addFirst(T value) {
        Node<T> node = createNode(value);
        if (isEmpty()) {
            first = last = node;
        } else {
            node.next = first;
            first = node;
        }
        size++;
    }

    public void addLast(T value) {
        Node<T> node = createNode(value);
        if (isEmpty()) {
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }

        size++;
    }

    public int indexOf(T value) {
        int index = 0;
        Node<T> current = first;

        while (current != null) {
            if (current.value == value) return index;

            current = current.next;
            index++;
        }

        return -1;
    }

    

    public boolean hasSingleNode() {
        return first == last;
    }

    private Node<T> createNode(T value) {
        return new Node<>(value);
    }

    public boolean isEmpty() {
        return first == null;
    }
}
