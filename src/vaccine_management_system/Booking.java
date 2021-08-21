package vaccine_management_system;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import java.text.SimpleDateFormat; 
import javax.swing.JFormattedTextField.AbstractFormatter;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.SystemColor;

public class Booking extends JFrame {

	private JPanel contentPane;
	private JTextField B_id;
	private JTextField u_id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Booking frame = new Booking();
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
	public Booking() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1257, 767);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 255));
	
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BOOK VACCINE");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(516, 68, 355, 39);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 204, 204));
		panel.setBorder(new TitledBorder(null, "BOOK VACCINE ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(50, 187, 547, 383);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("BOOKING ID :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(28, 69, 109, 29);
		panel.add(lblNewLabel_1);
		
		B_id = new JTextField();
		B_id.setBounds(170, 69, 265, 29);
		panel.add(B_id);
		B_id.setColumns(10);
		Random r1 = new Random();
		int temp1=r1.nextInt();
		B_id.setText("IND"+temp1);
		
		JLabel lblNewLabel_1_1 = new JLabel("USER ID :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(41, 140, 96, 29);
		panel.add(lblNewLabel_1_1);
		
		u_id = new JTextField();
		u_id.setBounds(170, 140, 265, 29);
		panel.add(u_id);
		u_id.setColumns(10);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("DATE :");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(41, 203, 83, 29);
		panel.add(lblNewLabel_1_1_1);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(170, 203, 265, 29);
		panel.add(dateChooser);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("SLOT :");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_1.setBounds(41, 269, 83, 29);
		panel.add(lblNewLabel_1_1_1_1);
		
		JRadioButton rb1 = new JRadioButton("10 AM -11 AM");
		rb1.setBackground(new Color(255, 204, 204));
		rb1.setBounds(170, 269, 103, 21);
		panel.add(rb1);
		
		JRadioButton rb2 = new JRadioButton("12 PM - 1 PM");
		rb2.setBackground(new Color(255, 204, 204));
		rb2.setBounds(275, 269, 99, 21);
		panel.add(rb2);
		
		JRadioButton rb3 = new JRadioButton("2 PM - 3 PM");
		rb3.setBackground(new Color(255, 204, 204));
		rb3.setBounds(386, 269, 96, 21);
		panel.add(rb3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 204, 204));
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "VACCINE ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(660, 187, 547, 241);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("VACCINE NAME :");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(10, 69, 127, 29);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("DOSE :");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_1_1.setBounds(54, 152, 83, 29);
		panel_1.add(lblNewLabel_1_1_1_1_1);
		
		JRadioButton rb4 = new JRadioButton("1");
		rb4.setBackground(new Color(255, 204, 204));
		rb4.setBounds(170, 158, 103, 21);
		panel_1.add(rb4);
		
		JRadioButton rb5 = new JRadioButton("2");
		rb5.setBackground(new Color(255, 204, 204));
		rb5.setBounds(275, 158, 99, 21);
		panel_1.add(rb5);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(255, 204, 204));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"COVISHIELD", "COVAXINE", "SPUTANIC-V", "COVAX", "PFIZER"}));
		comboBox.setBounds(170, 69, 265, 29);
		comboBox.setSelectedItem(null);
		panel_1.add(comboBox);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 204, 204));
		panel_2.setBorder(new TitledBorder(null, "BOOK", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(660, 453, 547, 106);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnBack = new JButton("INVOICE");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Invoice i = new Invoice();
				i.setVisible(isVisible());
				i.setLocationRelativeTo(null);
				i.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				dispose();				
				
		
			}
			
		});
		btnBack.setBackground(new Color(204, 255, 204));
		btnBack.setBounds(321, 23, 183, 61);
		panel_2.add(btnBack);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JButton btnNewButton = new JButton("BOOK");
		btnNewButton.setBackground(new Color(204, 255, 204));
		btnNewButton.setBounds(70, 23, 151, 61);
		panel_2.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
				//	System.out.println("Driver loaded successfully");
					Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","c##raj","git777");
					String sql = "insert into booking values(?, ?, ?, ?, ?, ?)";
					
				
					PreparedStatement stmt =c.prepareStatement(sql);
					String value=(String)comboBox.getSelectedItem();
					System.out.println(value);
					
					
					
					stmt.setString(1, B_id.getText());
					stmt.setString(2, u_id.getText());
					stmt.setString(3, value);
					stmt.setString(4, dateChooser.getDate().toString());
					if (rb1.isSelected()){
						stmt.setString(5,  rb1.getText());
					}
					else if (rb2.isSelected()) {
						stmt.setString(5,  rb2.getText());
					}
					else {
						stmt.setString(5,  rb3.getText());
					}
					if (rb4.isSelected()){
						stmt.setString(6,  rb4.getText());
					}else
						stmt.setString(6,  rb5.getText());
					stmt.executeUpdate();
					c.close();	
					}catch(Exception e1) {{
						JOptionPane.showMessageDialog(null, e1);
					}
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		connect();
	}
Connection con;
	
	PreparedStatement pst;
	ResultSet rs;
	public void connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver loaded successfully");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","c##raj","git777");
		
		
			
			}catch(Exception e) {{
				System.out.println(e);
			}
		}
	}
}
