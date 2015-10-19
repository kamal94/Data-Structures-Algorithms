
import java.util.Iterator;
/**
 * 
 */
public class main{

	public static void main(String[] args)
	{

		int length = 50;
		// String string  = "hi I am kamal";
		// String[] strings = string.split(" ");
		// for(String str: strings)
		// 	System.out.println(str);

		// int[] ints = IntStream.range(0,50).toArray();
		Integer[] integers = new Integer[length];
		for(int i = 0; i < length; i++)
			integers[i] = new Integer(i);

		LinkedList<Integer> LL = new LinkedList<Integer>(integers);
		LL.put(5);

		System.out.println("list: \n" +LL.toString());
		System.out.println("LL contains 5: " + LL.contains(new Integer(5)));

		System.out.println(LL.removeDuplicates());
		System.out.println(LL.remove(0,1));

	}
}