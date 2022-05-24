package models;

public class Reimbursement {
	int id;
	int author;
	int resolver;
	String description;
	ReimbursementType type;
	Status status;
	double amount;
	
//	public Reimbursement(int id, int author, int resolver, String description, ReimbursementType type,
//			Status status, double amount) {
//		this.id = id;
//		this.author = author;
//		this.resolver = resolver;
//		this.description = description;
//		this.type= type;
//		this.status = status;
//		this.amount = amount;
//		
//	}
	
	public Reimbursement(int int1, int int2, int int3, int int4, ReimbursementType valueOf,
			javax.net.ssl.SSLEngineResult.Status valueOf2, double double1) {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAuthor() {
		return author;
	}
	public void setAuthor(int i) {
		this.author = i;
	}
	public int getResolver() {
		return resolver;
	}
	public void setResolver(int resolverId) {
		this.resolver = resolverId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ReimbursementType getType() {
		return type;
	}
	public void setType(ReimbursementType type) {
		this.type = type;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	

}
