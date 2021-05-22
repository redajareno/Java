import java.util.*;

/**
 * Heap Sort implementation in Java.
 * 
 * Currently set to Min-Heap.
 * I have revised the Heap Sort algorithm in from LiveExample 23.9 to Min-Heap.
 * 
 * @author Reno Redaja
 * @credit https://revel-ise.pearson.com/courses/5ffcb0664674c5001a02d3b9/assignments/4e239e7f-306b-406f-b8bc-f4ea67c11a78/pages/a22ba9efe41bdfe97f64ff039e820bf147cdba4c8?source=scores
 */
public class minHeap<E extends Comparable<E>> {
    ArrayList<E> list = new ArrayList<>();
    Comparator<? super E> c;

    /**
     * Default heap using natural order for comparison.
     */
    public minHeap() {
        this.c = (e1, e2) -> ((Comparable<E>)e1).compareTo(e2);
    } //end Heap method

    /**
     * Create a heap with a specified comparator.
     * 
     * @param c Comparator
     */
    public minHeap(Comparator<E> c) {
        this.c = c;
    } //end Heap method

    /**
     * Create a heap from an array of objects.
     * 
     * @param objects Generic Objects
     */
    public minHeap(E[] objects) {
        this.c = (e1, e2) -> ((Comparable<E>)e1).compareTo(e2);

        for (int i = 0; i < objects.length; i++) {
            add(objects[i]);
        }
    } //end heap method

    /**
     * Add a new object into the heap.
     * 
     * @param newObject Generic Object
     */
    public void add(E newObject) {
        list.add(newObject); //Append to the heap
        int currentIndex = list.size() - 1; //index of last node

        while (currentIndex > 0) {
            int parentIndex = (currentIndex - 1) / 2;
            //Swap if the current object is LESS than its parent (UPDATED)
            //CHANGE TO GREATER THAN ITS PARENT FOR MAX HEAP, > 0 
            //CHANGE TO LESS THAN ITS PARENT FOR MIN HEAP, < 0
            if (list.get(currentIndex).compareTo(list.get(parentIndex)) < 0) { //UPDATED TO <, MIN HEAP
                E temp = list.get(currentIndex);
                list.set(currentIndex, list.get(parentIndex));
                list.set(parentIndex, temp);
            } else {
                break; //the tree is a heap now
            } //end if-else statment
            currentIndex = parentIndex;
        } //end while loop
    } //end add method

    /**
     * Remove the root from the heap.
     * 
     * @return The removed object.
     */
    public E remove() {
        //Edge case
        if (list.size() == 0) {
            return null;
        }

        E removedObject = list.get(0);
        list.set(0, list.get(list.size() - 1));
        list.remove(list.size() - 1);

        int currentIndex = 0;
        while (currentIndex < list.size()) {
            int leftChildIndex = 2 * currentIndex + 1;
            int rightChildIndex = 2 * currentIndex + 2;

            //Find the maximum between two children
            if (leftChildIndex >= list.size()) {
                break; //The tree is a heap
            }

            int maxIndex = leftChildIndex;
            if (rightChildIndex < list.size()) {
                if (c.compare(list.get(maxIndex), list.get(rightChildIndex)) > 0) {
                    maxIndex = rightChildIndex;
                } //end inner if statment
            } //end outter if statement

            //Swap if the current node is GREATER than the maximum (UPDATED)
            //CHANGE TO LESS THAN MAXIMUM FOR MAX HEAP, < 0
            //CHANGE TO GREATER THAN MAXIMUM FOR MIN HEAP, > 0
            if (list.get(currentIndex).compareTo(list.get(maxIndex)) > 0) { //UPDATED TO >, MIN HEAP
                E temp = list.get(maxIndex);
                list.set(maxIndex, list.get(currentIndex));
                list.set(currentIndex, temp);
                currentIndex = maxIndex;
            } else {
                break; //The tree is a heap
            } //end if-else statment
        } //end while loop

        return removedObject;
    } //end remove method

    /**
     * Get the number of nodes in the tree.
     * 
     * @return Number of nodes in the tree
     */
    public int getSize() {
        return list.size();
    } //end getSize method

    /**
     * Return true if heap is empty.
     * 
     * @return True if heap is empty, else false.
     */
    public boolean isEmpty() {
        return list.size() == 0;
    } //end isEmpty method

} //end Heap class