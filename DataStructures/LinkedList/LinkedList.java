package DataStructures.LinkedList;
import DataStructures.BuildingBlocks.Node;

import java.util.HashMap;
import java.util.Iterator;

/**
 * @author Kamal Kamalaldin
 * @version 10/19/2015
 */
public class LinkedList<T extends Comparable<T>> implements Iterable<Node>
{
	private Node head, tail;

	public LinkedList()
	{}

	/**
	 * Constructs a Linked List form an array
	 * @param  array the array to be converted to a Linked List
	 */
	public LinkedList(T[] array)
	{
		for(T t:array)
			put(t);
	}

	/**
	 * Adds data to the trailing tail
	 * @param data the data to be put to the end of the LL
	 */
	public void put(T data)
	{
		Node<T> node = new Node<T>(data);
		if(head == null)	//if no head, then begin LL with data
		{	
			head = node;
			tail = head;
			return;
		}
		tail.setNext(node); //add data to trailing tail
		tail = tail.getNext();
	}

	/**
	 * Removes the first i-th occurance of the object t in the Linked list. If an i-th 
	 * occrance can not be found, the method returns -1.
	 * @param  t 	the object to be removed in the Linked List, whose occrance is i
	 * @param  occ  	the occrance of the object t in the linked List. The first occrance
	 *             is represented by 1.
	 * @return   index 	the index of the object that was removed.
	 */
	public int remove(T t, int occ)
	{
		Node n;
		if(isEmpty())	//edge case: if list is empty
			return -1;
		else 
			n = head;

		//edge case: if LL is size 1
		if(head.getNext() == null && head.getData().equals(t)
			 && occ == 1)
		{
			head = null;
			return 0;
		}

		int counter = 1;
		int index = 0;
		Node next = n.getNext();
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
	public Node peek()
	{
		return head;
	}

	/**
	 * Returns true if the Linked List is empty
	 * @return true if the Linked list is empty
	 */
	public boolean isEmpty()
	{
		return head == null;
	}

	/**
	 * Returns the nth node in the linked list, where the 1st node is the head node.
	 * @param  ind the index of the node to be returned.
	 * @return   Node		the node at the given index.
	 */
	public Node getNthNode(int ind)
	{
		Node node = head;
		for(int i = 0; i < ind-1; i++)
		{
			if(node == null)
				return null;
			node = node.getNext();
		}
		return node;
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
		Iterator<Node> it = iterator();
		while(it.hasNext())
		{
			Node n = it.next();
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
		Node n = head;
		while(n!= null)	//until the end of the LL
		{
			if(n.getData().equals(obj))	//if any Node contains the same T, return true
				return true;
			n = n.getNext();
		}
		return false;	//if end is reached return false
	}

	public Node removeNode(Node n)
	{
		if(n.getNext() == null)
			return null;

		n.setData((T) n.getNext().getData());
		n.setNext(removeNode(n.getNext()));
		return n;
	}

	/**
	 * Removes duplicates from the linked list.
	 * @return String 	A string representation of the Linked List after removing duplicates
	 */
	public String removeDuplicates()
	{
		HashMap<Integer, T> hashmap = new HashMap<Integer, T>();

		Iterator<Node> it = iterator();
		while(it.hasNext())
		{
			Node n = it.next();
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
	 * Returns the k to last element in the list by checking the length of the list and
	 * running along the list again to find the k-to-last element. If the index is out of
	 * bound, null is returned.
	 * @param  k The offset from the end of the list for the index of the Node wanted.
	 *           For k = 1, the method will return the last element.
	 * @return   The Node k-to-last from the end in the Linked List
	 */
	public Node bruteForceNthoLastElement(int k)
	{
		int length = 0;
		Iterator<Node> it = iterator();
		while(it.hasNext())
		{
			length++;
			it.next();
		}
		System.out.println("Linked List length: " + length);
		int index = length -1 - k;
		Node n = head;
		for(int i = 0; i<index; i++)
		{
			n = n.getNext();
		}

		return n;
	}

	/**
	 * Returns the k to last element in the list by checking the length of the list and
	 * running along the list again to find the k-to-last element. If the index is out of
	 * bound, null is returned.
	 * @param  k The offset from the end of the list for the index of the Node wanted.
	 *           For k = 1, the method will return the last element.
	 * @return   The Node k-to-last from the end in the Linked List
	 */
	public Node recursiveNthoLastElement(Node head, int  k, Carrier car)
	{
		// Carrier car = new Carrier();
		// car.goal = k;
		// car.node = head;
		if(head == null)	//base case
			return null;

		Node node =  recursiveNthoLastElement(head.getNext(), k, car);

		if(car.count == k)
			return node;

		car.count++;
		return head;
	}

	public class Carrier {
		int count = 0;
	}

	/**
	 * Implementing iterator method that iterates from the head to the tail
	 * @return Iterator 	an Iterator instance
	 */
	@Override
	public Iterator<Node> iterator()
	{
		Iterator<Node> it = new Iterator<Node>()
		{
			Node n = head;

			@Override
            public boolean hasNext() {
                return (n != null);
            }

            @Override
            public Node next() {
            	Node t = n;
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