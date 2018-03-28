import java.util.Scanner;

public class Airplane {
	
	private int economyRows = 30; // 30 rows of seats in total in economy class
	private int economySeats = 7; // 6 seats per row in economy class and one aisle in between 6 of the seats. 
	
	private int firstRows = 5;   // 5 rows of seats in total in first class 
	private int firstSeats = 5;  // 4 seats per row in first class and one aisle in between 4 of the seats.
	
	private char[][]firstClass;   // 2D array of the seating for first class
	private char[][]economyClass; // 2D array of the seating for economy class
	
	public Airplane() {
		
		firstClass = new char[firstRows][firstSeats];
		economyClass = new char[economyRows][economySeats];
		
		 // Initialize the first class seats
		 for(int i = 0; i < firstRows; i++) {
			 for(int j = 0; j < firstSeats; j++) {
				 firstClass[i][j] = 'E';    		 // 'E' means empty seats
				 if(j == 2) {					     // Seat cannot be placed in an aisle column for firstClass array
					 firstClass[i][j] = 'A';		 // 'A' means aisle
				 }
			 }
		 }
		 
		 // Next, initialize the economy class seats
		 for(int i = 0; i < economyRows; i++) {
			 for(int j = 0; j < economySeats; j++) {
				 economyClass[i][j] = 'E'; 
				 if(j == 3) {                  		// Seat cannot placed in an aisle column for economyClass array
					 economyClass[i][j] = 'A'; 
				 }
			 }
		 }

	}
	

	//Method displays the seats of the airplane
	public void showSeating() {

		System.out.println("\nE represents an empty seat, F represents an occupied seat, A represents an aisle\n");
		
		// Displays first class seats
		System.out.println("First Class Seating: ");
		for(int i = 0; i < firstRows; i++) {
			System.out.print("Row ");
			System.out.printf("%2d", i);
			System.out.print(" ");
			
			for(int j = 0; j < firstSeats; j++) {
				System.out.print(firstClass[i][j] + " "); 
			 }
			 System.out.println();
		 } 
		
		// Displays economy class seats
	    System.out.println("\nEconomy Class Seating: ");
		for(int i = 0; i < economyRows; i++) {
			System.out.print("Row ");
			System.out.printf("%2d", i);
			System.out.print(" ");
			
			for(int j = 0; j < economySeats; j++) {
				System.out.print(economyClass[i][j] + " "); 
			 }
			 System.out.println();
		 }	
	}
	
	//Method adds passengers to first class by taking in number of passengers as a parameter
	public void addFirst(int num) {
		
		//For each passenger, a seating preference is asked (Window or Aisle)
		for(int i = 1; i <= num; i++) {
			System.out.println("Enter seating preference for passenger " + i + ": Window or Aisle?");
			Scanner read = new Scanner(System.in);  //Ask for the passenger's seating preference
			String seating = read.next();           
			seating = seating.toLowerCase();
			boolean seatFound = false;        //seatFound holds boolean value of false since passenger has not found their seat yet
			
			//Loop through first class seats
			for(int j = 0; j < firstRows; j++) {
				for(int k = 0; k < firstSeats; k++) {
					if(firstClass[j][k] == 'E' && seatFound == false) {      //If an empty seat is found and passenger has not been seated
						if(seating.equals("window") && (k == 0 || k == 4)) { //If empty seat is a window seat
							seatFound = true;        //Passenger has found their seat and set seatFound boolean to true
							firstClass[j][k] = 'F'; // Also set seat to 'F', which means seat is not empty anymore
							System.out.println("Passenger " + i + " added");
						}else {
							if(seating.equals("aisle") && (k == 1 || k == 3)){  //If an empty seat is an aisle seat
								seatFound = true;		//Passenger has found their seat and set seatFound boolean to true
								firstClass[j][k] = 'F'; 
								System.out.println("Passenger " + i + " added");
							}
						}
					}
				}
			}
			
			if(seatFound == false) { //If seatFound is equal to false, then print a message that passenger has not found a seat.
				System.out.println("\nNo match has been found for passenger " + i + " for seat " + seating + "\n");
			}
		}
	}
	
	
	//Method adds passengers to economy class by taking in number of passengers as a parameter
	public void addEconomy(int num) {
		
		//For each passenger, a seating preference is asked (Window, Middle, or Aisle)
		for(int i = 1; i <= num; i++) {  
			System.out.println("Enter seating preference for passenger " + i + ": Window, Middle, or Aisle");
			Scanner read = new Scanner(System.in);
			String seating = read.next();
			seating = seating.toLowerCase();
			boolean seatFound = false;
			
			for(int j = 0; j < economyRows; j++) {         //nested goes through seats in the in the economy class
				for(int k = 0; k < economySeats; k++) {
					if(economyClass[j][k] == 'E' && seatFound == false) {  //If seat is empty and passenger has not found a seat yet
						if(seating.equals("window") && (k == 0 || k == 6)) { //Checks for an empty window seat
							seatFound = true;         //seatFound set to true since seat has been found for the passenger
							economyClass[j][k] = 'F'; //set seat to 'F', since seat is not empty anymore
							System.out.println("Passenger " + i + " added");
						}else {
							if(seating.equals("aisle") && (k == 2 || k == 4)){  //If there is an empty aisle seat
								seatFound = true;
								economyClass[j][k] = 'F'; 
								System.out.println("Passenger " + i + " added");
							}else {
								if(seating.equals("middle") && (k == 1 || k == 5)){  //If there is a empty middle seat
									seatFound = true;
									economyClass[j][k] = 'F'; 
									System.out.println("Passenger " + i + " added");
								}
							}
						}
					}
				}
			}
			
			if(seatFound == false) { //If seatFound is equal to false, then print a message that passenger has not found a seat.
				System.out.println("\nNo match has been found for passenger " + i + " for seat " + seating + "\n");
			}
		}
	}
		
}
