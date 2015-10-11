/**
 * BinarySearch.java
 *
 * A class that accepts a generic array and searches for
 * a target element using binary search.
 *
 * 
 * Author: Kamal Kamalaldin
 * Version: 10/10/2015
 */
public class BinarySearch<T extends Comparable<T>>
{
	T[] array;
	T target;
	int beginning;
	int ending;
	int mid;

	
	/**
	 * Instantiates a BinarySearch object that can be used to search
	 * a sorted generic array.
	 * 
	 * @param  arr An array of generic objects that implement the Comparable interface
	 * @param  tar The target being searched for.
	 * @param  beg The beginning index of the array
	 * @param  end [description]
	 * @return     [description]
	 */
	public BinarySearch(T[] arr, T tar)
	{
		array = arr;		target = tar;
		beginning = 0;
		ending = array.length-1;
	}

	/**
	 * Searches a sorted array of generic objects in a binary fashion and returns 
	 * the index of the element. If the element being searched for is not in the array,
	 * -1 is returned.
	 * 
	 * @return int the index of the target element in the array or -1 if the element is
	 *             not found.
	 */
	public int search()
	{
		return binarySearch(beginning, ending);
	}


	private int binarySearch(int begin, int end)
	{
		mid = begin + (end-begin)/2;

		if(begin == mid)	//if we have reached the last two values, the element 
			return -1;		//is not in the array

		if(end > array.length)	//if the ending is out of bounds, return null
			return -1;

		if(array[mid].compareTo(target) < 0) //if target is larger than mid value
		{
			return binarySearch(mid, ending);
		}
		else if(array[mid].compareTo(target) > 0) //if target is less than mid value
		{
			return binarySearch(begin, mid);
		}
		else if(array[mid].compareTo(target) == 0) //if target is the mid value
		{
			return mid;	//return the mid index
		}

		return -1;	// if this is reached, return null
	}
}