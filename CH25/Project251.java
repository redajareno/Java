/*
 * Project 25.1
 * 
 * Start with the BST class, which implements the Tree interface, both attached (code from the textbook). 
 * Define a new class that extends the BST class to implement the following methods:
 * 
 * height()
 * getNumberOfLeaves()
 * getNumberOfNonLeaves()
 * 
 * Create a Test/Demo class that tests/demonstrates your implementation, using at least 10 elements. 
 * Ensure that you test each of the methods you just implemented. Draw out your tree to show that your program is properly 
 * calculating the height, number of leaves, and number of non-leaves for your tree. You can draw it using a drawing tool on 
 * your computer and take a screenshot, create it in Word, or draw on a piece of paper and take a picture of it. As long as 
 * the picture of your tree is submitted as a Word doc, pdf, or image file, it will be accepted.
 * 
 * @author Reno Redaja
 */
public class Project251 {

    /**
     * Main method testing newly implemented methods in BST:
     * height()
     * getNumberOfLeaves()
     * getNumberOfNonLeaves()
     * 
     * @param args No arguments
     */
    public static void main(String[] args) {
        BST<Integer> intBST = new BST<>();

        intBST.insert(8);
        intBST.insert(1);
        intBST.insert(5);
        intBST.insert(20);
        intBST.insert(6);
        intBST.insert(17);
        intBST.insert(9);
        intBST.insert(12);
        intBST.insert(87);

        //Print height of the BST
        System.out.println("Height of the BST: " + intBST.height()); 

        //Print number of leaves
        System.out.println("Number of leaves in BST: " + intBST.getNumberOfLeaves()); 

        //Print number of nonleaves
        System.out.println("Number of non leaves in BST: " + intBST.getNumberOfNonLeaves()); 

    } //end main method

} //end Project251 class