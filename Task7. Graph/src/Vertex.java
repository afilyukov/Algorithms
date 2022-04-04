import java.util.Objects;

public class Vertex<T> {
    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    private T payload;
    private boolean visited;
    private int weight;

    public Vertex(T payload) {
        this.payload = payload;
        this.visited = false;
        this.weight = -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vertex)) return false;
        Vertex<?> vertex = (Vertex<?>) o;
        return visited == vertex.visited && weight == vertex.weight && payload.equals(vertex.payload);
    }

    @Override
    public int hashCode() {
        return Objects.hash(payload, visited, weight);
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "payload=" + payload +
                '}';
    }
}