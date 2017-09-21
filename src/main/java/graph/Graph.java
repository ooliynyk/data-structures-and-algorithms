package graph;

import java.util.*;


public class Graph {
    private Vertex[] vertices;
    private int[][] adjacencyMatrix;
    private int size;
    private boolean[] visitoryFlags;

    public Graph(int capacity) {
        this.vertices = new Vertex[capacity];
        this.adjacencyMatrix = new int[capacity][capacity];
        this.visitoryFlags = new boolean[capacity];
    }

    public void insert(Vertex vertex) {
        if (size >= vertices.length) {
            throw new IllegalStateException("Graph is full");
        }
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

    public boolean isLinked(Vertex first, Vertex second) {
        int firstVertexIndex = findVertexIndex(first);
        int secondVertexIndex = findVertexIndex(second);
        return !(firstVertexIndex == -1 || secondVertexIndex == -1) ?
                adjacencyMatrix[firstVertexIndex][secondVertexIndex] == 1 : false;
    }

    public List<Vertex> vertices() {
        return Arrays.asList(vertices);
    }

    public void dfs() {
        Stack<Integer> vertexStack = new Stack<>();
        vertexStack.push(0);
        visit(0);
        while (!vertexStack.isEmpty()) {
            int currentVertexIndex = vertexStack.peek();
            int unvisitedVertexIndex = getUnvisitedVertex(currentVertexIndex);
            if (unvisitedVertexIndex == -1) {
                vertexStack.pop();
            } else {
                visit(unvisitedVertexIndex);
                vertexStack.push(unvisitedVertexIndex);
            }
        }
        finishVisits();
    }

    public void bfs() {
        Queue<Integer> vertexQueue = new LinkedList<>();
        vertexQueue.offer(0);
        while (!vertexQueue.isEmpty()) {
            int currentVertexIndex = vertexQueue.poll();
            int unvisitedVertexIndex;
            while ((unvisitedVertexIndex = getUnvisitedVertex(currentVertexIndex)) != -1) {
                visit(unvisitedVertexIndex);
                vertexQueue.offer(unvisitedVertexIndex);
            }
        }
        finishVisits();
    }

    private void finishVisits() {
        for (int i = 0; i < size; i++) {
            visitoryFlags[i] = false;
        }
        System.out.println();
    }

    public void minimalSpanningTree() {
        Stack<Integer> vertexStack = new Stack<>();
        vertexStack.push(0);
        while (!vertexStack.isEmpty()) {
            int currentVertexIndex = vertexStack.peek();
            int unvisitedVertexIndex = getUnvisitedVertex(currentVertexIndex);
            if (unvisitedVertexIndex != -1) {
                visit(currentVertexIndex);
                visit(unvisitedVertexIndex);
                System.out.printf(" ");
                vertexStack.push(unvisitedVertexIndex);
            } else {
                vertexStack.pop();
            }
        }
        finishVisits();
    }

    private void visit(int index) {
        visitoryFlags[index] = true;
        System.out.printf("%s", vertices[index]);
    }

    private int getUnvisitedVertex(int originIndex) {
        for (int i = 0; i < visitoryFlags.length; i++) {
            if (adjacencyMatrix[i][originIndex] == 1 && visitoryFlags[i] == false) {
                return i;
            }
        }
        return -1;
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
