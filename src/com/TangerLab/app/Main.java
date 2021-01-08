package com.TangerLab.app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import javax.swing.JComboBox;
import javax.swing.JButton;

import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JList;


public class Main {

	private JFrame frame;
	private JTextField textNom;
	private JTextField textDate;
	private JTextField textPrenom;
	private JTextField textAge;
	private JTextField textPrix;
	private JTable table;

	Connection conn;
	PreparedStatement stmt;
	private JTable table_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
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
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("rawtypes")
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.getContentPane().setForeground(Color.BLACK);
		frame.setBounds(100, 100, 1286, 747);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.info);
		panel.setBounds(10, 81, 468, 570);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nom :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(34, 69, 120, 40);
		panel.add(lblNewLabel);
		
		JLabel lblPrnom = new JLabel("Pr\u00E9nom :");
		lblPrnom.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPrnom.setBounds(34, 132, 120, 40);
		panel.add(lblPrnom);
		
		JLabel lblAge = new JLabel("Age  :");
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAge.setBounds(34, 195, 120, 40);
		panel.add(lblAge);
		
		JLabel lblService = new JLabel("Service  :");
		lblService.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblService.setBounds(34, 260, 120, 40);
		panel.add(lblService);
		
		JLabel lblDateEntreeService = new JLabel("Date Entree Service  :");
		lblDateEntreeService.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDateEntreeService.setBounds(34, 328, 153, 40);
		panel.add(lblDateEntreeService);
		
		JLabel lblPrixUnitaire = new JLabel("Prix(chiffre d'affaire/nbrUnite/nbrHeure) :");
		lblPrixUnitaire.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPrixUnitaire.setBounds(34, 385, 261, 50);
		panel.add(lblPrixUnitaire);
		
		textNom = new JTextField();
		textNom.setFont(new Font("Tahoma", Font.BOLD, 13));
		textNom.setBounds(188, 69, 251, 40);
		panel.add(textNom);
		textNom.setColumns(10);
		
		textDate = new JTextField();
		textDate.setFont(new Font("Tahoma", Font.BOLD, 13));
		textDate.setColumns(10);
		textDate.setBounds(188, 326, 251, 40);
		panel.add(textDate);
		
		textPrenom = new JTextField();
		textPrenom.setFont(new Font("Tahoma", Font.BOLD, 13));
		textPrenom.setColumns(10);
		textPrenom.setBounds(188, 130, 251, 40);
		panel.add(textPrenom);
		
		textAge = new JTextField();
		textAge.setFont(new Font("Tahoma", Font.BOLD, 13));
		textAge.setColumns(10);
		textAge.setBounds(188, 193, 251, 40);
		panel.add(textAge);
		
		JComboBox<?> cmbxService = new JComboBox();
		cmbxService.setFont(new Font("Tahoma", Font.BOLD, 14));
		cmbxService.setModel(new DefaultComboBoxModel(new String[] {"Vendeur", "Representant", "Producteur", "ProducteurARisque", "Manutentionnaire", "ManutentionnaireARisque"}));
		cmbxService.setBounds(188, 260, 251, 40);
		panel.add(cmbxService);
		
		textPrix = new JTextField();
		textPrix.setFont(new Font("Tahoma", Font.BOLD, 13));
		textPrix.setColumns(10);
		textPrix.setBounds(305, 389, 134, 40);
		panel.add(textPrix);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.control);
		panel_1.setBounds(34, 452, 405, 107);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			

	
         public void actionPerformed(ActionEvent e) {
				
				String nom = textNom.getText();
				String prenom = textPrenom.getText();
				String age = textAge.getText();
				String service = cmbxService.getSelectedItem().toString();
				String date = textDate.getText();
				String prix = textPrix.getText();
				
				
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tangerlab", "root", "");
					 
					
					 
					 stmt = conn.prepareStatement("insert into employe(nom,prenom,age,service,date_entree_service,prix_unitaire,salaire)values(?,?,?,?,?,?,?)");
						
					 stmt.setString(1,nom);
					 stmt.setString(2,prenom);
					 stmt.setString(3,age);
					 stmt.setString(4,service);
					 stmt.setString(5,date);
					 stmt.setString(6,prix);
					 
					 
					 
					 
				switch (service) {
					 
					case "Vendeur":
						
						double salaireVendeur =( 0.2 * Integer.parseInt(prix))+1500;
						
						 stmt.setDouble(7,salaireVendeur);
						
						 stmt.execute();
						
						break;
                    case "Representant":
                    	
                    	double salaireRepresentant =( 0.2 * Integer.parseInt(prix))+2500;
						
						 stmt.setDouble(7,salaireRepresentant);
						
						 stmt.execute();
						
						break;
                    case "Producteur":
                    	
                    	double salaireProducteur =( 5 * Integer.parseInt(prix));
						
						 stmt.setDouble(7,salaireProducteur);
						
						 stmt.execute();
	
	                    break;
                    case "ProducteurARisque":
                    	
                    	double salaireProducteurARisque =( 5 * Integer.parseInt(prix))+200;
						
						 stmt.setDouble(7,salaireProducteurARisque);
						
						 stmt.execute();
	
	                    break;
                    case "Manutentionnaire":
                    	
                    	double salaireManutentionnaire =( 50 * Integer.parseInt(prix));
					
						 stmt.setDouble(7,salaireManutentionnaire);
						
						 stmt.execute();
 	
	                    break;
                    case "ManutentionnaireARisque":
                    	
                    	double salaireManutentionnaireARisque =( 50 * Integer.parseInt(prix))+200;
						
						 stmt.setDouble(7,salaireManutentionnaireARisque);
						
						 stmt.execute();
	
  	                    break;

					default:
						break;
					}
					  
					 JOptionPane.showMessageDialog(btnAdd, "Employe Added Successfully");
						show();
					 textNom.setText("");
					 textPrenom.setText("");
					 textAge.setText("");
					 cmbxService.setSelectedIndex(0);
					 textDate.setText("");
					 textPrix.setText("");
					 
					 textNom.requestFocus();
					 
					 	 
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
	
		}
		});
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAdd.setBounds(10, 11, 103, 38);
		panel_1.add(btnAdd);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int msg = JOptionPane.showConfirmDialog(null, "Are you sure to delete", "Delete", JOptionPane.YES_NO_OPTION);
				if(msg==0) {
					
			
				
				 DefaultTableModel df = (DefaultTableModel)table.getModel();	
			     int selectedIndex = table.getSelectedRow();	
				
			
				
			     try {
						
						
						int id = Integer.parseInt(df.getValueAt(selectedIndex, 0).toString());
						
						
						 Class.forName("com.mysql.cj.jdbc.Driver");
						
						 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tangerlab", "root", "");
						 
					
					     stmt = conn.prepareStatement("DELETE from employe  where id = '" + id + "'");
						 stmt.executeUpdate();
						  
						 JOptionPane.showMessageDialog(btnAdd, "Employe Deleted Successfully");
						 show();
						 textNom.setText("");
						 textPrenom.setText("");
						 textAge.setText("");
						 cmbxService.setSelectedIndex(0);
						 textDate.setText("");
						 textPrix.setText("");
						 
						 textNom.requestFocus();
						
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
				
				
				

		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDelete.setBounds(210, 60, 126, 38);
		panel_1.add(btnDelete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				 DefaultTableModel df = (DefaultTableModel)table.getModel();	
			     int selectedIndex = table.getSelectedRow();
				
			     

					try {
						
						
						int id = Integer.parseInt(df.getValueAt(selectedIndex, 0).toString());
						
						String nom = textNom.getText();
						String prenom = textPrenom.getText();
						String age = textAge.getText();
						String service = cmbxService.getSelectedItem().toString();
						String date = textDate.getText();
						String prix = textPrix.getText();
						
						double salaire = 0; 
						
						
						
						Class.forName("com.mysql.cj.jdbc.Driver");
						
						 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tangerlab", "root", "");
						 
						
						 
							
					 
						 
						 
					switch (service) {
						 
						case "Vendeur":
							
							salaire =( 0.2 * Integer.parseInt(prix))+1500;
							
							
							
							break;
	                    case "Representant":
	                    	
	                    	salaire =( 0.2 * Integer.parseInt(prix))+2500;
							
							
							
							break;
	                    case "Producteur":
	                    	
	                    	salaire =( 5 * Integer.parseInt(prix));
							
							
		
		                    break;
	                    case "ProducteurARisque":
	                    	
	                    	salaire =( 5 * Integer.parseInt(prix))+200;
							
							
		
		                    break;
	                    case "Manutentionnaire":
	                    	
	                    	salaire =( 50 * Integer.parseInt(prix));
						
							
							
	 	
		                    break;
	                    case "ManutentionnaireARisque":
	                    	
	                    	salaire =( 50 * Integer.parseInt(prix))+200;
							
							
		
	  	                    break;

						default:
							break;
						}
					
//					update data -----------------
					
					 stmt = conn.prepareStatement("UPDATE employe SET " + "nom = '" + nom + "', prenom = '" + prenom + "', age = '" + age + "', date_entree_service = '" + date + "', service = '" + service + "', prix_unitaire = '" + prix+ "', salaire = '" + salaire + "' where id = '" + id + "'");
							 stmt.executeUpdate();
						  
						 JOptionPane.showMessageDialog(btnAdd, "Employe edited Successfully");
						 show();
						 textNom.setText("");
						 textPrenom.setText("");
						 textAge.setText("");
						 cmbxService.setSelectedIndex(0);
						 textDate.setText("");
						 textPrix.setText("");
						 
						 textNom.requestFocus();
						 
						 	 
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
		
			}
			     
			     
			     
			     
				
				
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnUpdate.setBounds(292, 11, 103, 38);
		panel_1.add(btnUpdate);
		
		JButton btnCancel = new JButton("Quitter");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCancel.setBounds(81, 60, 112, 38);
		panel_1.add(btnCancel);
		
		JButton btnOrder = new JButton("Show Employe");
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				show();
				
				
			}
});
		btnOrder.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnOrder.setBounds(123, 11, 159, 38);
		panel_1.add(btnOrder);
		
		JLabel lblNewLabel_1 = new JLabel("Registration form");
		lblNewLabel_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_1.setBackground(SystemColor.textHighlight);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 0, 179, 40);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Gestion des Employees");
		lblNewLabel_2.setForeground(SystemColor.inactiveCaptionBorder);
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel_2.setBounds(417, 11, 484, 59);
		frame.getContentPane().add(lblNewLabel_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.info);
		panel_2.setForeground(new Color(240, 240, 240));
		panel_2.setBounds(499, 81, 761, 231);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("List des Employe\u00E9s");
		lblNewLabel_1_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1.setBackground(SystemColor.textHighlight);
		lblNewLabel_1_1.setBounds(10, 0, 179, 40);
		panel_2.add(lblNewLabel_1_1);
		
		JScrollPane scrollTable = new JScrollPane();
		scrollTable.setBounds(10, 51, 741, 159);
		panel_2.add(scrollTable);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				

				 DefaultTableModel df = (DefaultTableModel)table.getModel();	
			     int selectedIndex = table.getSelectedRow();
				 textNom.setText(df.getValueAt(selectedIndex, 1).toString());
				 textPrenom.setText(df.getValueAt(selectedIndex, 2).toString());
				 textAge.setText(df.getValueAt(selectedIndex, 3).toString());
				 textDate.setText(df.getValueAt(selectedIndex, 5).toString());
				 textPrix.setText(df.getValueAt(selectedIndex, 6).toString());
				
				
				
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFont(new Font("Tahoma", Font.BOLD, 12));
		table.setModel(new DefaultTableModel(
				
			new Object[][] {
			},
			new String[] {
				"ID", "Nom", "Prenom", "Age", "Service", "Date Entree Service", "Prix", "Salaire"
			}
		) {

			public boolean isCellEditable(int rowIndex, int columnIndex) {
			    return false;
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(55);
		table.getColumnModel().getColumn(3).setPreferredWidth(50);
		table.getColumnModel().getColumn(4).setPreferredWidth(81);
		table.getColumnModel().getColumn(5).setPreferredWidth(107);
		table.getColumnModel().getColumn(6).setPreferredWidth(49);
		scrollTable.setViewportView(table);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.info);
		panel_3.setBounds(498, 323, 762, 328);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Employ\u00E9s lister par service");
		lblNewLabel_1_1_1.setBounds(10, 0, 259, 40);
		lblNewLabel_1_1_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1_1.setBackground(SystemColor.textHighlight);
		panel_3.add(lblNewLabel_1_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 120, 742, 197);
		panel_3.add(scrollPane);
		
		table_1 = new JTable();
		table_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nom", "Prenom", "Age", "Service"
			}
		));
		scrollPane.setViewportView(table_1);
		
		JComboBox serviceList = new JComboBox();
		serviceList.setFont(new Font("Tahoma", Font.BOLD, 15));
		serviceList.setModel(new DefaultComboBoxModel(new String[] {"Vendeur", "Representant", "Producteur", "ProducteurARisque", "Manutentionnaire", "ManutentionnaireARisque"}));
		serviceList.setBounds(163, 54, 249, 43);
		panel_3.add(serviceList);
		
		JButton btnList = new JButton("Lister");
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
//			
				String serviceListe= serviceList.getSelectedItem().toString();
              try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tangerlab", "root", "");
					 
					
					 
					 stmt = conn.prepareStatement("	SELECT * FROM `employe` WHERE service = '" + serviceListe + "'");
						
					 ResultSet result = stmt.executeQuery();
					 

					 DefaultTableModel df = (DefaultTableModel)table_1.getModel();
					 
					 df.setRowCount(0);
					 
					 while(result.next()) {
						int id = result.getInt("id");
						String nom = result.getString("nom");
						String prenom = result.getString("prenom");
						int age = result.getInt("age");
						String service = result.getString("service");
						
						
                        df.addRow(new Object[] {id,nom,prenom,age,service});
					 }
					
	 
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
				
				
				
				
			}
		});
		btnList.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnList.setBounds(462, 54, 128, 43);
		panel_3.add(btnList);
		

	
	}
	public void show() {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tangerlab", "root", "");
			 
			
			 
			 stmt = conn.prepareStatement("SELECT * FROM employe");
				
			 ResultSet result = stmt.executeQuery();
			 

			 DefaultTableModel df = (DefaultTableModel)table.getModel();
			 
			 df.setRowCount(0);
			 
			 while(result.next()) {
				int id = result.getInt("id");
				String nom = result.getString("nom");
				String prenom = result.getString("prenom");
				int age = result.getInt("age");
				String service = result.getString("service");
				String date_entree_service = result.getString("date_entree_service");
				int prix_unitaire = result.getInt("prix_unitaire");
				Double salaire = result.getDouble("salaire");
				
                df.addRow(new Object[] {id,nom,prenom,age,service,date_entree_service,prix_unitaire,salaire});
                
             }
			

		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
		
		
		
		
	}
}
