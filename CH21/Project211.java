import java.io.*;
import java.util.*;

/**
 * Project 21.1
 * 
 * Write a program that reads in the lists of "girl" names and "boy" names from the attached files.
 * Store these lists in two separate sets. You may choose what type of set to use in your program.
 * Find their union, difference, and intersection. You may find it helpful to copy the sets to
 * preserve the original sets from being changed when you complete these tasks.
 * Print out your results, including the count of names for each new set. 
 * 
 * @author Reno Redaja
 */
public class Project211 {

    /**
     * Main method.
     * 
     * This program reads in two .txt files & stores them into a TreeSet (automatically sorted).
     * It will print the total amount of names in the Boys.txt & Girls.txt files.
     * Afterwards, it will print their Union, Difference, & Intersection along with the amount
     * of names in the newly allocated TreeSets.
     * 
     * @param args
     */
    public static void main(String[] args) {

        try {
            File boyFile = new File("Boys.txt"); //Read from original file, Boys.txt
            File girlFile = new File("Girls.txt"); //Read from original file, Girls.txt

            Scanner readBoyFile = new Scanner(boyFile); //Read Boy.txt file using Scanner

            //Two TreeSets: Boy TreeSet & Girl TreeSet
            TreeSet<String> boyTreeSet = new TreeSet<>(); //Allocate memory for first tree
            TreeSet<String> girlTreeSet = new TreeSet<>(); //Allocate memory for second tree

            while (readBoyFile.hasNextLine()) { //start outter while loop
                String boydata = readBoyFile.nextLine(); //Read line in Boy.txt
                boyTreeSet.add(boydata); //add each line of data to TreeSet

                Scanner readGirlFile = new Scanner(girlFile); //Read Girl.txt file using Scanner

                while (readGirlFile.hasNextLine()) { //start inner while loop
                    String girldata = readGirlFile.nextLine(); //Read line in Girl.txt

                    girlTreeSet.add(girldata); //add each line of data to TreeSet
                } //end inner while loop

                readGirlFile.close(); //finish reading, close girl file reader
            } //end outter while
            
            readBoyFile.close(); //finish reading, close boy file reader

            System.out.println("Boys: " + boyTreeSet.size() + "\n" + boyTreeSet); //Print the count of boys names along with TreeSet
            System.out.println("\nGirls: " + girlTreeSet.size() + "\n" + girlTreeSet); //Print the count of girls names along with TreeSet
            
            TreeSet<String> unionSet = new TreeSet<String>(boyTreeSet); //clone -> Boy Tree Set: UNION
            unionSet.addAll(girlTreeSet);
            System.out.println("\nUnion: " + unionSet.size() +  "\n" + unionSet);

            TreeSet<String> differenceSet = new TreeSet<>(boyTreeSet); //clone -> Boy Tree Set: DIFFERENCE
            differenceSet.removeAll(girlTreeSet);
            System.out.println("\nDifference: " + differenceSet.size() + "\n" + differenceSet);

            TreeSet<String> intersectionSet = new TreeSet<>(boyTreeSet); //clone -> Boy Tree Set: INTERSECTION
            intersectionSet.retainAll(girlTreeSet);
            System.out.println("\nIntersection: " + intersectionSet.size() + "\n" + intersectionSet);

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } //end try catch block

    } //end main

} //end Project211