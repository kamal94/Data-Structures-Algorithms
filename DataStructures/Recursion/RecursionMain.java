package DataStructures.Recursion;

/**
 * 
 */
public class RecursionMain {

	public static final long MAX_STEP_POSSIBLITIES = 50;
	private static long[] stepPossibilities = new long[(int) MAX_STEP_POSSIBLITIES];
	public static void main(String[] args)
	{
		System.out.println(nthStepsPossiblity(6));
	}

	/**
	 * Solution for 9.1 in Cracking the coding interview
	 *
	 * 
	 */
	public static long nthStepsPossiblity(long n)
	{
		//base case
		if(n == 1)
			return 1;
		if(n == 2)
			return 2;
		if(n == 3)
			return 4;

		if( n < MAX_STEP_POSSIBLITIES && stepPossibilities[(int) n] != 0)
			return stepPossibilities[(int)n];
		long pos =  (nthStepsPossiblity(n-1) + 1
				+ nthStepsPossiblity(n-2) + 2
				+ nthStepsPossiblity(n-3) + 4
			);

		if(n < MAX_STEP_POSSIBLITIES)
			stepPossibilities[(int) n] = pos;

		return pos;
	}
}