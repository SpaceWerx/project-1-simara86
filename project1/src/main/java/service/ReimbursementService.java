//package service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import models.Reimbursement;
//import models.Status;
//import models.User;
//
//public class ReimbursementService {
//
//	private List<Reimbursement> reimbursementByAuthor;
//	public void submittReimbursement(Reimbursement reimbursemetToBeSubmitted) {
//		
//		Reimbursement latestReimbursement = reimbursements.get(reimbursements.size() - 1);
//		int id = latestReimbursement.getId() + 1; //New Id is 1 higer thatn the previous highest
//		
//		reimbursemetToBeSubmitted.setId(id);
//		reimbursemetToBeSubmitted.setStatus(Status.PENDING);
//		reimbursements.add(reimbursemetToBeSubmitted);
//		
//	}
//	public void update(Reimbursement unprocessedReimbursement, int resolverId, Status updateStatus) {
//		for (Reimbursement reimbursement : reimbursements) {
//			if(reimbursement.getId() == unprocessedReimbursemet.getId());
//			reimbursement.setResolver(resolverId);
//			reimbursement.setStatus(updateStatus);
//			return;
//			
//		}
//		throw new RuntimeException("There was an error processing this reimbursement, plase try again");
//	}
//	
//	public List<Reimbursement> getPendingReimbursement(){
//		List<Reimbursement> pendingReimbursement = new ArrayList<>();
//		
//		for (Reimbursement reimbursement : reimbursements) {
//			if (reimbursement.getStatus() == Status.PENDING) {
//				pendingReimbursement.add(reimbursement);
//			}
//		}
//		return pendingReimbursement;
//		
//	}
//	public Reimbursement getReimbursementById(int id) {
//		for (Reimbursement reimbursement : reimbursemets) {
//			if (reimbursement.getId() == id) {
//				return reimbursement;
//			}
//		}
//		return getReimbursementById(0);
//	}
//	public List<Reimbursement> getResolvedReimbursement(){
//         List<Reimbursement> resolvedReimbursement = new ArrayList<>();
//		
//		for (Reimbursement reimbursement : reimbursements) {
//			if (reimbursement.getStatus() == Status.APPROVED) {
//				resolvedReimbursement.add(reimbursement);
//			}
//		}
//		return resolvedReimbursement;
//		
//	}
//	public List<Reimbursement> geReimbursementByAuthor(){
//        List<Reimbursement> userReimbursement = new ArrayList<>();
//		
//		for (Reimbursement r: reimbursements) {
//			if (r.getAuthor() == userId || r.getResolver() == userId) {
//				userReimbursement.add(r);
//			}
//		}
//		return userReimbursement;
//}
//}