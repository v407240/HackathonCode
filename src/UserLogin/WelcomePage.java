package UserLogin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;

public class WelcomePage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomePage frame = new WelcomePage();
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
	public WelcomePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcomeToVz = new JLabel("Welcome to VZ Transports!!!");
		lblWelcomeToVz.setForeground(Color.BLUE);
		lblWelcomeToVz.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblWelcomeToVz.setBounds(90, 65, 277, 14);
		contentPane.add(lblWelcomeToVz);
		
		JButton btnRegisterCar = new JButton("Register Car");
		btnRegisterCar.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnRegisterCar.setForeground(Color.BLUE);
		btnRegisterCar.setBounds(64, 135, 118, 23);
		contentPane.add(btnRegisterCar);
		
		JButton btnPoolCab = new JButton("Pool Cab");
		btnPoolCab.setForeground(Color.BLUE);
		btnPoolCab.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnPoolCab.setBounds(192, 135, 106, 23);
		contentPane.add(btnPoolCab);
	}
}
