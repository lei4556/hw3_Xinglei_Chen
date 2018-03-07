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


public class DeveloperDao {
	
	private static final String URL = "jdbc:mysql://cs5200-spring2018-chen1.crlb2yt71jpm.us-east-2.rds.amazonaws.com/hw2_xinglei_chen_spring_2018";
	private static final String USERNAME = "chen.xingl";
	private static final String PASSWORD = "Whatever48@";
	
	public static DeveloperDao instance = null;
	public static DeveloperDao getInstance() {
		if (instance == null) {
			instance = new DeveloperDao();
		}
		return instance;
	}
	private DeveloperDao() {}
	
	public int createDeveloper(Developer developer) {
		Connection connection = null;
		PreparedStatement statement= null;
		int result = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "INSERT INTO person (firstname, lastname, username, password, email, developerKey) VALUES (?,?,?,?,?,?)";
			statement = connection.prepareStatement(sql);
			statement.setString(1, developer.getFirstName());
			statement.setString(2, developer.getLastName());
			statement.setString(3, developer.getUsername());
			statement.setString(4, developer.getPassword());
			statement.setString(5, developer.getEmail());
			statement.setString(6, developer.getDeveloperKey());
			result = statement.executeUpdate();
			connection.close();
			sql = "INSERT INTO developer (developerKey) VALUES (?)";
			statement = connection.prepareStatement(sql);
			statement.setString(1, developer.getDeveloperKey());
			result = statement.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public Collection<Developer> findAllDevelopers(){
		List<Developer> developers = new ArrayList<Developer>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "SELECT * FROM developer, person WHERE Person.id = Developer.PersonId";
			statement = connection.prepareStatement(sql);
			results = statement.executeQuery();
			while(results.next()) {
				String firstName = results.getString("firstName");
				String lastName = results.getString("lastName");
				String username = results.getString("username");
				String password = results.getString("password");
				String email = results.getString("email");
				Date dob = results.getDate("dob");
				String developerKey = results.getString("developerKey");
				Developer developer = new Developer(firstName, lastName, username, password, email, dob, developerKey);
				developers.add(developer);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return developers;
	}
	
	public Developer findDeveloperById(int developerId) {
		
		Developer developer = null;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "SELECT * FROM developer, person WHERE person.id = developer.personid and developer.id = ?";
			statement = connection.prepareStatement(sql);
			statement.setFloat(1, developerId);
			results = statement.executeQuery();
			if(results.next()) {
				String firstName = results.getString("firstName");
				String lastName = results.getString("lastName");
				String username = results.getString("username");
				String password = results.getString("password");
				String email = results.getString("email");
				Date dob = results.getDate("dob");
				String developerKey = results.getString("developerKey");
			    developer = new Developer(firstName, lastName, username, password, email, dob, developerKey);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return developer;
	}
	
	public Developer findDeveloperByUsername(String username1) {
		Developer developer = null;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "SELECT * FROM developer, person WHERE person.id = developer.personid and person.username = ? ";
			statement = connection.prepareStatement(sql);
			statement.setString(1, username1);
			results = statement.executeQuery();
			if(results.next()) {
				String firstName = results.getString("firstName");
				String lastName = results.getString("lastName");
				String username = results.getString("username");
				String password = results.getString("password");
				String email = results.getString("email");
				Date dob = results.getDate("dob");
				String developerKey = results.getString("developerKey");
			    developer = new Developer(firstName, lastName, username, password, email, dob, developerKey);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return developer;
	}
	
	public Developer findDeveloperByCredentials(String username1, String password1) {

		Developer developer = null;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "SELECT * FROM developer, person WHERE person.id = developer.personid and person.username = ? and person.password = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, username1);
			statement.setString(2, password1);
			results = statement.executeQuery();
			if(results.next()) {
				String firstName = results.getString("firstName");
				String lastName = results.getString("lastName");
				String username = results.getString("username");
				String password = results.getString("password");
				String email = results.getString("email");
				Date dob = results.getDate("dob");
				String developerKey = results.getString("developerKey");
			    developer = new Developer(firstName, lastName, username, password, email, dob, developerKey);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return developer;
	}
	
	public int updateDeveloper(int developerId, Developer developer) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		int results = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "UPDATE developer and person SET firstname = ?, lastname = ?, username = ?, password = ?, email = ?, developerKey = ? WHERE person.id = developer.personid and developer.id = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, developer.getFirstName());
			statement.setString(2, developer.getLastName());
			statement.setString(3, developer.getUsername());
			statement.setString(4, developer.getPassword());
			statement.setString(5, developer.getEmail());
			statement.setString(6, developer.getDeveloperKey());
			statement.setInt(7, developerId);
			results = statement.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		return results;
	}
	
	public int deleteDeveloper(int developerId) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		int result = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "DELETE FROM developer and person WHERE person.id = developer.personid and developer.id = ?";
			statement = connection.prepareStatement(sql); 
			statement.setInt(1, developerId);
			result = statement.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
}
