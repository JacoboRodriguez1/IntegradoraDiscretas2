package structures;

public class MyLinkedList<T> {

    private class Node {
        T data;
        Node next;
        Node(T data) { this.data = data; }
    }

    private Node head;
    private int size;

    public void add(T data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = node;
        }
        size++;
    }

    public T get(int index) {
        checkBounds(index);
        Node temp = head;
        for (int i = 0; i < index; i++)
            temp = temp.next;
        return temp.data;
    }

    public int size() { return size; }

    private void checkBounds(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Invalid index: " + index);
    }
}
