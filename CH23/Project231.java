/**
 * Project 23.1
 * 
 * Write a program that implements the following generic method using the bubble sort:
 *
 * public static <E extends Comparable<E>> void bubbleSort(E[] list)
 * 
 * Section 23.3 Bubble Sort gives you the algorithm and a sample implementation using an array of ints. 
 * For this project, you will use the Comparable interface to sort a generic list.
 *
 * In your main method, include at least two calls to your bubbleSort() method using two different types of 
 * objects (for example integers and strings).
 * 
 * @author Reno Redaja
 */
public class Project231 {

    /**
     * Main method.
     * 
     * @param args
     */
    public static void main(String[] args) {
		Integer[] nums = {13, 9, 7, 2, -5, 3, 3, 10}; //Create an Integer array
		String[] names = {"Mountbatten", "Windsor", "Wales", "Reno"}; //Create a String array

		//Sort the arrays
		bubbleSort(nums);
		bubbleSort(names);

        //Print the arrays
        toString(nums);
		toString(names);
        
    } //end main method

    /**
     * Bubble Sort method using comparable.
     * 
     * @param <E> Generic Object
     * @param list The list
     */
    public static <E extends Comparable<E>> void bubbleSort(E[] list) {
        boolean needNextPass = true; 

        for (int k = 1; k < list.length && needNextPass; k++) {
            //Array may be sorted & next pass not needed
            needNextPass = false;
            for (int i = 0; i < list.length - k; i++) {
                if (list[i].compareTo(list[i + 1]) > 0) {
                    //Swap 
                    E temp = list[i]; 
                    list[i] = list[i + 1];
                    list[i + 1] = temp;
                    needNextPass = true;
                } //end if statment
            } //end inner for loop
        } //end outer for loop
    } //end bubbleSort method

    /**
     * Print array of objects.
     * 
     * @param list The list
     */
	public static void toString(Object[] list) {
		for (int i = 0; i < list.length; i++)
			System.out.print(list[i] + " ");
		System.out.println();
	} //end toString method

} //end Project231 class