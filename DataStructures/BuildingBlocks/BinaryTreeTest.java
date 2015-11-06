package DataStructures.BuildingBlocks;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Kamal on 11/4/15.
 */
public class BinaryTreeTest {

    BinaryTree<Integer> binaryTree;

    @Before
    public void build()
    {
        binaryTree = new BinaryTree<>(5);
        binaryTree.setLeft(new BinaryTree(4));
        binaryTree.setRight(new BinaryTree(3));
    }

    @Test
    public void testGetNode() throws Exception {
        assertEquals(binaryTree.getNode().getData(), new Integer(5));
    }

    @Test
    public void testGetLeft() throws Exception {
        assertEquals(binaryTree.getLeft().getNode().getData(), 4);
    }

    @Test
    public void testSetLeft() throws Exception {
        binaryTree.setLeft(new BinaryTree(25));
        assertEquals(binaryTree.getLeft().getNode().getData(), 25);
    }

    @Test
    public void testSetRight() throws Exception {
        binaryTree.setRight(new BinaryTree(3));
        assertEquals(binaryTree.getRight().getNode().getData(), 3);
    }

    @Test
    public void testGetRight() throws Exception {
        binaryTree.setRight(new BinaryTree(25));
        assertEquals(binaryTree.getRight().getNode().getData(), 25);

    }

    @Test
    public void testSetNode() throws Exception {
        binaryTree.setNode(new Node<>(52));
        assertEquals(binaryTree.getNode().getData(), new Integer(52));
    }

    @Test
    public void testIsLeaf() throws Exception {
        assertEquals(binaryTree.getRight().isLeaf(), true);
        assertEquals(binaryTree.getLeft().isLeaf(), true);
        assertEquals(binaryTree.isLeaf(), false);
    }
}