//package service;
//
//import java.util.List;
//
//import models.Reimbursement;
//import models.ReimbursementType;
//import models.Role;
//import models.User;
//
//public class CLI_Menu_Service{
//	public void displayMenu() {
//		boolean menuOptions = true; //Using this to let the menu continue after user input
//		
//		//Greetings for the user
//		System.out.println("-----------------------------------------------------------");
//		System.out.println("Welcome to the Revature Reimbursement System");
//		System.out.println("-----------------------------------------------------------");
//		System.out.println();
//		
//		//display the menu as long as the menuOptions boolean == true
//		//display all my menu options until boolean == false
//		while (menuOptions) {
//			System.out.println("PLEASE ENTER THE NUMBER OF YOUR CHOICE");
//			System.out.println("1- Employee Portal");
//			System.out.println("2- Finance Manager Portal");
//			System.out.println("0- Exit Application");
//			
//		// The user choose a menu option and the scanner takes the input and put into an int variable
//		// Calls the promptSelection() helper method to handle validation
//		// The parameters list the valid options that the user must choose from
//		int firstChoice = promptSelection(1,2,0);
//		
//		//Take the user input and the switch statement executes the appropriate code
//		switch (firstChoice) {
//		
//		case 1: 
//			handlePortal(Role.EMPLOYEE);
//			break;
//		case 2: 
//			handlePortal(Role.MANAGER);
//			break;
//		case 0:
//			System.out.println("\nHAve a greate day! Goodbye. ");
//			menuOptions=false;
//			break;
//		}
//	}//end of the while loop
//		
//			
//}//end of displayMenu method
//	public void displayEmployeeMenu(User employee) {
//		boolean employeePortal = true;
//		
//		System.out.println("--------------------------------------------------------------");
//		System.out.println("PLEASE ENTER THE NUMBER OF YOUR CHOICE");
//		System.out.println("--------------------------------------------------------------");
//		System.out.println();
//		while (employeePortal) {
//		
//		//The user choose a menu option and the scanner takes the input and put  it into and int variable
//		int employeeChoice = promptSelection(1,2,0);
//		
//		switch (employeeChoice) {
//		case 1: 
//			displayPreviousRequest(employee);
//			break;
//		case 2: 
//			displayReimbursement(employee);
//			break;
//		case 0:
//			System.out.println("Returning to Main Menu...");
//			employeePortal= false;
//			break;
//		}
//		
//	}
//	
//}
//	public void displayFinanceManagerMenu (User manager) {
//		boolean managerPortal = true;
//		
//		System.out.println("--------------------------------------------------------");
//		System.out.println("PLEASE ENTER THE NUMBER OF YOUR CHOICE");
//		System.out.println("--------------------------------------------------------");
//		System.out.println();
//		
//		while (managerPortal) {
//			
//			int managerChoice = promptSelection(1,2,3,0);
//			
//			switch (managerChoice) {
//			case 1:
//				displayPendingReimbursements();
//				break;
//			case 2:
//				displayResolvedReimbursements();
//			case 3:
//				displayReimbursement(manager);
//				break;
//			case 0:
//				System.out.println("Returning to Main Menu...");
//				managerPortal = false;
//				break;
//			}
//		}
//		
//		
//		
//	}
//	public String fetchInput() {
//		return scan.nextLine().split("")[0];
//		
//	}
//	
//	public int promptSelection(int  ...validEntries) {
//		int input;
//		boolean valid = false;
//		
//		do {
//			input = parseIntegerInput(fetchInput());
//			
//			for (int entry : validEntries) {
//				if (entry == input) {
//					// if it does, we activate the flag, which will end the do-while loop
//					valid = true;
//					break;
//					
//				}
//				if (!valid) {
//					System.out.println("Input received was not a valid option, please try again. ");
//				}
//			}
//			
//		}while(!valid);
//		return input;
//		
//		
//		
//		
//	}
//	
//  	public int paseIntegerInput(String input) {
//	
//	try {
//		return Integer.parseInt(input);
//	}catch (NumberFormatException e) {
//		System.out.println("The input received was not valid, please try again.");
//		return -1;
//	}
//	
//}
//  	public Double parseDoubleInput(String input) {
//  		try {
//  			return Double.parseDouble(input);
//  			
//  		}catch (NumberFormatException e) {
//  			System.out.println("The input received was not valid, please try again.");
//  			return (double) -1;
//  		}
//  		
//  		
//  	}	
//  	public void handlePortal(Role role) {
//  		// get the List of employee from the repository layer
//  		List<User> users = userService.getByROoe(role);
//  		
//  		int[] ids = new int [users.size() + 1];
//  		ids[users.size()] = 0;
//  		for (int i =0; i < users.size();i++) {
//  			ids[i] = users.get(i).getUserId();
//  		}
//  		
//  		// Ask for employee Id number to continue
//  		System.out.println("-------------------------------------------------------");
//  		System.out.println("PLEASE ENTER THE NUMBER OF YOUR CHOICE");
//  		
//  		// enhanced for loop to print out all users one by one
//  		for (User u : users) {
//  			System.out.println(u.getUserId() + "->" + u.getUsername());
//  		}
//  		System.out.println("0 - Return to Main Menu");
//  		System.out.println();
//  		
//  		int userChoice = promptSelection(ids);
//  		
//  		if (userChoice == 0) {
//  			return;
//  		}
//  		User employee = userService.getUsersById(userChoice);
//  		
//  		if (role == Role.MANAGER) {
//  			System.out.println("Opening Manager Portal for " + employee.getUsername());
//  			displayFinanceManagerMenu(employee);
//  		}else {
//  			System.out.println("Opening Employee Portal for " + employee.getUsername());
//  			displayEmployeeMenu(employee);
//  		}
//  		
//  			
//  	 }
//  	public void displayPreviousRequest(User Employee) {
//  		List<Reimbursement> reimbursements =rService.getReimbursementsByAuthor(employee.getUserId());
//  		
//  		if (reimbursements.isEmpty()) {
//  			System.out.println("No Previous REquest...");
//  			System.out.println("Returning to Previous Menu...");
//  		}
//  		for (Reimbursement r : reimbursements) {
//  			System.out.println(r);
//  		}
//  			
//  		}
//  	public void submitReimbursement(User employee) {
//  		Reimbursement reimbursementToBeSubmitted = new Reimbursement();
//  		reimbursementToBeSubmitted.setAuthor(employee.getUserId());
//  		
//  		System.out.println("What type of reimbursement would you like to submit?");
//  		System.out.println("PLEASE ENTER THE NUMBER OF YOUR CHOICE");
//  		System.out.println("1- Lodging");
//  		System.out.println("2- Travel");
//  		System.out.println("3- Food");
//  		System.out.println("4- Other");
//  		int typeDecision = promptSelection( 1,2,3,4);
//  		
//  		switch (typeDecision) {
//  		case 1:
//  			reimbursementToBeSubmitted.setType(ReimbursementType.LODGIN);
//  			break;
//  		case 2:
//  			reimbursementToBeSubmitted.setType(ReimbursementType.TRAVEL);
//  			break;
//  		case 3:
//  			reimbursementToBeSubmitted.setType(ReimbursementType.FOOD);
//  			break;
//  		case 4:
//  			reimbursementToBeSubmitted.setType(ReimbursementType.OTHER);
//  			break;
//  		
//  	}
//  		System.out.println("Please enter the dollar amount you are requesting to be reimbursed: ");
//  		System.out.println("$");
//  		
//  		reimbursementToBeSubmitted.setAmount(parseDoubleInput(fetchInput()));
//  		if(reimbursementToBeSubmitted.getAmount()<=0) {
//  			System.out.println("Invalid Amount has been entered, please input a correct dollar amount. ");
//  			boolean valid = false;
//  			while(!valid) {
//  				reimbursementToBeSubmitted.setAmount(parseDoubleInput(fetchInput()));
//  				if (reimbursementToBeSubmitted.getAmount() !=0) {
//  					valid = true;
//  				}
//  			}
//  		}
//  		System.out.println("Please enter a description/reason for your reimbursement rquest. ");
//  		reimbursementToBeSubmitted.setDescription(scan.nextLine());
//  		if (rtbs)
//  	}

//}
