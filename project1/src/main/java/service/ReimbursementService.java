package service;

import java.util.ArrayList;
import java.util.List;

import models.Reimbursement;
import models.Role;
import models.Status;
import models.User;
import repositories.ReimbursementDAO;

public class ReimbursementService {
	
	
	//Instantiating the DAO and user service to utilize in various methods
	ReimbursementDAO reimbursementDAO = new ReimbursementDAO();
	UserService userService = new UserService();
	
	public List<Reimbursement> getPendingReimbursements(){return reimbursementDAO.getByStatus(Status.PENDING);}
		
	
	
	public List <Reimbursement> getResolvedReimbursements(){
		List<Reimbursement> resolvedReimbursements = new ArrayList<>();
		
		resolvedReimbursements.addAll(reimbursementDAO.getByStatus(Status.APPROVED));
		resolvedReimbursements.addAll(reimbursementDAO.getByStatus(Status.DENIED));
		return resolvedReimbursements;
	}

	
	public int submitReimbursement (Reimbursement reimbursementToBeSubmitted) {
		
		User employee = userService.getUserById(reimbursementToBeSubmitted.getAuthor());
		
		if(employee.getRole() != Role.EMPLOYEE) {
			throw new IllegalArgumentException("Manager cannot submit reimbursement request.");
		}else {
			reimbursementToBeSubmitted.setStatus(Status.PENDING);
			
			return reimbursementDAO.create(reimbursementToBeSubmitted);
		}
	}
	
	public Reimbursement update(Reimbursement unprocessedReimbursement, int resolverId, Status updatedStatus) {
		User manager = userService.getUserById(resolverId);
		
		if(manager.getRole() != Role.MANAGER) {
			throw new IllegalArgumentException("An Employee cannot process reimbursement request.");
		}else {
			unprocessedReimbursement.setResolver(resolverId);
			unprocessedReimbursement.setStatus(updatedStatus); 
			reimbursementDAO.update(unprocessedReimbursement);
			return unprocessedReimbursement;
		}
		
	}
	public Reimbursement getReimbursementById(int id) {
		return reimbursementDAO.getReimbursementById(id);
		}
		
	public List<Reimbursement> getReimbursementByAuthor( int userId){
		return reimbursementDAO.getReimbursementsByUser(userId);
		
	}
	
	}
		
	
