package controllers;

import java.util.Objects;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.javalin.http.Context;
import io.javalin.http.HttpCode;
import models.User;
import service.AuthService;

public class AuthenticationController {
	
	AuthService authService = new AuthService();
	
	public void handleLogin (Context ctx) {
		
		//Reading the form parameters from the http request with the respective string keys.
		//Storing the form parameters form parameters in local variables;
		
		String username = ctx.formParam("username");
		String password = ctx.formParam("password");
		
		//Checking to make sure that the appropriate forms are provided
		if (Objects.equals(username, "") || Objects.equals(password, "")){
			
			//Returning a bad request status and message
			ctx.status(HttpCode.BAD_REQUEST);
			ctx.result("Invalid Credentials");
			
		}else {
			
			// Calling the authService login method
			User user = authService.login(username, password);
			
			//Ensuring the user was found and accepted
			//The service returns null if unsuccessful
			
			if(user !=null) {
				
				//Sending accepted status code
				ctx.status(HttpCode.ACCEPTED);
				//Giving the front-end access to the response headers
				ctx.header("Access-Control-Expose-Headers","Current-User");
				//Returning a Current-User header for authentication 
				ctx.header("Current-User",""+user.getUserId());
				//Sending user role for portal navigation
				ctx.result(user.getRole().toString());
				
			}else {
				
				
				//Sending bad request and message if unsuccessful login service method
					ctx.status(HttpCode.BAD_REQUEST);
					ctx.result("Invalid Credentials");
				}
			}
		}
	
	
	
	
	
	
	
	
	

	public void handlerRegister(Context ctx) {
		// Try/catch block to catch any exceptions thrown
		
		try {
			String input = ctx.body();
				
				//Instantiating and using  the object mapper
				//This will parse the input string to a User object and store it in the local variable
			ObjectMapper mapper = new ObjectMapper();
			    User user = mapper.readValue(input, User.class);
			    
			    // Once the user object is created, storing the positive integer ID from the register service method
			    int id = authService.register(user);
			    
			    //Id ID is still 0, the registration was unsuccessful
			    if(id ==0) {
			    	//Testing the client that registration failed
			    	ctx.status(HttpCode.INTERNAL_SERVER_ERROR);
			    	ctx.result("Registration successfull");
			    }else {
			    	//Proclaiming successful creation of new user
			    	ctx.status(HttpCode.CREATED);
			    	ctx.result("Registration successfull");
			    	
			    }
			    
			    //Casting any exceptions thrown 
			    
		}catch (Exception e) {
			//Returning 500 status 
			ctx.status(HttpCode.INTERNAL_SERVER_ERROR);
			
			//If the exception has a message, send it back in the body
			if(!e.getMessage().isEmpty()) {
				ctx.result(e.getMessage());
			}
			//Stacktrace to help debug the server
			e.printStackTrace();
		}
	}
}


