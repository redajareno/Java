/**
 * Project 24.1
 * 
 * Start with the MyLinkedList class, which implements the MyList interface (code from the textbook).
 * Define a new class that extends MyLinkedList to override and implement the following methods:
 *
 * contains(E e)
 * get(int index)
 * indexOf(E e)
 * lastIndexOf(E e)
 * set(int index, E e)
 * 
 * @author Reno Redaja
 */
public class Project241 {

    /**
     * Main method.
     * 
     * Within the main method, test the following overridden methods:
     * contains(E e) - test done
     * get(int index) - 
     * indexOf(E e) - test done
     * lastIndexOf(E e) - test done
     * set(int index, E e) - test done
     * 
     * @param args
     */
    public static void main(String[] args) {
        //Create a list of Strings called myList
        MyLinkedList<String> myList = new MyLinkedList<String>(); 

        //Add elements to the list
        myList.add("Luffy"); //Add to the list
        System.out.println("(1)" + myList);
        myList.add(0, "Zoro"); //Add to index 0 in the list
        System.out.println("(2)" + myList);
        myList.addLast("Nami"); //Add last to the list
        System.out.println("(3)" + myList);
        myList.add("Usopp"); //Add to end of the list
        System.out.println("(4)" + myList);
        myList.add(2, "Sanji"); //Add to index 2 in the list
        System.out.println("(5)" + myList);
        myList.add(4, "Chopper"); //Add to index 4 in the list
        System.out.println("(6)" + myList);
        myList.set(1, "Shanks"); //Set Shanks to index 1 in the list
        System.out.println("(7)" + myList);
        myList.addLast("Franky");
        System.out.println("(8)" + myList);

        //Remove elements from the list
        myList.remove(1); //Remove element in index 1 in the list
        System.out.println("(9)" + myList);
        
        //Contains elements in the list
        System.out.println("(10) Contains string Luffy: " + myList.contains("Luffy"));
        System.out.println("(11) Contains string Zoro: " + myList.contains("Zoro"));
        
        //Index # in the list
        int index = myList.indexOf("Usopp");
        System.out.println("(12) Index of Usopp: " + index);
        int indexLast = myList.lastIndexOf("Franky");
        System.out.println("(13) Index of Franky: " + indexLast);

        //Add more elements to the list
        myList.add(3, "Robin");
        System.out.println("(14)" + myList);
        myList.add("Brook");
        System.out.println("(15)" + myList);

        //Get elements in the list
        for (String onePiece : myList) {
            System.out.println("\n" + onePiece + "\t");
        }

    } //end main method

} //end Project241 class