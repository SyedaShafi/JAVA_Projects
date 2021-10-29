package todolist_project;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener{

	JLabel title;
	JLabel userId;
	JLabel password;
	
	JTextField userIdText;
	JPasswordField passwordText;
	
	JButton login;
	
	JPanel panel, panel2;
	public Login() {
		title = new JLabel();
		
		title.setFont(new Font(null,Font.PLAIN,28));
		title.setPreferredSize(new Dimension(400, 70));
		title.setHorizontalTextPosition(JLabel.CENTER);
		title.setVerticalTextPosition(JLabel.CENTER);
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setVerticalAlignment(JLabel.CENTER);
		
		userId = new JLabel("User ID");
		password = new JLabel("Password");
		login = new JButton("Login");
		userIdText = new JTextField();
		passwordText = new JPasswordField();
		panel = new JPanel();
		panel2 = new JPanel();
		
		userId.setPreferredSize(new Dimension(120, 50));
		userId.setBackground(Color.white);
		userId.setFont(new Font(null, Font.PLAIN, 18));
		userId.setOpaque(true);
		userId.setHorizontalAlignment(JLabel.CENTER);
		userId.setVerticalAlignment(JLabel.CENTER);
		
		password.setPreferredSize(new Dimension(120, 50));
		password.setBackground(Color.white);
		password.setFont(new Font(null, Font.PLAIN, 18));
		password.setOpaque(true);
		password.setHorizontalAlignment(JLabel.CENTER);
		password.setVerticalAlignment(JLabel.CENTER);
		
		
		userIdText.setPreferredSize(new Dimension(330, 50));
		userIdText.setFont(new Font(null, Font.PLAIN, 20));
		
		passwordText.setPreferredSize(new Dimension(330, 50));
		passwordText.setFont(new Font(null, Font.PLAIN, 20));
		
		
		login.setPreferredSize(new Dimension(130,60));
		login.setFont(new Font(null, Font.PLAIN, 22));
		login.setFocusable(false);
		
		panel.setPreferredSize(new Dimension(500, 120));
		panel.setBackground(Color.LIGHT_GRAY);
		
		panel2.setPreferredSize(new Dimension(500, 40));
		panel2.setBackground(Color.LIGHT_GRAY);
		
		login.addActionListener(this);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.lightGray);
		this.setSize(500,500);
		this.setLocation(300, 60);
		this.setLayout(new FlowLayout());
		
		this.add(panel);
		
		this.add(userId);
		this.add(userIdText);
		
		this.add(panel2);
		
		this.add(password);
		this.add(passwordText);
		
		this.add(login);
		
		
		this.setVisible(true);
		
	}
	
	
	
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String userid = userIdText.getText();
		String passWord = passwordText.getText();
		
		try {
			
			String query = "select * from signup where userid = '"+userid+"' and password = '"+passWord+"'";
			Connection con = CP.createConnection();
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			if(rs.next())
			{
				
				new todo().setVisible(true);
				this.setVisible(false);
				
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Incorrect id or password");
			}
			
		} 
		catch (Exception e2) {
			e2.printStackTrace();
		}
		

		
	}
	
//	public static void main(String[] args) {
//		new Login();
//		
//	}

}
