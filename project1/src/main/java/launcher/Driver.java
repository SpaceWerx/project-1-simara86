package launcher;
	import java.util.Scanner;

	public class Driver {
		
		public static void main (String[] args) {
			Scanner scan= new Scanner(System.in);
			
			
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println("*********************************");
				System.out.println();
				System.out.println("Welcome to Reimbursement Menu");
				System.out.println();
				System.out.println("*********************************");
				System.out.println();
				System.out.println();
				System.out.println("Select a number from the following Menu");
				System.out.println();
				System.out.println("1- Lodging");
				System.out.println("2- Travel");
				System.out.println("3- Food");
				System.out.println("4- Other");
				
			switch	(scan.nextInt()) {
			
			case 1: 
				System.out.println("You've selected Lodging");
				break;
				
			case 2:
				System.out.println("You've selected Travel");
				break;
				
			case 3:
				System.out.println("You've selected Food");
				break;
				
			case 4:
				System.out.println("You've selected Other");
				break;
			}
				
				
			}
		}



