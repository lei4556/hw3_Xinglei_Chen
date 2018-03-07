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

import chinly.models.Developer;
import chinly.models.Page;
import chinly.models.Role;
import chinly.models.Website;

public class WebsiteDao {
	
	private static final String URL = "jdbc:mysql://cs5200-spring2018-chen1.crlb2yt71jpm.us-east-2.rds.amazonaws.com/hw2_xinglei_chen_spring_2018";
	private static final String USERNAME = "chen.xingl";
	private static final String PASSWORD = "Whatever48@";
	
	public static WebsiteDao instance = null;
	public static WebsiteDao getInstance() {
		if (instance == null) {
			instance = new WebsiteDao();
		}
		return instance;
	}
	
	private WebsiteDao(){}
		
	public int createWebsiteForDeveloper(int developerId, Website website) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		int result = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql1 = "INSERT INTO website (id, name, description, visits, developerId) VALUES (?, ?, ?, ?, ?)";
			
			statement = connection.prepareStatement(sql1);
			statement.setInt(1, website.getId());
			statement.setString(2, website.getName());
			statement.setString(3, website.getDescription());
			statement.setInt(4, website.getVisits());
			statement.setInt(5, developerId);
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

	public Collection<Website> findAllWebsites() {
		List <Website> websites = new ArrayList<Website>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql1 = "SELECT * FROM website;";
			statement = connection.prepareStatement(sql1);
			results = statement.executeQuery();
			while(results.next()) {
				int id = results.getInt("id");
				String name = results.getString("name");
				String description = results.getString("description");
				Date created = results.getDate("created");
				Date updated = results.getDate("updated");
				int visits = results.getInt("visits");
				Developer developer = ((Website) results).getDeveloper(); 
				Role role = ((Developer) results).getRole();
				Collection<Page> pages = ((Website) results).getPages();
				Website website = new Website(id, name, description, created, updated, visits, developer, role, pages);
				websites.add(website);
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
		return websites;
	}

	public Collection<Website> findWebsitesForDeveloper(int developerId){
		List <Website> websites = new ArrayList<Website>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql1 = "SELECT * FROM website WHERE developerId = ?;";
			statement = connection.prepareStatement(sql1);
			statement.setInt(1, developerId);
			results = statement.executeQuery();
			while (results.next()) {
				int id = results.getInt("id");
				String name = results.getString("name");
				String description = results.getString("description");
				Date created = results.getDate("created");
				Date updated = results.getDate("updated");
				int visits = results.getInt("visits");
				Developer developer = ((Website) results).getDeveloper(); 
				Role role = ((Developer) results).getRole();
				Collection<Page> pages = ((Website) results).getPages();
				Website website = new Website(id, name, description, created, updated, visits, developer, role, pages);
				websites.add(website);
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
		return websites;
	}
	
	public Website findWebsiteById(int websiteId) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "SELECT * FROM website WHERE id=?;";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, websiteId);
			results = statement.executeQuery(sql);
			if(results.next()) {
				int id = results.getInt("id");
				String name = results.getString("name");
				String description = results.getString("description");
				Date created = results.getDate("created");
				Date updated = results.getDate("updated");
				int visits = results.getInt("visits");
				Developer developer = ((Website) results).getDeveloper(); 
				Role role = ((Developer) results).getRole();
				Collection<Page> pages = ((Website) results).getPages();
				Website website = new Website(id, name, description, created, updated, visits, developer, role, pages);
					return website;
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

	public int updateWebsite(int websiteId, Website website) {
		Connection connection = null;
		PreparedStatement statement = null;
		int results = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "UPDATE website"+
						"SET name=?, description=?, created=?, updated=?, visits=?"+
						"WHERE id = ?;";
			statement = connection.prepareStatement(sql);
			statement.setString(1, website.getName());
			statement.setString(2, website.getDescription());
			statement.setInt(3, website.getVisits());
			statement.setInt(4, websiteId);
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

	public int deleteWebsite(int websiteId) {
		Connection connection = null;
		PreparedStatement statement = null;
		int results = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "DELETE FROM website"+
						"WHERE id = ?;";
			statement = connection.prepareStatement(sql);
			statement.setInt(1,websiteId);
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

