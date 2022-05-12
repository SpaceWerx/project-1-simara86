package vendingMachine;

import java.util.ArrayList;
import java.util.Scanner;

public class Drinks extends Products{
	private int id;
	private static ArrayList<Drinks> beverage = new ArrayList<>();
	
	public Drinks() {
		
	}

	public Drinks(int id, String brand, double price) {
		super(brand, price);
		this.id = id;
		
	}
	
	public int getIds() {
		return id;
	}
	public String toString() {
		return  "          "+ getIds() + "  " +  getBrand()+ " $" + getPrice();
	
		
	}
 

	public  void productsAvailable() {
		System.out.println("************ Available Drinks ************\n");
		
		
	
	}
	public void setDrinks() {
		Scanner drinkInput = new Scanner(System.in);
	 Drinks d = new Drinks();
		
		Drinks drink1 = new Drinks( 11, "Pepsi    ", 1.00);
		Drinks drink2 = new Drinks (12, "Coke     ", 1.50);
		Drinks drink3 = new Drinks (13, "Sprite   ", 1.50);
		Drinks drink4 = new Drinks (14, "Dasani   ", 1.50);
		Drinks drink5 = new Drinks (15, "Powerade ", 1.50);
		
		ArrayList<Drinks> beverage = new ArrayList<>();
		beverage.add(drink1);
		beverage.add(drink2);
		beverage.add(drink3);
		beverage.add(drink4);
		beverage.add(drink5);
		//for loop to traverse through arrayList and return object 
    
			for (Drinks b: beverage){
        System.out.println(b);
      
		}
  
		System.out.print("Enter your Money: $");
	    double moneyInserted= drinkInput.nextDouble();
		System.out.print("Select your product: ");
		int snackselected =drinkInput.nextInt();
		
		
	switch (snackselected) {
	case 11:
	 
	if ( moneyInserted >= drink1.getPrice() ) {
		System.out.println("Vending...");
		System.out.println("Here's your " + drink1.getBrand());
		double change = (double)moneyInserted - drink1.getPrice();
		System.out.println("Take your change: $" + change);		
		
	}
	else {
		System.out.println (" Not enough fund");
	}
		break; 
		
		case 12: 
			
			if ( moneyInserted >= drink2.getPrice() ) {
				
				System.out.println("Vending...");
				System.out.println("Here's your " + drink2.getBrand());
				double change = (double)moneyInserted - drink2.getPrice();
				System.out.println("Take your change: $" + change);
				
				
				
			}
			else {
				System.out.println (" Not enough fund");
			}
	
			break;
			
		    case 13:
			
			if ( moneyInserted >= drink3.getPrice() ) {
				
				System.out.println("Vending...");
				System.out.println("Here's your " + drink3.getBrand());
				double change = (double)moneyInserted - drink3.getPrice();
				System.out.println("Take your change: $" + change);
				
			}
			else {
				System.out.println (" Not enough fund");
			}
	  break;
		case 14: 
	     
			if ( moneyInserted >= drink4.getPrice() ) {
				
				System.out.println("Vending...");
				System.out.println("Here's your " + drink4.getBrand());
				double change = (double)moneyInserted - drink4.getPrice();
				System.out.println("Take your change: $" + change);
				
			}
			else {
				System.out.println (" Not enough fund");
			}
	
          break;
		
		case 15: 
       
        if ( moneyInserted >= drink5.getPrice() ) {
        	
			System.out.println("Vending...");
			System.out.println("Here's your " + drink5.getBrand());
			double change = (double)moneyInserted - drink5.getPrice();
			System.out.println("Take your change: $" + change);
			
		}
		else {
			System.out.println (" Not enough fund");
		}
       break;
       default:
    	   System.out.println ("Please select a number 1-5");
  
	
	}
}	

}

	