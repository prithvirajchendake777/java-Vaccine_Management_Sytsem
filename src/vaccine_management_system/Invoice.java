package vaccine_management_system;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.swing.JRViewer;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.awt.event.ActionEvent;

public class Invoice extends JFrame {

	private JPanel contentPane;
	private JTextField txtid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Invoice frame = new Invoice();
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
	public Invoice() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1089, 757);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel jpanel = new JPanel();
		jpanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		jpanel.setBounds(10, 64, 1055, 646);
		contentPane.add(jpanel);
		jpanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User ID  :");
		lblNewLabel.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 18));
		lblNewLabel.setBounds(54, 24, 99, 30);
		contentPane.add(lblNewLabel);
		
		txtid = new JTextField();
		txtid.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 18));
		txtid.setBounds(166, 24, 220, 30);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		JButton btnNewButton = new JButton("Generate Report");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					try {
						Class.forName("oracle.jdbc.driver.OracleDriver");
						System.out.println("Driver loaded successfully");
						Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","c##raj","git777");
					//	Statement stmt =c.createStatement();
							HashMap a = new HashMap();
							a.put("id", txtid.getText());
							jpanel.removeAll();
							jpanel.repaint();
							jpanel.revalidate();
						JasperDesign jdesign = JRXmlLoader.load("E:\\java workspace\\vaccine_management_system\\blank.jrxml");
						JasperReport jreport = JasperCompileManager.compileReport(jdesign);
						JasperPrint jprint = JasperFillManager.fillReport(jreport, a,c);
						JRViewer v = new JRViewer(jprint);
						jpanel.setLayout(new BorderLayout());
						jpanel.add(v);
						
					} catch (JRException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				
				
			}
		});
		btnNewButton.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 17));
		btnNewButton.setBounds(417, 24, 226, 30);
		contentPane.add(btnNewButton);
		connect();
	}
	
	Connection c;
	
	PreparedStatement pst;
	ResultSet rs;
	public void connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver loaded successfully");
			Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","c##raj","git777");
		//	Statement stmt =c.createStatement();
		//	ResultSet rs = stmt.executeQuery("select * from centre");
		//	while(rs.next())
			//{
			//	System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
		//	}
			
		
			
			}catch(Exception e) {{
				System.out.println(e);
			}
		}
	}
	
	
	
}
