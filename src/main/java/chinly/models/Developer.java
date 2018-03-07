package chinly.models;

import java.util.Collection;
import java.util.Date;

public class Developer extends Person {
	
	private int id;
	private String developerKey;
	private Role role;
	private Priviledge priviledge;
	
	private Collection<Website> websites;
	public void addWebsite(Website website){
        this.websites.add(website);
    }

    public void removeWebsite(Website website){
        this.websites.remove(website);
    }

	
    public Developer(String firstName, String lastName, String username, String password, String email, Date dob, String developerKey) {
		super();
		this.developerKey = developerKey;
	}

    public Developer(String firstName, String lastName, String username, String password, String email, String developerKey) {
		super();
		this.developerKey = developerKey;
	}
    
	public Developer(int id, String developerKey, Role role, Priviledge priviledge, Collection<Website> websites) {
		super();
		this.id = id;
		this.developerKey = developerKey;
		this.role = role;
		this.priviledge = priviledge;
		this.websites = websites;
	}
	
	

	public Developer(int id, String developerKey) {
		super();
		this.id = id;
		this.developerKey = developerKey;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDeveloperKey() {
		return developerKey;
	}

	public void setDeveloperKey(String developerKey) {
		this.developerKey = developerKey;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Priviledge getPriviledge() {
		return priviledge;
	}

	public void setPriviledge(Priviledge priviledge) {
		this.priviledge = priviledge;
	}

	public Collection<Website> getWebsites() {
		return websites;
	}

	public void setWebsites(Collection<Website> websites) {
		this.websites = websites;
	}
    
    

	
	
	
}
