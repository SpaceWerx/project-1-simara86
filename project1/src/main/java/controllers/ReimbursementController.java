package controllers;

import javax.net.ssl.SSLEngineResult.Status;

import io.javalin.http.Context;
import io.javalin.http.HttpCode;
import models.Reimbursement;
import service.ReimbursementService;


public class ReimbursementController {
	
//	public void handleSubmit(Context ctx) {
//		
//		try {
//			//Storing the json object input as a string
//			String input = ctx.body();
//			
//			//Utilizing the object mapper to parse the input into a reimbursement object
//			Reimbursement reimbursement = objectMapper.readValue(input, Reimbursement.class);
//			
//			//Strong the positive integer ID that is returned from the service method
//			int id = reimbursementService.submitReimbursement(reimbursement);
//			
//			//IF the ID is still 0, the submission was unsuccessful
//			
//			if(id != 0) {
//				//Proclaim victory and returning the ID 
//				ctx.status(HttpCode.CREATED);
//				ctx.result(""+id);
//				
//				
//			}else {
//				ctx.status(HttpCode.BAD_REQUEST);
//				ctx.result("Reimbursement submission was unsuccessful");
//			}
//			
//	}catch (Exception e) {
//		ctx.status(HttpCode.INTERNAL_SERVER_ERROR);
//		
//		//If the exception has a message, send it back in the body
//		if(!e.getMessage().isEmpty()) {
//		ctx.result(e.getMessage());
//	}
//		//Stacktrace to help debug the server
//		e.printStackTrace();
//	}
//
//	}
//	public void handleProcess(Context ctx) {
//		// Retrieving the header sent with the request that stores the ID of the current user
//		String authHeader =ctx.header("Current-User");
//		
//		//Making sure the client sent the header along with the request
//		if(authHeader != null) {
//			//Parsing the ID they sent in the header
//			int userId = Integer.parseInt(authHeader);
//			
//			try {
//				//Retrieving the id from the path parameter as designated in the javalin routes config
//				String reimbursementIdInput = ctx.pathParam("id");
//				
//				//Parsing the reimbursement ID from the path parameter
//				int id= Integer.parseInt(reimbursementIdInput);
//				
//				//Storing the new status sent with the request as a form parameter
//				String statusInput =ctx.formParam("status");
//				
//				//Calling the getReimbursementById method and storing the return value
//				Reimbursement reimbursement = reimbursementService.getReimbursementById(id);
//				
//				//Checking to ensure that the reimbursement exist in the database before updating
//				if(reimbursement !=null) {
//					//Calling the update method and storing the updated reimbursement 
//					Reimbursement processedReimbursement = reimbursemenentService.update(reimbursement, userId,Status.valueOf(statusInput));
//					
//					//Return the processed reimbursement object 
//					ctx.status(HttpCode.ACCEPTED);
//					ctx.json(processedReimbursement);
//				}else {
//					ctx.status(HttpCode.BAD_REQUEST);
//					ctx.result("Reimbursement processing was not successful");
//				}
//				
//			}catch(Exception e) {
//				ctx.status(HttpCode.INTERNAL_SERVER_ERROR);
//				if(!e.getMessage().isEmpty()) {
//					ctx.result(e.getMessage());
//				}
//				
//			e.printStackTrace();
//			}
//			
//			
//		}else {
//			//Telling the client they are missing the authHeader
//			ctx.status(HttpCode.FORBIDDEN);
//			ctx.result("Missing Current User Header with ID");
//			
//		}
//	}
//	
//	public void handleGetReimbursementByStatus(Context ctx) {
//		
//		try {
//			String statusParm =ctx.queryParam("status");
//			
//			Status status = Status.valueOf(statusParm);
//			
//			//Retrieving all pending reimbursement or all resolved reimbursements
//			if(status == Status.PENDING) {
//				ctx.status(HttpCode.OK);
//				ctx.json(reimbursementService.getResolvedReimbursements());
//			}else {
//				ctx.status(HttpCode.OK);
//				ctx.json(reimbursementService.getResolvedReimbursements());
//				
//			}
//		}catch (Exception e) {
//			//Returning 500 status
//			ctx.status(HttpCode.INTERNAL_SERVER_ERROR);
//		if(!e.getMessage().isEmpty()) {
//			
//			ctx.result(e.getMessage());
//		}
//		e.printStackTrace();
//	}
//	}
//	
//	public void handkeGetReimbursementByAuthor(Context ctx) {
//		
//		try {
//			String idParam =ctx.queryParam("author");
//			
//			if(idParam !=null) {
//			int id = Integer.parseInt(idParam);
//			
//			if(userService.checkUserExistById(id)) {
//			ctx.status(HttpCode.OK);
//			ctx.json(reimbursementService.getReimbursementByAuthor(id));
//			
//		}else {
//			ctx.status(HttpCode.NOT_FOUND);
//			ctx.result("Unable to retrieve reimbursement, current user is not in the database");
//		}
//		}else {
//			ctx.status(HttpCode.BAD_REQUEST);
//			ctx.result("Missing Current User header");
//		}
//	}catch (Exception e) {
//		ctx.status(HttpCode.INTERNAL_SERVER_ERROR);
//		
//		if(!e.getMessage().isEmpty()) {
//		ctx.result(e.getMessage());
//		
//	}
//		e.printStackTrace();
//}
//	}
//	
//	public void handleGetReimbursementById(Context ctx) {
//		try {
//			String idParam =ctx.pathParam("id");
//			int id = Integer.parseInt(idParam);
//			
//			Reimbursement reimbursement = ReimbursementService.getReimbursementById(id);
//			
//			if(reimbursement !=null) {
//				ctx.status(HttpCode.OK);
//				ctx.json(reimbursement);
//				
//				
//			}else {
//				ctx.status(HttpCode.BAD_REQUEST);
//				ctx.result("Could not retrieve the reimbursement");
//			}
//			
//			
//			
//		}catch (Exception e) {
//			ctx.status(HttpCode.INTERNAL_SERVER_ERROR);
//			
//			if(!e.getMessage().isEmpty()) {
//				
//				ctx.result(e.getMessage());
//			}
//			e.printStackTrace();
//		}
//		
//	}
//	
//	public void handleGetReimbursements(Context ctx) {
//		
//		if(ctx.queryParam("author")!=null) {
//		
//		handkeGetReimbursementByAuthor(ctx);
//	}else if(ctx.queryParam("status")!=null) {
//	handleGetReimbursementByStatus(ctx);
//	
//	}
//	}
}

