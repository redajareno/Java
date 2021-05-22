package FinalProject;

import java.util.*;

/**
 * Flight class
 * 
 * @author Reno Redaja
 *
 */
public class Flight {
	
	/////////////
	//Variables//
	/////////////
	
	public int flightID; //Variable type integer named flightID
	public String flightOrigin; //Variable type string named flightOrigin
	public String flightDestination; //Variable type string named flightDestination
    public static Queue<Passenger> passengerList = new LinkedList<Passenger>(); //Create a queue of Passengers
    public static Queue<Passenger> waitList = new LinkedList<Passenger>(); //Create a wait list queue of Passengers
	
	////////////////
	//Constructors//
	////////////////
	
	/**
	 * Default Flight constructor method.
	 */
	public Flight() {
		this.flightID = 0;
		this.flightOrigin = "";
		this.flightDestination = "";
	} //end Flight constructor method
	
	/**
	 * Creates new instance of Flight setting the flight ID, origin, & destination.
	 * 
	 * @param flightID The flight ID.
	 * @param flightOrigin The flight origin.
	 * @param flightDestination The flight destination.
	 */
	public Flight(int flightID, String flightOrigin, String flightDestination) {
		this.flightID = flightID;
		this.flightOrigin = flightOrigin;
		this.flightDestination = flightDestination;
	} //end Flight constructor method
	
	/////////////////////
	//Getters & Setters//
	/////////////////////
	
	/**
	 * Returns the flight ID.
	 * 
	 * @return The flight ID.
	 */
	public int getFlightID() {
		return flightID;
	} //end getFlightID method
	
	/**
	 * Sets the flight ID.
	 * 
	 * @param flightID The flight ID.
	 */
	public void setFlightID(int flightID) {
		this.flightID = flightID;
	} //end setFlightID method
	
	/**
	 * Returns the origin of flight.
	 * 
	 * @return The origin of flight.
	 */
	public String getFlightOrigin() {
		return flightOrigin;
	} //end getFlightOrigin method
	
	/**
	 * Sets the origin of flight.
	 * 
	 * @param flightOrigin The origin of flight.
	 */
	public void setFlightOrigin(String flightOrigin) {
		this.flightOrigin = flightOrigin;
	} //end setFlightOrigin method
	
	/**
	 * Returns the destination of flight.
	 * 
	 * @return The destination of flight.
	 */
	public String getFlightDestination() {
		return flightDestination;
	} //end getFlightDestination method
	
	/**
	 * Sets the destination of flight.
	 * 
	 * @param flightDestination The destination of flight.
	 */
	public void setFlightDestination(String flightDestination) {
		this.flightDestination = flightDestination;
	} //end setFlightDestination method
	
	/**
	 * addPassengers method
	 * 
	 * A Flight can store up to 5 Passengers.
	 * If there is more than 5 Passengers,
	 * then add to the wait list.
	 * 
	 * @param pass Passengers
	 */
	public static void addPassengers(Passenger pass) {
		//Keep adding object of Passengers
		//If there are more than 5 passengers, add them to wait list.
		if (passengerList.size() >= 5) {
			waitList.add(pass);
			
			System.out.println("You have been wait listed.");
		} else {
			passengerList.add(pass);
		}
	} //end flightPassengers method
	
	/**
	 * removePassengers method
	 * 
	 * Removes a Passenger from the list
	 * If a Passenger is removed from the main list, then
	 * add the next person from the top of the wait list
	 * to the main list.
	 * 
	 * @param pass Passengers
	 */
	public static void removePassengers(Passenger pass) {
		if (passengerList.remove(pass)) { //Remove Passenger from flight list
			passengerList.add(waitList.poll()); //Retrieve "top" Passenger from wait list then add to Passenger list in order
			
			System.out.println("Congratulations!\n You are no longer wait listed.");
		} 
	} //end removePassengers method
	 
	/**
	 * Print Flight details.
	 */
	@Override
	public String toString() {
		return "\nFlight ID#: " + flightID + ", " + "Origin: " + flightOrigin 
				+ ", " + "Destination: "+ flightDestination;
	} //end toString method
	
} //end Flight class