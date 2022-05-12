package vendingMachine;

public abstract class Products {
	//abstract class Product (parent class): blue print for my Drinks and Snacks classes 
	private String brand;
	private double price; 
	
	public Products() {
		}
	public Products(String brand, double price) {
		this.brand = brand;
		this.price = price;
	}
	
	public String getBrand() {
		return brand;
	}
    public double getPrice(){
	   return price; 
}
   
abstract public void productsAvailable();
  
    static void instructions() {
    	System.out.println("     Welcome to Vending Machine\n");
    	System.out.println(" Select 1 for Snacks and 2 for Drinks");
    }	
	}
