package FinalProject;

import java.util.*;

/**
 * Travel Agent class
 * 
 * Within the Travel Agent class, I have implemented a flight
 * reservation system. The user or "Travel Agent" will allow
 * customers to call the agency to book/cancel their flights
 * using my implementation.
 * 
 * This is the class that carries the heavy work load. It contains
 * a user-interface (UI) that allows the travel agent to create, edit,
 * and print a Passenger. Also, it allows to store a Passenger in the 
 * flight that he/she desires to travel to.
 * 
 * @author Reno Redaja
 *
 */
public class TravelAgent {
	
	////////////////////
	//Global variables//
	////////////////////
	
    public static Scanner scanner = new Scanner(System.in); //Instantiate scanner for user input
    public static ArrayList<Passenger> passengerList = new ArrayList<Passenger>(); //Create an ArrayList to store Passenger object class.
    public static Passenger passenger; //Create a Passenger class
    public static Flight[] flights = {new Flight(1, "HNL", "LAX"), new Flight(2, "HNL", "ATL"),
    									new Flight(3, "HNL", "DEN"), new Flight(4, "LAX", "HNL"),
    										new Flight(5, "ATL", "HNL"), new Flight(6, "DEN", "HNL")}; //Create an array of Flights
    	
    ///////////
    //Methods//
    ///////////
    
    /**
     * renoAgency method.
     * 
     * Within this method contains the user-interface which allows the
     * user or travel agent to create, edit, and print a(n) Passenger's
     * information. Also, allows the book, cancel, and print Flight 
     * reservations.
     */
	public static void renoAgency() {
        try {
            int userOption; //Assign variable of type integer to userOption

            do {
                System.out.println("\nWelcome to Reno's Flight Agency! \nWhat would you like to do today?");
                System.out.println("\n1.) Create passenger"); //GOOD
                System.out.println("2.) Edit passenger"); //GOOD  
                System.out.println("3.) Display passenger information based on name"); //GOOD
                System.out.println("4.) Display passenger information based on segments flown"); //GOOD
                System.out.println("5.) Book reservation"); //BETTER
                System.out.println("6.) Cancel reservation"); //...
                System.out.println("7.) Display all flights"); //GOOD
                System.out.println("0.) Exit");
                System.out.print("\nEnter a numerical value for choice or 0 to exit: ");
                
                userOption = scanner.nextInt(); //user option input from menu
                scanner.nextLine(); //Advances this scanner past current line
            
                if (userOption < 0) { //Check if error
                    System.out.println("Please enter a number between 1 thru 7 or 0 to exit.");
                } else if (userOption >= 8) { //Check if error
                    System.out.println("Please enter a number between 1 thru 7 or 0 to exit.");
                } else { 
                    switch (userOption) {
                        case 1:
                            createPassenger(passengerList);
                            break;
                        case 2:
                        	editPassenger(passengerList);
                            break;
                        case 3:
                        	printPassenger(passengerList);
                            break;
                        case 4:
                        	segmentsFlown(passengerList);
                            break;
                        case 5: 
                        	bookRes();
                            break;
                        case 6: 
                        	cxlRes();
                            break;
                        case 7: 
                        	printFlights();
                            break;    
                        case 0: //User chooses 0, exit program
                            System.out.println("Thank you for choosing Reno's Flight Agency! :)");
                            break;
                        default:
                            System.out.println("Invalid option.");
                            break;
                    } //end switch statement
                } //end nested if-else statements
            } while (userOption != 0); //end do while loop
            
        } catch (java.util.InputMismatchException e) { //Catch exception if wrong input by user
            System.out.println("Try again, please enter a number.");
            scanner.nextLine();
        } //end try/catch block
	} //end renoAgency method
	
	/**
	 * createPassenger method.
	 * 
	 * Creates a(n) of object of Passenger(s) and is stored
	 * into an ArrayList.
	 * 
	 * @param createPassenger List of passengers
	 */
	public static void createPassenger(ArrayList<Passenger> createPassenger) {
		Random rand = new Random();
		int randID = rand.nextInt(100);
		
		System.out.println("\nLet's create a Passenger!");
		System.out.println("\nYour ID# has been created for you: " + randID);
		
		System.out.print("Enter first name: ");
		String firstName = scanner.nextLine();
		
		System.out.print("Enter last name: ");
		String lastName = scanner.nextLine();
		
		System.out.print("Enter email: ");
		String email = scanner.nextLine();
		
		passenger = new Passenger(randID, firstName, lastName, email);
		createPassenger.add(passenger);
		
		System.out.println("\nSuccessfully created!");
	} //end createPassenger method
	
	/**
	 * editPassenger method
	 * 
	 * Allows the user or travel to edit the object(s) of
	 * stored Passenger(s) in the ArrayList.
	 * 
	 * @param editPassenger List of passengers
	 */
	public static void editPassenger(ArrayList<Passenger> editPassenger) {		
		if (editPassenger.isEmpty()) {
			printPassenger(editPassenger);
		} else {
			System.out.print("\nEnter Passenger index to edit: ");
			int mod_Index = scanner.nextInt();
			
			System.out.println("\nCHOICES:");
			System.out.println("1.) First Name");
			System.out.println("2.) Last Name");
			System.out.println("3.) Email");
			System.out.print("\nPlease enter number value between 1 thru 3: ");
			int mod_Choice = scanner.nextInt();
			
			scanner.nextLine();
			
			switch (mod_Choice) {
				case 1:
					System.out.print("Edit first name: ");
					String mod_First_Name = scanner.nextLine();
					editPassenger.get(mod_Index).setfirstName(mod_First_Name);
					break;
				case 2:
					System.out.print("Edit last name: ");
					String mod_Last_Name = scanner.nextLine();
					editPassenger.get(mod_Index).setlastName(mod_Last_Name);
					break;
				case 3:
					System.out.print("Edit email: ");
					String mod_Email = scanner.nextLine();
					editPassenger.get(mod_Index).setemail(mod_Email);
					break;
				default:
					System.out.println("Try again.");
					break;
			} //end switch statement

			System.out.println("\nSuccessfully edited!");
		} //end if-else statement
	} //end editPassenger method
	
	/**
	 * printPassenger method
	 * 
	 * If there are no Passengers, print there are no Passengers.
	 * Else prints the list Passengers
	 * 
	 * @param printPassenger List of passengers
	 */
	public static void printPassenger(ArrayList<Passenger> printPassenger) {		
		if (printPassenger.isEmpty()) {
			System.out.println("\nThere are currently no Passenger(s).");
			System.out.println("Please create a Passenger(s)");
		} else {
			System.out.println("\nList of Passenger(s):\n");
			
			for (int i = 0; i < printPassenger.size(); i++) {
				System.out.print("Passenger Index (" + i + "): " + printPassenger.get(i) + "\n");
			}
		}
	} //end printPassenger method		
	
	/**
	 * segmentsFlown method
	 * 
	 * Prints the amount of segments flown from a Passenger.
	 * 
	 * @param segmentsFlown Amount of segments flown
	 */
	public static void segmentsFlown(ArrayList<Passenger> segmentsFlown) {		
		if (segmentsFlown.isEmpty()) {
			System.out.println("\nNo one has flown.");
			System.out.println("Please book your reservation(s).");
		} else {
			System.out.println("\nAmount Passenger(s) flown:\n");
			
			for (int i = 0; i < segmentsFlown.size(); i++) {
				System.out.println(segmentsFlown.get(i).getfirstName() + " has flown " + segmentsFlown.get(i).getamountFlown() + " amount of times.");
			}
		}
	} //end segmentsFlown method
	
	/**
	 * bookRes method
	 * 
	 * Allows the user or travel agent to book a reservation.
	 * Prints the list of Passengers and needs to choose the
	 * Passenger at a certain index and be stored into a Flight.
	 * If there are more than 5 Passengers within a Flight,
	 * they will be on a wait listed.
	 */
	@SuppressWarnings("static-access")
	public static void bookRes() {
		if (passengerList.isEmpty()) { //If Passenger list is empty
			printPassenger(passengerList); //print list of passengers
		} else {
			System.out.println("\nLet's book your reservation!");
			
			printPassenger(passengerList); //print list of passengers
			
			//Travel agent selects a Passenger to assign flight to
			System.out.print("\nSelect passenger to book reservation: ");
			int passengerIndex = scanner.nextInt(); //passengerIndex # choice 
			
			//Choose a Flight to book
			System.out.print("Select your flight to book: ");
			int flightIndex = scanner.nextInt(); //flight index # choice		
			
			switch (flightIndex) { //if Travel agent chooses Flight at index...
				case 0, 1, 2, 3, 4, 5:
					passenger = passengerList.get(passengerIndex); //get Passenger at the choice of user index
					flights[flightIndex].addPassengers(passenger);  //add Passenger to the flight of choice
					passenger.increaseFlown(); //Increment amount has flown for Passenger
					System.out.println("\nYour flight has been booked!" + flights[flightIndex] + "" + passengerList.get(passengerIndex));				
					break;
				default:
					System.out.println("Try again.");
					break;
			} //end switch statement
			
			System.out.println("\nSuccessfully booked reservation!");
		} //end if-else statement
	} //end bookRes method
	
	/**
	 * cxlRes method
	 * 
	 * Allows the user or travel agent to cancel a reservation.
	 * Prints the list of Passengers and needs to choose the
	 * Passenger and Flight at a certain index to cancel.
	 * If that person was originally on the Flight list and cancelled,
	 * the top or head element in the wait list will be retrieved and
	 * stored to the Flight list and decrement the amount of times flown.
	 */
	@SuppressWarnings("static-access")
	public static void cxlRes() {
		if (passengerList.isEmpty()) {
			printPassenger(passengerList); //print list of passengers
		} else {
			System.out.println("\nLet's cancel your reservation!");
			
			printPassenger(passengerList); //print list of passengers
			
			//Travel agent selects a Passenger to assign flight to
			System.out.print("Select passenger to cancel reservation: ");
			int passengerIndex = scanner.nextInt(); //passengerIndex # choice 

			//Choose a Flight to book
			System.out.print("Select your flight to cxl: ");
			int flightIndex = scanner.nextInt(); //flight index # choice	
			
			switch (flightIndex) { //if Travel agent chooses Flight at index...
				case 0, 1, 2, 3, 4, 5:
					passenger = passengerList.get(passengerIndex);
					flights[passengerIndex].removePassengers(passenger);
					passenger.decreaseFlown(); //Decrement amount has flown for Passenger
					System.out.println("\nYour flight has been cancelled!" + flights[flightIndex] + " for " + passengerList.get(passengerIndex));	
					break;
				default:
					System.out.println("Try again.");
					break;
			} //end switch statement
		} //end if-else statement
	} //end cxlRes method
 	
	/**
	 * printFlights method
	 * 
	 * Prints the list of Flights.
	 */
	public static void printFlights() {
		for (int i = 0; i < flights.length; i++) {
			System.out.println("\nFlight Index (" + i + "): " + flights[i]);
		}		
	} //end printFlights method
	
} //end TravelAgent class