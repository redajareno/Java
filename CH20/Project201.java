import java.util.*;

/**
 * Project 20.1
 * 
 * Simple "Bank" program.
 * This program is a simple bank program that asks the user to add an account.
 * The user is allowed to withdraw, deposit, or delete the account.
 * In order to keep track, the user is also able to print out all of the accounts with the balance.
 * There are also exception handling in case the user has made mistakes while making inputs.
 * 
 * The reason why I chose an ArrayList for this project is because the way an ArrayList are resizable 
 * and can grow and/or shrink dynamically. Elements may be inserted or deleted at a particular position.
 * In an ArrayList, it contains many methods that may manipulate the stored objects for example...
 * add(), remove(), and get() like used in this program. You may also traverse through the list 
 * in both directions (forward & backward) using a ListIterator as well as hold duplicate elements.
 * 
 * @author Reno Redaja
 */
public class Project201 {

    //Global variables
    public static Account account; //Create an object Account named account
    public static ArrayList<Account> arrayListAccounts = new ArrayList<Account>(); //Create an ArrayList of Account object
    public static Scanner scanner = new Scanner(System.in); //Instantiating scanner for user input

    /**
     * Main method.
     * 
     * @param args None
     */
    public static void main(String[] args) {
        bank(); //Driver method
    } // end main method

    /**
     * Bank method.
     * 
     * This method asking for user input. It prompts the user if he/she wants to
     * add, delete, withdraw, deposit, and print account information.
     */
    public static void bank() { 
        int userOption; //Assign variable of type integer to userOption

        do {
            System.out.println("\nMENU");
            System.out.println("1. Add new account");
            System.out.println("2. Delete account");
            System.out.println("3. Withdraw");
            System.out.println("4. Deposit");
            System.out.println("5. Print all account info");
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
                        addAccount(arrayListAccounts); //User chooses 1, add account to Account ArrayList
                        break;
                    case 2:
                        deleteAccount(arrayListAccounts); //User chooses 2, delete account from Account ArrayList
                        break;
                    case 3:
                        withdrawAccount(arrayListAccounts); //User chooses 3, withdraw balance from Account ArrayList
                        break;
                    case 4:
                        depositAccount(arrayListAccounts); //User chooses 4, deposit balance from Account ArrayList
                        break;
                    case 5: 
                        printAccount(arrayListAccounts); //User chooses 5, prints all accounts from ArrayList
                        break;
                    case 0: //User chooses 0, exit program
                        System.out.println("Exit");
                        break;
                    default:
                        System.out.println("Please select a value from 1-5 or 0 to exit.");
                        break;
                } //end switch statement
            } //end nested if-else statments
        } while(userOption != 0); //end do while loop
    } //end bank() method

    /**
     * Prompts the user for a name and amount to add a new account.
     * Also, handles scanner exceptions if the user enters wrong input.
     * 
     * @param addAccount The account in the ArrayList.
     */
    public static void addAccount(ArrayList<Account> addAccount) {
        try {
            System.out.print("Enter name: ");
            String newName = scanner.nextLine(); //User enters name

            System.out.print("Enter amount: $");
            double newBalance = scanner.nextDouble(); //User enters balance

            account = new Account(newName, newBalance); //Create an object class Account with user input name & balance
            addAccount.add(account); //Add created object Account to ArrayList
        } catch (java.util.InputMismatchException e) { //Catch exception if wrong input by user
            System.out.println("Please enter a numerical value.");
            scanner.nextLine();
        } //end try/catch block
    } //end addAccount() method

    /**
     * Prompts the user for an index to delete an account.
     * Also, handles scanner exceptions if the user enters wrong input.
     * 
     * @param deleteAccount The account in the ArrayList.
     */
    public static void deleteAccount(ArrayList<Account> deleteAccount) {
        printAccount(deleteAccount); //Prints list of accounts

        try {
            System.out.print("Enter index to delete: ");
            int deleteIndex = scanner.nextInt();
            deleteAccount.remove(deleteIndex);
        } catch (IndexOutOfBoundsException IOBexception) { //Catch exception if wrong input by user
            System.out.println("Please enter an index to delete.");
            scanner.nextLine();
        } //end try/catch block
    } //end deleteAccount() method

    /**
     * Prompts the user for an index to withdraw from an account.
     * Also, handles scanner exceptions if the user enters wrong input.
     * 
     * @param withdrawAccount The account in the ArrayList.
     */
    public static void withdrawAccount(ArrayList<Account> withdrawAccount) {
        printAccount(withdrawAccount); //Prints list of accounts

        try { //outter try/catch for input mismatch
            try { //inner try/catch index of out bounds exception for ArrayList
                System.out.print("Enter index to withdraw: ");
                int index = scanner.nextInt();

                System.out.print("Enter amount to withdraw: ");
                double amount = scanner.nextDouble();

                withdrawAccount.get(index).withdraw(amount);
            } catch (IndexOutOfBoundsException IOBexception) {
                System.out.println("Please enter an index to withdraw.");
                scanner.nextLine();
            } //end inner try/catch block
        } catch (java.util.InputMismatchException e) { //Catch exception if wrong input by user
            System.out.println("Please enter an amount to withdraw.");
            scanner.nextLine();
        } //end outter try/catch block
    } //end withdrawAccount() method

    /**
     * Prompts the user for an index to deposit to a account.
     * Also, handles scanner exceptions if the user enters wrong input.
     * 
     * @param depositAccount The account in the ArrayList.
     */
    public static void depositAccount(ArrayList<Account> depositAccount) {
        printAccount(depositAccount); //Prints list of accounts

        try { //outter try/catch for input mismatch
            try { //inner try/catch index of out bounds exception for ArrayList
                System.out.print("Enter index to deposit: ");
                int index = scanner.nextInt();
                System.out.print("Enter amount to deposit: ");
                double amount = scanner.nextDouble();
        
                depositAccount.get(index).deposit(amount);
            } catch (IndexOutOfBoundsException IOBexception) {
                System.out.println("Please enter an index to deposit.");
                scanner.nextLine();
            } //end inner try/catch block
        } catch (java.util.InputMismatchException e) { //Catch exception if wrong input by user
            System.out.println("Please enter an index/amount to deposit.");
            scanner.nextLine();
        } //end outter try/catch block
    } //end depositAccount() method

    /**
     * Prints all the accounts in the ArrayList.
     * 
     * @param printAccount The account in the ArrayList.
     */
    public static void printAccount(ArrayList<Account> printAccount) {
        System.out.println("\nAccounts: ");
        System.out.println("---------");

        for (int i = 0; i < printAccount.size(); i++) {
            System.out.println("Index: " + i + "\nName: " + printAccount.get(i).getName() + "\nBalance: $" 
                    + printAccount.get(i).getBalance() + "\n");
        } //end for loop
    }//end printAccount() method

} //end class Project201