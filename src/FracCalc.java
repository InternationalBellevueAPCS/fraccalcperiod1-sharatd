import java.util.*;
public class FracCalc {

    /**
     * Prompts user for input, passes that input to produceAnswer, then outputs the result.
     * @param args - unused
     */
    public static void main(String[] args) 
    {
    	Scanner console = new Scanner(System.in);
    	System.out.println("Please enter an equation using fractions if needed. Make sure to put underscore instead of space between "
    			+ " numbers in a mixed number. Enter EXIT to quit: ");
    	String str_input = console.nextLine();
    	if (str_input.equals("EXIT")) {
    		System.out.println("Thank you for using this program!");
    	}
    	while (!(str_input.equals("EXIT"))) {
    		String secondoperand = produceAnswer(str_input);
    		System.out.println(secondoperand);
    		System.out.println("Please enter an equation using fractions if needed. Make sure to put underscore instead of space between "
        			+ " numbers in a mixed number. Enter EXIT to quit: ");
    		str_input = console.nextLine();
    		System.out.println(str_input);
        // TODO: Read the input from the user and call produceAnswer with an equation
        // Checkpoint 1: Create a Scanner, read one line of input, pass that input to produceAnswer, print the result.
        // Checkpoint 2: Accept user input multiple times.
    	}
    }
    
    /**
     * produceAnswer - This function takes a String 'input' and produces the result.
     * @param input - A fraction string that needs to be evaluated.  For your program, this will be the user input.
     *      Example: input ==> "1/2 + 3/4"
     * @return the result of the fraction after it has been calculated.
     *      Example: return ==> "1_1/4"
     */
    public static String produceAnswer(String userinput)
    {
    	String secondstring = userinput.substring(userinput.lastIndexOf(" ")+1);
    	String secondwhole = userinput.substring(userinput.lastIndexOf(" ")+1, userinput.lastIndexOf("_"));
    	String secondnumerator = userinput.substring(userinput.lastIndexOf("_")+1, userinput.lastIndexOf("/"));
    	String seconddenominator = userinput.substring(userinput.lastIndexOf("/")+1);
        // TODO: Implement this function to produce the solution to the input
        // Checkpoint 1: Return the second operand.  Example "4/5 * 1_2/4" returns "1_2/4".
        // Checkpoint 2: Return the second operand as a string representing each part.
        //               Example "4/5 * 1_2/4" returns "whole:1 numerator:2 denominator:4".
        // Checkpoint 3: Evaluate the formula and return the result as a fraction.
        //               Example "4/5 * 1_2/4" returns "6/5".
        //               Note: Answer does not need to be reduced, but it must be correct.
        // Final project: All answers must be reduced.
        //               Example "4/5 * 1_2/4" returns "1_1/5".
        return "whole:" + secondwhole + " " + "numerator:" + secondnumerator + " " + "denominator:" + seconddenominator;
    }


    // TODO: Fill in the space below with helper methods
    
    /**
     * greatestCommonDivisor - Find the largest integer that evenly divides two integers.
     *      Use this helper method in the Final Checkpoint to reduce fractions.
     *      Note: There is a different (recursive) implementation in BJP Chapter 12.
     * @param a - First integer.
     * @param b - Second integer.
     * @return The GCD.
     */
    public static int greatestCommonDivisor(int a, int b)
    {
        a = Math.abs(a);
        b = Math.abs(b);
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        while (min != 0) {
            int tmp = min;
            min = max % min;
            max = tmp;
        }
        return max;
    }
    
    /**
     * leastCommonMultiple - Find the smallest integer that can be evenly divided by two integers.
     *      Use this helper method in Checkpoint 3 to evaluate expressions.
     * @param a - First integer.
     * @param b - Second integer.
     * @return The LCM.
     */
    public static int leastCommonMultiple(int a, int b)
    {
        int gcd = greatestCommonDivisor(a, b);
        return (a*b)/gcd;
    }
}
