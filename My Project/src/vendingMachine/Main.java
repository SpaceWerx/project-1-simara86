package vendingMachine;

import java.util.Scanner;
import java.util.InputMismatchException;

// * 4 Pillars of OOP
// * Must create and use at least 3 Constructors
// * Must have at least 4 methods
// * Must include a section to get responses from User
// * Must contain a switch statement
// * Must handle at least 1 exception
// * Project must include at least 3 Classes
// * Use one of the Collections structures.
// * Use a loop to traverse through your Collection structure that you chose and modify,// * organize, or return values from the iteration. 
// * ex. Sort my structure, Search, find and return object 

class Main{
  public static void main(String[] args) {
		Drinks drinks = new Drinks(); 
		Snacks snacks = new Snacks();
    
			Scanner scan = new Scanner (System.in);
     boolean stop = false;
	while (stop==false){
      Products.instructions();

    //try catch: This will catch a Runtime exception: InputMistmatchException (if the user types in anything that is not a number)
try {
switch(scan.nextInt()) {
//This case will run if user select Snacks
		case 1:
			snacks.productsAvailable();
			snacks.setSnacks();
			break;
//This case will run if user select Drinks
    	case 2:
			 drinks.productsAvailable(); 
			 drinks.setDrinks();
			 break;
			
			default:
			System.out.println("Invalid option\nPlease choose 1 or 2");
		}
		//the block of code inside of the catch will print a message to the user telling what they did wrong and  the instruction to what to do next
	}catch(InputMismatchException e) {
  System.out.println(e);
	System.out.println("Invalid selection\nPlease enter a number" );
		System.out.println("");
	}
	}
}

}
  
