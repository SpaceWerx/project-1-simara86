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

}
