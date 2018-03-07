package chinly.DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Date;


import chinly.models.Page;
import chinly.models.Widget;
import chinly.models.Developer;
import chinly.models.Role;
import chinly.models.Priviledge;
import chinly.models.Website;

public class PageDao {
	
	private static final String URL = "jdbc:mysql://cs5200-spring2018-chen1.crlb2yt71jpm.us-east-2.rds.amazonaws.com/hw2_xinglei_chen_spring_2018";
	private static final String USERNAME = "chen.xingl";
	private static final String PASSWORD = "Whatever48@";
	
	public static PageDao instance = null;
	public static PageDao getInstance() {
		if (instance == null) {
			instance = new PageDao();
		}
		return instance;
	}
	
	private PageDao(){}
		
	public int createPageForWebsite(int websiteId, Page page) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		int result = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql1 = "INSERT INTO page (id, title, description, views, websiteId) "
					+  "VALUES (?, ?, ?, ?, ?)";
			
			statement = connection.prepareStatement(sql1);
			statement.setInt(1, page.getId());
			statement.setString(2, page.getTitle());
			statement.setString(3, page.getDescription());
			statement.setInt(4, page.getViews());
			statement.setInt(5, websiteId);
			result = statement.executeUpdate();
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	public Collection<Page> findAllPages() {
		List <Page> pages = new ArrayList<Page>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql1 = "SELECT * FROM page;";
			statement = connection.prepareStatement(sql1);
			results = statement.executeQuery();
			while(results.next()) {
				int id = results.getInt("id");
				String title = results.getString("title");
				String description = results.getString("description");
				Date created = results.getDate("created");
				Date updated = results.getDate("updated");
				int views = results.getInt("views");
				Website website = ((Page) results).getWebsite(); 
				Role role = ((Developer) results).getRole();
				Priviledge priviledge = ((Developer) results).getPriviledge();
				Collection<Widget> widgets = ((Page) results).getWidgets();
				Page page = new Page(id, title, description, created, updated, views, website, role, priviledge, widgets);
				pages.add(page);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return pages;
	}

	public Collection<Page> findPagesForWebsite(int websiteId){
		List <Page> pages = new ArrayList<Page>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql1 = "SELECT * FROM website WHERE websiteId = ?;";
			statement = connection.prepareStatement(sql1);
			statement.setInt(1, websiteId);
			results = statement.executeQuery();
			while (results.next()) {
				int id = results.getInt("id");
				String title = results.getString("title");
				String description = results.getString("description");
				Date created = results.getDate("created");
				Date updated = results.getDate("updated");
				int views = results.getInt("views");
				Website website = ((Page) results).getWebsite(); 
				Role role = ((Developer) results).getRole();
				Priviledge priviledge = ((Developer) results).getPriviledge();
				Collection<Widget> widgets = ((Page) results).getWidgets();
				Page page = new Page(id, title, description, created, updated, views, website, role, priviledge, widgets);
				pages.add(page);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return pages;
	}
	
	public Page findPageById(int pageId) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "SELECT * FROM page WHERE id=?;";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, pageId);
			results = statement.executeQuery(sql);
			if(results.next()) {
				int id = results.getInt("id");
				String title = results.getString("title");
				String description = results.getString("description");
				Date created = results.getDate("created");
				Date updated = results.getDate("updated");
				int views = results.getInt("views");
				Website website = ((Page) results).getWebsite(); 
				Role role = ((Developer) results).getRole();
				Priviledge priviledge = ((Developer) results).getPriviledge();
				Collection<Widget> widgets = ((Page) results).getWidgets();
				Page page = new Page(id, title, description, created, updated, views, website, role, priviledge, widgets);
				return page;
			}	
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	public int updatePage(int pageId, Page page) {
		Connection connection = null;
		PreparedStatement statement = null;
		int results = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "UPDATE page"+
						"SET title=?, description=?, created=?, updated=?, views=?"+
						"WHERE id = ?;";
			statement = connection.prepareStatement(sql);
			statement.setString(1, page.getTitle());
			statement.setString(2, page.getDescription());
			statement.setInt(3, page.getViews());
			statement.setInt(4, pageId);
			results = statement.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return results;

	}

	public int deletePage(int pageId) {
		Connection connection = null;
		PreparedStatement statement = null;
		int results = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "DELETE FROM page"+
						"WHERE id = ?;";
			statement = connection.prepareStatement(sql);
			statement.setInt(1,pageId);
			results = statement.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return results;

	}
		
			
		
}

