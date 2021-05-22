import java.util.*;

/**
 * Project 22.1
 * 
 * Write a program that prompts the user to enter a string and displays the maximum 
 * increasingly ordered subsequence of characters. Here are a few example runs:
 *
 * Enter a string: hello world
 * Maximum increasingly ordered subsequence is elow
 *
 * Enter a string: windward
 * Maximum increasingly ordered subsequence is inw
 * 
 * The time complexity of my program is O(n^2). The worst case time complexity
 * would be O(n * m). It would happen where there would be no subsequence present in m & n.
 * 
 * @author Reno Redaja
 */
public class Project221 {

    /**
     * Main method.
     * 
     * @param args No arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //Create scanner
        System.out.print("Enter a string: "); //Print "Enter a string: "
        String userInput = sc.nextLine(); //Get user input
        sc.close();

        System.out.println("Maximum increasingly ordered subsequence is: ");
        maxChar(userInput); //Find maximum increasingly ordered subsequence of characters   
    } //end main method    

    /**
     * maxChar method.
     * 
     * Use a ArrayList to store the String and store them into characters.
     * It will iterate throught the user input String and will store into the list.
     * Allocate the memory and if the decimal number of the character is bigger,
     * arrange in ascending order.
     * 
     * @param s The user's string input
     */
    public static void maxChar(String s) {
        ArrayList<Character> charList = new ArrayList<>(); //Create ArrayList containing Characters
        int size = s.length(); //Store string length in variable size

        //Find the maximum increasingly ordered subsequence
        for (int i = 0; i < size; i++) { //Iterate through the String storing into an ArrayList of characters
            ArrayList<Character> list = new ArrayList<>(); //Create another ArrayList containing Characters
            list.add(s.charAt(i)); //Add characters to list
            for (int j = i + 1; j < size; j++) { //Iterate through the String storing into an ArrayList of characters
                if (s.charAt(j) > list.get(list.size() - 1)) { 
                    list.add(s.charAt(j)); //Add characters to list
                }
            }

            //Allocate lists
            if (list.size() >= charList.size()) {
                charList.clear();
                charList.addAll(list);
            }
            //list.clear();
        }

        //Display the ordered subsequence of characters
        for (Character c: charList) {
            System.out.println(c);
        }

    } //end maxChar method

} //end Project221 class