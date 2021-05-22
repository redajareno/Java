import java.util.Scanner;

/**
 * Project 18.1
 * 
 * Write a program that recursively sums all the digits in a given integer. 
 * Create a method based on the following method header:
 *
 * public static int sumDigits(long num)
 *
 * This method should recursively add up all the digits that make up the long num. 
 * The main() method should prompt the user to enter a number, then call the sumDigits() method 
 * to add up the digits in the number. The result should then be displayed to the user.
 * 
 * @author Reno Redaja
 */
public class Project181 {

    /**
     * Main method.
     * 
     * Runs sumDigits() method.
     * 
     * @param args None
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); //Create a Scanner

        System.out.print("Enter an integer: "); 
        long num = in.nextLong(); //User enters an integer

        System.out.println("The sum of digits in " + num + " is " + sumDigits(num)); //Display sum of integers
        in.close(); //Resource leak, close Scanner
    } //end main method

    /**
     * Method sums the digits in an integer using Helper Recursion method.
     * 
     * @param num Number
     * @return sum of digits in an integer
     */
    public static int sumDigits(long num) {
        return sumDigits(num, 0);
    } //end sumDigit method

    /**
     * Helped overloaded method.
     * 
     * @param num Number
     * @param sum sum of digits
     * @return sum of digits in an integer
     */
    public static int sumDigits(long num, int sum) {
        if (num == 0) { //Base case
            return sum;
        } else { //Recursive call
            return sumDigits(num / 10, sum + (int)(num % 10));
        }
    } //end sumDigit method

} //end Project 181