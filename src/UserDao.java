import java.sql.*;

public class UserDao {
	String jdbcURL = "jdbc:mysql://localhost:3306/hotel";
	String dbUser = "root";
	String dbPassword = "root";
	Connection connection;
	String sql;
	public UserModel checkLogin(String username, String password) throws SQLException,
	ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
		String sql = "SELECT * FROM login WHERE username = ? and password = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, username);
		statement.setString(2, password);

		ResultSet result = statement.executeQuery();

		UserModel user = null;

		if (result.next()) {
			user = new UserModel();
			user.setUsername(result.getString("username"));
		}

		connection.close();

		return user;
	}
	public boolean checkDate(String indate, String outdate, int rooms) throws SQLException,
	ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
		String sql2 = "SELECT sum(rooms) FROM booking WHERE"
				+ "? <= outdate AND ? >= indate";

		PreparedStatement statement2 = connection.prepareStatement(sql2);
		statement2.setString(1, indate); 
		statement2.setString(2, outdate); 
		ResultSet result2 = statement2.executeQuery();
		result2.next(); 
		if( result2.getInt(1) <= 10 && rooms <= getDetails(indate, outdate) && getDetails(indate, outdate)>0) {	
		    return true;
		}else {
			return false;
		}
	}

	@SuppressWarnings("unused")
	public void BookRoom(String indate, String outdate, String username, String rooms) throws SQLException,
	ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
		sql = "insert into booking (indate, outdate, username,rooms) values(?,?,?,? ) ";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, indate);
		statement.setString(2, outdate);
		statement.setString(3, username);
		statement.setString(4, rooms);
		int result = statement.executeUpdate();
	}
	public int getDetails(String indate, String outdate) throws SQLException,
	ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
		String sql = "SELECT sum(rooms) FROM booking WHERE"
				+ "? <= outdate AND ? >= indate";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, indate);
		statement.setString(2, outdate);
		ResultSet result = statement.executeQuery();
		result.next();
		int value = 10-result.getInt(1);
		return value;
	}
}
