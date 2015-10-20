
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



		System.out.println("Node at second to last index 0: " + LL.bruteForceNthoLastElement(0));
		LL.removeDuplicates();

		LLNode node = LL.getNthNode(4);
		System.out.println("4th node: " + node.toString());
		System.out.println(LL.removeNode(node));
		System.out.println(node.getNext());
		System.out.println( "3rd to last element in List: " +
			LL.recursiveNthoLastElement(LL.getNthNode(1), 3,  LL.new Carrier()));
	}
}