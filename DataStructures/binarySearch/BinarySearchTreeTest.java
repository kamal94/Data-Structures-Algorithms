package DataStructures.binarySearch;

import DataStructures.BuildingBlocks.BinaryTree;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * A class that tests Binary Search Tree class.
 * Created by Kamal on 11/4/15.
 */
public class BinarySearchTreeTest {

    BinarySearchTree<Integer> tree;
    @Before
    public void setUp() throws Exception {
        tree = new BinarySearchTree<>(2);
    }

    @Test
    public void testPut() throws Exception {
        //test putting in both orders and getting similar result
        tree.put(3);
        tree.put(1);
        assertEquals(tree.getLeft().getNode().getData(), 1);
        assertEquals(tree.getRight().getNode().getData(), 3);
        tree = new BinarySearchTree<>(2);
        tree.put(1);
        tree.put(3);
        assertEquals(tree.getLeft().getNode().getData(), 1);
        assertEquals(tree.getRight().getNode().getData(), 3);


    }

    @Test
    public void testFind() throws Exception {
        //test finding valid values in the tree
        assertEquals(tree.find(2), new Integer(2));
        tree.put(3);
        tree.put(1);
        assertEquals(tree.find(1), new Integer(1));
        assertEquals(tree.find(3), new Integer(3));
        //test finding values again
        assertEquals(tree.find(2), new Integer(2));
        //test finding values not in the tree
        assertEquals(tree.find(50), null);
        //test finding values not in the tree but in super tree
        assertEquals(tree.getLeft().find(2), null);
    }

    @Test
    public void testBinarySearch() throws Exception {

    }
}