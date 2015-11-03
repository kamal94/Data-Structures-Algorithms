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
 * Version: 10/10/2015
 */
public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree
{
	private BinarySearchTree<T> left;
	private BinarySearchTree<T> right;

	public BinarySearchTree(Comparable comparable) {
		super(comparable);
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
        if(t == null)
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
		if (this.getNode() == null)
			return null;

        int comp = getNode().compareTo(new Node(t));
        if(comp<0) {
            if(getLeft() == null) {return null;}
            else return left.find(t);
        }
        else if(comp>0) {
            if(right == null) {return null;}
            else return right.find(t);
        }
        else
            return (T) getNode().getData();
	}



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