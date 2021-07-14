package shop;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.*;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.SpringLayout;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.DropMode;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class Home extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel balanceLabel;
	private DefaultTableModel tableModel;
	private HomeController homeController;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home(new Customer());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public Home(Customer customer) throws ClassNotFoundException, SQLException {
		homeController = new HomeController(customer);
		
		ResultSet items = homeController.index();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panel, BorderLayout.WEST);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {0, 0};
		gbl_panel.rowHeights = new int[] {0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton btnNewButton = new JButton("Select");
		
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		panel.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_5 = new JButton("Profile");
		
		GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
		gbc_btnNewButton_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_5.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_5.gridx = 0;
		gbc_btnNewButton_5.gridy = 1;
		panel.add(btnNewButton_5, gbc_btnNewButton_5);
		
		
		JButton btnNewButton_2 = new JButton("Log Out");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				homeController.logOut();
			}
		});
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_2.gridx = 0;
		gbc_btnNewButton_2.gridy = 2;
		panel.add(btnNewButton_2, gbc_btnNewButton_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new CardLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3, "name_70182361133900");
		panel_3.setLayout(null);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(150, 108, 96, 20);
		panel_3.add(spinner);
		
		JLabel lblNewLabel_1 = new JLabel("quantity");
		lblNewLabel_1.setLabelFor(spinner);
		lblNewLabel_1.setBounds(50, 111, 62, 16);
		panel_3.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 209, 452, 92);
		panel_3.add(scrollPane);
		
		table = new JTable();
		table.setRowSelectionAllowed(false);
		table.setEnabled(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id", "name", "price", "stock"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		
		tableModel = (DefaultTableModel) table.getModel();
		try {
			while(items.next()) {
				Object[] data = { 
						items.getBigDecimal("id"), items.getString("name"), items.getBigDecimal("price"), items.getBigDecimal("stock")};
				tableModel.addRow(data);
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		scrollPane.setViewportView(table);
		
		JLabel lblId = new JLabel("id");
		lblId.setBounds(50, 69, 62, 14);
		panel_3.add(lblId);
		
		textField_1 = new JTextField();
		lblId.setLabelFor(textField_1);
		textField_1.setColumns(10);
		textField_1.setBounds(150, 66, 96, 20);
		panel_3.add(textField_1);
		
		JLabel lblNewLabel_2 = new JLabel("Choose Items");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(226, 11, 125, 32);
		panel_3.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(51, 178, 317, 20);
		panel_3.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Search");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String q = textField_2.getText();
				
				ResultSet items = homeController.search(q);
				
				tableModel.setNumRows(0);
				try {
					while(items.next()) {
						Object[] data = { 
								items.getBigDecimal("id"), items.getString("name"), items.getBigDecimal("price"), items.getBigDecimal("stock")};
						tableModel.addRow(data);
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_3.setBounds(413, 177, 89, 23);
		panel_3.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Buy");
		
		btnNewButton_4.setBounds(305, 107, 107, 23);
		panel_3.add(btnNewButton_4);
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4, "name_70196421529900");
		panel_4.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setText(customer.getFirst_name() + customer.getBalance());
		textArea.setBounds(10, 0, 551, 172);
		panel_4.add(textArea);
		
		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5, "name_355984477506000");
		SpringLayout sl_panel_5 = new SpringLayout();
		panel_5.setLayout(sl_panel_5);
		
		JLabel lblNewLabel_3 = new JLabel("Name");
		sl_panel_5.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 10, SpringLayout.NORTH, panel_5);
		sl_panel_5.putConstraint(SpringLayout.WEST, lblNewLabel_3, 10, SpringLayout.WEST, panel_5);
		panel_5.add(lblNewLabel_3);
		
		JLabel nameLabel = new JLabel(customer.getName());
		sl_panel_5.putConstraint(SpringLayout.WEST, nameLabel, 44, SpringLayout.EAST, lblNewLabel_3);
		sl_panel_5.putConstraint(SpringLayout.SOUTH, nameLabel, 0, SpringLayout.SOUTH, lblNewLabel_3);
		panel_5.add(nameLabel);
		
		JLabel lblNewLabel_5 = new JLabel("Email");
		sl_panel_5.putConstraint(SpringLayout.WEST, lblNewLabel_5, 0, SpringLayout.WEST, lblNewLabel_3);
		panel_5.add(lblNewLabel_5);
		
		JLabel emailLabel = new JLabel(customer.getEmail());
		sl_panel_5.putConstraint(SpringLayout.NORTH, emailLabel, 0, SpringLayout.NORTH, lblNewLabel_5);
		sl_panel_5.putConstraint(SpringLayout.WEST, emailLabel, 0, SpringLayout.WEST, nameLabel);
		panel_5.add(emailLabel);
		
		JLabel lblNewLabel_7 = new JLabel("Phone");
		sl_panel_5.putConstraint(SpringLayout.WEST, lblNewLabel_7, 0, SpringLayout.WEST, lblNewLabel_3);
		sl_panel_5.putConstraint(SpringLayout.SOUTH, lblNewLabel_7, -219, SpringLayout.SOUTH, panel_5);
		panel_5.add(lblNewLabel_7);
		
		JLabel phoneLabel = new JLabel(customer.getPhone());
		sl_panel_5.putConstraint(SpringLayout.NORTH, phoneLabel, 0, SpringLayout.NORTH, lblNewLabel_7);
		sl_panel_5.putConstraint(SpringLayout.WEST, phoneLabel, 0, SpringLayout.WEST, nameLabel);
		panel_5.add(phoneLabel);
		
		JLabel lblNewLabel_9 = new JLabel("Balance");
		sl_panel_5.putConstraint(SpringLayout.NORTH, lblNewLabel_9, 25, SpringLayout.SOUTH, lblNewLabel_7);
		sl_panel_5.putConstraint(SpringLayout.WEST, lblNewLabel_9, 0, SpringLayout.WEST, lblNewLabel_3);
		panel_5.add(lblNewLabel_9);
		
		balanceLabel = new JLabel(customer.getBalance().toString());
		sl_panel_5.putConstraint(SpringLayout.NORTH, balanceLabel, 0, SpringLayout.NORTH, lblNewLabel_9);
		sl_panel_5.putConstraint(SpringLayout.WEST, balanceLabel, 0, SpringLayout.WEST, nameLabel);
		panel_5.add(balanceLabel);
		
		JLabel lblNewLabel_4 = new JLabel("Id");
		sl_panel_5.putConstraint(SpringLayout.NORTH, lblNewLabel_5, 23, SpringLayout.SOUTH, lblNewLabel_4);
		sl_panel_5.putConstraint(SpringLayout.WEST, lblNewLabel_4, 0, SpringLayout.WEST, lblNewLabel_3);
		sl_panel_5.putConstraint(SpringLayout.EAST, lblNewLabel_4, 0, SpringLayout.EAST, lblNewLabel_3);
		panel_5.add(lblNewLabel_4);
		
		JLabel idLabel = new JLabel(customer.getId().toString());
		sl_panel_5.putConstraint(SpringLayout.SOUTH, idLabel, -296, SpringLayout.SOUTH, panel_5);
		sl_panel_5.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 0, SpringLayout.NORTH, idLabel);
		sl_panel_5.putConstraint(SpringLayout.WEST, idLabel, 0, SpringLayout.WEST, nameLabel);
		panel_5.add(idLabel);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cardlayout = (CardLayout) panel_2.getLayout();
				cardlayout.show(panel_2, "name_70182361133900");
			}
		});
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item_id = textField_1.getText();
				String qty = spinner.getValue().toString();
				
				try {
					homeController.buy(item_id, qty);
				} catch (HeadlessException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				updateTable();
				try {
					updateUserProfile(customer);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cardlayout = (CardLayout) panel_2.getLayout();
				cardlayout.show(panel_2, "name_355984477506000");
			}
		});
		String[] columnNames = {"First Name",
                "Last Name",
                "Sport",
                "# of Years",
                "Vegetarian"};
		Object[][] data = {
			    {"Kathy", "Smith",
			     "Snowboarding", new Integer(5), new Boolean(false)},
			    {"John", "Doe",
			     "Rowing", new Integer(3), new Boolean(true)},
			    {"Sue", "Black",
			     "Knitting", new Integer(2), new Boolean(false)},
			    {"Jane", "White",
			     "Speed reading", new Integer(20), new Boolean(true)},
			    {"Joe", "Brown",
			     "Pool", new Integer(10), new Boolean(false)}
			};
		
	}
	
	public void updateTable() {
		ResultSet items = homeController.index();
		tableModel.setNumRows(0);
		try {
			while(items.next()) {
				Object[] data = { 
						items.getBigDecimal("id"), items.getString("name"), items.getBigDecimal("price"), items.getBigDecimal("stock")};
				tableModel.addRow(data);
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void updateUserProfile(Customer customer) throws SQLException {
		Customer temp;
		temp = homeController.customer(customer);
		balanceLabel.setText(temp.getBalance().toString());
		
	}
	
}
