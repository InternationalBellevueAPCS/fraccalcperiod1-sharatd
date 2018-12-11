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
    	//Prompts user to enter equation
    	/*if (str_input.equals("EXIT")) {
    		System.out.println("Thank you for using this program!");
    	}
    	while (!(str_input.equals("EXIT"))) {
    	*/
    	String fraction = produceAnswer(str_input);
    	System.out.println(fraction);
    	//firstOperand(str_input);
    	//Calls produceAnswer and prints result
    		//System.out.println(secondoperand);
    		/*System.out.println("Please enter an equation using fractions if needed. Make sure to put underscore instead of space between "
        			+ " numbers in a mixed number. Enter EXIT to quit: ");
    		str_input = console.nextLine();
    		System.out.println(str_input);
    		*/
        // TODO: Read the input from the user and call produceAnswer with an equation
        // Checkpoint 1: Create a Scanner, read one line of input, pass that input to produceAnswer, print the result.
        // Checkpoint 2: Accept user input multiple times.
    	//}
    }
    
    /**
     * produceAnswer - This function takes a String 'input' and produces the result.
     * @param input - A fraction string that needs to be evaluated.  For your program, this will be the user input.
     *      Example: input ==> "1/2 + 3/4"
     * @return the result of the fraction after it has been calculated.
     *      Example: return ==> "1_1/4"
     */
    public static String operator(String userinput) {
    	String operator = userinput.substring(userinput.indexOf(" ")+1, userinput.lastIndexOf(" "));
    	return operator;
    }
  
    public static String produceAnswer(String userinput) {
    	String firststring = userinput.substring(0, userinput.indexOf(" "));
    	String firstwhole = " ";
    	String firstnumerator = " ";
    	String firstdenominator = " ";
    	String secondstring = userinput.substring(userinput.lastIndexOf(" ")+1);
    	String secondwhole = " ";
    	String secondnumerator = " ";
    	String seconddenominator = " ";
    	String output_str = " ";
    	//Declares variables for second operand
    	if (!secondstring.contains("_")) {
    		if (secondstring.contains("/")) {
        	secondnumerator = secondstring.substring(secondstring.indexOf(" ")+1, secondstring.indexOf("/"));
        	seconddenominator = secondstring.substring(secondstring.lastIndexOf("/")+1);
       
        	//return ("whole:0" + " " + "numerator:" + secondnumerator + " " + "denominator:" + seconddenominator);	
    		//Numerator is number before sign and denominator is number after, returns whole number, numerator, and denominator
    		}
        	else {
        	secondwhole = secondstring;
        	//return ("whole:" + secondwhole + " " + "numerator:0 denominator:1");
        	//returns whole number and default numerator as well as denominator if second operand is not mixed number
        	}
    	}	
    	else {
    		secondwhole = secondstring.substring(secondstring.indexOf(" ")+1, secondstring.indexOf("_"));
    		System.out.println(secondwhole);
    		secondnumerator = secondstring.substring(secondstring.indexOf("_")+1, secondstring.indexOf("/"));
    		seconddenominator = secondstring.substring(secondstring.indexOf("/")+1);

        	//return ("whole:" + secondwhole + " " + "numerator:" + secondnumerator + " " + "denominator:" + seconddenominator);
    	//The numerator is the number before the operator and the denominator is the number after if there is no whole number
    	//If there is an underscore, print out whole number before underscore, numerator before operator, and denominator after
    	}
    	System.out.println("second:"+ secondnumerator + seconddenominator);
    	System.out.println("first string:"+firststring);
    	if (!firststring.contains("_")) {
    		if (firststring.contains("/")) {
    			firstnumerator = firststring.substring(firststring.indexOf(" ")+1, firststring.indexOf("/"));
    			firstnumerator = firststring.substring(firststring.indexOf(" ")+1, firststring.indexOf("/"));
            	firstdenominator = firststring.substring(firststring.lastIndexOf("/")+1);
            	//return ("whole:0" + " " + "numerator:" + firstnumerator + " " + "denominator:" + firstdenominator);	
        		//Numerator is number before sign and denominator is number after, returns whole number, numerator, and denominator
        		
    			}
            	else {
            	firstwhole = firststring;
            	//return ("whole:" + firstwhole + " " + "numerator:0 denominator:1");
            	//returns whole number and default numerator as well as denominator if second operand is not mixed number
            	}
        	}	
        	else {
        		firstwhole = firststring.substring(firststring.indexOf(" ")+1, firststring.indexOf("_"));
        		System.out.println(firstwhole);
        		firstnumerator = firststring.substring(firststring.indexOf("_")+1, firststring.indexOf("/"));
        		firstdenominator = firststring.substring(firststring.indexOf("/")+1);
            	//return ("whole:" + firstwhole + " " + "numerator:" + firstnumerator + " " + "denominator:" + firstdenominator);
        	//The numerator is the number before the operator and the denominator is the number after if there is no whole number
        	//If there is an underscore, print out whole number before underscore, numerator before operator, and denominator after
        	
    		}
    	System.out.println("first:"+ firstnumerator + firstdenominator);
    	int lcm = leastCommonMultiple(Integer.parseInt(firstdenominator), Integer.parseInt(seconddenominator));
		//6_5/7 + 5_2/3
    	System.out.println("firstdenominator:" + firstdenominator);
		System.out.println("seconddenominator:" + seconddenominator);
		System.out.println(lcm);
    	String sign = operator(userinput);
    	System.out.println(sign);
    	if (sign.contains("+")) {
    		//System.out.println(sign);
    		if (userinput.contains("_")) {
    			int wholenumber = Integer.parseInt(firstwhole) + Integer.parseInt(secondwhole);
    			int num = Integer.parseInt(firstnumerator) * (lcm/Integer.parseInt(firstdenominator)) + Integer.parseInt(secondnumerator) * (lcm/Integer.parseInt(seconddenominator)); 
    			int denominator = lcm;
    		//System.out.println("wholenumber" + wholenumber);
    		//System.out.println("numerator" + num);
    		//System.out.println("denominator" + lcm);
    		return (wholenumber + "_" + num + "/" + denominator);
    		}
    		else {
    			int num = Integer.parseInt(firstnumerator) * (lcm/Integer.parseInt(firstdenominator)) + Integer.parseInt(secondnumerator) * (lcm/Integer.parseInt(seconddenominator)); 
    			int denominator = lcm;
    			//System.out.println("wholenumber" + wholenumber);
        		//System.out.println("numerator" + num);
        		//System.out.println("denominator" + lcm);
        		return (num + "/" + denominator);
        	}
    		
    	}
    	else if (sign.contains("-")) {
    		if (userinput.contains("_")) {
    			int wholenumber = Integer.parseInt(firstwhole) - Integer.parseInt(secondwhole);
    			int num = Integer.parseInt(firstnumerator) * (lcm/Integer.parseInt(firstdenominator)) - Integer.parseInt(secondnumerator) * (lcm/Integer.parseInt(seconddenominator)); 
    			int denominator = lcm;
    		//System.out.println("wholenumber" + wholenumber);
    		//System.out.println("numerator" + num);
    		//System.out.println("denominator" + lcm);
    		
    			return (wholenumber + "_" + num + "/" + denominator);
    		}
    		else {
    			int num = Integer.parseInt(firstnumerator) * (lcm/Integer.parseInt(firstdenominator)) - Integer.parseInt(secondnumerator) * (lcm/Integer.parseInt(seconddenominator)); 
    			int denominator = lcm;
    			//System.out.println("wholenumber" + wholenumber);
        		//System.out.println("numerator" + num);
        		//System.out.println("denominator" + lcm);
        		return (num + "/" + denominator);
        
    		}
    	}
    	else if (sign.contains("*")) {
    		if (userinput.contains("_")) {
    			int firstnum = Integer.parseInt(firstwhole) * Integer.parseInt(firstdenominator) + Integer.parseInt(firstnumerator);
    			int secondnum = Integer.parseInt(secondwhole) * Integer.parseInt(seconddenominator) + Integer.parseInt(secondnumerator);
    			int tempnum = firstnum * secondnum;
    			int denominator = Integer.parseInt(firstdenominator) * Integer.parseInt(seconddenominator);
    			int whole = 0;
    			int num = 0;
    			if (tempnum > denominator){
    				whole = tempnum / denominator;
    				num = tempnum % denominator;
    			}
    			else {
    				num = tempnum;
    			}
    		//System.out.println(firstnum);
    		//System.out.println(secondnum);
    		//System.out.println(denominator);
    		//System.out.println(whole);
    		//System.out.println(num);
    			return (whole + "_" + num + "/" + denominator);
    		}
    		else {
    			int firstnum = Integer.parseInt(firstnumerator);
    			int secondnum =  Integer.parseInt(secondnumerator);
    			int tempnum = firstnum * secondnum;
    			int denominator = Integer.parseInt(firstdenominator) * Integer.parseInt(seconddenominator);
    			int whole = 0;
    			int num = 0;
    			if (tempnum > denominator){
    				whole = tempnum / denominator;
    				num = tempnum % denominator;
    			}
    			else {
    				num = tempnum;
    			}
    			//System.out.println(firstnum);
    			//System.out.println(secondnum);
    			//System.out.println(denominator);
    			//System.out.println(whole);
    			//System.out.println(num);
    			return (whole + "_" + num + "/" + denominator);
    		}
    	}
    	else {
    		if (userinput.contains("_")) {
    			int firstnum = Integer.parseInt(firstwhole) * Integer.parseInt(firstdenominator) + Integer.parseInt(firstnumerator);
    			int secondnum = Integer.parseInt(secondwhole) * Integer.parseInt(seconddenominator) + Integer.parseInt(secondnumerator);
    			int tempnum = firstnum * Integer.parseInt(seconddenominator);
    			int denominator = Integer.parseInt(firstdenominator) * secondnum;
    			int whole = 0;
    			int num = 0;
    			if (tempnum > denominator){
    			whole = tempnum / denominator;
    			num = tempnum % denominator;
    			}
    			else {
    				num = tempnum;
    			}
    		//System.out.println(firstnum);
    		//System.out.println(secondnum);
    		//System.out.println(denominator);
    		//System.out.println(whole);
    		//System.out.println(num);
    		
    		return (whole + "_" + num + "/" + denominator);
    		}
    		else {
    			int firstnum =   Integer.parseInt(firstnumerator);
    			int secondnum =  Integer.parseInt(secondnumerator);
    			int tempnum = firstnum * Integer.parseInt(seconddenominator);
    			int denominator = Integer.parseInt(firstdenominator) * secondnum;
    			int whole = 0;
    			int num = 0;
    			if (tempnum > denominator){
    			whole = tempnum / denominator;
    			num = tempnum % denominator;
    			}
    			else {
    				num = tempnum;
    			}
    		//System.out.println(firstnum);
    		//System.out.println(secondnum);
    		//System.out.println(denominator);
    		//System.out.println(whole);
    		//System.out.println(num);
    		
    		return (whole + "_" + num + "/" + denominator);
    		}
    	}
    		
    	}
    	
    
    	/*String firstnumerator = userinput.substring(userinput.indexOf("_") + 1, userinput.indexOf("/"));
    	String firstdenominator = userinput.substring(userinput.indexOf("/") + 1, userinput.indexOf(" "));
    	int finaldenominator = leastCommonMultiple(Integer.parseInt(firstdenominator), Integer.parseInt(seconddenominator));
    	int finalnumerator = Integer.parseInt(firstnumerator) * (finaldenominator/Integer.parseInt(firstdenominator)) + Integer.parseInt(secondnumerator) * (finaldenominator/Integer.parseInt(seconddenominator));
    	System.out.println(finalnumerator + "/" + finaldenominator);
    	if (userinput.indexOf("_") != -1) {
    	*/
    	//}
        // TODO: Implement this function to produce the solution to the input
        // Checkpoint 1: Return the second operand.  Example "4/5 * 1_2/4" returns "1_2/4".
        // Checkpoint 2: Return the second operand as a string representing each part.
        //               Example "4/5 * 1_2/4" returns "whole:1 numerator:2 denominator:4".
        // Checkpoint 3: Evaluate the formula and return the result as a fraction.
        //               Example "4/5 * 1_2/4" returns "6/5".
        //               Note: Answer does not need to be reduced, but it must be correct.
        // Final project: All answers must be reduced.
        //               Example "4/5 * 1_2/4" returns "1_1/5".
    //	return("x");
  //  }


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
