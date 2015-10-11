/**
 * 
 */
public class main{

	public static void main(String[] args)
	{
		Integer[] nums = new Integer[50];

		for(int i = 0; i < nums.length; i++)
			nums[i] = i*2;

		BinarySearch<Integer> binSearch = new BinarySearch<Integer>(nums, Integer.parseInt(args[0]));
		System.out.println(binSearch.search());
	}
}