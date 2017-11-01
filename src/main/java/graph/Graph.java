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

    public void insert(char label) {
        insert(new Vertex(label));
    }

    public void link(Vertex first, Vertex second) {
        int firstVertexIndex = findVertexIndex(first);
        int secondVertexIndex = findVertexIndex(second);

        link(vertices[firstVertexIndex], vertices[secondVertexIndex]);
    }

    public void link(int from, int to) {
        if (from == -1 || to == -1) {
            throw new IllegalArgumentException("One of vertices is not found in the graph");
        }
        adjacencyMatrix[from][to] = 1;
        adjacencyMatrix[to][from] = 1;
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

    public List<Character> topo() {
        int counter = size;
        List<Character> labels = new ArrayList<>(counter);
        while (--counter > 0) {
            int currentVertexPosition = noSuccessors();
            if (currentVertexPosition == -1) {
                System.err.printf("Graph has cycles");
                return Collections.emptyList();
            }
            labels.add(vertices[currentVertexPosition].getLabel());
            delete(currentVertexPosition);
        }
        return labels;
    }

    public void delete(int position) {
        for (int i = 0; i < size - 1; i++) {
            adjacencyMatrix[i] = adjacencyMatrix[i+1];
            for (int j = position; j < size - 1; j++) {
                adjacencyMatrix[i][j] = adjacencyMatrix[i][j+1];
            }
        }
    }

    private int noSuccessors() {
        for (int i = 0; i < size; i++) {
            boolean hasSuccessors = false;
            for (int j = 0; j < size; j++) {
                if (adjacencyMatrix[i][j] == 1) {
                    hasSuccessors = true;
                    break;
                }
            }
            if (!hasSuccessors)
                return i;
        }
        return -1;
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
