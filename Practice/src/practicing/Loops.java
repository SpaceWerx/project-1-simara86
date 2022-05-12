package practicing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public  class Loops {
	public static void main (String[] args) {

	int [] colors= {1,2,3,4,5};
	
	List<String>cars=new ArrayList<String>();
	cars.add("Mitsubishi");
	cars.add("Mazda");
	cars.add("Honda");
	System.out.println(cars.get(0));
	System.out.println("--------------------------------------------------");
	
	//For each loop
	for(String c : cars) {
		System.out.println(c); 
		
	}
	System.out.println("--------------------------------------------------");
   //For loop for the array 
	for (int i=0; i< colors.length;i++ ) {
		if(colors[i]%2!=1) {
		System.out.println(colors[i]);
		}
	}
	System.out.println("--------------------------------------------------");
	
	//While Loop
	int a= 5;
	while(a==5) {
		System.out.println("Hello, World");
		break;
	}
	System.out.println("--------------------------------------------------");
//	Do While loop 
	do {
		
		System.out.println("This a Do-While loop");
		
	}while (a==15);
	
	System.out.println("--------------------------------------------------");
	
	//For loop with a variable
	for (int b=1; b<= 5; b++) {
		System.out.println(b);
	}
	System.out.println("--------------------------------------------------");
	
	int originalNumber = 2;
	Scanner sc = new Scanner(System.in);
	int m = sc.nextInt();
	for (int i = 1; i <= 10; i++) {
	    int multiple = originalNumber * i;
	    System.out.println(multiple);
	    // Use multiple however you want to
	}
	
	}
	
	}


   