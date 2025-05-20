package structures;

public class MyStack<T> {

    private class Node {
        T data;
        Node next;
        Node(T data) { this.data = data; }
    }

    private Node top;
    private int size;

    public void push(T item) {
        Node node = new Node(item);
        node.next = top;
        top = node;
        size++;
    }

    public T pop() {
        if (isEmpty()) throw new RuntimeException("Stack is empty");
        T value = top.data;
        top = top.next;
        size--;
        return value;
    }

    public T peek() {
        if (isEmpty()) throw new RuntimeException("Stack is empty");
        return top.data;
    }

    public boolean isEmpty() { return top == null; }

    public int size() { return size; }
}
