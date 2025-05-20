package structures;

public class MyQueue<T> {

    private class Node {
        T data;
        Node next;
        Node(T data) { this.data = data; }
    }

    private Node front, rear;
    private int size;

    public void enqueue(T item) {
        Node node = new Node(item);
        if (rear != null) rear.next = node;
        rear = node;
        if (front == null) front = rear;
        size++;
    }

    public T dequeue() {
        if (isEmpty()) throw new RuntimeException("Queue is empty");
        T value = front.data;
        front = front.next;
        if (front == null) rear = null;
        size--;
        return value;
    }

    public boolean isEmpty() { return front == null; }

    public int size() { return size; }
}
