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

    @Test
    public void verticesShouldBeLinked() {
        Graph graph = new Graph(3);
        Vertex a = new Vertex('A');
        Vertex b = new Vertex('B');
        Vertex c = new Vertex('C');
        graph.insert(a);
        graph.insert(b);
        assertFalse(graph.isLinked(a, b));
        graph.link(a, b);
        assertTrue(graph.isLinked(a, b));
        assertFalse(graph.isLinked(a, c));
        assertFalse(graph.isLinked(b, c));
    }

    @Test
    public void testTopo() {
        Graph theGraph = new Graph(20);
        theGraph.insert('A');
        theGraph.insert('B');
        theGraph.insert('C');
        theGraph.insert('D');
        theGraph.insert('E');
        theGraph.insert('F');
        theGraph.insert('G');
        theGraph.insert('H');
        theGraph.link(0, 3);
        theGraph.link(0, 4);
        theGraph.link(1, 4);
        theGraph.link(2, 5);
        theGraph.link(3, 6);
        theGraph.link(4, 6);
        theGraph.link(5, 7);
        theGraph.link(6, 7);
        theGraph.topo();
    }

}