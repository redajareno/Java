import java.util.*;

/**
 * Project 24.2
 * 
 * Use your updated Linked List class from Project 24.1 to implement a basic queue class to help you keep track of customers waiting (in the checkout line, in a waiting room, in a buffet line, etc). Design your queue class so that your program will be able to do the following:
 *
 * Add new customers to the end of the queue
 * Remove a customer from the beginning of the queue
 * Determine whether a customer is in the queue
 * Count how many customers are in the queue
 * Print out all the customers in the queue
 * 
 * @author Reno Redaja
 */
public class Project242 {

    //Global variables
    public static MyLinkedList<String> guestList = new MyLinkedList<String>(); //Create a LinkedList of Strings
    public static Scanner scanner = new Scanner(System.in); //Instantiate scanner for user input

    /**
     * Main method.
     * 
     * @param args No arguments
     */
    public static void main(String[] args) {
        guestList();
    } //end main method

    /**
     * guestList method.
     * 
     * This method asking for user input. It prompts the user if he/she wants to
     * add, remove, check, get & print list of customers.
     */
    public static void guestList() {
        try {
            int userOption; //Assign variable of type integer to userOption

            do {
                System.out.println("\nWelcome! Let's start a line of customers!");
                System.out.println("\n1. Add customer");
                System.out.println("2. Remove customer");
                System.out.println("3. Check for customer");
                System.out.println("4. Get customer count");
                System.out.println("5. Print list of customers");
                System.out.println("0. Exit");
                System.out.print("\nEnter a numerical value for choice or 0 to exit: ");
                userOption = scanner.nextInt(); //user option input from menu
                scanner.nextLine(); //Advances this scanner past current line
            
                if (userOption < 0) { //Check if error
                    System.out.println("Please enter a number between 1 thru 5 or 0 to exit.");
                } else if (userOption >= 6) { //Check if error
                    System.out.println("Please enter a number between 1 thru 5 or 0 to exit.");
                } else { 
                    switch (userOption) {
                        case 1:
                            addCustomer(guestList);
                            break;
                        case 2:
                            removeCustomer(guestList);
                            break;
                        case 3:
                            checkCustomer(guestList);
                            break;
                        case 4:
                            getCustomer(guestList);
                            break;
                        case 5: 
                            printCustomer(guestList);
                            break;
                        case 0: //User chooses 0, exit program
                            System.out.println("Exit");
                            break;
                        default:
                            System.out.println("Please select a value from 1-5 or 0 to exit.");
                            break;
                    } //end switch statement
                } //end nested if-else statments
            } while (userOption != 0); //end do while loop
        } catch (java.util.InputMismatchException e) { //Catch exception if wrong input by user
            System.out.println("Try again, please enter a number.");
            scanner.nextLine();
        } //end try/catch block
    } //end guestList method

    /**
     * Add elements of type String into the list.
     * 
     * @param addCustomer The list
     */
    public static void addCustomer(MyLinkedList<String> addCustomer) {
        System.out.print("Enter customer name to add: ");
        String newCust = scanner.nextLine(); //User enters name

        addCustomer.add(newCust); //Add customer into list
        System.out.println("Successfully added!");
    } //end addCustomer method

    /**
     * Remove elements of type String in the list.
     * 
     * @param removeCustomer The list
     */
    public static void removeCustomer(MyLinkedList<String> removeCustomer) {
        printCustomer(removeCustomer); //Print list of customers

        System.out.print("\nEnter an index to remove customer: ");
        int deleteIndex = scanner.nextInt(); //User enters an integer

        if (deleteIndex > removeCustomer.size()) {
            System.out.println("Please enter an index within the list.");
        } else {
            removeCustomer.remove(deleteIndex); //Remove customer at the index from user input
            System.out.println("Successfully removed!");
        } //end if-else statement
    } //end removeCustomer method

    /**
     * Check if element is in the list.
     * 
     * @param checkCustomer The list
     */
    public static void checkCustomer(MyLinkedList<String> checkCustomer) {
        System.out.print("Enter customer name to check: ");
        String checkCust = scanner.nextLine(); //User enters name

        int index = guestList.indexOf(checkCust);

        if (checkCustomer.contains(checkCust) == true) {
            System.out.println(checkCust + " is currently number " + index + " in line.");
        } else {
            System.out.println(checkCust + " is not in line.");
        } //end if-else statements
    } //end checkCustomer method

    /**
     * Get the count of elements in the list.
     * 
     * @param getCustomer The list
     */
    public static void getCustomer(MyLinkedList<String> getCustomer) {
        System.out.println("There are " + getCustomer.size() + " customers currently waiting.");
    } //end getCustomer method

    /**
     * Prints all the elements in the list.
     * 
     * @param printCustomer The list
     */
    public static void printCustomer(MyLinkedList<String> printCustomer) {
        System.out.println("\nCUSTOMERS: ");
        System.out.println("---------");

        for (int i = 0; i < printCustomer.size(); i++) {
            System.out.println("Customer @ index " + i + ": " + printCustomer.get(i));
        }
    } //end printCustomer method
    
} //end Project242 class