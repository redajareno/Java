package FinalProject;

/**
 * Final Project
 * 
 * Within this file runs the TravelAgency class that 
 * carries the heavy work load.
 *
 * @author Reno Redaja
 *
 */
public class FinalProject {

	/**
	 * Main method.
	 * 
	 * Final Project
	 * 
	 * Creates a new object of the TravelAgent class 
	 * and runs the renoAgency() method.
	 * 
	 * @param args No arguments
	 */
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		TravelAgent ta = new TravelAgent();
		
		ta.renoAgency(); //Main driver method
	} //end main method

} //end FinalProject class
