package DataStructures.binarySearch;

import DataStructures.BuildingBlocks.BinaryTree;
import DataStructures.BuildingBlocks.Node;

/**
 * BinaryTree.java
 *
 * A class that accepts a generic array and searches for
 * a target element using binary search.
 *
 * 
 * Author: Kamal Kamalaldin
 * Version:11/11/2015
 */
public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree
{

	//instance variables
	private BinarySearchTree<T> left;
	private BinarySearchTree<T> right;

	public BinarySearchTree(Comparable comparable) {
		super(comparable);
	}

    @Override
    public BinarySearchTree<T> getLeft() {
        return left;
    }

    @Override
    public BinarySearchTree<T> getRight() {
        return right;
    }

    /**
     * Puts the object in the binary search tree and returns true if the inserttion is successful.
     * If the object is null or an instance of the object is already in the binary search tree, false
     * is returned.
     *
     * @param t     T the object to be inserted in the binary search tree
     * @return  boolean     True if the object was inserted. False if the object is already in the
     *                      BST or if the object is null
     */
    public boolean put(T t)
    {
        if(t == null) //check input
            return false;

        if(getNode() == null)
            setNode(new Node(t));

        if(getNode().getData().compareTo(t) > 0)
            return right.put(t);
        if(getNode().getData().compareTo(t) < 0)
            return left.put(t);

        return false;
    }


	/**
	 * Searches a sorted array of generic objects in a binary fashion and returns 
	 * the index of the element. If the element being searched for is not in the array,
	 * -1 is returned.
	 * 
	 * @return int the index of the target element in the array or -1 if the element is
	 *             not found.
	 */
	public T find(T t)
	{
		if (this.getNode() == null) //base case, reached a leaf node
			return null;

		//compare t with current node
        int comp = getNode().compareTo(new Node(t));
        if(comp<0) {	//if t is bigger, search right tree
            if(getLeft() == null) {return null;}
            else return left.find(t);
        }	//if t is smaller, search left tree
        else if(comp>0) {
            if(right == null) {return null;}
            else return right.find(t);
        }
        else //if equal, t is found!
            return (T) getNode().getData();
	}


	/**
	 * Returns true if the element is in the BST
	 * @param t 	The element to be tested for presense in the BST
	 * @return		True if the element is in the BST
	 */
	public boolean contains(T t)
	{
		return (find(t) != null);
	}

	/**
	 * Searches for an element in a sorted array. Returns the index of the element if it
     * is in the array, otherwise returns -1
	 * @param array     a sorted array of T elements
	 * @param target    T which is to be searched for
	 * @param begin     The index at which the array search should begin
	 * @param end       The index at which the array search should end
	 * @return  int     The index of the object if it is in the array, or -1 if it is not
     *                  in the array
	 */
	public static <T extends Comparable<T>> int binarySearch(T[] array, T target, int begin, int end)
	{
		int mid = begin + (end-begin)/2;

		if(begin == mid)	//if we have reached the last two values, the element 
			return -1;		//is not in the array

		if(end > array.length)	//if the ending is out of bounds, return null
			return -1;

		if(array[mid].compareTo(target) < 0) //if target is larger than mid value
		{
			return binarySearch(array, target, mid, end);
		}
		else if(array[mid].compareTo(target) > 0) //if target is less than mid value
		{
			return binarySearch(array, target, begin, mid);
		}
		else if(array[mid].compareTo(target) == 0) //if target is the mid value
		{
			return mid;	//return the mid index
		}

		return -1;	// if this is reached, return null
	}
}