package chinly.models;

import java.util.Collection;
import java.util.Date;

public class Website {
	private int id;
	private String name;
	private String description;
	private Date created;
	private Date updated;
	private int visits;
	private Developer developer; 
	private Role role;
	private Collection<Page> pages;
	public void addPage(Page page){
        this.pages.add(page);
    }

    public void removePage(Page page){
        this.pages.remove(page);
    }

	public Website() {
		super();
	}


	public Website(int id, String name, String description, Date created, Date updated, int visits, Developer developer,
			Role role, Collection<Page> pages) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.created = created;
		this.updated = updated;
		this.visits = visits;
		this.developer = developer;
		this.role = role;
		this.pages = pages;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public int getVisits() {
		return visits;
	}

	public void setVisits(int visits) {
		this.visits = visits;
	}

	public Collection<Page> getPages() {
		return pages;
	}

	public void setPages(Collection<Page> pages) {
		this.pages = pages;
	}

	public Developer getDeveloper() {
		return developer;
	}

	public void setDeveloper(Developer developer) {
		this.developer = developer;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
    

}
