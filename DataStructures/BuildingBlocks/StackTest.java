package DataStructures.BuildingBlocks;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * A class to test StackTest class.
 * Created by Kamal on 11/4/15.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StackTest {

    private Stack<Integer> stack;

    @Before
    public void runBefore()
    {
        Integer[] intgrs = new Integer[5];
        for(int i = 0; i< intgrs.length; i++)
            intgrs[i] = i;

        stack = new Stack<Integer>(intgrs);
    }

    @Test
    public void testEmptyConstruct()
    {
        Stack<Integer> integers = new Stack<>();
        assertEquals(integers.pop(), null);
    }

    @Test
    public void testArrayConstruct()
    {
        Integer[] integers = new Integer[5];
        for(int i = 0; i< integers.length; i++)
            integers[i] = i;

        stack = new Stack<Integer>(integers);
        assertEquals(stack.pop(), new Integer(4));
        assertEquals(stack.pop(), new Integer(3));
        assertEquals(stack.pop(), new Integer(2));
        assertEquals(stack.pop(), new Integer(1));
        assertEquals(stack.pop(), new Integer(0));

        stack = new Stack<Integer>(integers, Stack.ASCENDING_ORDER);
        assertEquals(stack.pop(), new Integer(4));
        assertEquals(stack.pop(), new Integer(3));
        assertEquals(stack.pop(), new Integer(2));
        assertEquals(stack.pop(), new Integer(1));
        assertEquals(stack.pop(), new Integer(0));

        stack = new Stack<>(integers, Stack.DESCENDING_ORDER);

        assertEquals(stack.pop(), new Integer(0));
        assertEquals(stack.pop(), new Integer(1));
        assertEquals(stack.pop(), new Integer(2));
        assertEquals(stack.pop(), new Integer(3));
        assertEquals(stack.pop(), new Integer(4));

    }

    @Test
    public void testPop() throws Exception {
        assertEquals(stack.pop(), new Integer(4));
        assertEquals(stack.pop(), new Integer(3));
        assertEquals(stack.pop(), new Integer(2));
        assertEquals(stack.pop(), new Integer(1));
        assertEquals(stack.pop(), new Integer(0));
        assertEquals(stack.pop(), null);
        assertEquals(stack.pop(), null);
    }

    @Test @Before
    public void testPush() throws Exception {
        stack = new Stack<>();
        stack.push(new Integer(1));
        assertEquals(stack.pop(), new Integer(1));
    }

    @Test
    public void testPeek() throws Exception {
        assertEquals(stack.peek(), new Integer(4));
    }

    @Test
    public void testToString()
    {
        assertEquals(stack.toString(), "4->3->2->1->0->END");
    }
}