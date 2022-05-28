package service;
import java.util.ArrayList;
import java.util.List;

import models.Reimbursement;
import models.Role;
import models.Status;
import models.User;
import repositories.ReimbursementDAO;

public class ReimbursementService {
	
	public static ReimbursementDAO reimbursementDAO = new ReimbursementDAO();
    public static UserService rService = new UserService();
    public static ArrayList<Reimbursement> reimbursements = new ArrayList<>();
   
//    public static void clearData() {
//        reimbursements.clear();
//    }
    
//	public static Reimbursement update(Reimbursement unprocessedReimbursment) {
//		
////		User Founder = rService.getUserById(resolverID);
////
////        if(Founder.getRole() != Role.Founder) {
////            throw new RuntimeException("There was an error processing this reimbursement, please try again.");
////        }else {
////
////            unprocessedReimbursment.setResolver(resolverID);
////            unprocessedReimbursment.setStatus(updatedStatus);
//
//            reimbursementDAO.update(unprocessedReimbursment);
//
//         return unprocessedReimbursment;
//        //}
//}


public static int sumbitReimbursement (Reimbursement reimbursementToBeSubmitted) {
	User employee = rService.getUserById(reimbursementToBeSubmitted.getAuthor());

   

       
        reimbursementToBeSubmitted.setStatus(Status.Pending);


        return reimbursementDAO.create(reimbursementToBeSubmitted);
}


public static List<Reimbursement>getPendingReimbursements() {
	return ReimbursementDAO.getByStatus(Status.Pending);
		
	}
	

public static Reimbursement getReimbursementById(int id) {
	return reimbursementDAO.getReimbursementById(id);
}

public static List<Reimbursement> getReimbursementsByAuthor(int userId) {

    List<Reimbursement> userReimbursements = new ArrayList<>();

        for(Reimbursement r : reimbursements) {
            if (r.getAuthor() == userId || r.getResolver() == userId) {
            }
        }
        return userReimbursements;
	}

public List<Reimbursement> getReimbursementByStatus(Status status) {
	// TODO Auto-generated method stub
	return reimbursementDAO.getByStatus(status);
}

public Reimbursement update(Reimbursement reimbursement, int resolver, Status statusinput) {
	reimbursement.setResolver(resolver);
	reimbursement.setStatus(statusinput);
	reimbursementDAO.update(reimbursement);
	return reimbursement;
}


}
//import java.util.ArrayList;
//import java.util.List;
//
//import models.Reimbursement;
//import models.Role;
//import models.Status;
//import models.User;
//import repositories.ReimbursementDAO;
//
//public class ReimbursementService {
//	
//	
//	//Instantiating the DAO and user service to utilize in various methods
//	ReimbursementDAO reimbursementDAO = new ReimbursementDAO();
//	UserService userService = new UserService();
//	
//	//This method is meant to return a List of reimbursement records from the database that have a status of Pending.
//	
//	public List<Reimbursement> getPendingReimbursements(){return reimbursementDAO.getByStatus(Status.Pending);}
//		
//	//This method is meant to combine reimbursement records with status of Approved or Denied
//	//It will return the combine list of records
//	
//	public List <Reimbursement> getResolvedReimbursements(){
//		List<Reimbursement> resolvedReimbursements = new ArrayList<>();
//		
//		resolvedReimbursements.addAll(reimbursementDAO.getByStatus(Status.Approved));
//		resolvedReimbursements.addAll(reimbursementDAO.getByStatus(Status.Denied));
//		
//		//return the combine list of records
//		return resolvedReimbursements;
//	}
//
//	//This will take in a new reimbursement submission
//	//The submission author must be an employee
//	public int submitReimbursement (Reimbursement reimbursementToBeSubmitted) {
//		
//		//Getting the user information from the author ID attached to the reimbursement submission
//		
//		User employee = UserService.getUserById(reimbursementToBeSubmitted.getAuthor());
//		
//		if(employee.getRole() != Role.Employee) {
//			throw new IllegalArgumentException("Manager cannot submit reimbursement request.");
//		}else {
//			reimbursementToBeSubmitted.setStatus(Status.Pending);
//			
//			return reimbursementDAO.create(reimbursementToBeSubmitted);
//		}
//	}
//	//This method is meant to update the respective fields and ensure the user has a manager role
//	//The full reimbursement will be returned with update fields
//	public Reimbursement update(Reimbursement unprocessedReimbursement, int resolverId, Status updatedStatus) {
//		User manager = userService.getUserById(resolverId);
//		
//		//Checking if the user is an employee
//		if(manager.getRole() != Role.Manager) {
//			throw new IllegalArgumentException("An Employee cannot process reimbursement request.");
//		}else {
//			unprocessedReimbursement.setResolver(resolverId);
//			unprocessedReimbursement.setStatus(updatedStatus); 
//			reimbursementDAO.update(unprocessedReimbursement);
//			return unprocessedReimbursement;
//		}
//		
//	}
//	
//	/////////////////////////////////////////////////////////////////////////////////////////////////
//	
//	//This method is mean to retrieve a single record with the passed-in Id
//	public Reimbursement getReimbursementById(int id) {
//		return reimbursementDAO.getReimbursementById(id);
//		}
//	
//	//This method should retrieve all reimbursement records that are associated with the userId provided	
//	public List<Reimbursement> getReimbursementByAuthor( int userId){
//		return reimbursementDAO.getReimbursementsByUser(userId);
//		
//	}
//
//	public List<Reimbursement> getReimbursementByStatus(Status status){
//        return reimbursementDAO.getByStatus(status);
//}
//
//	
//	
//	}

		
	
