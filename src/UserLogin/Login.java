package UserLogin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txt_un;
	private JTextField txt_ui;
	private JTextField txt_pw;
	private JTextField txt_loc;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("UserName");
		lblUsername.setForeground(Color.BLUE);
		lblUsername.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblUsername.setBounds(102, 74, 82, 14);
		contentPane.add(lblUsername);
		
		JLabel lblUserid = new JLabel("UserId");
		lblUserid.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblUserid.setForeground(Color.BLUE);
		lblUserid.setBounds(101, 106, 49, 14);
		contentPane.add(lblUserid);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.BLUE);
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblPassword.setBounds(101, 139, 64, 14);
		contentPane.add(lblPassword);
		
		txt_un = new JTextField();
		txt_un.setBounds(194, 71, 86, 20);
		contentPane.add(txt_un);
		txt_un.setColumns(10);
		
		txt_ui = new JTextField();
		txt_ui.setBounds(194, 103, 86, 20);
		contentPane.add(txt_ui);
		txt_ui.setColumns(10);
		
		txt_pw = new JTextField();
		txt_pw.setBounds(194, 139, 86, 20);
		contentPane.add(txt_pw);
		txt_pw.setColumns(10);
		
		JLabel lblLocation = new JLabel("Location");
		lblLocation.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblLocation.setForeground(Color.BLUE);
		lblLocation.setBounds(101, 181, 64, 14);
		contentPane.add(lblLocation);
		
		txt_loc = new JTextField();
		txt_loc.setBounds(194, 175, 86, 20);
		contentPane.add(txt_loc);
		txt_loc.setColumns(10);
		
		JButton btnSignup = new JButton("SignUp");
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSignup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try
			    {
			      // create a mysql database connection
			      String myDriver = "org.gjt.mm.mysql.Driver";
			      String myUrl = "jdbc:mysql://localhost/car_pool";
			      Class.forName(myDriver);
			      Connection conn = DriverManager.getConnection(myUrl, "root", "");
			     
			      // create a sql date object so we can use it in our INSERT statement
			      
			      // the mysql insert statement
			      String query = " insert into user (login_id, user_name, password, location)"
			        + " values (?, ?, ?, ?)";
			 
			      // create the mysql insert preparedstatement
			      PreparedStatement preparedStmt = conn.prepareStatement(query);
			    
			      preparedStmt.setString (1, txt_ui.getText());
			      preparedStmt.setString (2, txt_un.getText());
			      preparedStmt.setString   (3, txt_pw.getText());
			      preparedStmt.setString(4, txt_loc.getText());
			 
			      // execute the preparedstatement
			      if(preparedStmt.execute())
			      {
			    	  
			      }
			      
			    	  WelcomePage wcpkg = new WelcomePage();
			    	  wcpkg.setVisible(true);
			      
			       
			      conn.close();
			    }
			    catch (Exception e1)
			    {
			      System.err.println("Got an exception!");
			      System.err.println(e1.getMessage());
			    }
			
			}
		});
		btnSignup.setBounds(121, 216, 89, 23);
		contentPane.add(btnSignup);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setForeground(Color.BLUE);
		panel.setBounds(10, 37, 293, 213);
		contentPane.add(panel);
		
		passwordField = new JPasswordField();
		panel.add(passwordField);
		
		JLabel lblSigninToAvail = new JLabel("SignUp to Avail VZ Transports");
		lblSigninToAvail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSigninToAvail.setForeground(Color.BLUE);
		panel.add(lblSigninToAvail);
	}
}
