package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
		
	}
	
}
