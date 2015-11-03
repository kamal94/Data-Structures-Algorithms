package DataStructures.Factorial;

public class Factorial
{
	public static long recursiveFactorial(long num)
	{
		if(num < 1) return -1;	//check for positivity
		if(num == 1) return num;	//check for base case
		if(Integer.MAX_VALUE/num < num-1) return -1; //check for overflow possiblities
		long result =  num * recursiveFactorial(num-1);
		if(result < 0) return -1;
		return result;
	}

	public static long loopFactorial(long num)
	{
		long result = 0;
		if(num < 1) return -1;
		for(; num > 1; num--)
			result *= num;
		return result;
	}

	/**
     * LinkedListMain method
     */
    public static class FactorialMain {

        public static void main(String[] args)
        {

            for(String argument: args)
            {
                System.out.println("Recursive Factorial of "+ argument +
                 " = " + recursiveFactorial(Long.valueOf(argument)));
                System.out.println("Loop Factorial of "+ argument +
                 " = " + recursiveFactorial(Long.valueOf(argument)));
            }
        }
    }
}