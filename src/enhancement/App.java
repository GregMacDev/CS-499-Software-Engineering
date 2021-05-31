package enhancement;

import java.util.Scanner;

/**
* <h1>Item bids C++ to Java Conversion Enhancement</h1>
* This program takes a user's input and stores the values in a ItemForBid class.
* This program has been converted from C++.
* <p>
*
* @author  Greg MacPhelemy
* @version 1.0
* @since   05-11-2021
*/

public class App {

	/**
	 * This method prints out the elements of an ItemForBid object
	 * @param passedItem This is the ItemForBid object to be printed to the screen.
	 */
	private static void displayBid(ItemForBid passedItem) {
		//String bid = String.format("%.2f", passedItem.getBidAmount());
		
		System.out.printf("%-12s%s\n","Title: ", passedItem.getItemTitle());
		System.out.printf("%-12s%s\n","Fund: ", passedItem.getFundType());
		System.out.printf("%-12s%s\n","Vehicle: ", passedItem.getVehicleType());
		System.out.printf("%-12s%.2f\n\n","Bid Amount: $", passedItem.getBidAmount());
	}
	
	/**
	 * This method gathers information from the user, stores it as an ItemForBid
	 * object and returns the object.
	 * @param scanner This is the scanner object that reads a user's input
	 * @return newItem This returns the object containing user input data.
	 */
	private static ItemForBid getBid(Scanner scanner) {
		
		// Creates a new ItemForBid object
		ItemForBid newItem = new ItemForBid();
		
		// Collects user input data for each of the object's variables
		System.out.println("Enter title: ");
		newItem.setItemTitle(scanner.nextLine());
		
		System.out.println("Enter fund: ");
		newItem.setFundType(scanner.nextLine());
		
		System.out.println("Enter vehicle: ");
		newItem.setVehicleType(scanner.nextLine());
		
		System.out.println("Enter amount: ");
		newItem.setBidAmount(scanner.nextDouble());
		
		return newItem;
	}	

	/**
	 * This is the main method that prints the menu to the screen and controls the
	 * user's navigation of the menu.
	 * @param args unused
	 */
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		ItemForBid newItem = new ItemForBid();
		int userChoice = 0;
		
		// Populate test data
		//testPopulate(Items);		
		 
		// Main menu for user selection
		while(userChoice != 9) {
			System.out.println("Menu:");
			System.out.println("1. Enter Bid");
			System.out.println("2. Display Bid");
			System.out.println("9. Exit");
			
			// Validating user input
			do {				
				// Prevents invalid input by checking for an int input from the user
				while(!scanner.hasNextInt()) {
					System.out.println("Number not entered. Please enter a valid number.");
					scanner.next();
				}
				userChoice = scanner.nextInt();
				
				// White listing user input
				if(userChoice !=1 && userChoice !=2 && userChoice !=9) {
					System.out.println("Invalid menu option. Please enter a valid menu option.");
				}
				//White listing conditional for do/while loop
			} while (userChoice != 1 && userChoice != 2 && userChoice !=9);
			
			// Clear scanner buffer
			scanner.nextLine();
			
			// User input switch control.
			switch(userChoice) {
			case 1: // Enter bids
				newItem = getBid(scanner);
				break;
			case 2:	// Display all bids
				displayBid(newItem);
				break;
			}
		}
		// Always close the scanner!
		scanner.close();
	}

}
