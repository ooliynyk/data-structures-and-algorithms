package graph;

import lombok.Data;

@Data
public class Vertex {
    private final char label;

    public Vertex(char label) {
        this.label = label;
    }
}
