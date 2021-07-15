package shop;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminLoginController {
	private DBConnector dbConn;
	
	AdminLoginController() throws ClassNotFoundException, SQLException{
		dbConn = new DBConnector();
	}
	
	public ResultSet authenticate(String email, String password) {
		ResultSet admin = dbConn.execute(String.format("select * from admins where email='%s' and password='%s'", email, password));
		return admin;
	}
}
