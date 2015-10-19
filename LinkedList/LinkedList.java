import java.util.HashMap;
import java.util.Iterator;

/**
 * @author Kamal Kamalaldin
 * @version 10/19/2015
 */
public class LinkedList<T extends Comparable<T>> implements Iterable<LLNode>
{
	private LLNode head, tail;
	/**
	 * Constructs a Linked List form an array
	 * @param  array the array to be converted to a Linked List
	 */
	public LinkedList(T[] array)
	{
		for(T t:array)
		{
			put(t);
		}
	}

	/**
	 * Adds data to the trailing tail
	 * @param data the data to be put to the end of the LL
	 */
	public void put(T data)
	{
		LLNode<T> node = new LLNode<T>(data);
		if(head == null)	//if no head, then begin LL with data
		{	
			head = node;
			tail = head;
		}
		tail.setNext(node); //add data to trailing tail
		tail = tail.getNext();
	}

	/**
	 * Removes the first i-th occurance of the object t in the Linked list. If an i-th 
	 * occrance can not be found, the method returns -1.
	 * @param  t 	the object to be removed in the Linked List, whose occrance is i
	 * @param  i  	the occrance of the object t in the linked List. The first occrance 
	 *             is represented by 1.
	 * @return   index 	the index of the object that was removed.
	 */
	public int remove(T t, int occ)
	{
		LLNode n;
		if(head == null)
			return -1;
		else 
			n = head;

		//TODO::edge case when LL size is 1

		int counter = 1;
		int index = 0;
		LLNode next = n.getNext();
		while(next != null)
		{
			if(next.getData().equals(t))
			{
				if(occ==counter)
				{
					n.setNext(next.getNext());
					return index;
				}
				else
					counter++;
			}
			n = next;
			next = n.getNext();
			index ++;
		}
		return -1;
	}

	/**
	 * Peeks at the head of the the LinkedList
	 * @return [description]
	 */
	public LLNode peek()
	{
		return head;
	}

	/**
	 * Returns a string representation of the LinkedList. The string representation
	 * of the nodes depends on the implementation of the toString method of the Objects 
	 * within the nodes.
	 * 
	 * @return String A string representing the Nodes of the Linked List. Each node is 
	 *                separated by a "->" string.
	 */
	public String toString()
	{
		String string = "";
		Iterator<LLNode> it = iterator();
		while(it.hasNext())
		{
			LLNode n = it.next();
			string += n.toString();
			string += "->";
		}
		string += "END";
		return string;
	}

	/**
	 * Returns true if the Linked List contains obj in the Linked List
	 * @param  obj an object to be searched for in the Linked List
	 * @return   boolean true if obj is in a node in the Linked List
	 */
	public boolean contains(T obj)
	{
		LLNode n = head;
		while(n!= null)	//until the end of the LL
		{
			if(n.getData().equals(obj))	//if any Node contains the same T, return true
				return true;
			n = n.getNext();
		}
		return false;	//if end is reached return false
	}

	public String removeDuplicates()
	{
		HashMap<Integer, T> hashmap = new HashMap<Integer, T>();

		Iterator<LLNode> it = iterator();
		while(it.hasNext())
		{
			LLNode n = it.next();
			if(hashmap.containsKey(n.getData().hashCode()))
			{
				System.out.println("Duplicate found at index " + remove((T) n.getData(), 2));
			}
			else
				hashmap.put(n.getData().hashCode(), (T) n.getData());
		}
		return this.toString();
	}


	/**
	 * Implementing iterator method that iterates from the head to the tail
	 * @return Iterator 	an Iterator instance
	 */
	@Override
	public Iterator<LLNode> iterator()
	{
		Iterator<LLNode> it = new Iterator<LLNode>()
		{
			LLNode n = head;

			@Override
            public boolean hasNext() {
                return (n != null);
            }

            @Override
            public LLNode next() {
            	LLNode t = n;
            	n = n.getNext();
                return t;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
		};

		return it;
	}
}