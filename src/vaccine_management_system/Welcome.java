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
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

public class Welcome extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcome frame = new Welcome();
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
	public Welcome() {
		setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		setTitle("Co-WIN  VACCINATION SYSTEM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1208, 512);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 204, 204));
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "COWIN", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(77, 35, 1068, 351);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WELCOME TO CO-WIN VACCINATION SYSTEM");
		lblNewLabel.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 35));
		lblNewLabel.setBounds(133, 156, 925, 85);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\croma\\OneDrive\\Documents\\Medical-Immunologist-Male-Light-icon.png"));
		lblNewLabel_1.setBounds(431, 37, 149, 128);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Co-WIN \r\n Winnig Over Covid-19 Virus");
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		lblNewLabel_2.setBounds(283, 244, 554, 44);
		panel.add(lblNewLabel_2);
		
		JButton btnSignin = new JButton("Sign_UP");
		btnSignin.setBounds(413, 396, 123, 59);
		contentPane.add(btnSignin);
		btnSignin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				Register r = new Register();
				r.setVisible(isVisible());
				r.setLocationRelativeTo(null);
				r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				dispose();
				
				
			
			}
			
			
		});
		btnSignin.setBackground(new Color(204, 255, 204));
		btnSignin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnNewButton = new JButton("Log_IN");
		btnNewButton.setBounds(642, 396, 123, 59);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				Logins l1 = new Logins();
				l1.setVisible(isVisible());
				l1.setLocationRelativeTo(null);
				l1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				dispose();
				
				
			}
		});
		btnNewButton.setBackground(new Color(204, 255, 204));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
	}
}
