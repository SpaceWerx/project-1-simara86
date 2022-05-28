package controllers;

import java.util.Objects;		

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.http.HttpCode;
import models.User;
import service.AuthService;

import service.AuthService;

import io.javalin.http.Handler;

public class AuthenticationController {
	AuthService as = new AuthService();
	
	ObjectMapper Mapper = new ObjectMapper();
	public void handleRegister(Context ctx) {
		
		try {
			
			String input = ctx.body();
			
			User user = Mapper.readValue(input, User.class);
			
			int id = AuthService.register(user);
			
			if(id == 0) {
				
				ctx.status(HttpCode.INTERNAL_SERVER_ERROR);
				ctx.result("Registration unsuccessful.");
			}
			
		} catch (Exception e) {
			
			ctx.status(HttpCode.INTERNAL_SERVER_ERROR);
			
			if(!e.getMessage().isEmpty()) {
				ctx.result(e.getMessage());
			}
			
			e.printStackTrace();
		}

///////////////////////////////////////////////////////////////
	}
	
	
	public Handler loginHandler = (ctx) -> {
		String body = ctx.body();
		
		Gson gson = new Gson();
		//I recommend you make this an employee object 
		User u = gson.fromJson(body, User.class);

		if(as.login(u.getUsername(), u.getPassword()) == 1) {
			ctx.status(201);
			ctx.result("Manager Login Sucessful!");
		}
		else if(as.login(u.getUsername(), u.getPassword()) == 2) {
			ctx.status(202);
			ctx.result("Employee Login Sucessful!");
		}
		else {
		ctx.result("Login Failed!");
		ctx.status(401);
		}
	};
	
	
}
//
//
//import java.util.Objects;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.google.gson.Gson;
//import io.javalin.http.Handler;
//import io.javalin.http.HttpCode;
//import models.User;
//import service.AuthService;
//
//public class AuthenticationController {
//	
//	AuthService as = new AuthService();
//	
//
//	
//	
//	
//	
//
//    public Handler handleLogin = (ctx) -> {
//        String body = ctx.body();
//
//        Gson gson = new Gson();
//        //I recommend you make this an employee object 
//        User u = gson.fromJson(body, User.class);
//
//        if(as.login(u.getUsername(), u.getPassword()) == 1) {
//            ctx.status(201);
//            ctx.result("Manager Login Sucessful!");
//        }
//        else if(as.login(u.getUsername(), u.getPassword()) == 2) {
//            ctx.status(202);
//            ctx.result("Employee Login Sucessful!");
//        }
//        else {
//        ctx.result("Login Failed!");
//        ctx.status(401);
//        }
//    };
////		
////		public Handler handleLogin= (ctx)->{
////			 String username = ctx.formParam("username");
////			 String password = ctx.formParam("password");
////			 
////			 if(Objects.equals(username, "")|| Objects.equals(password,"")){
////				 
////				 //Returning a bad request status and message
////				 ctx.status(HttpCode.BAD_REQUEST);
////				 ctx.result("Invalid Credentials");
////				 
////			 }else {
////				 
////				 User user = as.login(username, password);
////				 
////				 
////				 if (user != null) {
////					 
////					 ctx.status(HttpCode.ACCEPTED);
////					 
////				 }
////			 }
////			 
////			 
////			 		
////		};
//	
//	
//	
//	
//
//	public Handler handlerRegister =(ctx)-> {
//		// Try/catch block to catch any exceptions thrown
//		
//		try {
//			String input = ctx.body();
//			Gson gson = new Gson();
//				
//				//Instantiating and using  the object mapper
//				//This will parse the input string to a User object and store it in the local variable
//			ObjectMapper mapper = new ObjectMapper();
//			   User user = mapper.readValue(input, User.class);
//			    
//			    // Once the user object is created, storing the positive integer ID from the register service method
//			    int id = as.register(user);
//			    
//			    //Id ID is still 0, the registration was unsuccessful
//			    if(id ==0) {
//			    	//Testing the client that registration failed
//			    	ctx.status(HttpCode.INTERNAL_SERVER_ERROR);
//			    	ctx.result("Registration successfull");
//			    }else {
//			    	//Proclaiming successful creation of new user
//			    	ctx.status(HttpCode.CREATED);
//			    	ctx.result("Registration successfull");
//			    	
//			    }
//			    
//			    //Casting any exceptions thrown 
//			    
//		}catch (Exception e) {
//			//Returning 500 status 
//			ctx.status(HttpCode.INTERNAL_SERVER_ERROR);
//			
//			//If the exception has a message, send it back in the body
//			if(!e.getMessage().isEmpty()) {
//				ctx.result(e.getMessage());
//			}
//			//Stacktrace to help debug the server
//			e.printStackTrace();
//		}
//	};
//}
//
//
