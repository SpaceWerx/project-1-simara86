package service;

import models.Role;
import models.User;
import repositories.UserDAO;

public class AuthService {
	UserDAO userDAO = new UserDAO();

	public  int login(String username, String password) {

        try {

            User user = UserDAO.getByUsername(username);

            if(user!=null && password.equals(user.getPassword()) && user.getRole()== Role.Manager) {
                System.out.println("Manager Logged In Successfully!");
                return 1;
             
            } else if (user!=null && password.equals(user.getPassword()) && user.getRole()== Role.Employee) {

                System.out.println("Employee Logged In Successfully!");
                return 2;
            } else {

                System.out.println("Username or Password Does Not Exist!");
                return 0;
            }
        } catch (Exception e) {
            System.out.println("Login Unsuccessful");
            e.printStackTrace();
            return 0;
        }
     
        
	}

public static int register(User userToBeRegistered) {

    if(UserDAO.getByUsername(userToBeRegistered.getUsername()) != null) {

        throw new NullPointerException("Username is already taken");
    }

    return UserDAO.create(userToBeRegistered);
	}
}

//public class AuthService {
	
// UserDAO userDAO = new UserDAO();
//	
//
//	//making a new user object
//public  int register (User userToBeRegistered) {
//	
//	// checking if the username already exists in the database
//	// if the method returns null, the username is available
//	
//	if (userDAO.getByUsername(userToBeRegistered.getUsername()) !=null){
//		
//		//Throws a NullPointerException if username is already taken
//		throw new NullPointerException("User is already taken");
//	}
//	return userDAO.create(userToBeRegistered);
//	
//}
//////////////////////////////////Login////////////////////////////////////////////////////
//public int login(String username, String password) {
//	if(username.equals("manager") && password.equals("password")) {
//		return 1;
//	}
//	else if(username.equals("employee") && password.equals("password")) {
//		return 2;
//	}
//	else {
//		return 0;
//	}
//}
////public int login (String username, String password) {
////	//Instantiating a temporary user
////	
////	
////	//Will catch any exceptions thrown by the userDao methods
////	try {
////		User user = UserDAO.getByUsername(username);
////		//Retrieving the user data from database from the username given
////		user = UserDAO.getByUsername(username);
////		
////		if(user != null && password.equals(user.getPassword())) {
////			
////			System.out.println("Logged In Successfully!");
////			return 1;
////			
////		}else if (user!=null && !password.equals(user.getPassword())) {
////			System.out.println("Wrong Password");
////			return 2;
////		}
////	}catch (Exception e){
////		System.out.println("User does not exist!");
////		e.printStackTrace();
////	}
////	//If the try/catch does not run, a null object is returned and login is deemed unsuccessful
////	return 0;
////}
////public static Object login(int anyInt) {
////	// TODO Auto-generated method stub
////	return null;
////}
////public static Object update(String string) {
////	return null;
////}
//}
