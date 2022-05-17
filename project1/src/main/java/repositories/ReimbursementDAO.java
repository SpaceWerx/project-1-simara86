package repositories;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.SSLEngineResult.Status;

import models.Reimbursement;
import models.ReimbursementType;
import utilities.ConnectionFactory;

public class ReimbursementDAO {
	public Reimbursement getReimbursementById(int id) {
		
		// try/catch block to catch SQL exception that can be thrown with connection
		try(Connection connection = ConnectionFactory.getConnection()){
			String sql = "select * from ers_reimbursemets where id =?";
		//when we need parameters we need to use a PREPARED Statement, as opposed to a Statement (seen above)
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		//insert the methods arguments (int id) as the first (and only variable in our SQL query
		preparedStatement.setInt(1, id);
		
		ResultSet resultSet =preparedStatement.executeQuery();
		
		//if there are resut in the result set...
		if(resultSet.next()) {
			
			//return a reimbursement with the data to be returned to the service layer
			return new Reimbursement(
					resultSet.getInt("id"),
					resultSet.getInt("author"),
					resultSet.getInt("resolver"),
					resultSet.getInt("description"),
					ReimbursementType.valueOf(resultSet.getString("type")),
					Status.valueOf(resultSet.getString("status")),
					resultSet.getDouble("amount")
					);
		}
			
		}catch(SQLException e) {
			System.out.println("Something went wrong with the database!");
			e.printStackTrace();
		}
		// Fail-safe if the try/catch block does not run
	
	return null;

}
	
	public List<Reimbursement>getReimbursementsByUser (int userId) {
		
		// try/catch block to catch SQL exception that can be thrown with connection
		try (Connection connection = ConnectionFactory.getConnection()) {
			String sql = "select * from ers_reimbursement where author = ?";
		
			//Preparing the sql statement to be execute once we fill the query parameter (userId)
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			//Filling the missing query value (?) with the method parameter (userId)
			preparedStatement.setInt(1, userId);
			
			
			
			//Building a sql result set from the execution of the query statement
			ResultSet resultSet = preparedStatement .executeQuery();
			
			//Initializing a new Reimbursement array list to house and return with the data from the database
			List<Reimbursement> reimbursements = new ArrayList<>();
			
			//This while loop will continue to ass reimbursements to the list
			//until all the data from the result set has run out 
			
			while(resultSet.next()) {
				// Adding reimbursements to the list with the data extracted from the database
				reimbursements.add(new Reimbursement(
						resultSet.getInt("id"),
						resultSet.getInt("author"),
						resultSet.getInt("resolver"),
						resultSet.getInt("description"),
						ReimbursementType.valueOf(resultSet.getString("type")),
						Status.valueOf(resultSet.getString("status")),
						resultSet.getDouble("amount")	
						));
				
			}
			
					return reimbursements;
			
		}catch (SQLException e) {
			System.out.println("Something Went Wrong Obtaining Your List!");
			e.printStackTrace();
		}
		return null;
		
	}
	
	public List<Reimbursement> getByStatus(Status status){
		try (Connection connection = ConnectionFactory.getConnection()) {
			String sql = "select * from ers_reimbursement where status = ?::status";
		
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, status.toString());
			
			ResultSet resultSet = preparedStatement .executeQuery();
			
			List<Reimbursement> reimbursements = new ArrayList<>();//Upcasting,we ate instantiating an ArrayList
			while(resultSet.next()) {
				// Adding reimbursements to the list with the data extracted from the database
				reimbursements.add(new Reimbursement(
						resultSet.getInt("id"),
						resultSet.getInt("author"),
						resultSet.getInt("resolver"),
						resultSet.getInt("description"),
						ReimbursementType.valueOf(resultSet.getString("type")),
						Status.valueOf(resultSet.getString("status")),
						resultSet.getDouble("amount")	
						));
				
			}
			
					return reimbursements;
			
		}catch (SQLException e) {
			System.out.println("Something Went Wrong Obtaining the reimbursement!");
			e.printStackTrace();
		}
		return null;

		}
	
	public List<Reimbursement> getAllReimbursement(){
		try (Connection connection = ConnectionFactory.getConnection()) {
			
			List<Reimbursement> reimbursements = new ArrayList<>();
			
			String sql = "select * from ers_reimbursement";
			java.sql.Statement statement = connection.createStatement();
		
			
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()) {
				// Adding reimbursements to the list with the data extracted from the database
				reimbursements.add(new Reimbursement(
						resultSet.getInt("id"),
						resultSet.getInt("author"),
						resultSet.getInt("resolver"),
						resultSet.getInt("description"),
						ReimbursementType.valueOf(resultSet.getString("type")),
						Status.valueOf(resultSet.getString("status")),
						resultSet.getDouble("amount")	
						));
				
			}
			
					return reimbursements;
			
		}catch (SQLException e) {
			System.out.println("Something went wrong with database!");
			e.printStackTrace();
		}
		return null;

		}
}
