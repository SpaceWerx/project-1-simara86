package launcher;

import java.sql.Connection;
import java.sql.SQLException;


import controllers.AuthenticationController;
import controllers.ReimbursementController;
import controllers.UserController;
import io.javalin.Javalin;

//import models.Menu;
import utilities.ConnectionFactory;

public class Driver {
	
	
	public static void main(String[] args) throws SQLException {
	
		UserController uc = new UserController();
		AuthenticationController ac = new AuthenticationController();
		ReimbursementController rc = new ReimbursementController();
		
		//Testing Database Connectivity - just testing whether our Connection (from ConnectionFactory) is successful
		try(Connection conn = ConnectionFactory.getConnection()){
			System.out.println("Connection Successful :)");
		} catch(SQLException e) {
			System.out.println("Connection failed");
			e.printStackTrace();
		}	

	
		//Make the menu	run, its only 2 lines of code	
//CLI_Menu_Service  menu = new CLI_Menu_Service();
////			
//menu.displayMenu();
//		
		
		Javalin app = Javalin.create(
				config -> {
					config.enableCorsForAllOrigins(); //This is what allows tech server to process JS requests from anywhere
				}
			).start(3000);
		
			//Now we need our endpoint
		app.get("/employee", uc.getEmployeesHandler); //get employee list

        app.post("/employee", uc.insertEmployeesHandler); //create employee

        app.post("/login", ac.loginHandler); //login

        app.get("/status", rc.handleGetReimbursmentByStatus); //status of pending requests

        app.get("/reimbursement", rc.handleGetReimbursements); //status of ALL reimbursements approved or denied or pending

        app.get("/{id}", rc.handleGetReimbursementById); //show you the reimbursement based on id same ID

        app.post("/submit", rc.handleSubmit); //Submit a reimbursement
        
       // app.put("/approved", rc.handleApproved);
        
       // app.put("/denied", rc.handleDenied);

        app.put("/process", rc.handleProcess); //approve or deny any reimbursement

        app.get("/author", rc.handleGetReimbursementByAuthor); //same as id except with author
			
		
	}
	
	}

