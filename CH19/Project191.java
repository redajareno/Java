import java.util.ArrayList;

/**
 * Project 19.1
 * 
 * Write a program that returns the largest item in an Array List. Create a
 * method based on the following method header:
 *
 * public static <E extends Comparable<E>> E max(ArrayList<E> list)
 * 
 * In your main() method, test your max() method by creating two different types
 * of ArrayLists (for example, one that stores Strings and one that stores
 * Integers).
 * 
 * @author Reno Redaja
 */
public class Project191 {

    /**
     * Main method.
     * 
     * Runs max() method.
     * 
     * @param args None
     */
    public static void main(String[] args) {
        //CODE
        ArrayList<String> heroesList = new ArrayList<String>();
        heroesList.add("Superman");
        heroesList.add("Batman");
        heroesList.add("Spiderman");
        System.out.println(heroesList);

        ArrayList<Integer> numList = new ArrayList<Integer>();
        numList.add(20);
        numList.add(69);
        numList.add(-1);
        System.out.println(numList);

        //max(heroes);

        System.out.println(max(heroesList));
        System.out.println(max(numList));

    } //end main method

    /**
     * max() method.
     * 
     * The max method compares the values in the Generic ArrayList 
     * of type E and returns the max number.
     * 
     * @param <E> Generic type E
     * @param list Generic ArrayList type E assigned to list
     * @return Max number
     */
    public static <E extends Comparable<E>> E max(ArrayList<E> list) {
        E max = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            if (max.compareTo(list.get(i)) < 0) {
                max = list.get(i);
            }
        }
        
        return max;
    } //end max() method

} //end Project191 class