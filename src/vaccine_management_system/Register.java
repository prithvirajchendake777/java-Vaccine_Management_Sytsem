package vaccine_management_system;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Window.Type;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class Register extends JFrame {

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
		setAlwaysOnTop(true);
		setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		setForeground(new Color(0, 0, 0));
		setTitle("Co-WIN \r\n Winnig Over Covid-19");
		setBackground(SystemColor.activeCaption);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1190, 765);
		contentPane = new JPanel();
		contentPane.setForeground(Color.LIGHT_GRAY);
		contentPane.setBackground(new Color(204, 255, 255));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.LIGHT_GRAY);
		panel.setBorder(new LineBorder(Color.WHITE, 2));
		panel.setBackground(new Color(255, 204, 204));
		panel.setBounds(261, 34, 643, 660);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\croma\\OneDrive\\Pictures\\heart-beat-icon128x128.png"));
		lblNewLabel.setBounds(259, 10, 128, 137);
		panel.add(lblNewLabel);
		
		U_name = new JTextField();
		U_name.setToolTipText("");
		U_name.setBackground(Color.WHITE);
		U_name.setFont(new Font("Tahoma", Font.PLAIN, 15));
		U_name.setBounds(64, 246, 516, 41);
		panel.add(U_name);
		U_name.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("ENTER USERNAME");
		lblNewLabel_1.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 14));
		lblNewLabel_1.setBounds(64, 195, 291, 41);
		panel.add(lblNewLabel_1);
		
		password = new JPasswordField();
		password.setBounds(64, 343, 516, 41);
		panel.add(password);
		
		JLabel lblNewLabel_2 = new JLabel(" ENTER PASSWORD");
		lblNewLabel_2.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 14));
		lblNewLabel_2.setBounds(64, 297, 291, 36);
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User u1 = new User();
				u1.setVisible(isVisible());
				
				u1.setLocationRelativeTo(null);
				u1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				dispose();
				
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					System.out.println("Driver loaded successfully");
					Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","c##raj","git777");
					String sqlq ="insert into rstn values(?,?)"; 
					PreparedStatement stmt1 =c.prepareStatement(sqlq);
				
					stmt1.setString(1, U_name.getText());
					stmt1.setString(2, password.getText());
				
					stmt1.executeUpdate();
					JOptionPane.showMessageDialog(null, "registration successfull!");
					c.close();
				
						
					}catch(Exception e1) {{
						JOptionPane.showMessageDialog(null, e1);
					}
				}
				
			}
		});
		btnNewButton.setBackground(new Color(204, 255, 204));
		btnNewButton.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 15));
		btnNewButton.setBounds(64, 429, 516, 41);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("Register or SignIn for Vaccination");
		lblNewLabel_3.setForeground(Color.BLUE);
		lblNewLabel_3.setFont(new Font("Comic Sans MS", Font.BOLD, 19));
		lblNewLabel_3.setBounds(161, 149, 353, 36);
		panel.add(lblNewLabel_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 204, 204));
		panel_1.setBounds(64, 557, 516, 70);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Arogya Setu");
		lblNewLabel_4.setBounds(60, 10, 152, 48);
		panel_1.add(lblNewLabel_4);
		lblNewLabel_4.setBackground(new Color(211, 211, 211));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\croma\\OneDrive\\Pictures\\icons8-heart-health-48.png"));
		
		JLabel lblNewLabel_4_1 = new JLabel("Ministry Of Health");
		lblNewLabel_4_1.setIcon(new ImageIcon("C:\\Users\\croma\\OneDrive\\Pictures\\icons8-india-national-emblem-48.png"));
		lblNewLabel_4_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4_1.setBackground(new Color(211, 211, 211));
		lblNewLabel_4_1.setBounds(312, 10, 170, 48);
		panel_1.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_5 = new JLabel("Co-WIN \r\n Winnig Over Covid-19");
		lblNewLabel_5.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 16));
		lblNewLabel_5.setBounds(201, 490, 284, 44);
		panel.add(lblNewLabel_5);
	}
}
