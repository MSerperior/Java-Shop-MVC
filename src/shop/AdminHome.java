package shop;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.CardLayout;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AdminHome extends JFrame {

	private JPanel contentPane;
	private JTextField item_id_field;
	private JTextField item_name_field;
	private JTextField item_price_field;
	private JTextField item_stock_field;
	private JTextField update_item_id_field;
	private JTextField update_item_stock_field;
	private JTextField update_item_price_field;
	private JTextField top_up_user_id;
	private JTable table;
	private DefaultTableModel tableModel;
	private JTextField searchField;
	private AdminHomeController adminHomeController;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminHome frame = new AdminHome();
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
	public AdminHome() throws ClassNotFoundException, SQLException {
		
		adminHomeController = new AdminHomeController();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.WEST);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton add_items_button = new JButton("Add Items");
		
		GridBagConstraints gbc_add_items_button = new GridBagConstraints();
		gbc_add_items_button.fill = GridBagConstraints.HORIZONTAL;
		gbc_add_items_button.insets = new Insets(0, 0, 5, 0);
		gbc_add_items_button.gridx = 0;
		gbc_add_items_button.gridy = 0;
		panel.add(add_items_button, gbc_add_items_button);
		
		JButton update_items_button = new JButton("Update Items");
		
		GridBagConstraints gbc_update_items_button = new GridBagConstraints();
		gbc_update_items_button.fill = GridBagConstraints.HORIZONTAL;
		gbc_update_items_button.insets = new Insets(0, 0, 5, 0);
		gbc_update_items_button.gridx = 0;
		gbc_update_items_button.gridy = 1;
		panel.add(update_items_button, gbc_update_items_button);
		
		JButton top_up_button = new JButton("Top Up Balance");
		GridBagConstraints gbc_top_up_button = new GridBagConstraints();
		gbc_top_up_button.fill = GridBagConstraints.HORIZONTAL;
		gbc_top_up_button.gridx = 0;
		gbc_top_up_button.gridy = 2;
		panel.add(top_up_button, gbc_top_up_button);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new CardLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, "name_620037494065100");
		SpringLayout sl_panel_2 = new SpringLayout();
		panel_2.setLayout(sl_panel_2);
		
		JLabel lblNewLabel = new JLabel("Add Items");
		sl_panel_2.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.WEST, lblNewLabel, 200, SpringLayout.WEST, panel_2);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Item Id");
		sl_panel_2.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 57, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.WEST, lblNewLabel_1, 10, SpringLayout.WEST, panel_2);
		panel_2.add(lblNewLabel_1);
		
		item_id_field = new JTextField();
		sl_panel_2.putConstraint(SpringLayout.NORTH, item_id_field, 0, SpringLayout.NORTH, lblNewLabel_1);
		sl_panel_2.putConstraint(SpringLayout.WEST, item_id_field, 47, SpringLayout.EAST, lblNewLabel_1);
		panel_2.add(item_id_field);
		item_id_field.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Item Name");
		sl_panel_2.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 21, SpringLayout.SOUTH, lblNewLabel_1);
		sl_panel_2.putConstraint(SpringLayout.WEST, lblNewLabel_2, 0, SpringLayout.WEST, lblNewLabel_1);
		panel_2.add(lblNewLabel_2);
		
		item_name_field = new JTextField();
		sl_panel_2.putConstraint(SpringLayout.NORTH, item_name_field, -3, SpringLayout.NORTH, lblNewLabel_2);
		sl_panel_2.putConstraint(SpringLayout.WEST, item_name_field, 0, SpringLayout.WEST, item_id_field);
		panel_2.add(item_name_field);
		item_name_field.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Price");
		sl_panel_2.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 21, SpringLayout.SOUTH, lblNewLabel_2);
		sl_panel_2.putConstraint(SpringLayout.WEST, lblNewLabel_3, 0, SpringLayout.WEST, lblNewLabel_1);
		panel_2.add(lblNewLabel_3);
		
		item_price_field = new JTextField();
		sl_panel_2.putConstraint(SpringLayout.WEST, item_price_field, 0, SpringLayout.WEST, item_id_field);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, item_price_field, 0, SpringLayout.SOUTH, lblNewLabel_3);
		panel_2.add(item_price_field);
		item_price_field.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Stock");
		sl_panel_2.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 16, SpringLayout.SOUTH, lblNewLabel_3);
		sl_panel_2.putConstraint(SpringLayout.WEST, lblNewLabel_4, 0, SpringLayout.WEST, lblNewLabel_1);
		panel_2.add(lblNewLabel_4);
		
		item_stock_field = new JTextField();
		sl_panel_2.putConstraint(SpringLayout.NORTH, item_stock_field, -3, SpringLayout.NORTH, lblNewLabel_4);
		sl_panel_2.putConstraint(SpringLayout.WEST, item_stock_field, 0, SpringLayout.WEST, item_id_field);
		panel_2.add(item_stock_field);
		item_stock_field.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Add");
		sl_panel_2.putConstraint(SpringLayout.NORTH, btnNewButton_3, -1, SpringLayout.NORTH, item_id_field);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item item = new Item();
				item.setId(new BigDecimal(item_id_field.getText()));
				item.setName(item_name_field.getText());
				item.setPrice(new BigDecimal(item_price_field.getText()));
				item.setStock(new BigDecimal(item_stock_field.getText()));
				
				try {
					adminHomeController.addItem(item);
					new JOptionPane().showMessageDialog(null, "data has been added");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panel_2.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Clear");
		sl_panel_2.putConstraint(SpringLayout.WEST, btnNewButton_4, 62, SpringLayout.EAST, item_name_field);
		sl_panel_2.putConstraint(SpringLayout.WEST, btnNewButton_3, 0, SpringLayout.WEST, btnNewButton_4);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				item_id_field.setText("");
				item_name_field.setText("");
				item_price_field.setText("");
				item_stock_field.setText("");
			}
		});
		sl_panel_2.putConstraint(SpringLayout.NORTH, btnNewButton_4, 0, SpringLayout.NORTH, lblNewLabel_2);
		panel_2.add(btnNewButton_4);
		
		JScrollPane scrollPane = new JScrollPane();
		sl_panel_2.putConstraint(SpringLayout.NORTH, scrollPane, 228, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.WEST, scrollPane, 0, SpringLayout.WEST, lblNewLabel_1);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, scrollPane, -10, SpringLayout.SOUTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.EAST, scrollPane, 542, SpringLayout.WEST, panel_2);
		panel_2.add(scrollPane);
		
		table = new JTable();
		table.setEnabled(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Item Name", "Price", "Stock"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		scrollPane.setViewportView(table);
		tableModel = (DefaultTableModel) table.getModel();
		
		ResultSet result = adminHomeController.indexItem();
		
		try {
			while(result.next()) {
				Object[] data = { 
						result.getBigDecimal("id"), result.getString("name"), result.getBigDecimal("price"), result.getBigDecimal("stock")};
				tableModel.addRow(data);
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		searchField = new JTextField();
		sl_panel_2.putConstraint(SpringLayout.WEST, searchField, 10, SpringLayout.WEST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, searchField, -6, SpringLayout.NORTH, scrollPane);
		sl_panel_2.putConstraint(SpringLayout.EAST, searchField, 450, SpringLayout.WEST, panel_2);
		panel_2.add(searchField);
		searchField.setColumns(10);
		
		JButton searchButton = new JButton("Search");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tableModel.setNumRows(0);
				String q = searchField.getText();
				ResultSet result = adminHomeController.searchItems(q);
				
				try {
					while(result.next()) {
						Object[] data = { 
								result.getBigDecimal("id"), result.getString("name"), result.getBigDecimal("price"), result.getBigDecimal("stock")};
						tableModel.addRow(data);
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		sl_panel_2.putConstraint(SpringLayout.SOUTH, searchButton, -4, SpringLayout.NORTH, scrollPane);
		sl_panel_2.putConstraint(SpringLayout.EAST, searchButton, 0, SpringLayout.EAST, scrollPane);
		panel_2.add(searchButton);
		
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, "name_620045442799900");
		SpringLayout sl_panel_3 = new SpringLayout();
		panel_3.setLayout(sl_panel_3);
		
		JLabel lblNewLabel_5 = new JLabel("Update Items");
		sl_panel_3.putConstraint(SpringLayout.NORTH, lblNewLabel_5, 10, SpringLayout.NORTH, panel_3);
		sl_panel_3.putConstraint(SpringLayout.WEST, lblNewLabel_5, 201, SpringLayout.WEST, panel_3);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_3.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Id");
		sl_panel_3.putConstraint(SpringLayout.NORTH, lblNewLabel_6, 53, SpringLayout.NORTH, panel_3);
		sl_panel_3.putConstraint(SpringLayout.WEST, lblNewLabel_6, 10, SpringLayout.WEST, panel_3);
		sl_panel_3.putConstraint(SpringLayout.EAST, lblNewLabel_6, 28, SpringLayout.WEST, panel_3);
		panel_3.add(lblNewLabel_6);
		
		update_item_id_field = new JTextField();
		sl_panel_3.putConstraint(SpringLayout.NORTH, update_item_id_field, -3, SpringLayout.NORTH, lblNewLabel_6);
		sl_panel_3.putConstraint(SpringLayout.WEST, update_item_id_field, 65, SpringLayout.EAST, lblNewLabel_6);
		panel_3.add(update_item_id_field);
		update_item_id_field.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Stock");
		sl_panel_3.putConstraint(SpringLayout.NORTH, lblNewLabel_7, 25, SpringLayout.SOUTH, lblNewLabel_6);
		sl_panel_3.putConstraint(SpringLayout.WEST, lblNewLabel_7, 0, SpringLayout.WEST, lblNewLabel_6);
		panel_3.add(lblNewLabel_7);
		
		update_item_stock_field = new JTextField();
		sl_panel_3.putConstraint(SpringLayout.NORTH, update_item_stock_field, 0, SpringLayout.NORTH, lblNewLabel_7);
		sl_panel_3.putConstraint(SpringLayout.WEST, update_item_stock_field, 0, SpringLayout.WEST, update_item_id_field);
		panel_3.add(update_item_stock_field);
		update_item_stock_field.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Price");
		sl_panel_3.putConstraint(SpringLayout.NORTH, lblNewLabel_8, 31, SpringLayout.SOUTH, lblNewLabel_7);
		sl_panel_3.putConstraint(SpringLayout.WEST, lblNewLabel_8, 0, SpringLayout.WEST, lblNewLabel_6);
		panel_3.add(lblNewLabel_8);
		
		update_item_price_field = new JTextField();
		sl_panel_3.putConstraint(SpringLayout.NORTH, update_item_price_field, 0, SpringLayout.NORTH, lblNewLabel_8);
		sl_panel_3.putConstraint(SpringLayout.WEST, update_item_price_field, 0, SpringLayout.WEST, update_item_id_field);
		panel_3.add(update_item_price_field);
		update_item_price_field.setColumns(10);
		
		JButton btnNewButton = new JButton("Add Stock");
		
		sl_panel_3.putConstraint(SpringLayout.WEST, btnNewButton, 68, SpringLayout.EAST, update_item_id_field);
		sl_panel_3.putConstraint(SpringLayout.SOUTH, btnNewButton, 0, SpringLayout.SOUTH, lblNewLabel_6);
		panel_3.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Clear");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update_item_id_field.setText("");
				update_item_price_field.setText("");
				update_item_stock_field.setText("");
			}
		});
		sl_panel_3.putConstraint(SpringLayout.NORTH, btnNewButton_1, -4, SpringLayout.NORTH, lblNewLabel_8);
		sl_panel_3.putConstraint(SpringLayout.WEST, btnNewButton_1, 0, SpringLayout.WEST, btnNewButton);
		panel_3.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Change Price");
		
		sl_panel_3.putConstraint(SpringLayout.WEST, btnNewButton_2, 0, SpringLayout.WEST, btnNewButton);
		sl_panel_3.putConstraint(SpringLayout.SOUTH, btnNewButton_2, 0, SpringLayout.SOUTH, update_item_stock_field);
		panel_3.add(btnNewButton_2);
		
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4, "name_620048800437300");
		SpringLayout sl_panel_4 = new SpringLayout();
		panel_4.setLayout(sl_panel_4);
		
		JLabel lblNewLabel_9 = new JLabel("Top Up Balance");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		sl_panel_4.putConstraint(SpringLayout.NORTH, lblNewLabel_9, 10, SpringLayout.NORTH, panel_4);
		sl_panel_4.putConstraint(SpringLayout.WEST, lblNewLabel_9, 200, SpringLayout.WEST, panel_4);
		panel_4.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("User ID");
		sl_panel_4.putConstraint(SpringLayout.NORTH, lblNewLabel_10, 60, SpringLayout.NORTH, panel_4);
		sl_panel_4.putConstraint(SpringLayout.WEST, lblNewLabel_10, 10, SpringLayout.WEST, panel_4);
		panel_4.add(lblNewLabel_10);
		
		top_up_user_id = new JTextField();
		sl_panel_4.putConstraint(SpringLayout.WEST, top_up_user_id, 41, SpringLayout.EAST, lblNewLabel_10);
		sl_panel_4.putConstraint(SpringLayout.SOUTH, top_up_user_id, 0, SpringLayout.SOUTH, lblNewLabel_10);
		panel_4.add(top_up_user_id);
		top_up_user_id.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Balance");
		sl_panel_4.putConstraint(SpringLayout.NORTH, lblNewLabel_11, 25, SpringLayout.SOUTH, lblNewLabel_10);
		sl_panel_4.putConstraint(SpringLayout.WEST, lblNewLabel_11, 0, SpringLayout.WEST, lblNewLabel_10);
		panel_4.add(lblNewLabel_11);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"50000", "100000", "200000", "500000", "1000000"}));
		sl_panel_4.putConstraint(SpringLayout.WEST, comboBox, 0, SpringLayout.WEST, top_up_user_id);
		sl_panel_4.putConstraint(SpringLayout.SOUTH, comboBox, 0, SpringLayout.SOUTH, lblNewLabel_11);
		panel_4.add(comboBox);
		
		JButton btnNewButton_5 = new JButton("Top Up");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user_id = top_up_user_id.getText();
				String amount = comboBox.getSelectedItem().toString();
				adminHomeController.topUpUser(user_id, amount);
			}
		});
		sl_panel_4.putConstraint(SpringLayout.NORTH, btnNewButton_5, 24, SpringLayout.SOUTH, comboBox);
		sl_panel_4.putConstraint(SpringLayout.WEST, btnNewButton_5, 0, SpringLayout.WEST, top_up_user_id);
		panel_4.add(btnNewButton_5);
		
		
		add_items_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout) panel_1.getLayout();
				cardLayout.show(panel_1, "name_620037494065100");
			}
		});
		update_items_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout) panel_1.getLayout();
				cardLayout.show(panel_1, "name_620045442799900");
			}
		});
		
		top_up_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout) panel_1.getLayout();
				cardLayout.show(panel_1, "name_620048800437300");
			}
		});
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Item item = new Item();
				item.setId(new BigDecimal(update_item_id_field.getText()));
				String amount  = update_item_stock_field.getText();
				adminHomeController.addStock(item, amount);
				updateTable();
				new JOptionPane().showMessageDialog(null, "data has been updated");
			}
		});
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item item = new Item();
				item.setId(new BigDecimal(update_item_id_field.getText()));
				String price = update_item_price_field.getText();
				adminHomeController.updatePrice(item, price);
				updateTable();
				new JOptionPane().showMessageDialog(null, "data has been updated");
			}
		});
		
	}
	
	public void updateTable() {
		ResultSet items = adminHomeController.indexItem();
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
}
