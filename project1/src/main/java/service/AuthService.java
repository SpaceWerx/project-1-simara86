package service;

import models.User;
import repositories.UserDAO;

public class AuthService {
	//making a new user object
public int register (User userToBeRegistered) {
	
	// checking if the username already exists in the database
	// if the method returns null, the username is available
	
	if(UserDAO.getByUsername(userToBeRegistered.getUsername()) !=null){
		
		//Throws a NullPointerException if username is already taken
		throw new NullPointerException("User is already taken");
	}
	return userDAO.creare(userToBeRegistered);
	
}
public User login (String username, String password) {
	//Instantiating a temporary user
	User user;
	
	//Will catch any exceptions thrown by the userDao methods
	try {
		//Retrieving the user data from database from the username given
		user = userDAO.getUsername(usrename);
		
		if(user1=null && password.equals(User.getPassword())) {
			
			System.out.println("Logged In Successfully!");
			return user;
			
		}else if (user!=null && !password.equals(Usr.getPassword())) {
			System.out.println("Wrong Password");
			return null;
		}
	}catch (Exception e){
		System.out.println("User does not exist!");
		e.printStackTrace();
	}
	//If the try?catch does not run, a null object is returned and login is deemed unsuccessful
	return null;
}
}
