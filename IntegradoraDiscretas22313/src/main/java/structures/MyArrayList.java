package structuras;

public class MyArrayList<T> {

    private class Node {
        T data;
        Node next;

        Node(T data) { this.data = data; }
    }

    private Node head;
    private int size;

    public void add(T element) {
        Node node = new Node(element);
        if (head == null) {
            head = node;
        } else {
            Node current = head;
            while (current.next != null)
                current = current.next;
            current.next = node;
        }
        size++;
    }

    public T get(int index) {
        checkBounds(index);
        Node current = head;
        for (int i = 0; i < index; i++)
            current = current.next;
        return current.data;
    }

    public void set(int index, T element) {
        checkBounds(index);
        Node current = head;
        for (int i = 0; i < index; i++)
            current = current.next;
        current.data = element;
    }

    public int size() { return size; }

    public boolean isEmpty() { return size == 0; }

    private void checkBounds(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
    }
}
