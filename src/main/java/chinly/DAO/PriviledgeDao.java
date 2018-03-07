package chinly.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import chinly.models.Priviledge;

public class PriviledgeDao {
	
	private static final String URL = "jdbc:mysql://cs5200-spring2018-chen1.crlb2yt71jpm.us-east-2.rds.amazonaws.com/hw2_xinglei_chen_spring_2018";
	private static final String USERNAME = "chen.xingl";
	private static final String PASSWORD = "Whatever48@";
	
	public static PriviledgeDao instance = null;
	public static PriviledgeDao getInstance() {
		if (instance == null) {
			instance = new PriviledgeDao();
		}
		return instance;
	}
	
	private PriviledgeDao(){}
	
	public int assignWebsiteRole(int developerId, int websiteId, int priviledgeId){
		
		Connection connection = null;
		PreparedStatement statement = null;
		int result = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql1 = "INSERT INTO Role (developerId, websiteId, roleId) VALUES (?, ?, ?)";
			statement = connection.prepareStatement(sql1);
			statement.setInt(1,developerId);
			statement.setInt(2, websiteId);
			statement.setInt(3, priviledgeId);
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
	
        public int assignPageRole(int developerId, int pageId, int priviledgeId){
		
		Connection connection = null;
		PreparedStatement statement = null;
		int result = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql1 = "INSERT INTO Role (developerId, websiteId, roleId) VALUES (?, ?, ?)";
			statement = connection.prepareStatement(sql1);
			statement.setInt(1, developerId);
			statement.setInt(2, pageId);
			statement.setInt(3, priviledgeId);
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

	

	public int deleteWebsiteRole(int developerId, int websiteId, int priviledgeId){
		Connection connection = null;
		PreparedStatement statement = null;
		int results = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "DELETE FROM Role"+
						 "WHERE developerId = ? AND websiteId = ? AND roleId = ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1,developerId);
			statement.setInt(2, websiteId);
			statement.setInt(3, priviledgeId);
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
	
	public int deletePageRole(int developerId, int pageId, int priviledgeId){
		Connection connection = null;
		PreparedStatement statement = null;
		int results = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "DELETE FROM widget"+
						"WHERE id = ?;";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, developerId);
			statement.setInt(2, pageId);
			statement.setInt(3, priviledgeId);
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



