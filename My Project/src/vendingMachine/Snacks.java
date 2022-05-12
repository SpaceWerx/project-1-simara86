package vendingMachine;

import java.util.ArrayList;
import java.util.Scanner;

public class Snacks extends Products{
	private int id;
	private  ArrayList<Snacks> food = new ArrayList<>();
	public Snacks() {
		}
	public Snacks( int id, String brand, double price) {
		super(brand, price);
		this.id= id;	
	}
	public int getId() {
		return id;
	}
	public ArrayList<Snacks> getFood() {
		return food;
	}
	public String toString() {
	return  "          "+ getId() + "  " +  getBrand()+ " $" + getPrice();	
	}
	@Override
	public  void productsAvailable() {
		System.out.println("************ Available Snacks ************\n");
	}
	public void setSnacks() {
		Scanner snackInput= new Scanner(System.in);
			
	 Snacks s = new Snacks();
		
		Snacks snack1 = new Snacks( 1, "Reese's ", 1.00);
		Snacks snack2 = new Snacks (2, "KitKat  ", 1.50);
		Snacks snack3 = new Snacks (3, "Doritos ", 1.50);
		Snacks snack4 = new Snacks (4, "Lay's   ", 1.50);
		Snacks snack5 = new Snacks (5, "Cheetos ", 1.50);
		
		ArrayList<Snacks> food = new ArrayList<>();
		food.add(snack1);
		food.add(snack2);
		food.add(snack3);
		food.add(snack4);
		food.add(snack5);
		//Enchanced for loop to iterate throug ArrayList
    for (Snacks f: food){
        System.out.println(f);	
		}
		System.out.print("Enter your Money: ");
	    double moneyInserted= snackInput.nextDouble();
		System.out.print("Select your product: ");
		int snackselected =snackInput.nextInt();
		
	switch (snackselected) {
	case 1:
	 
	if ( moneyInserted >= snack1.getPrice() ) {
		
		System.out.println("Vending...");
		System.out.println("Here's your " + snack1.getBrand());
		double change = (double)moneyInserted - snack1.getPrice();
		System.out.println("Take your change: $" + change);
	}
	else {
		System.out.println (" Not enough fund");
	}
		break; 

  case 2: 
    	
			if ( moneyInserted >= snack2.getPrice() ) {	
				System.out.println("Vending...");
				System.out.println("Here's your " + snack2.getBrand());
				double change = (double)moneyInserted - snack2.getPrice();
				System.out.println("Take your change: $" + change);	
			}
			else {
				System.out.println (" Not enough fund");
			}
			break;  
		   case 3:
			
			if ( moneyInserted >= snack3.getPrice() ) {
				
				System.out.println("Vending...");
				System.out.println("Here's your " + snack3.getBrand());
				double change = (double)moneyInserted - snack3.getPrice();
				System.out.println("Take your change: $" + change);		
			}
			else {
				System.out.println (" Not enough fund");
			}
	        break;
		
		    case 4: 
	     
			if ( moneyInserted >= snack4.getPrice() ) {
				
				System.out.println("Vending");
				System.out.println("Here's your " + snack4.getBrand());
				double change = (double)moneyInserted - snack4.getPrice();
				System.out.println("Take your change: $" + change);
				
			}
			else {
				System.out.println (" Not enough fund");
			}
	
          break;
          
		  case 5: 
       
           if ( moneyInserted >= snack5.getPrice() ) {
			System.out.println("Vending");
			System.out.println("Here's your " + snack5.getBrand());
			double change = (double)moneyInserted - snack5.getPrice();
			System.out.println(change + " in change");
			
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
