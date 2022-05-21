package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.SSLEngineResult.Status;

import models.Reimbursement;
import models.ReimbursementType;
import models.Role;
import models.User;
import utilities.ConnectionFactory;

public class UserDAO {
	
	
	
	public List<User> getUserById(int userId) {
		try(Connection conn = ConnectionFactory.getConnection()){
			
			ResultSet resultSet = null;
			
			String sql = "select * from user where user_id = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, userId);
			
			resultSet = ps.executeQuery();
			
			List<User> userList = new ArrayList<>();
			
			while(resultSet.next()) {
				User u = new User(
						resultSet.getInt("user_id"),
						resultSet.getString("username"),
						resultSet.getString("password"),
						Role.valueOf(resultSet.getString("role"))
					);
				userList.add(u);
			}
			return userList;			
		}
		catch(SQLException e) {
			System.out.println("Something went wrong");
			e.printStackTrace();
			return null;
		}		
		
	}

	public List<User> getUserByUsername(String username){
         
		try(Connection conn = ConnectionFactory.getConnection()){
			
			ResultSet resultSet = null;
			String sql = "select * from user where user_username = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			
			
			ps.setString(1, username);
			
			resultSet = ps.executeQuery();
			
			List<User> userList = new ArrayList<>();
			
			while(resultSet.next()) {
				User u = new User(
						resultSet.getInt("user_id"),
						resultSet.getString("username"),
						resultSet.getString("password"),
						Role.valueOf(resultSet.getString("role"))
					);
				userList.add(u);
			}
			return userList;			
		}
		catch(SQLException e) {
			System.out.println("Something went wrong");
			e.printStackTrace();
			return null;
		}		
		
	}
	public List<User> getAllUser(){
		try (Connection connection = ConnectionFactory.getConnection()) {
			
			List<User> users = new ArrayList<>();
			
			String sql = "select * from ers_reimbursement";
			java.sql.Statement statement = connection.createStatement();
		
			
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()) {
				// Adding reimbursements to the list with the data extracted from the database
				users.add(new User(
						resultSet.getInt("userId"),
						resultSet.getString("username"),
						resultSet.getString("password"),
						Role.valueOf(resultSet.getString("role"))
						));
				
			}
			
					return users;
			
		}catch (SQLException e) {
			System.out.println("Something went wrong with database!");
			e.printStackTrace();
		}
		return null;

		}
	
	public int create(User createdUser) {
		try (Connection connection = ConnectionFactory.getConnection()) {
			String sql = "INSERT INTO ers_users (id, username, password, role) "
					+ "VALUES (?,?,?::type, ?)"
					+ "RETURNING ers_user.id";
			
           // We must use a prepared statement because we have parameters
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			// use the PreparedStatement objects methods to insert values into the query's ?s
			// the value will come from the Reimbursement object we send in.
			
			preparedStatement.setInt(1, createdUser.getUserId());
			preparedStatement.setString(2, createdUser.getUsername());
			preparedStatement.setObject(4, createdUser.getPassword());
			preparedStatement.setObject(3, createdUser.getRole().name());
						
			
			ResultSet resultSet;
			
			// Here we are checking that the sql query executed and returned the User record with the new id
			
			if((resultSet = preparedStatement.executeQuery()) !=null) {
				//must call this to get the returned reimbursement record id
				resultSet.next();
				return resultSet.getInt(1);
			}
				
			}catch (SQLException e) {
				System.out.println("Creating reimbursement has failed");
				e.printStackTrace();
			}
		return 0;
		}
		
	
	
}
