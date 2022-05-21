package controllers;

import io.javalin.http.Context;
import io.javalin.http.HttpCode;
import models.Reimbursement;
import service.ReimbursementService;

public class ReimbursementController {
	
	public void handleSubmit(Context ctx) {
		
		try {
			//Storing the json object input as a string
			String input = ctx.body();
			
			//Utilizing the object mapper to parse the input into a reimbursement object
			Reimbursement reimbursement = objectMapper.readValue(input, Reimbursement.class);
			
			//Strong the positive integer ID that is returned from the service method
			int id = reimbursementService.submitReimbursement(reimbursement);
			
			//IF the ID is still 0, the submission was unsuccessful
			
			if(id != 0) {
				//Proclaim victory and returning the ID 
				ctx.status(HttpCode.CREATED);
				ctx.result(""+id);
				
				
			}else {
				ctx.status(HttpCode.BAD_REQUEST);
				ctx.result("Reimbursement submission was unsuccessful");
			}
			
	}catch (Exception e) {
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
