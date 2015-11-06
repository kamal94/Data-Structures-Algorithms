package DataStructures.BuildingBlocks;

/**
 * Created by Kamal on 11/3/15.
 */
public class BinaryTree<T extends Comparable<T>> {
    private BinaryTree left;
    private BinaryTree right;
    private Node<T> node;

    public BinaryTree(T t)
    {
        node = new Node<>(t);
        left = null;
        right = null;
    }

    public BinaryTree getLeft() {
        return left;
    }

    public void setLeft(BinaryTree left) {
        this.left = left;
    }

    public BinaryTree getRight() {
        return right;
    }

    public void setRight(BinaryTree right) {
        this.right = right;
    }

    public Node<T> getNode() {
        return node;
    }

    public void setNode(Node<T> node) {
        this.node = node;
    }

    public boolean isLeaf() {
        return (getLeft() == null && getRight() == null);
    }
}
