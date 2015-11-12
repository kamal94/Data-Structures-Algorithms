package DataStructures.Graph;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

/**
 * A class that represents a node in a (non-directional) graph.
 *
 * Created by Kamal on 11/11/15.
 */
public class GraphNode <T extends Comparable<T>> {
    ArrayList<Edge<T>> edges;
    T t;
    private boolean connectionLoop;

    public GraphNode(T t)
    {
        connectionLoop = false;
        this.t = t;
        edges = new ArrayList<Edge<T>>();
    }

    /**
     * Links the passed node to this node. Both edges will have reference to each other.
     *
     * @param n The node to be connected to this one
     */
    public void connectNode(GraphNode<T> n)
    {
        if(connectionLoop) {
            connectionLoop = false;
            return;
        }

        Edge<T> edge = new Edge<>(this, n);
        this.edges.add(edge);
        n.connectNode(this);
        connectionLoop = true;
    }

    /**
     * Returns true if this node is connected to the passed node.
     *
     * @param n The GraphNode to be tested for connection with this GraphNode
     * @return  boolean True if there is an edge that connects the two nodes.
     */
    public boolean connectedTo(GraphNode<T> n)
    {
        return edges.contains(n);
    }

    /**
     * Returns all the edges this GraphNode is connected to.
     * @return
     */
    public ArrayList<Edge<T>> getEdges() {
        return edges;
    }

    /**
     * Returns a Set of GraphNodes that this GraphNode is connected to.
     *
     * @return Set<GraphNode>   All the GraphNodes connected to this GraphNode
     */
    public Set<GraphNode<T>> getConnectedNodes()
    {
        Set<GraphNode<T>> nodeSet = new TreeSet<GraphNode<T>>();
        for(Edge<T> edge: edges)
        {
            if (!edge.isLoop()) {
                GraphNode[] graphNodes = edge.getNodes();
                if(graphNodes[0] == this)
                    nodeSet.add(graphNodes[1]);
                else
                    nodeSet.add(graphNodes[0]);
            }
        }
        return nodeSet;
    }

    /**
     * Compares this GraphNode to the passed GraphNode
     *
     * @param obj   a GraphNode to compare this GraphNode to.
     * @return  boolean True if the objects have the same address in memory
     * @throws ClassCastException   Throws exception if the object passed is not an
     *                              instance of the GraphNode class
     */
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof GraphNode))
            throw new ClassCastException("The object passed is not an instance of the GraphNode class");

        return this == obj;
    }
}
