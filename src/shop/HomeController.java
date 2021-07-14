package shop;

import java.awt.HeadlessException;
import java.math.BigDecimal;
import java.sql.*;

import javax.swing.JOptionPane;

public class HomeController {
	private DBConnector dbConn;
	private Customer customer;
	HomeController(Customer customer) throws ClassNotFoundException, SQLException{
		dbConn = new DBConnector();
		this.customer = customer;
	}
	
	public ResultSet index() {
		return dbConn.execute("select * from items");
	}
	
	public ResultSet search(String q) {
		return dbConn.execute("select * from items where name LIKE '%"+ q +"%'");
	}
	public void logOut() {
		System.exit(1);
	}
	public Customer customer(Customer customer) throws SQLException {
		ResultSet creds = dbConn.execute(String.format("Select * from customers where id = '%s'", customer.getId().toString()));
		Customer user = new Customer();
		if(creds.next()) {
			user.setId(creds.getBigDecimal("id"));
			user.setEmail(creds.getString("email"));
			user.setFirst_name(creds.getString("first_name"));
			user.setLast_name(creds.getString("last_name"));
			user.setPhone(creds.getString("phone"));
			user.setBalance(creds.getBigDecimal("balance"));
		}
		else {
			user = null;
		}
		return user;
	}
	public void buy(String item_id, String qty) throws HeadlessException, SQLException {
		ResultSet rs = dbConn.execute(String.format("select * from items where id='%s'", item_id));
		
		if(rs.next()) {
			Item item = new Item();
			item.setId(rs.getBigDecimal("id"));
			item.setPrice(rs.getBigDecimal("price"));
			item.setStock(rs.getBigDecimal("stock"));
			BigDecimal qtyDec = new BigDecimal(qty);
			BigDecimal total_price = item.getPrice().multiply(qtyDec);
			BigDecimal leftOver = customer.getBalance().subtract(total_price);
			
			
			if(item.getStock().compareTo(qtyDec) == -1) {
				JOptionPane.showMessageDialog(null, "stock in short");
			}
			else if(customer.getBalance().compareTo(item.getPrice().multiply(qtyDec)) == -1){
				JOptionPane.showMessageDialog(null, "balance not enough");
			}
			else {
				
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to buy?") == 0) {
					JOptionPane.showMessageDialog(null, String.format("Balance %s -> %s", customer.getBalance().toString(), leftOver.toString()));
					customer.setBalance(leftOver);
					item.setStock(item.getStock().subtract(qtyDec));
					
					dbConn.executeUpdate(String.format("update customers set balance = %s where customers.id = %s", customer.getBalance().toString(), customer.getId().toString()));	
					dbConn.executeUpdate(String.format("update items set stock = %s where items.id = %s", item.getStock().toString(), item.getId().toString()));
					dbConn.executeUpdate(String.format("insert into transactions ("
							+ "customer_id, "
							+ "item_id, "
							+ "quantity) values (%s, %s, %s)", customer.getId().toString(), item_id, qty));
				}
				
			}
		}
	}
}
