package vaccine_management_system;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Availability extends JFrame {

	private JPanel contentPane;
	private JTextField txtc_id;
	private JTextField txtc_name;
	private JTextField txtc_addr;
	private JTable table;
	private JTextField txtStatus;
	private JTextField txtsearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Availability frame = new Availability();
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
	public Availability() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1290, 774);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CHECK AVAILABILITY");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(485, 31, 332, 31);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 204, 204));
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Status", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(42, 257, 565, 358);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Centre ID :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(55, 57, 93, 31);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Centre NAME :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(43, 137, 105, 31);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Address :");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(55, 213, 93, 31);
		panel.add(lblNewLabel_1_1_1);
		
		txtc_id = new JTextField();
		txtc_id.setBounds(216, 59, 241, 31);
		panel.add(txtc_id);
		txtc_id.setColumns(10);
		
		txtc_name = new JTextField();
		txtc_name.setColumns(10);
		txtc_name.setBounds(216, 139, 241, 31);
		panel.add(txtc_name);
		
		txtc_addr = new JTextField();
		txtc_addr.setColumns(10);
		txtc_addr.setBounds(216, 215, 241, 31);
		panel.add(txtc_addr);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Status");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_1.setBounds(55, 287, 93, 31);
		panel.add(lblNewLabel_1_1_1_1);
		
		txtStatus = new JTextField();
		txtStatus.setColumns(10);
		txtStatus.setBounds(216, 287, 241, 31);
		panel.add(txtStatus);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(637, 135, 607, 480);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(255, 204, 204));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 204, 204));
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "SEARCH CENTRE", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(42, 135, 565, 82);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_2 = new JLabel("Enter Centre name :");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(25, 27, 164, 31);
		panel_1.add(lblNewLabel_1_2);
		
		txtsearch = new JTextField();
		txtsearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				

				try {
			          
		            String id = txtsearch.getText();
		            	Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","c##raj","git777");
		                pst = c.prepareStatement("select c_id,c_addr,status from centre where c_name = ?");
		                pst.setString(1, id);
		                ResultSet rs = pst.executeQuery();

		            if(rs.next()==true)
		            {
		              
		                String c_id = rs.getString(1);
		                
		                String c_addr = rs.getString(2);
		                String status = rs.getString(3);
		                
		                txtc_id.setText(c_id);
		                txtc_addr.setText(c_addr);
		                txtStatus.setText(status);
		                JOptionPane.showMessageDialog(null, "VACCINE IS "+ status);
		                
		                
		            }   
		            else
		            {
		            	txtc_id.setText("");
		            	txtc_addr.setText("");
		                txtStatus.setText("");
		                 
		            }
		            


		        } 
			
			 catch (SQLException ex) {
		           
		        }
				
			}
		});
		txtsearch.setColumns(10);
		txtsearch.setBounds(218, 27, 241, 31);
		panel_1.add(txtsearch);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.setBackground(new Color(204, 255, 204));
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
				
				String c_id,c_name,c_addr,status;
				c_id=txtc_id.getText();
				c_name=txtc_name.getText();
				c_addr=txtc_addr.getText();
				status=txtStatus.getText();
				
				 try {
					 	Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","c##raj","git777");
						pst = c.prepareStatement("insert into centre(c_id,c_name,c_addr,status)values(?,?,?,?)");
						pst.setString(1, c_id);
						pst.setString(2, c_name);
						pst.setString(3, c_addr);
						pst.setString(4,status);
						pst.executeUpdate();
						JOptionPane.showMessageDialog(null, "Record Addedddd!!!!!");
						table_load();
							           
						txtc_id.setText("");
						txtc_name.setText("");
						txtc_addr.setText("");
						txtStatus.setText("");
						txtc_id.requestFocus();
					   }
				 
					catch (SQLException e1) 
				        {
										
						System.out.print(e1);
					}
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(64, 657, 131, 49);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.setBackground(new Color(204, 255, 204));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(234, 657, 131, 49);
		contentPane.add(btnNewButton_1);
		
		JButton NEXT = new JButton("NEXT");
		NEXT.setBackground(new Color(204, 255, 204));
		NEXT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					Booking b1 = new Booking();
					b1.setVisible(isVisible());
					b1.setLocationRelativeTo(null);
					b1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					dispose();
				
			}
		});
		NEXT.setFont(new Font("Tahoma", Font.BOLD, 14));
		NEXT.setBounds(400, 657, 131, 49);
		contentPane.add(NEXT);
		connect();
		table_load();
	}
	Connection conn;
	
	PreparedStatement pst;
	ResultSet rs;
	public void connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver loaded successfully");
			Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","c##raj","git777");
		
			
			}catch(Exception e) {{
				System.out.println(e);
			}
		}
	}
	
	  public void table_load()
	    {
	    	try 
	    	{
	    	Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","c##raj","git777");
		    pst = c.prepareStatement("select * from centre");
		    rs = pst.executeQuery();
		    table.setModel(DbUtils.resultSetToTableModel(rs));
		} 
	    	catch (SQLException e) 
	    	 {
	    		e.printStackTrace();
		  } 
	    }
	
}
