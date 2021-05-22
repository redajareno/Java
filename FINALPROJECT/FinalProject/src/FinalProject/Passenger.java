package FinalProject;

/**
 * Passenger class
 * 
 * @author Reno Redaja
 *
 */
public class Passenger {
	
	/////////////
	//Variables//
	/////////////
	
	public int uniqeID; //Variable type integer named passengerID
	public String firstName; //Variable type string named passengerFirstName
	public String lastName; //Variable type string named passengerLastName
	public String email; //Variable type string named passengerEmail
	public int amountFlown; //Variable type integer named passengerFlown
	
	////////////////
	//Constructors//
	////////////////	
	
	/**
	 * Default Passenger constructor method.
	 */
	public Passenger() {
		this.uniqeID = 0;
		this.firstName = "";
		this.lastName = "";
		this.email = "";
		this.amountFlown = 0;
	} //end Passenger constructor method
	
	/**
	 * Creates new instance of Passenger setting the ID, name, email
	 * and amount of times Passenger has flown.
	 * 
	 * @param uniqueID The passenger ID.
	 * @param firstName Passenger first name.
	 * @param lastName Passenger last name.
	 * @param email Passenger email.
	 * @param amountFlown Passenger flown.
	 */
	public Passenger(int uniqueID, String firstName, String lastName, 
						String email) {
		this.uniqeID = uniqueID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	} //end Passenger constructor method
	
	/////////////////////
	//Getters & Setters//
	/////////////////////
	
	/**
	 * Returns the passenger ID number.
	 * 
	 * @return The passenger ID.
	 */
	public int getuniqueID() {
		return uniqeID;
	} //end getPassengerID method
	
	/**
	 * Sets the passenger ID number.
	 * 
	 * @param uniqueID The passenger ID.
	 * @return 
	 */
	public void setuniqueID(int uniqueID) {
		this.uniqeID = uniqueID;
	} //end setPassengerID method
	
	/**
	 * Returns the passengers first name.
	 * 
	 * @return The passengers first name.
	 */
	public String getfirstName() {
		return firstName;
	} //end getPassengerFirstName method
	
	/**
	 * Sets the passengers first name.
	 * 
	 * @param firstName The passengers first name.
	 */
	public void setfirstName(String firstName) {
		this.firstName = firstName;
	} //end setPassengerFirstName method
	
	/**
	 * Returns the passengers last name.
	 * 
	 * @return The passengers last name.
	 */
	public String getlastName() {
		return lastName;
	} //end getPassengerLastName method
	
	/**
	 * Sets the passengers last name.
	 * 
	 * @param lastName The passengers last name.
	 */
	public void setlastName(String lastName) {
		this.lastName = lastName;
	} //end setPassengerLastName method
	
	/**
	 * Returns the passengers email.
	 * 
	 * @return The passengers email.
	 */
	public String getemail() {
		return email;
	} //end getPassengerEmail method
	
	/**
	 * Sets the passengers email.
	 * 
	 * @param email The passengers email.
	 */
	public void setemail(String email) {
		this.email = email;
	} //end setPassengerEmail
	
	/**
	 * Returns the amount the passenger has flown.
	 * 
	 * @return The amount the passenger has flown.
	 */
	public int getamountFlown() {
		return amountFlown;
	} //end getPassengerFlown method
	
	/**
	 * Increase the amount of times a Passenger has flown.
	 * 
	 * @return The amount the passenger has flown.
	 */ 
	public int increaseFlown() {
		return amountFlown++;
	} //end increaseFlown method
	
	/**
	 * Decrease the amount of times a Passenger has flown.
	 * 
	 * @return The amount the passenger has flown.
	 */
	public int decreaseFlown() {
		return amountFlown--;
	} //end increaseFlown method
	
	/**
	 * Print out Passenger details.
	 */
	public String toString() {
		return "\nID#: " + uniqeID + "\nName: " + firstName + " "
				+ lastName + "\nEmail: " + email + "\nFlown: " + amountFlown;
	} //end toString method
	
} //end Passenger class