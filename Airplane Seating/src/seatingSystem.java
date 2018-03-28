import java.util.Scanner;

public class seatingSystem {
	
	public static void main(String[] args) {
		
		Airplane airplane = new Airplane();   //Construct an airplane that will have first class and economy class seating
		 
		int menuChoice = 1;   //Holds the option the user select from the menu
		int classChoice = 1;  //Holds the class which the user will add the passenger to (First Class or Economy Class)
		int numPassenger = 0; //Holds the number of passengers that will be traveling together
		
		do {
			System.out.println("Please select from 1 of the 3 options below:");
			System.out.println("Enter 1 to add passengers");
			System.out.println("Enter 2 to show airplane seating");
			System.out.println("Enter 3 to quit the program");
			
			Scanner selection = new Scanner(System.in);  //Receive user input for menu selection and class selection for adding passenger
			menuChoice = selection.nextInt();
			
			if(menuChoice == 1){
				System.out.println("Enter 1 to add passenger to First Class");  //To add a passenger, the user must enter the class (First or Economy)
				System.out.println("Enter 2 to add passenger to Economy Class");  
				selection = new Scanner(System.in);
				classChoice = selection.nextInt();       //Holds the class the passenger will be added to
				
				if(classChoice == 1) {   //If user chooses to add passenger to first class
					System.out.println("Enter number of passengers traveling together: 1 or 2");  //First class can have up to 2 passengers traveling together
					selection = new Scanner(System.in);  
					numPassenger = selection.nextInt();    //Holds number of passengers traveling together
					airplane.addFirst(numPassenger);      //Call first class add method and pass in number of passengers as parameter
				}else {
					if(classChoice == 2) {	 //If user chooses to add passenger to economy class
						System.out.println("Enter number of passengers traveling together: 1, 2, or 3"); //Economy class can have up to 3 passengers traveling together
						selection = new Scanner(System.in);
						numPassenger = selection.nextInt();
						airplane.addEconomy(numPassenger);  //Call economy class add method and pass in number of passengers as parameter
					}
				}
			}
			
			if(menuChoice == 2) {
				airplane.showSeating();   //Displays the airplane's seating
			}
			
			if(menuChoice == 3) {
				System.out.println("Quit");  //Display quit message to indicate the end of the program
			}
			
			System.out.println();
			
		}  while(menuChoice != 3); //While the user has not selected option 3 to quit the program, continuing the program
			
	}
}
