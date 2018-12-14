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
    	//If user inputs EXIT, end program
    	/*if (str_input.equals("EXIT")) {
    		System.out.println("Thank you for using this program!");
    	}
    	*/
    	//Calls produce answer while input is not exit
    	//while (!(str_input.equals("EXIT"))) {
    	String fraction = produceAnswer(str_input);
    	System.out.println(fraction);
    	//}
    	
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
    public static String firstOperand(String userinput) {
    	//Sets firststring as first operand and returns that
    	String firststring = userinput.substring(0, userinput.indexOf(" "));
    	return firststring;
    }
    public static String secondOperand(String userinput) {
    	//Sets secondstring to second operand and returns the result
    	String secondstring = userinput.substring(userinput.lastIndexOf(" ")+1);
    	System.out.println("secondstring:"+secondstring);
    	return secondstring;
    }
    public static String operator(String userinput) {
    	//Returns the operator
    	String operator = userinput.substring(userinput.indexOf(" ")+1, userinput.lastIndexOf(" "));
    	System.out.println("operator:"+operator);
    	return operator;
    }
    public static String whole(String operand) {
    	String wholenumber = " ";
    	//Whole number is number before underscore
    	if (operand.contains("_")) {
    		wholenumber = operand.substring(0, operand.indexOf("_"));
    	}
    	
    	else {
    	//If no underscore, whole number is whole operand
    		wholenumber = operand;
    		if (operand.contains("/")) {
    			//However, if there is a dividing sign, there is no whole number
    			wholenumber = " ";	
    			System.out.println(wholenumber);
    		}
    	}
    	return wholenumber;
    }
    public static String numerator(String operand) {
    
    	String num = " ";
    	System.out.println("operand "+operand);
    	if (operand.contains("_")) {
    		//Numerator is number between underscore and dividing sign
    		num = operand.substring(operand.indexOf("_")+1, operand.indexOf("/"));
    		return num;
    	}
    	else {
    		//If there is no underscore, numerator could either be first number of no number
    		if (!operand.contains("/")) {
    			num = " ";
    			return num;
    		}
    		else {
    			num = operand.substring(0, operand.indexOf("/"));
    			System.out.println("num=" + num);
    			return num;
    		}
    		
    	}
    	
    }
    public static String denominator(String operand) {
    	String denom = " ";
    	if (operand.contains("_")) {
    		//Denominator is number after dividing sign if there's underscore
    		denom = operand.substring(operand.indexOf("/")+1);
    		return denom;
    	}
    	else {
    		//If there is no dividing sign, there is no denominator. If there is a dividing sign, the denominator is the first number
    		//after the dividing sign
    		if(!operand.contains("/")) {
    			denom = " ";
    			return denom;
    		}
    		else { 
    			denom = operand.substring(operand.indexOf("/")+1);
    			return denom;
    		}
    	}
  
    	
    }
    public static String oneZero(String firststring, String secondstring, String operator, String firstwhole, String firstnumerator, String firstdenominator,
   		 String secondwhole,  String secondnumerator,  String seconddenominator) {
    	int firstwholenum = 0;
    	int firstnum = 0;
    	int firstdenom = 0;
    	int secondwholenum = 0;
    	int secondnum = 0;
    	int seconddenom = 0;
    	int finalnum = 0;
		int finalwhole = 0;
		int lcm = 0;
		int finaldenom = 0;
    	System.out.println("inside fractions firstnumerator "+firstnumerator);
    	System.out.println("inside fractions secondnumerator "+secondnumerator);
    	System.out.println("inside fractions seconddenominator "+seconddenominator);
    	if (!firstnumerator.equals(" ")) {
    	 firstnum = Integer.parseInt(firstnumerator);
     	System.out.println("inside fractions firstumerator "+firstnum);
    	}
    	if (!firstdenominator.equals(" ")) {
    	 firstdenom = Integer.parseInt(firstdenominator);
    	}
    	if (!firstwhole.equals(" ")) {
    	 firstwholenum = Integer.parseInt(firstwhole);
    	}
    	if (!secondnumerator.equals(" ")) {
    	 secondnum = Integer.parseInt(secondnumerator);
    	 System.out.println("inside fractions secondnumerator " + secondnum);
    	}
    	if (!seconddenominator.equals(" ")) {
    	 seconddenom = Integer.parseInt(seconddenominator);
    	 System.out.println("inside fractions denom " + seconddenom);
    	}
    	if (!secondwhole.equals(" ")) {
    	 secondwholenum = Integer.parseInt(secondwhole);
    	 System.out.println("inside fractions whole " + secondwholenum);
    	}
    	System.out.println(firstwhole + "," + secondwhole);
    	// taking care of negative numbers
    	if (!firstwhole.equals(" ")) {
    		if (firstwholenum < 0) {
    			firstwholenum *= -1;
    		}
    		// make mixed fraction into improper fraction
    		firstnum = firstwholenum*firstdenom+firstnum;
    		if (firstnumerator.equals(" ")) {
    			firstnum = firstwholenum;
    			firstdenom = 1;
    			System.out.println("whole "+ firstnum+firstdenom);
    		}
    	}
    	if (firststring.equals("0")) {
    		//If the first operand is 0
    		if (operator.equals("+")) {
    			int gcd = greatestCommonDivisor(secondnum, seconddenom);
    	    	System.out.println(gcd);
    		
    	    	if (gcd != 1) {
    	    		secondnum = secondnum/gcd;
    	    		seconddenom = seconddenom/gcd;
    	    	}
    	    	if (finalwhole != 0) {
    	        	//If the final whole number is not 0, return the mixed number
    	        		return(secondwhole + "_" + secondnum + "/" + seconddenom);
    	        }
    	    	else {
    	    		return( secondnum + "/" + seconddenom);
    	    	}
    		}
    		else if (operator.equals("-")) {
    			//If operator is subtraction, return the negative form of other string
    			int gcd = greatestCommonDivisor(secondnum, seconddenom);
    	    	System.out.println(gcd);
    		
    	    	if (gcd != 1) {
    	    		secondnum = secondnum/gcd;
    	    		seconddenom = seconddenom/gcd;
    	    	}
    	    	if (finalwhole != 0) {
    	        	//If the final whole number is not 0, return the mixed number
    	        		return(secondwhole + "_" + secondnum + "/" + seconddenom);
    	        }
    	    	else {
    	    		return( secondnum + "/" + seconddenom);
    	    	}
    		
    		}
    		else {
    		//If operator is multiplication or division, return the firststring, 0.
    			return firststring;
    		}
    	}
    	else {
    		
    		if (operator.equals("+") || operator.equals("-")) {
    			return firststring;
    		}
    		else if (operator.equals("*")){
    			return secondstring;
    		}
    		else {
    			return "DNE";
    		}
    	}
    	
    }
    public static String bothWhole(String firststring, String secondstring, String operator) {
    	if (operator.equals("+")) {
    		int finalnumber = Integer.parseInt(firststring) + Integer.parseInt(secondstring);
    		return Integer.toString(finalnumber);
    	}
    	else if (operator.equals("-")) {
    		int finalnumber = Integer.parseInt(firststring) - Integer.parseInt(secondstring);
    		return Integer.toString(finalnumber);
    	}
    	else if (operator.equals("*")) {
    		int finalnumber = Integer.parseInt(firststring) * Integer.parseInt(secondstring);
    		return Integer.toString(finalnumber);
    	}
    	else {
    		int finalnumber = Integer.parseInt(firststring) / Integer.parseInt(secondstring);
    		return Integer.toString(finalnumber);
    	}
    }
    public static String fractions(String firstwhole, String firstnumerator, String firstdenominator,
    		String secondwhole, String secondnumerator, String seconddenominator, String operator) {
    	
    	int firstwholenum = 0;
    	int firstnum = 0;
    	int firstdenom = 0;
    	int secondwholenum = 0;
    	int secondnum = 0;
    	int seconddenom = 0;
    	int finalnum = 0;
		int finalwhole = 0;
		int lcm = 0;
		int finaldenom = 0;
    	System.out.println("inside fractions firstnumerator "+firstnumerator);
    	System.out.println("inside fractions secondnumerator "+secondnumerator);
    	System.out.println("inside fractions seconddenominator "+seconddenominator);
    	if (!firstnumerator.equals(" ")) {
    	 firstnum = Integer.parseInt(firstnumerator);
     	System.out.println("inside fractions firstumerator "+firstnum);
    	}
    	if (!firstdenominator.equals(" ")) {
    	 firstdenom = Integer.parseInt(firstdenominator);
    	}
    	if (!firstwhole.equals(" ")) {
    	 firstwholenum = Integer.parseInt(firstwhole);
    	}
    	if (!secondnumerator.equals(" ")) {
    	 secondnum = Integer.parseInt(secondnumerator);
    	 System.out.println("inside fractions secondnumerator " + secondnum);
    	}
    	if (!seconddenominator.equals(" ")) {
    	 seconddenom = Integer.parseInt(seconddenominator);
    	 System.out.println("inside fractions denom " + seconddenom);
    	}
    	if (!secondwhole.equals(" ")) {
    	 secondwholenum = Integer.parseInt(secondwhole);
    	 System.out.println("inside fractions whole " + secondwholenum);
    	}
    	System.out.println(firstwhole + "," + secondwhole);
    	// make mixed fraction into improper fraction
    	if (!firstwhole.equals(" ")) {
    		if (firstwholenum < 0) {
    			firstwholenum *= -1;
    		}
    		firstnum = firstwholenum*firstdenom+firstnum;
    		if (firstnumerator.equals(" ")) {
    			firstnum = firstwholenum;
    			firstdenom = 1;
    			System.out.println("whole "+ firstnum+firstdenom);
    		}
    		//return (firstwhole + "_" + firstnum + "/" + firstdenom);
    	}
    	
    	if (!secondwhole.equals(" ")) {
    		if (secondwholenum < 0) {
    			secondwholenum *= -1;
    		}
    		secondnum = secondwholenum*seconddenom+secondnum;
    		if (secondnumerator.equals(" ")) {
    			secondnum = secondwholenum;
    			seconddenom = 1;
    			System.out.println("whole "+ secondnum+seconddenom);
    		}
    		//return (secondwhole + "_" + secondnum + "/" + seconddenom);
    	}
    	
    	// if operator is + or - find lcm
    	
    	if (operator.equals("+") || operator.equals("-")) {
    		lcm = leastCommonMultiple(firstdenom, seconddenom);
    		finaldenom = lcm;
    		if (operator.equals("+")) {
    			finalnum = firstnum * (lcm/firstdenom) + secondnum * (lcm/seconddenom); 
    		}
    		else {
    			System.out.println("secondnumerator:" + secondnum);
    			finalnum = firstnum * (lcm/firstdenom) - secondnum * (lcm/seconddenom); 
    			System.out.println("finalnumerator" + finalnum);
    		}
    	}
    	else if (operator.equals("*")) {
    		//If operator is multiplication, simply multiply the numerators to get final numerator and same with final denominator
    		finalnum = firstnum * secondnum;
    		finaldenom = firstdenom * seconddenom;
    	}
    	else {
    		//If operator is division, multiply the first numerator by the second denominator to get the final numerator.
    		//To get the final denominator, multiply the first denominator by the secondnumerator
    		finalnum = firstnum * seconddenom;
    		finaldenom = firstdenom * secondnum;
    	}
    		
    	System.out.println("finalnum:"+finalnum + "/" + finaldenom);
    	//If final number is improper fraction, make it into mixed number
    	if (finalnum/finaldenom > 1) {
    		finalwhole = finalnum/finaldenom;
    		finalnum = finalnum - finalwhole * finaldenom;
    		System.out.println(finalwhole + "_" + finalnum + "/" + finaldenom);
    	}
    	
    	//else 
    	//Otherwise, simply return the final numerator over the final denominator
    	//{
    		
    	//}
    	
    	int gcd = greatestCommonDivisor(finalnum, finaldenom);
    	System.out.println(gcd);
    	if (gcd != 1) {
    		finalnum = finalnum/gcd;
    		finaldenom = finaldenom/gcd;
    	}
    	if (finalwhole != 0) {
        	//If the final whole number is not 0, return the mixed number
        		return(finalwhole + "_" + finalnum + "/" + finaldenom);
        }
    	else {
    		return( finalnum + "/" + finaldenom);
    	}
    	//return(" ");
    	/*if (firststring.contains("/")) {
    		firstnumerator = firststring.substring(firststring.indexOf(" ")+1, firststring.indexOf("/"));
        	firstdenominator = firststring.substring(firststring.lastIndexOf("/")+1);
    		if (secondstring.contains("/")) {
    		}
    	}
    	else {
    		secondnumerator = secondstring.substring(secondstring.indexOf(" ")+1, secondstring.indexOf("/"));
        	seconddenominator = secondstring.substring(secondstring.lastIndexOf("/")+1);
    	}
    	String finalfirstnumber = (firstnumerator + "/" + firstdenominator);
    	String finalsecondnumber = (secondnumerator + "/" + seconddenominator);
    	System.out.println(finalfirstnumber);
    	*/
    	//return (" ");
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
    	String finalanswer = " ";
    	firststring = firstOperand(userinput);
    	firstwhole = whole(firststring);
    	firstnumerator = numerator(firststring);
    	System.out.println(firstnumerator + "++");
    	firstdenominator = denominator(firststring);
    	secondstring = secondOperand(userinput);
    	secondwhole = whole(secondstring);
    	secondnumerator = numerator(secondstring);
    	seconddenominator = denominator(secondstring);
    	String operator = operator(userinput);
    	
    	if (firststring.equals("0") && secondstring.equals("0")) {
    		//If both operands equal zero, return 0
    		return "0";
    	}
    	else if (firststring.equals("0") || secondstring.equals("0")) {
    		//If one of the operands equals zero, call the oneZero method and return the result
    		String onezero = oneZero(firststring, secondstring, operator,firstwhole,  firstnumerator,  firstdenominator,
    	    		 secondwhole,  secondnumerator,  seconddenominator);
    		return onezero;
    	}
    	
    	else if (!firststring.contains("/") && !secondstring.contains("/")) {
    		//If neither operand contains a dividing sign, call bothWhole method and return result
    		String finalwhole = bothWhole(firstwhole, secondwhole, operator);
    		return finalwhole;
    	}
    	else {
    		//Lastly, if either operands contains a fraction, call the fractions method and store result in finalanswer
    		finalanswer = fractions(firstwhole,  firstnumerator,  firstdenominator,
    		 secondwhole,  secondnumerator,  seconddenominator,  operator);
    	}
    	
    	return(finalanswer);

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
