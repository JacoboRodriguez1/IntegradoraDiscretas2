package structures;

public class AdjacencyListGraph<T> implements MyGraph<T> {

    private class Vertex {
        T data;
        MyLinkedList<Vertex> neighbors;

        Vertex(T data) {
            this.data = data;
            this.neighbors = new MyLinkedList<>();
        }
    }

    private MyLinkedList<Vertex> vertices;

    public AdjacencyListGraph() {
        vertices = new MyLinkedList<>();
    }

    @Override
    public void addVertex(T data) {
        if (findVertex(data) == null) {
            vertices.add(new Vertex(data));
        }
    }

    @Override
    public void addEdge(T from, T to) {
        Vertex v1 = findVertex(from);
        Vertex v2 = findVertex(to);

        if (v1 == null) {
            v1 = new Vertex(from);
            vertices.add(v1);
        }
        if (v2 == null) {
            v2 = new Vertex(to);
            vertices.add(v2);
        }

        if (!hasEdge(v1, v2)) {
            v1.neighbors.add(v2);
        }
    }

    @Override
    public boolean areConnected(T from, T to) {
        Vertex v1 = findVertex(from);
        Vertex v2 = findVertex(to);

        if (v1 == null || v2 == null) return false;

        for (int i = 0; i < v1.neighbors.size(); i++) {
            if (v1.neighbors.get(i).data.equals(to)) {
                return true;
            }
        }

        return false;
    }

    private boolean hasEdge(Vertex from, Vertex to) {
        for (int i = 0; i < from.neighbors.size(); i++) {
            if (from.neighbors.get(i).data.equals(to.data)) {
                return true;
            }
        }
        return false;
    }

    private Vertex findVertex(T data) {
        for (int i = 0; i < vertices.size(); i++) {
            Vertex v = vertices.get(i);
            if (v.data.equals(data)) return v;
        }
        return null;
    }
}
