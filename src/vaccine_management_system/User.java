package vaccine_management_system;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class User extends JFrame {

	private JPanel contentPane;
	private JTextField f_name;
	private JTextField l_name;
	private JTextField txtage;
	private JTextField txtaddr;
	private JTextField mob;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User frame = new User();
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
	public User() {
		setBackground(new Color(255, 255, 255));
		setTitle("CoWIN VACCINATION SYSTEM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1168, 772);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 255, 255));
		panel.setBounds(38, 50, 1078, 647);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("USER DETAILS ");
		lblNewLabel.setBackground(SystemColor.menu);
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
		lblNewLabel.setBounds(451, 10, 233, 45);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "USER REGISTRATION", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBackground(new Color(255, 204, 204));
		panel_1.setBounds(10, 102, 1058, 503);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		f_name = new JTextField();
		f_name.setFont(new Font("Tahoma", Font.PLAIN, 13));
		f_name.setBounds(194, 65, 295, 33);
		panel_1.add(f_name);
		f_name.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("FIRST NAME :");
		lblNewLabel_2.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 14));
		lblNewLabel_2.setBounds(52, 65, 94, 33);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("LAST NAME :");
		lblNewLabel_3.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 14));
		lblNewLabel_3.setBounds(52, 151, 94, 33);
		panel_1.add(lblNewLabel_3);
		
		l_name = new JTextField();
		l_name.setFont(new Font("Tahoma", Font.PLAIN, 13));
		l_name.setBounds(194, 151, 295, 33);
		panel_1.add(l_name);
		l_name.setColumns(10);
		
		JLabel lblNewLabel_3_1 = new JLabel("AGE :");
		lblNewLabel_3_1.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 14));
		lblNewLabel_3_1.setBounds(79, 233, 94, 33);
		panel_1.add(lblNewLabel_3_1);
		
		txtage = new JTextField();
		txtage.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtage.setColumns(10);
		txtage.setBounds(194, 233, 295, 33);
		panel_1.add(txtage);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("ADDRESS  :");
		lblNewLabel_3_1_1.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 14));
		lblNewLabel_3_1_1.setBounds(52, 346, 94, 33);
		panel_1.add(lblNewLabel_3_1_1);
		
		txtaddr = new JTextField();
		txtaddr.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtaddr.setColumns(10);
		txtaddr.setBounds(194, 318, 295, 89);
		panel_1.add(txtaddr);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("MOBILE NO. :");
		lblNewLabel_2_1_1_1.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 14));
		lblNewLabel_2_1_1_1.setBounds(570, 233, 94, 33);
		panel_1.add(lblNewLabel_2_1_1_1);
		
		mob = new JTextField();
		mob.setFont(new Font("Tahoma", Font.PLAIN, 13));
		mob.setColumns(10);
		mob.setBounds(707, 232, 278, 33);
		panel_1.add(mob);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
				//	System.out.println("Driver loaded successfully");
					Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","c##raj","git777");
					String sql = "insert into users values(?, ?, ?, ?, ?)";
					
					PreparedStatement stmt =c.prepareStatement(sql);
					stmt.setString(1, f_name.getText());
					stmt.setString(2, l_name.getText());
					stmt.setString(3, txtage.getText());
					stmt.setString(4, txtaddr.getText());
					stmt.setString(5, mob.getText());
				
					stmt.executeUpdate();
					Availability a = new Availability();
						a.setVisible(isVisible());
						a.setLocationRelativeTo(null);
						a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						dispose();
			
					c.close();
				
					
					
					}catch(Exception e1) {{
						JOptionPane.showMessageDialog(null, e1);
					}
				}
				
			}
		});
		btnNewButton.setBackground(new Color(204, 255, 204));
		btnNewButton.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 16));
		btnNewButton.setBounds(720, 330, 238, 49);
		panel_1.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\croma\\OneDrive\\Documents\\person-icon.png"));
		lblNewLabel_1.setBounds(652, 23, 141, 170);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon("C:\\Users\\croma\\OneDrive\\Documents\\Data-View-Details-icon.png"));
		lblNewLabel_1_1.setBounds(816, 23, 141, 170);
		panel_1.add(lblNewLabel_1_1);
	}
}
