package vaccine_management_system;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class Logins extends JFrame {

	private JPanel contentPane;
	private JTextField U_name;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Logins frame = new Logins();
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
	public Logins() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1043, 703);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 204, 204));
		panel.setBorder(new TitledBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "LOG_IN", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(508, 22, 466, 614);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel.setBounds(196, 48, 84, 56);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(53, 155, 74, 37);
		panel.add(lblNewLabel_1);
		
		U_name = new JTextField();
		U_name.setFont(new Font("Tahoma", Font.PLAIN, 14));
		U_name.setColumns(10);
		U_name.setBounds(54, 202, 348, 47);
		panel.add(U_name);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(53, 299, 105, 30);
		panel.add(lblNewLabel_2);
		
		password = new JPasswordField();
		password.setFont(new Font("Tahoma", Font.PLAIN, 14));
		password.setBounds(53, 348, 349, 47);
		panel.add(password);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					System.out.println("Driver loaded successfully");
					Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","c##raj","git777");
					Statement stmt =c.createStatement();
					String sql = "select * from rstn where U_name='"+U_name.getText()+"' and password='"+password.getText().toString()+"'";
					ResultSet rs = stmt.executeQuery(sql);
					if(rs.next())
					{
						JOptionPane.showMessageDialog(null, "Login Success");
						Availability a = new Availability();
						a.setVisible(isVisible());
						a.setLocationRelativeTo(null);
						a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "Please Try Again!!");
					}
					
					
					
					}catch(Exception e1) {{
						System.out.println(e1);
					}
				}
				
				
			}
		});
		btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 15));
		btnNewButton.setBackground(new Color(204, 255, 204));
		btnNewButton.setBounds(196, 466, 96, 47);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\croma\\OneDrive\\Documents\\Person-Male-Light-icon.png"));
		lblNewLabel_3.setBounds(306, 26, 150, 131);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\croma\\OneDrive\\Documents\\profile-icon-png-891.png"));
		lblNewLabel_4.setBounds(10, 59, 472, 531);
		contentPane.add(lblNewLabel_4);
	}
}
