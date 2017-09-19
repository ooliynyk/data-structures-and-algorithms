package graph;

import java.util.Arrays;
import java.util.List;


public class Graph {
    private Vertex[] vertices;
    private int[][] adjacencyMatrix;
    private int size;

    public void insert(Vertex vertex) {
        vertices[size++] = vertex;
    }

    public void link(Vertex first, Vertex second) {
        int firstVertexIndex = findVertexIndex(first);
        int secondVertexIndex = findVertexIndex(second);
        if (firstVertexIndex == -1 || secondVertexIndex == -1) {
            throw new IllegalArgumentException("One of vertices is not found in the graph");
        }
        adjacencyMatrix[firstVertexIndex][secondVertexIndex] = 1;
        adjacencyMatrix[secondVertexIndex][firstVertexIndex] = 1;
    }

    public List<Vertex> vertices() {
        return Arrays.asList(vertices);
    }

    private int findVertexIndex(Vertex vertex) {
        for (int i = 0; i < size; i++) {
            if (vertices[i].equals(vertex)) {
                return i;
            }
        }
        return -1;
    }

}
