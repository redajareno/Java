import java.util.*;

/**
 * Project 21.2
 * 
 * Write a program that gets a phrase from the user. Print out the position and character found at
 * that position. Use a map to count how many times an 'A', 'E', 'I', 'O', or 'U' appears in 
 * the phrase. You may choose what type of map to use in your program.
 * Your program should print out the character in the original case entered by the user, 
 * but should treat 'a' and 'A' the same when counting them. 
 * 
 * @author Reno Redaja
 */
public class Project212 {
    
    /**
     * Main method.
     * 
     * @param args No argugments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //Create new Scanner, sc

        System.out.print("Enter a phrase: ");
        String phrase = sc.nextLine(); //User enters a phrase

        //print out index & phrase character
        for (int i = 0; i < phrase.length(); i++) {
            System.out.println(i + ": " + phrase.charAt(i));
        }

        countCharacters(phrase);
        sc.close();
    } //end main method

    /**
     * This method specifically prints out the amount of times
     * a vowel has appeared in a string.
     * 
     * Create a Map containing chatacter as a key & 
     * occurences as a value. Search the input String "s"
     * if the same character is present, increment the count by 1.
     * else keep the count at 1. Then print the output.
     * 
     * @param s A String
     */
    public static void countCharacters(String s) {
        //Create HashMap containing char as a key & occurrences as a value
        Map<Character, Integer> map = new HashMap<>();

        //Convert string into char array & lower case
        char[] stringArray = s.toLowerCase().toCharArray();

        //Search the stringArray
        for (Character c : stringArray) {
            if (map.containsKey(c)) {
                //If char is present, increment by 1
                map.put(c, map.get(c) + 1);
            } else {
                //If there is no char, put 1
                map.put(c, 1);
            }
        }

        System.out.println("\nThis phrase contains: ");
        System.out.println(map.get('a') + " 'A's "); //print all A's in map
        System.out.println(map.get('e')  + " 'E's "); //print all E's in map
        System.out.println(map.get('i')  + " 'I's "); //print all I's in map
        System.out.println(map.get('o')  + " 'O's "); //print all O's in map
        System.out.println(map.get('u')  + " 'U's "); //print all U's in map
    } //end countLetters method

} //end Project212 class