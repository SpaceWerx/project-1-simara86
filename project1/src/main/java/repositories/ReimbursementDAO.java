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
	
	public int create(Reimbursement reimbursementToBeSubmitted) {
		try (Connection connection = ConnectionFactory.getConnection()) {
			String sql = "INSERT INTO ers_reimbursementd (author, description, type, status, amount) "
					+ "VALUES (?,?,?::type, ?)"
					+ "RETURNING ers_reimbursements.id";
			
           // We must use a prepared statement because we have parameters
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			// use the PreparedStatement objects methods to insert values into the query's ?s
			// the value will come from the Reimbursement object we send in.
			
			preparedStatement.setInt(1, reimbursementToBeSubmitted.getAuthor());
			preparedStatement.setString(2, reimbursementToBeSubmitted.getDescription());
			preparedStatement.setObject(3, reimbursementToBeSubmitted.getType().name());
			preparedStatement.setObject(4, reimbursementToBeSubmitted.getStatus());
			preparedStatement.setDouble(5, reimbursementToBeSubmitted.getAmount());
			
			//We need to use the result set to retrieve the newly generated and returned the reimbursement record with the new id
			ResultSet resultSet;
			
			// Here we are checking that the sql query executed and returned the reimbursement record with the new id
			
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
		
	public void update(Reimbursement unprocessedReimbursement) {
		
		try (Connection connection = ConnectionFactory.getConnection()) {
			String sql = "UPDATE ers_reimbursements SET resolver = ?, status =?::status WHERE id = ?";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			//Setting the update parameters (?'s) with their respective values.
			preparedStatement.setInt(1, unprocessedReimbursement.getResolver());
			preparedStatement.setObject(2, unprocessedReimbursement.getStatus().name());
			preparedStatement.setInt(3, unprocessedReimbursement.getId());
			
			// Executing the record update 
			preparedStatement.executeUpdate();
			
			//Proclaim victory
			System.out.println("Reimbursement Successfully Updated");
		}catch (SQLException e) {
			System.out.println("Updating Failed!");
			e.printStackTrace();
		}
	}

	public List<Reimbursement> getByStatus(models.Status pending) {
		// TODO Auto-generated method stub
		return null;
	}
}
