package controllers;

import java.util.List;

import com.google.gson.Gson;

import io.javalin.http.Handler;
import models.User;
import service.UserService;

public class UserController {
	UserService es = new UserService();

	public Handler getEmployeesHandler = (ctx) ->{
		List<User> allUsers =es.getAllUsers();
		
		Gson gson = new Gson();
		String JSONObject = gson.toJson(allUsers);
		
		ctx.result(JSONObject);
		ctx.status(200);
	};
	

	public Handler insertEmployeesHandler = (ctx) ->{
		String body = ctx.body();
		
		Gson gson = new Gson();
		
		User employee = gson.fromJson(body, User.class);
		
		//es.addUser(employee);
		
		ctx.result("Employee successfully added!");
		ctx.status(201);
		
	};
}
