
package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Role;

import models.User;

import repositories.UserDAO;

public class UserService {
	
		
static UserDAO userDAO = new UserDAO();
	

	
	public static User getUserByUsername(String username) {
		return userDAO.getByUsername(username);
	}
//////////////////////////////////////////////////
	
	public List<User> getAllUsers() {
		return userDAO.getAllUsers();
	}
/////////////////////////////////////////////////////////////////////////////////////////////////	
	public void UserExistsById(int id) {
	for(User user : userDAO.getAllUsers()) {
		if(user.getUserId()== id) {
			System.out.println("This ID exists");
			break;
		}
	}
		System.out.println("This ID does not exist");
}
//////////////////////////////////////////////	
	public List<User> getUserByRole(Role role){
		List<User> byRole = new ArrayList<>();
		for(User user : userDAO.getAllUsers()) {
			if(user.getRole() == role) 
			{
				byRole.add(user);
			}
		}
		
		return byRole;
	}
/////////////////////////////////////////////////////////////////////////
	public static User getUserById(int id) {
		return userDAO.getUserById(id);
	}
//////////////////////////////////////////////////////////////////////////
	public void addUser(User newEmployee) throws SQLException {
		
		//take in the Employee object sent from the menu and send it to the EmployeeDAO to be inserted into the database
		
		//call the DAO method that inserts the new Employee
		userDAO.create(newEmployee);
	}

	public boolean checkUserExistsById(int id) {
		return false;
	}
}



