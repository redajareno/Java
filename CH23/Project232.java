/**
 * Project 23.2
 * 
 * Starting from the code in LiveExample 23.9 (Heap.java), revise the implementation so that 
 * it is a min-heap rather than a max-heap. A max-heap, as shown in this example, is a 
 * heap in which each node is greater than or equal to any of its children. 
 * A min-heap is a heap in which each node is less than or equal to any of its children.
 * Min-heaps are often used to implement priority queues.
 * 
 * @author Reno Redaja
 */
public class Project232 {

    /**
     * Main method.
     * 
     * Run the Heap Sort implemented to Min-Heap.
     *  
     * @param args No arguments
     */
    public static void main(String[] args) {
        Integer[] numbers = new Integer[10]; //Create an Integer of Arrays

        //Add Random numbers to the Array
        System.out.println("Random nums: ");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) (Math.random() * 100);
            System.out.print(numbers[i] + "\t");
        }

        System.out.println('\n'); //new line

        //Sort
        minHeap(numbers);

        //Print sorted numbers
        System.out.println("Sorted nums: ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + "\t");
        }
    } //end main method

    /**
     * Min-Heap method.
     * 
     * @param <E> Generic type
     * @param list The list
     */
    public static <E extends Comparable<E>> void minHeap(E[] list) {
        //Create Heap of integers
        minHeap<E> minHeap = new minHeap<>();

        //Add elements to the heap
        for (int i = 0; i < list.length; i++) {
            minHeap.add(list[i]);
        }

        //Remove elements from the heap
        for (int i = list.length - 1; i >= 0; i--) {
            list[i] = minHeap.remove();
        }
    } //end minHeap method

} //end Project232 class