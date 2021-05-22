import java.util.*;

/**
 * Project 22.1
 * 
 * Write an O(n) program that prompts the user to enter a sequence of integers ending with 0,
 * and finds the longest subsequence with the same number. Here are a few example runs:
 *
 * Enter a series of numbers ending with 0:
 * 5 9 2 3 3 3 3 6 1 9 0
 * The longest same number sequence starts at index 3 with 4 values of 3
 *
 * Enter a series of numbers ending with 0:
 * 12 7 2 9 17 2 9 9 8 22 95 0
 * The longest same number sequence starts at index 6 with 2 values of 9
 * 
 * @author Reno Redaja
 */
public class Project222 {

    //Global variables
    public static Scanner sc = new Scanner(System.in); //Create Scanner to read input from user

    /**
     * Main method.
     * 
     * @param args No arguments
     */
    public static void main(String[] args) {
        System.out.println("Enter a series of numbers ending with 0:"); //Print
        int userNum = sc.nextInt(); 

        sameNum(userNum); //Sequence of same number method
    } //end main method

    /**
     * This method finds the longest subsequence with the same number.
     * First we would create an ArrayList to store the user's input of integers.
     * We will then search the ArrayList and at which index the number is the same, 
     * increase the count for every same number. If it is not the same, move index and keep
     * searching.
     * It will print the at which index it starts and counts how many times
     * the value appears.
     * 
     * @param num User number input
     */
    public static void sameNum(int num) {
        ArrayList<Integer> numberList = new ArrayList<>(); //Create ArrayList

        while (num != 0) { //Get user input and store to the ArrayList
            numberList.add(num);
            num = sc.nextInt();
        } //end while loop

        int size = numberList.size();
        int[] array = new int[size]; //create an array with length as numberList's size
        
        //Copy the list of elements from the list to array
        for (int i = 0; i < size; i++) {
            array[i] = numberList.get(i);
        }

        //Find longest series of same elements
        int index = 0;
        int count = 1;
        int times = 1;

        int i = 0;
        int same = array[i];
        int value = same;

        for (i = 1; i < size; i++) {
            if (same == array[i]) {
                count++;
            } else {
                if (count > times) {
                    value = same;
                    times = count;
                    index = i - count;
                }
                same = array[i];
                count = 1;
            }
        }

        //Print series of same number
        System.out.println("The longest same number sequence starts at index " + index + " with "
                            + times + " values of " + value);

    } //end sameNum method

} //end Project222 class