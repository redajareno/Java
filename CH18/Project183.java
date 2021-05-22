import java.util.Scanner;

/**
 * Project 18.3
 * 
 * Write a program that recursively prints out characters in a triangle shape, such as:
 *
 * *****
 * ****
 * ***
 * **
 * * 
 *
 * The main() method should prompt the user to enter a number of lines to print, and the character(s) to print.
 * Then it should call your method to print out the triangle. For this project, you will determine what 
 * your method should return, if anything, and what parameters your method will need.
 * 
 * @author Reno Redaja
 */
public class Project183 {

    /**
     * Main method.
     * 
     * Runs printTriangle() method.
     * 
     * @param args None
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); //Create a Scanner

        System.out.print("Enter number of lines to print: "); 
        int numOfLines = in.nextInt(); //User enters number of lines

        System.out.print("Enter the character(s) to print: ");
        in.nextLine(); //Skips integer and reads next line
        String userCharacters = in.nextLine(); //User enters character(s) to print
        
        printTriangle(numOfLines, numOfLines, userCharacters);

        in.close(); //Resource leak, close Scanner
    } //end main method

    /**
     * Print Triangle method.
     * 
     * Obtains the number and Strings then prints it out into a triangle by user input.
     * 
     * @param num1 Number
     * @param num2 Number
     * @param in String of characters for user input
     */
    public static void printTriangle(int num1, int num2, String input) {
        if (num1 > 0) { //Base case
            System.out.print(input);
            if (num2 > 1) {
                printTriangle(num1, num2 - 1, input); //Recursive call
            } else {
                System.out.println();
                printTriangle(num1 - 1, num1 - 1, input); //Recursive call
            }
        }
    } //end printTriangle method

} //end Project 183