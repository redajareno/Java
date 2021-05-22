/**
 * Project 26.2
 * 
 * Write out the code for an AVL tree. You may follow along with the code given in 
 * LiveExample 26.3 AVLTree.java (in Section 26.7 The AVLTree Class). The goal for
 * this assignment is to think about how these methods create a tree that is more 
 * than just a BST. See if you can write different balancing methods (LL, LR, etc) 
 * just based on the algorithm given in the text. As you are writing your code, 
 * include your own comments that describe in your own words what is happening.
 * 
 * Writing out this code, even if you're more or less copying from the book,
 * will help you understand how this class works. For your own good, please don't 
 * just copy the whole class, paste it into a Java file, and submit it. 
 * You won't learn anything by doing that.
 * 
 * Create a Test/Demo class that tests/demonstrates your AVLTree class. 
 * This can be similar to the TestAVLTree.java class in LiveEample 26.4 
 * TestAVLTree.java, or you can write your own. Just be sure that it tests 
 * out the methods in your AVLTree class.
 * 
 * -----------------------------------------------------------------------------
 * 
 * Within my Project262 I am demonstrating the AVL Tree. We start by populating the
 * AVL Tree with an element of type integer. While inserting I have also
 * demonstrated elements are also being deleted. It prints the elements within
 * the tree and its three types of traversals: inorder, postorder & preorder.
 * 
 * In the AVLTree.java file, I have commented showing how to implement
 * the AVL Tree class utilizing the BST class.
 * 
 * 
 * @author Reno Redaja
 *
 */
public class Project262 {
	
    public static void main(String[] args) {
    	// Create an AVL tree
    	AVLTree<Integer> tree = new AVLTree<>(new Integer[]{24, 8, 20, 10, 7, 17});
    	System.out.print("After inserting 24, 8, 20, 10, 7, 17:");
    	printTree(tree);
  
    	tree.insert(9);
    	tree.insert(12);
    	System.out.print("\nAfter inserting 9, 12:");
    	printTree(tree);
  
    	tree.insert(71);
    	System.out.print("\nAfter inserting 71");
    	printTree(tree);
  
    	tree.insert(10);
    	System.out.print("\nAfter inserting 10");
    	printTree(tree);
  
    	tree.delete(24);
    	tree.delete(17);
    	tree.delete(8);
    	System.out.print("\nAfter removing 24, 17, 8:");
    	printTree(tree);
  
    	tree.delete(9); 
    	System.out.print("\nAfter removing 9:");
    	printTree(tree);
      

    	System.out.print("\nElements in the tree: ");
    	for (int e: tree) {
    		System.out.print(e + " ");
    	}
    } //end main method

    public static void printTree(BST<Integer> tree) {
        // Traverse tree
        System.out.print("\nInorder (sorted): ");
        tree.inorder();
        System.out.print("\nPostorder: ");
        tree.postorder();
        System.out.print("\nPreorder: ");
        tree.preorder();
        System.out.print("\nThe number of nodes is " + tree.getSize());
        System.out.println();
    } //end print tree method
    
}
