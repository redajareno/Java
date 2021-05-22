import java.util.*;

/**
 * Project 25.2
 * 
 * Use your updated Binary Search Tree class from Project 25.1 to create a program that allows you to 
 * create a student roster, ordered by first name. Your program should be able to do the following:
 * 
 * Add new students to the roster
 * Remove a student from the roster
 * Determine whether a student is on the roster
 * Count how many students are on the roster
 * Print out all the students on the roster, in alphabetical order
 * 
 * @author Reno Redaja
 */
public class Project252 {

    //Global variables
    public static BST<String> myRoster = new BST<String>(); //Create a BST of Strings
    public static Scanner scanner = new Scanner(System.in); //Instantiate scanner for user input

    /**
     * Main method.
     * 
     * @param args No arguments
     */
    public static void main(String[] args) {
        roster();
    } //end main method

    /**
     * roster method.
     * 
     * This method asking for user input. It prompts the user if he/she wants to
     * add, remove, check, get & print list of student roster.
     */
    public static void roster() {
        try {
            int userOption; //Assign variable of type integer to userOption

            do {
                System.out.println("\nWelcome! Let's start a line of customers!");
                System.out.println("\n1. Add student");
                System.out.println("2. Remove student");
                System.out.println("3. Check for student");
                System.out.println("4. Get student count");
                System.out.println("5. Print list of students");
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
                            addStudent(myRoster);
                            break;
                        case 2:
                            removeStudent(myRoster);
                            break;
                        case 3:
                            checkStudent(myRoster);
                            break;
                        case 4:
                            getStudent(myRoster);
                            break;
                        case 5: 
                            printStudent(myRoster);
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
    } //end roster method

    /**
     * Adds a student in the roster.
     * 
     * @param addStudent Add a student to roster
     */
    public static void addStudent(BST<String> addStudent) {
        System.out.print("Enter student name to add: ");
        String newStudent = scanner.nextLine().toLowerCase(); //User enters name, set to lower case

        addStudent.insert(newStudent); //Add student into BST
        System.out.println("Successfully added!");
    } //end addStudent method

    /**
     * Removes a student from the roster.
     * 
     * @param removeStudent Remove a student from roster
     */
    public static void removeStudent(BST<String> removeStudent) {
        printStudent(removeStudent); //Print list of Students

        System.out.print("\nEnter Student name to remove: ");
        String studentName = scanner.nextLine().toLowerCase(); //User enters a name, set to lower case

        removeStudent.remove(studentName);

        System.out.println("Successfully removed!");
    } //end removeStudent method

    /**
     * Checks if a student is in the roster.
     * 
     * @param checkStudent Check if a student is in the roster
     */
    public static void checkStudent(BST<String> checkStudent) {
        printStudent(checkStudent); //Print list of Students

        System.out.print("\nEnter student name to check: ");
        String checkCust = scanner.nextLine().toLowerCase(); //User enters name, set to lower case

        //Capitalize first letter of name
        String capitalize = checkCust;
        String output = capitalize.substring(0, 1).toUpperCase() + capitalize.substring(1); 

        if (myRoster.search(checkCust) == true) {
            System.out.println(output + " is currently on the roster.");
        } else {
            System.out.println(output + " is not on the roster.");
        }
    } //end checkStudent method

    /**
     * Get the student size from the roster.
     * 
     * @param getStudent Get the student size from roster
     */
    public static void getStudent(BST<String> getStudent) {
        System.out.println("There are " + getStudent.size() + " student(s) on the roster.");
    } //end getStudent method

    /**
     * Print roster.
     */
    public static void printStudent(BST<String> printStudent) {
        System.out.println("\nSTUDENT(S): ");
        System.out.println("---------");

        for (String students : printStudent) {
            //Capitalize first letter of name
            String capitalize = students;
            String output = capitalize.substring(0, 1).toUpperCase() + capitalize.substring(1);

            System.out.println(output);
        }
    } //end printStudent method

} //end Project252 class