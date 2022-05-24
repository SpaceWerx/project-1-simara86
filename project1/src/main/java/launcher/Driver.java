package launcher;
import java.sql.Connection;
import java.sql.SQLException;

import controllers.AuthenticationController;
import controllers.UserController;
import io.javalin.Javalin;
//import models.Menu;
import utilities.ConnectionFactory;

public class Driver {
	
	
	public static void main(String[] args) throws SQLException {
	
		UserController us = new UserController();
		AuthenticationController ac = new AuthenticationController();
		
		//Testing Database Connectivity - just testing whether our Connection (from ConnectionFactory) is successful
		try(Connection conn = ConnectionFactory.getConnection()){
			System.out.println("Connection Successful :)");
		} catch(SQLException e) {
			System.out.println("Connection failed");
			e.printStackTrace();
		}	

	
		//Make the menu	run, its only 2 lines of code	
	//	Menu menu = new Menu();
			
	//	menu.displayMenu();
		
		
		Javalin app = Javalin.create(
				config -> {
					config.enableCorsForAllOrigins(); //This is what allows tech server to process JS requests from anywhere
				}
			).start(3000);
		
			//Now we need our endpoints
			app.get("/employee", us.getEmployeesHandler);
			
			app.post("/employee", us.insertEmployeesHandler);
			
			//In the future, we will also add a log in function
		//	app.post("/login", ac.loginHandler);
			
			
		
	}
	
	}

