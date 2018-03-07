package chinly.models;

public class User {
	private boolean userAgreement;
	private Person person;

	public User() {
		super();
	}


	public User(boolean userAgreement, Person person) {
		super();
		this.userAgreement = userAgreement;
		this.person = person;
	}


	public boolean isUserAgreement() {
		return userAgreement;
	}


	public void setUserAgreement(boolean userAgreement) {
		this.userAgreement = userAgreement;
	}


	public Person getPerson() {
		return person;
	}



	public void setPerson(Person person) {
		this.person = person;
	}
	
	
	
}