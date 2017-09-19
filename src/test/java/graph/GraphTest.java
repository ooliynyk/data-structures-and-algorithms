package graph;

import org.junit.Test;

import static org.junit.Assert.*;

public class GraphTest {

    @Test
    public void graphShouldContainsVerticesAfterInsertion() throws Exception {
        Graph graph = new Graph(15);
        Vertex testVertex1 = new Vertex('A');
        Vertex testVertex2 = new Vertex('B');
        graph.insert(testVertex1);
        graph.insert(testVertex2);
        assertTrue(graph.vertices().contains(testVertex1));
        assertTrue(graph.vertices().contains(testVertex2));
    }

    @Test(expected = IllegalStateException.class)
    public void graphShouldRaiseErrorWhenCapacityIsExceeded() {
        Graph graph = new Graph(1);
        graph.insert(new Vertex('A'));
        graph.insert(new Vertex('B'));
    }

}