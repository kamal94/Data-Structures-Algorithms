/**
 * main method
 */
public class main{

	public static void main(String[] args)
	{

		for(String argument: args)
		{
			System.out.println("Recursive Factorial of "+ argument +
			 " = " + Factorial.recursiveFactorial(Long.valueOf(argument)));
			System.out.println("Loop Factorial of "+ argument +
			 " = " + Factorial.recursiveFactorial(Long.valueOf(argument)));
		}
	}
}