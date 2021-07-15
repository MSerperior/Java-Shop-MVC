package shop;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class AdminHomeController {
	private DBConnector dbConn;
	
	AdminHomeController() throws ClassNotFoundException, SQLException{
		dbConn = new DBConnector();
	}
	
	public void addItem(Item item) throws SQLException {
		dbConn.executeUpdate(String.format("insert into items(id, name, stock, price) values(%s, '%s', %s, %s)", item.getId().toString(), item.getName(), item.getStock().toString(), item.getPrice().toString()));
	}
	
	public ResultSet indexItem() {
		return dbConn.execute("select * from items");
	}
	public ResultSet searchItems(String q) {
		return dbConn.execute("select * from items where name like '%"+q+"%' or id like '%"+q+"%'");
	}
	
	public void topUpUser(String user_id, String amount) {
		ResultSet result = dbConn.execute(String.format("select * from customers where id=%s", user_id));
		
		try {
			if(result.next()) {
				Customer customer = new Customer();
				customer.setBalance(result.getBigDecimal("balance").add(new BigDecimal(amount)));
				customer.setId(result.getBigDecimal("id"));
				
				dbConn.executeUpdate(String.format("update customers set balance='%s' where id=%s", customer.getBalance().toString(), customer.getId().toString()));
				new JOptionPane().showMessageDialog(null, "data has been updated");
			}
			else {
				new JOptionPane().showMessageDialog(null, "data was not found");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void addStock(Item item, String amount) {
		ResultSet result = dbConn.execute(String.format("select * from items where id=%s", item.getId().toString()));
		try {
			if(result.next()) {
				item.setPrice(result.getBigDecimal("price"));
				item.setStock(result.getBigDecimal("stock"));
			}
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		item.setStock(item.getStock().add(new BigDecimal(amount)));
		
		try {
			dbConn.executeUpdate(String.format("update items set stock='%s' where id=%s", item.getStock().toString(), item.getId().toString()));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public void updatePrice(Item item, String price) {
		ResultSet result = dbConn.execute(String.format("select * from items where id=%s", item.getId().toString()));
		try {
			if(result.next()) {
				item.setPrice(result.getBigDecimal("price"));
				item.setStock(result.getBigDecimal("stock"));
			}
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		item.setPrice(new BigDecimal(price));
		
		try {
			dbConn.executeUpdate(String.format("update items set price='%s' where id=%s", item.getPrice().toString(), item.getId().toString()));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
