package UserLogin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class RegCar extends JFrame {

	private JPanel contentPane;
	private JTextField txt_ruid;
	private JTextField txt_rrno;
	private JTextField txt_rcp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegCar frame = new RegCar();
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
	public RegCar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 723, 459);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegisterYourCar = new JLabel("Register Your Car ");
		lblRegisterYourCar.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblRegisterYourCar.setForeground(Color.BLUE);
		lblRegisterYourCar.setBounds(257, 33, 189, 29);
		contentPane.add(lblRegisterYourCar);
		
		JLabel lblUserid = new JLabel("UserId");
		lblUserid.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblUserid.setForeground(Color.BLUE);
		lblUserid.setBounds(62, 114, 46, 14);
		contentPane.add(lblUserid);
		
		txt_ruid = new JTextField();
		txt_ruid.setBounds(178, 111, 86, 20);
		contentPane.add(txt_ruid);
		txt_ruid.setColumns(10);
		
		JLabel lblRegistrationNo = new JLabel("Registration No");
		lblRegistrationNo.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblRegistrationNo.setForeground(Color.BLUE);
		lblRegistrationNo.setBounds(62, 154, 106, 14);
		contentPane.add(lblRegistrationNo);
		
		txt_rrno = new JTextField();
		txt_rrno.setBounds(178, 151, 86, 20);
		contentPane.add(txt_rrno);
		txt_rrno.setColumns(10);
		
		JLabel lblCapacity = new JLabel("Capacity");
		lblCapacity.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblCapacity.setForeground(Color.BLUE);
		lblCapacity.setBounds(62, 193, 93, 14);
		contentPane.add(lblCapacity);
		
		txt_rcp = new JTextField();
		txt_rcp.setBounds(178, 190, 86, 20);
		contentPane.add(txt_rcp);
		txt_rcp.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try
			    {
			      // create a mysql database connection
			      String myDriver = "org.gjt.mm.mysql.Driver";
			      String myUrl = "jdbc:mysql://localhost/car_pool";
			      Class.forName(myDriver);
			      Connection conn = DriverManager.getConnection(myUrl, "root", "");
			     
			      // create a sql date object so we can use it in our INSERT statement
			      
			      // the mysql insert statement
			      String query = " insert into car (user_id,capacity,plate_number)"
			        + " values (?, ?, ?)";
			 
			      // create the mysql insert preparedstatement
			      PreparedStatement preparedStmt = conn.prepareStatement(query);
			    
			      preparedStmt.setString (1, txt_ruid.getText());
			      preparedStmt.setString (2, txt_rrno.getText());
			      preparedStmt.setString   (3, txt_rcp.getText());
			 
			      // execute the preparedstatement
			      if(preparedStmt.execute())
			      {
			    	  
			      }
			      conn.close();
			      
			    	  WelcomePage wcpkg = new WelcomePage();
			    	  wcpkg.setVisible(true);
			      
			       
			      
			    }
			    catch (Exception e1)
			    {
			      System.err.println("Got an exception!");
			      System.err.println(e1.getMessage());
			    }
			
				WelcomePage wel = new WelcomePage();
				wel.setVisible(true);
			}
		});
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSubmit.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnSubmit.setForeground(Color.BLUE);
		btnSubmit.setBounds(124, 248, 89, 23);
		contentPane.add(btnSubmit);
	}
}
