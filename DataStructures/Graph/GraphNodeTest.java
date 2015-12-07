package DataStructures.Graph;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Kamal on 11/11/15.
 */
public class GraphNodeTest {

    private GraphNode<Integer> gNode;

    @Before
    public void buildUp()
    {
        gNode = new GraphNode<>(2);
    }

    @Test
    public void testConnectNode() throws Exception {
        GraphNode<Integer> newNode = new GraphNode<>(3);
        gNode.connectNode(newNode);
        assertEquals(gNode.getConnectedNodes().contains(newNode), true);
    }

    @Test
    public void testConnectedTo() throws Exception {
        GraphNode<Integer> newNode = new GraphNode<>(3);
        gNode.connectNode(newNode);
        assertEquals(gNode.connectedTo(newNode), true);
        assertEquals(gNode.connectedTo(new GraphNode<>(3)), false);
    }

    @Test
    public void testGetEdges() throws Exception {
        GraphNode<Integer> newNode = new GraphNode<>(3);
        gNode.connectNode(newNode);

        Edge<Integer> pseudoEdge = new Edge<Integer>(newNode, gNode);
        ArrayList<Edge<Integer>> arrayList = new  ArrayList<Edge<Integer>>();
        arrayList.add(pseudoEdge);

        assertEquals(gNode.getEdges(), arrayList);

    }

    @Test
    public void testGetConnectedNodes() throws Exception {

    }

    @Test
    public void testEquals() throws Exception {
        //testing that two nodes with the same value are not necessarily
        //the same node
        GraphNode<Integer> n = new GraphNode<>(1);
        GraphNode<Integer> m = new GraphNode<>(1);
        assertEquals(n.equals(m), false);
        //testing equality by reference
        n = m;
        assertEquals(n.equals(m), true);
    }
}