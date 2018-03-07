package chinly.models;


import java.util.Collection;
import java.util.Date;

public class Page {
	private int id;
	private String title;
	private String description;
	private Date created;
	private Date updated;
	private int views;
	private Role role;
	private Developer developer; 
	private Website website;
	private Priviledge priviledge;
	private Collection<Widget> widgets;// add fk of lower layer
	public void addWidget(Widget widget){
        this.widgets.add(widget);
    }

    public void removeWidget(Widget widget){
        this.widgets.remove(widget);
    }

	public Page() {
		super();
	}

	public Page(int id, String title, String description, Date created, Date updated, int views, Website website, Role role,
			Priviledge priviledge, Collection<Widget> widgets) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.created = created;
		this.updated = updated;
		this.views = views;
		this.website = website;
		this.priviledge = priviledge;
		this.role = role;
		this.widgets = widgets;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public Website getWebsite() {
		return website;
	}

	public void setWebsite(Website website) {
		this.website = website;
	}

	public Collection<Widget> getWidgets() {
		return widgets;
	}

	public void setWidgets(Collection<Widget> widgets) {
		this.widgets = widgets;
	}

	public Priviledge getPriviledge() {
		return priviledge;
	}

	public void setPriviledge(Priviledge priviledge) {
		this.priviledge = priviledge;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Developer getDeveloper() {
		return developer;
	}

}
