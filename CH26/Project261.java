/**
 * Project 26.1
 * 
 * Start with the BST class you created for project 25.1 (the BST including a method to calculate the height of the tree).
 * Edit this class to implement the following method:
 * 
 * // Returns true if the tree is an AVL tree
 * public boolean isAVLTree()
 * 
 * Create a Test/Demo class that tests/demonstrates your implementation, using at least 6 elements. 
 * Show one instance where the tree is balanced, and is therefore an AVL tree, and another instance where the tree is 
 * not balanced, and is therefore not an AVL tree. Draw out your trees to show that your program is properly
 * determining whether or not the tree is an AVL tree. You can draw it using a drawing tool on your computer
 * and take a screenshot, create it in Word, or draw on a piece of paper and take a picture of it. 
 * As long as the picture of your tree is submitted as a Word doc, pdf, or image file, it will be accepted.
 * 
 * @author Reno Redaja
 * 
 */
public class Project261 {

    /**
     * Main method.
     * 
     * @param args
     */
    public static void main(String[] args) {
        BST<Integer> tree1 = new BST<>();
        BST<Integer> tree2 = new BST<>();
        
        //Insert elements of type Integer into tree1
        tree1.insert(3);
        tree1.insert(1);
        tree1.insert(4);
        tree1.insert(6);
        tree1.insert(0);
        tree1.insert(2);

        //Insert elements of type Integer into tree2
        tree2.insert(6);
        tree2.insert(4);
        tree2.insert(3);
        tree2.insert(2);
        tree2.insert(0);
        tree2.insert(1);

        System.out.println("(Tree #1) \nInsert: 3, 1, 4, 6, 0, 2");
        System.out.println("Is AVL Tree? " + tree1.isAVLTree()); //Test isAVLTree method in BST.java
        System.out.println("\n(Tree #2) \nInsert: 6, 4, 3, 2, 0, 1");
        System.out.println("Is AVL Tree? " + tree2.isAVLTree()); //Test isAVLTree method in BST.java

    } //end main method

} //end Project261 class