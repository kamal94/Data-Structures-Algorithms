package DataStructures.BuildingBlocks;

/**
 * A class representing a stack collection
 * @author Kamal Kamalaldin
 * @version 11/04/2015
 * @param <T>   Generic class that extends Comparable
 */
class Stack<T extends Comparable<T>>{

    public static final int ASCENDING_ORDER = 1;
    public static final int DESCENDING_ORDER = 0;

	private Node<T> top;

	public Stack()
	{}

	public Stack(T first)
	{
		top = new Node<T>(first);
	}

    /**
     * Construct a stack from an array. If ascending order is passed, the last element in the array
     * will be the top element in the stack. If descending order is passed, the first element in the
     * array (index 0) will be the top element in the stack.
     *
     * @param array T[]     The array from which to construct the stack
     * @param order int     One of the ASCENDING or DESCENDING constants from this class.
     */
    public Stack(T[] array, int order)
    {
        if(order == DESCENDING_ORDER)
            for(int i = array.length-1; i >= 0; i--)
                push(array[i]);
        else
            for(int i = 0; i < array.length; i++)
                push(array[i]);


    }

    public Stack(T[] array)
    {
        this(array, ASCENDING_ORDER);
    }

	public T pop()
	{
		if(top == null)
			return null;

		Node<T> removed = top;
		top = top.getNext();
		return removed.getData();
	}

	public void push(T t)
	{
		Node<T> newNode = new Node<T>(t);
		newNode.setNext(top);
		top = newNode;
	}

    public T peek()
    {
        return top.getData();
    }

    public String toString()
    {
        String str = "";
        Node<T> n = top;
        while (n != null)
        {
            str += n.getData().toString() + "->";
            n = n.getNext();
        }
        str += "END";

        return str;
    }


}