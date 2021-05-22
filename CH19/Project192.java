import java.util.ArrayList;

/**
 * Project 19.2
 * 
 * Create a method that returns a new ArrayList, containing nonduplicate elements from the 
 * original ArrayList. Your method should be based on the following method header:
 * 
 * public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list)
 * 
 * You may add this method into the Java class you created for Project 19.1, and use the 
 * same ArrayLists to test your new method. Just ensure that your original ArrayLists contain 
 * some duplicates.
 * 
 * Below is an example of what your program might print out. I created an ArrayList of String
 * objects, containing Honolulu, Kaneohe, Waimanalo, Kapolei, Kaneohe, Pearl City. 
 * My second ArrayList contained Integer objects 3, 10, 2, 50, 7, 10, 2, 50.
 * 
 * Waimanalo
 * 50
 * [Honolulu, Kaneohe, Waimanalo, Kapolei, Pearl City]
 * [3, 10, 2, 50, 7]
 * 
 * @author Reno Redaja
 */
public class Project192 {

    /**
     * Main method.
     * 
     * Runs removeDuplicates() method.
     * 
     * @param args None
     */
    public static void main(String[] args) {

        ArrayList<String> oahuList = new ArrayList<String>();
        oahuList.add("Waimanalo");
        oahuList.add("Honolulu");
        oahuList.add("Kaneohe");
        oahuList.add("Waimanalo"); //Duplicate String "Waimanalo"
        oahuList.add("Kapolei");
        oahuList.add("Pearl City");
        System.out.println("Before: " + oahuList); //Before removeDuplicates() method
        System.out.println("After: " + removeDuplicates(oahuList) + "\n"); //After removeDuplicates() method

        ArrayList<Integer> numList = new ArrayList<Integer>();
        numList.add(50);
        numList.add(3);
        numList.add(10);
        numList.add(2);
        numList.add(50); //Duplicate int 50
        numList.add(7);
        System.out.println("Before: " + numList); //Before removeDuplicates() method
        System.out.println("After: " + removeDuplicates(numList)); //After removeDuplicates() method

         
    } //end main method

    /**
     * removeDuplicates() method
     * 
     * The remove duplicates method searches throughout the list
     * and if the data is the same, it will remove the duplicate.
     * 
     * @param <E> Generic type E
     * @param list Generic ArrayList type E assigned to list
     * @return List duplicate removed
     */
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        ArrayList<E> genericList = new ArrayList<>(list.size());
        
        for (E newList : list) { //newList within parameter list
            if (!genericList.contains(newList)) { 
                genericList.add(newList);
            }
        }

        return genericList;
    } //end removeDuplicates() method
    
} //end Project192 class