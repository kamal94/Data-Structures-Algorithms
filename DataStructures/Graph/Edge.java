package DataStructures.Graph;

/**
 * Created by Kamal on 11/10/15.
 */
public class Edge<T extends Comparable>{
    private boolean isLoop;
    private GraphNode one;
    private GraphNode two;

    /**
     * Construct an edge that links two GraphNodes.
     * @param a The first node.
     * @param b The second node.
     */
    public Edge(GraphNode a, GraphNode b) {
        one = a;
        two = b;
    }
    /**
     * Returns true if the node on one end of the edge is also on the other end of the edge.
     *
     * @return  true if the edge is a loop.
     */
    public boolean isLoop() {
        return one.equals(two);
    }

    /**
     * Returns true if the edges connecting the nodes are the same.
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Edge))
            throw new ClassCastException("Object passes is not an instance" +
                    " of the Edge class");

        GraphNode[] objNodes = ((Edge) obj).getNodes();
        if(one.equals(objNodes[0]) && two.equals(objNodes[1]))
            return true;
        if(one.equals(objNodes[1]) && two.equals(objNodes[0]))
            return true;

        return false;
    }

    /**
     * Returns the nodes this edge connects.
     * @return
     */
    public GraphNode[] getNodes()
    {
        return new GraphNode[]{one, two};
    }
}
