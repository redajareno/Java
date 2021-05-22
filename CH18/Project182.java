import java.util.Scanner;

/**
 * Project 18.2
 * 
 * Write a program that recursively counts the number of letters in a given word/phrase.
 * Create a method based on the following method header:
 *
 * public static int count(String s, char c)
 * 
 * This method should recursively count the number of times the character c occurs in the string s.
 * The main() method should prompt the user to enter a word/phrase and a character, then call 
 * the count() method to count the occurrences of the character in the string. 
 * The count() method should not be case sensitive. The result should then be displayed to the user.
 * 
 * @author Reno Redaja
 */
public class Project182 {

    /**
     * Main method.
     * 
     * Runs count() method.
     * 
     * @param args None
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); //Create a Scanner

        System.out.print("Enter a word or phrase: "); 
        String userWord = in.next(); //User enters a word or phrase

        System.out.print("Enter a letter to count: ");
        char userLetter = in.next().charAt(0);  //User enters a letter

		// Display the number of times the character occurs in the string
		System.out.println("There are " + count(userWord, userLetter) + " " + userLetter + "'s" + " in " + userWord + ".");

        in.close(); //Resource leak, close Scanner
    } //end main method

    /**
     * Count method using recurison.
     * 
     * If the string s is empty, return 0.
     * Otherwise if the character of s is equal to c, return 1 plus the 
     * number of times it appears. (convert to lowercase since not case sensitive)
     * Otherwise if the character of s is different from c, return the number of times it appears.
     * 
     * @param s String
     * @param c Character
     * @return Count of times a character occurs in the string
     */
    public static int count(String s, char c) {
        if (s.length() == 0) { //Base case
           return 0; 
        } else if (Character.toLowerCase(s.charAt(0) ) == Character.toLowerCase(c)) { //Convert to lower case if same character (not case sensitive)
           return 1 + count(s.substring(1), c); //Recursive call
        } else {
           return count(s.substring(1), c); //Recursive call
        }
    } //end count method

} //end Project 182