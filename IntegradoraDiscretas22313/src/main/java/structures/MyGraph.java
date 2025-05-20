package structures;

public interface MyGraph<T> {
    void addVertex(T vertex);
    void addEdge(T from, T to);
    boolean areConnected(T from, T to);
}
