package shop;

import java.sql.*;

public class DBConnector {
	static final String USER = "root";
	static final String PASS = "";
	static final String HOST = "jdbc:mysql://localhost/olshop";
	static Connection conn;
	Statement stmt;
	DBConnector() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(HOST,USER,PASS);
		
		stmt = conn.createStatement();
	}
	
	public ResultSet execute(String sql) {
		try {
			return stmt.executeQuery(sql);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return null;
		}
	}
	
	public void executeUpdate(String sql) throws SQLException {
		stmt.executeUpdate(sql);
	}
}
