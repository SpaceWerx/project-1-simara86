package repositories;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.SSLEngineResult.Status;

import models.Reimbursement;
import models.ReimbursementType;
import models.Role;
import models.User;
import utilities.ConnectionFactory;

public class UserDAO {


	

	
	public User getUserById (int id) {
		try(Connection conn = ConnectionFactory.getConnection()){
			
			String sql = "select * from ers_users where id = ?";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
			
            if (resultSet.next()) {
                return new User(
                    resultSet.getInt("id"),
                    resultSet.getString("username"),
                    resultSet.getString("password"),
                    Role.valueOf(resultSet.getString("role"))
                        );
            }
        } catch (SQLException e) {

            System.out.println("Something went wrong with getting user by id via the database!");
            e.printStackTrace();
        }
        return null;
    }



	

	public static User getByUsername(String username){
         
		try(Connection conn = ConnectionFactory.getConnection()){
			
			ResultSet resultSet = null;
			String sql = "select * from user where user_username = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			
			
			ps.setString(1, username);
			
			resultSet = ps.executeQuery();
			
			List<User> userList = new ArrayList<>();
			
			if (resultSet.next()) {
                return new User(
                    resultSet.getInt("id"),
                    resultSet.getString("username"),
                    resultSet.getString("password"),
                    Role.valueOf(resultSet.getString("role"))
                        );
            }		
		}
		catch(SQLException e) {
			System.out.println("Something went wrong");
			e.printStackTrace();
		}		
		
		return null;
	}

	public List<User> getAllUsers(){
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
	
	public int create(User userToBeRegistered) {
		try (Connection connection = ConnectionFactory.getConnection()) {
			String sql = "INSERT INTO ers_users (id, username, password, role) "
					+ "VALUES (?,?,?::type, ?)"
					+ "RETURNING ers_user.id";
			
           // We must use a prepared statement because we have parameters
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			// use the PreparedStatement objects methods to insert values into the query's ?s
			// the value will come from the Reimbursement object we send in.
			
			preparedStatement.setInt(1, userToBeRegistered.getUserId());
			preparedStatement.setString(2, userToBeRegistered.getUsername());
			preparedStatement.setObject(4, userToBeRegistered.getPassword());
			preparedStatement.setObject(3, userToBeRegistered.getRole().name());
						
			
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

	

