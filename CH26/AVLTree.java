import java.util.*;

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
 * @author Reno Redaja
 *
 */
public class AVLTree<E> extends BST<E> {

    /**
     * Create an empty AVL Tree using natural comparator.
     */
    public AVLTree() {
    } //end AVLTree constructor

    /**
     * Create a BST with a specified comparator.
     * 
     * @param c The comparator
     */
    public AVLTree(Comparator<E> c) {
        super(c);
    } //end AVLTree constructor

    /**
     * Create an AVL Tree from an array of objects.
     * 
     * @param objects Array of objects
     */
    public AVLTree(E[] objects) {
        super(objects);
    } //end AVLTree constructor

    /**
     * Override createNewNode to create AVL Tree node.
     */
    protected AVLTreeNode<E> createNewNode(E e) {
        return new AVLTreeNode<E>(e);
    } //end AVLTreeNode method

    /**
     * Insert an element and rebalance if necessary.
     * 
     * Inserting an element into an AVL Tree is same as 
     * inserting to a BST, except the tree may need to 
     * be rebalanced.
     */
    public boolean insert(E e) {
        boolean successful = super.insert(e); //Call insert method from BST.java file

        if(!successful) {
            return false; //If element is in the tree already
        } else {
            balancePath(e); //Balance from node element e to the root if necessary
        } 

        return true; //element e is inserted 
    } //end insert method

    /**
     * update height method
     * returns the updated height from the specific node
     * 
     * if node is a leaf return 0
     * if node has no left subtree, return 1 (from right subtree)
     * if node has no right subtree, return 1 (from left subtree)
     * if node has left AND right subtree, return height from left AND right
     * 
     * @param node The node
     */
    private void updateHeight(AVLTreeNode<E> node) {
        if (node.left == null && node.right == null) { //if node is a leaf
            node.height = 0; //return 0
        } else if (node.left == null) { //has no left subtree, but has right subtree
            //return height of right subtree
            node.height = 1 + ((AVLTreeNode<E>)(node.right)).height; 
        } else if (node.right == null) { //has no right subtree, but has left subtree
            //return height of left subtree
            node.height = 1 + ((AVLTreeNode<E>)(node.left)).height; 
        } else { //Contains a left AND right subtree
            //return height from left AND right subtree
            node.height = 1 + Math.max(((AVLTreeNode<E>)(node.right)).height, ((AVLTreeNode<E>)(node.left)).height);
        } //end if-else statements
    } //end updateHeight method

    /**
     * balance path method
     * balances the nodes in the path from specific node, if necessary
     * If balance factor at node A is -2, perform LL rotation or LR rotation
     * If balance factor at node A is +2, perform RR rotation or RL rotation
     * 
     * @param e Generic object
     */
    private void balancePath(E e) {
        ArrayList<TreeNode<E>> path = path(e);
        
        //Search the whole tree
        for (int i = path.size() - 1; i >= 0; i--) {
            AVLTreeNode<E> A = (AVLTreeNode<E>)(path.get(i));
            updateHeight(A);
            AVLTreeNode<E> parentOfA = (A == root) ? null : (AVLTreeNode<E>)(path.get(i - 1));

            //Check balance factor at node A
            switch (balanceFactor(A)) {
                case -2: //Balance factor at node A is -2
                    if (balanceFactor((AVLTreeNode<E>)A.left) <= 0) {
                        balanceLL(A, parentOfA); //Perform LL rotation
                    } else {
                        balanceLR(A, parentOfA); //Perform LR rotation
                    }
                    break;
                case +2: //Balance factor at node A is +2
                    if (balanceFactor((AVLTreeNode<E>)A.right) >= 0) {
                        balanceRR(A, parentOfA); //Perform LL rotation
                    } else {
                        balanceRL(A, parentOfA); //Perform LR rotation
                    }
                    break;
            }//end switch statement
        } //end for loop
    } //end balancePath method

    /**
     * Balance factor method
     * 
     * Check the balance factor of the node.
     * Check the node if it has a right subtree or left subtree.
     * Will return the balance factor.
     * 
     * @param node The node
     * @return The balance factor
     */
    private int balanceFactor(AVLTreeNode<E> node) {
        if (node.right == null) { //has no right subtree
            return -node.height;
        } else if (node.left == null) { //has no left subtree
            return +node.height;
        } else {
            //Balance Factor = Height of right tree - Height of left tree
            return ((AVLTreeNode<E>)node.right).height - ((AVLTreeNode<E>)node.left).height;
        }//end if-else statements
    } //end balanceFactor method

    /**
     * LL balance 
     * Imbalance occurs at a node A
     * Left heavy at node A & node B
     * Perform a single right rotation at node A to fix imbalance
     * 
     * @param A Node A
     */
    private void balanceLL(TreeNode<E> A, TreeNode<E> parentOfA) {
        //node A & node B is left heavy
        TreeNode<E> B = A.left; 

        //Check if root equal to node A, set node B as the root
        if (A == root) {
            root = B;
        } else {
            if (parentOfA.left == A) {
                parentOfA.left = B;
            } else {
                parentOfA.right = B;
            }
        }
        
        //Perform rotation
        A.left = B.right; //Set node B's right subtree to node A's left subtree
        B.right = A; //Set node A to node B's right subtree

        //Update height's for node A & node B
        updateHeight((AVLTreeNode<E>)A);
        updateHeight((AVLTreeNode<E>)B);
    } //end balanceLL method

    /**
     * LR balance
     * Imbalance occurs at a node A
     * Left heavy at node A
     * Right heavy at node B
     * Perform a double rotation:
     * 1) single left rotation at node B
     * 2) single right rotation at node A
     * 
     * @param A Node A
     */
    private void balanceLR(TreeNode<E> A, TreeNode<E> parentOfA) {
        TreeNode<E> B = A.left; //node A is left heavy
        TreeNode<E> C = B.right; //node B is right heavy

        //Check if root equal to node A, set node C as the root
        if (A == root) {
            root = C;
        } else {
            if (parentOfA.left == A) {
                parentOfA.left = C;
            } else {
                parentOfA.right = C;
            }
        }

        //Perform rotations
        A.left = C.right; //Set node C's right subtree to node A's left subtree
        B.right = C.left; //Set node C's left subtree to node B's right subtree
        C.left = B; //Set node B to node C's left subtree
        C.right = A; //Set node A to node C's right subtree

        //Update height's for node A, node B, & node C
        updateHeight((AVLTreeNode<E>)A);
        updateHeight((AVLTreeNode<E>)B);
        updateHeight((AVLTreeNode<E>)C);
    } //end balanceLR method

    /**
     * RR balance 
     * Imbalance occurs at a node A
     * Right heavy on node A & node B
     * Perform a single left rotation at Node A to fix imbalance
     * 
     * @param A Node A
     */
    private void balanceRR(TreeNode<E> A, TreeNode<E> parentOfA) {
        //node A & node B is right heavy
        TreeNode<E> B = A.right;

        //Check if root equal to node A, set node B as the root
        if (A == root) {
            root = B;
        } else {
            if (parentOfA.left == A) {
                parentOfA.left = B;
            } else {
                parentOfA.right = B;
            }
        }

        //Perform rotation
        A.right = B.left; //Set node B's left subtree to node A's right subtree
        B.left = A; //Set node A to node B's left subtree

        //Update height's for node A & node B
        updateHeight((AVLTreeNode<E>)A);
        updateHeight((AVLTreeNode<E>)B);
    } //end balaneRR method
    
    /**
     * RL balance
     * Imbalance occurs at a node A
     * Right heavy at node A
     * Left heavy at node B
     * Perform a double rotation:
     * 1) single right rotation at node B
     * 2) single left rotation at node A
     * 
     * @param A Node A
     */
    private void balanceRL(TreeNode<E> A, TreeNode<E> parentOfA) {
        TreeNode<E> B = A.right; //node A is right heavy
        TreeNode<E> C = B.left; //node B is left heavy

        //Check if root equal to node A, set node C as the root
        if (A == root) {
            root = C;
        } else {
            if (parentOfA.left == A) {
                parentOfA.left = C;
            } else {
                parentOfA.right = C;
            }
        }

        //Perform rotations
        A.right = C.left; //Set node C's left subtree to node A's right subtree
        B.left = C.right; //Set node C's right subtree to node B's left subtree
        C.left = A; //Set node A to node C's left subtree
        C.right = B; //Set node B to node C's right subtree

        //Update height's for node A, node B, & node C
        updateHeight((AVLTreeNode<E>)A);
        updateHeight((AVLTreeNode<E>)B);
        updateHeight((AVLTreeNode<E>)C);
    } //end balanceRL method

    /**
     * Delete method.
     * 
     * Delete an element from the AVL Tree.
     * It is the same as deleting from a BST, but the
     * tree may need to be rebelanced.
     */
    public boolean delete(E element) {
        //If element is not in the tree, return false
        if (root == null) {
            return false;
        }

        //Locate the node to be delete & also its parent node
        TreeNode<E> parent = null;
        TreeNode<E> current = root;
        
        while (current != null) {
            if (c.compare(element, current.element) < 0) {
                parent = current;
                current = current.left;
            } else if (c.compare(element, current.element) > 0) {
                parent = current;
                current = current.right;
            } else {
                break; //Element is in tree pointed by current
            } //end if-else statements
        } //end while loop

        //If element is not in the tree, return false
        if (root == null) {
            return false;
        }

        //Case 1: Current has no left children
        if (current.left == null) {
            //Connect parent with right child of the current node
            if (parent == null) {
                root = current.right;
            } else {
                if (c.compare(element, parent.element) < 0) {
                    parent.left = current.right;
                } else {
                    parent.right = current.right;
                }
                //Balance tree if necessary
                balancePath(parent.element);
            } //end inner if-else statement
        } else { 
            //Case 2: Current node has left child
            //Locate rightmost node in left subtree of
            //current node and also its parent
            TreeNode<E> parentOfRightMost = current;
            TreeNode<E> rightMost = current.left;

            while (rightMost.right != null) {
                parentOfRightMost = rightMost;
                rightMost = rightMost.right; //Keep searching right
            }

            //Replace element in current by element in right most
            current.element = rightMost.element;

            //Eliminate rightmost node
            if (parentOfRightMost.right == rightMost) {
                parentOfRightMost.right = rightMost.left;
            } else {
                //Special Case: parent of right most is current
                parentOfRightMost.left = rightMost.left; 
            }
            //Balance tree if necessary
            balancePath(parentOfRightMost.element);
        } //end outer if-else statment
        
        size--;
        return true; //Element inserted
    } //end delete method

    /**
     * AVLTreeNode is TreeNode plus height.
     */
    protected static class AVLTreeNode<E> extends BST.TreeNode<E> {
        protected int height = 0; //New data field

        public AVLTreeNode(E o) {
            super(o);
        }
    } //end inner class - AVLTreeNode extending BST TreeNode

} //end AVLTree class