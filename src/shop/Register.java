package shop;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.SpringLayout;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Register extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField textField_1;
	private JLabel lblNewLabel_3;
	private JTextField textField_2;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JTextField textField_4;
	private JButton btnNewButton;
	private JPasswordField passwordField;
	private DBConnector dbConn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Register() {
		try {
			dbConn = new DBConnector();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		lblNewLabel = new JLabel("first name");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 46, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		lblNewLabel.setLabelFor(textField);
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField, 0, SpringLayout.NORTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField, 65, SpringLayout.EAST, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, textField, -273, SpringLayout.SOUTH, contentPane);
		contentPane.add(textField);
		textField.setColumns(30);
		
		lblNewLabel_1 = new JLabel("Register");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 25, SpringLayout.SOUTH, lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, 300, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("last name");
		lblNewLabel_2.setLabelFor(lblNewLabel_2);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 33, SpringLayout.SOUTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_2, 47, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_2, -232, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_2, 0, SpringLayout.EAST, lblNewLabel);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField_1, -3, SpringLayout.NORTH, lblNewLabel_2);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField_1, 0, SpringLayout.WEST, textField);
		contentPane.add(textField_1);
		textField_1.setColumns(30);
		
		lblNewLabel_3 = new JLabel("email");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_3, 0, SpringLayout.WEST, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_3, -23, SpringLayout.EAST, lblNewLabel);
		lblNewLabel_3.setLabelFor(lblNewLabel_3);
		contentPane.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField_2, 21, SpringLayout.SOUTH, textField_1);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 3, SpringLayout.NORTH, textField_2);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField_2, 0, SpringLayout.WEST, textField);
		contentPane.add(textField_2);
		textField_2.setColumns(30);
		
		lblNewLabel_4 = new JLabel("password");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_4, 0, SpringLayout.WEST, lblNewLabel);
		lblNewLabel_4.setLabelFor(lblNewLabel_4);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("phone");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_5, 0, SpringLayout.WEST, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_5, -20, SpringLayout.EAST, lblNewLabel);
		contentPane.add(lblNewLabel_5);
		
		textField_4 = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_5, 3, SpringLayout.NORTH, textField_4);
		lblNewLabel_5.setLabelFor(textField_4);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField_4, 0, SpringLayout.WEST, textField);
		contentPane.add(textField_4);
		textField_4.setColumns(30);
		
		btnNewButton = new JButton("submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer customer = new Customer(
						textField.getText(), 
						textField_1.getText(), 
						textField_2.getText(), 
						passwordField.getText(),
						textField_4.getText(),
						new BigDecimal(0));
				
				try {
					dbConn.executeUpdate(String.format("insert into customers ("
							+ "first_name, "
							+ "last_name, "
							+ "email, "
							+ "password, "
							+ "phone, "
							+ "balance) VALUES ('%s', '%s', '%s', '%s', '%s', '%s')", 
							customer.getFirst_name(),
							customer.getLast_name(),
							customer.getEmail(),
							customer.getPassword(),
							customer.getPhone(),
							customer.getBalance().toString()));
					setVisible(false);
					Login login = new Login();
					login.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton, 19, SpringLayout.SOUTH, textField_4);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, 0, SpringLayout.WEST, textField);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton, -58, SpringLayout.SOUTH, contentPane);
		contentPane.add(btnNewButton);
		
		passwordField = new JPasswordField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 3, SpringLayout.NORTH, passwordField);
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField_4, 24, SpringLayout.SOUTH, passwordField);
		sl_contentPane.putConstraint(SpringLayout.NORTH, passwordField, 24, SpringLayout.SOUTH, textField_2);
		sl_contentPane.putConstraint(SpringLayout.WEST, passwordField, 0, SpringLayout.WEST, textField);
		passwordField.setColumns(30);
		contentPane.add(passwordField);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_1, 20, SpringLayout.EAST, btnNewButton);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton_1, 0, SpringLayout.SOUTH, btnNewButton);
		contentPane.add(btnNewButton_1);
	}
}
