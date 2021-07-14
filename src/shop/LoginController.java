package shop;

import java.sql.*;

public class LoginController {
	private DBConnector dbConn;
	
	LoginController() throws ClassNotFoundException, SQLException{
		dbConn = new DBConnector();
	}
	
	public Customer authenticate(String username, String password) throws SQLException {
		ResultSet creds = dbConn.execute(String.format("Select * from customers where email = '%s' and password = '%s'", username, password));
		Customer user = new Customer();
		if(creds.next()) {
			user.setId(creds.getBigDecimal("id"));
			user.setEmail(creds.getString("email"));
			user.setFirst_name(creds.getString("first_name"));
			user.setLast_name(creds.getString("last_name"));
			user.setPhone(creds.getString("phone"));
			user.setBalance(creds.getBigDecimal("balance"));
			return user;
		}
		else {
			return null;
		}
	}
	
}
