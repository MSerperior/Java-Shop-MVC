package shop;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;

public class AdminLogin {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	
	private DBConnector dbConn;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin window = new AdminLogin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		try {
			dbConn = new DBConnector();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JLabel lblNewLabel = new JLabel("Email");
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 219, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField, 0, SpringLayout.NORTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, textField, 54, SpringLayout.EAST, lblNewLabel);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Admin Login");
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, -275, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 46, SpringLayout.SOUTH, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1, 242, SpringLayout.WEST, frame.getContentPane());
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 25, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_2, 0, SpringLayout.WEST, lblNewLabel);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Login");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 61, SpringLayout.SOUTH, textField);
		
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 0, SpringLayout.WEST, textField);
		frame.getContentPane().add(btnNewButton);
		
		passwordField = new JPasswordField();
		springLayout.putConstraint(SpringLayout.NORTH, passwordField, -3, SpringLayout.NORTH, lblNewLabel_2);
		springLayout.putConstraint(SpringLayout.WEST, passwordField, 0, SpringLayout.WEST, textField);
		springLayout.putConstraint(SpringLayout.EAST, passwordField, 130, SpringLayout.EAST, lblNewLabel_2);
		frame.getContentPane().add(passwordField);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setForeground(Color.RED);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_3, 0, SpringLayout.WEST, textField);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_3, -6, SpringLayout.NORTH, textField);
		frame.getContentPane().add(lblNewLabel_3);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email = textField.getText();
				String password = passwordField.getText();
				
				ResultSet result = dbConn.execute(String.format("select * from admins where email='%s' and password='%s'", email, password));
				
				try {
					if(result.next()) {
						frame = new AdminHome();
						frame.setVisible(true);
					}
					else {
						lblNewLabel_3.setText("email or password is incorrect");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
}
