package todolist_project;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Signup extends JFrame implements ActionListener {

    JLabel title;
	
	JLabel firstName;
	JLabel lastName;
	JLabel userId;
	JLabel emailId;
	JLabel password;
	
	JTextField firstNameText;
	JTextField lastNameText;
	JTextField userIdText;
	JTextField emailIdText;
	JPasswordField passwordText;
	
	JButton submitButton;
	
	Signup()
	{
		title = new JLabel("Signup Form");
		
		title.setFont(new Font(null,Font.PLAIN,28));
		title.setPreferredSize(new Dimension(400, 70));
		title.setHorizontalTextPosition(JLabel.CENTER);
		title.setVerticalTextPosition(JLabel.CENTER);
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setVerticalAlignment(JLabel.CENTER);
		
		firstName = new JLabel("First Name : ");
		lastName = new JLabel("Last Name");
		userId = new JLabel("User ID");
		emailId = new JLabel("Email ID");
		password = new JLabel("Password");
		
		firstNameText = new JTextField();
		lastNameText = new JTextField();
		userIdText = new JTextField();
		emailIdText = new JTextField();
		passwordText = new JPasswordField();
		
		submitButton = new JButton("Signup");
		
		
		firstName.setPreferredSize(new Dimension(120,50));
		firstName.setFont(new Font(null,Font.PLAIN,18));
		firstName.setBackground(Color.white);
		firstName.setOpaque(true);
		firstName.setHorizontalAlignment(JLabel.CENTER);
		firstName.setVerticalAlignment(JLabel.CENTER);
		
		
		lastName.setPreferredSize(new Dimension(120,50));
		lastName.setFont(new Font(null,Font.PLAIN,18));
		lastName.setBackground(Color.white);
		lastName.setOpaque(true);
		lastName.setHorizontalAlignment(JLabel.CENTER);
		lastName.setVerticalAlignment(JLabel.CENTER);
		
		userId.setPreferredSize(new Dimension(120,50));
		userId.setFont(new Font(null,Font.ITALIC,18));
		userId.setBackground(Color.white);
		userId.setOpaque(true);
		userId.setHorizontalAlignment(JLabel.CENTER);
		userId.setVerticalAlignment(JLabel.CENTER);
		
		emailId.setPreferredSize(new Dimension(120,50));
		emailId.setFont(new Font(null,Font.PLAIN,18));
		emailId.setBackground(Color.white);
		emailId.setOpaque(true);
		emailId.setHorizontalAlignment(JLabel.CENTER);
		emailId.setVerticalAlignment(JLabel.CENTER);
		
		
		password.setPreferredSize(new Dimension(120,50));
		password.setFont(new Font(null,Font.PLAIN,18));
		password.setBackground(Color.white);
		password.setOpaque(true);
		password.setHorizontalAlignment(JLabel.CENTER);
		password.setVerticalAlignment(JLabel.CENTER);
		
		
		
		
		firstNameText.setPreferredSize(new Dimension(330,50));
		firstNameText.setFont(new Font(null,Font.PLAIN,20));
		
		
		lastNameText.setPreferredSize(new Dimension(330,50));
		lastNameText.setFont(new Font(null,Font.PLAIN,20));
		
		userIdText.setPreferredSize(new Dimension(330,50));
		userIdText.setFont(new Font(null,Font.PLAIN,20));
		
		
		emailIdText.setPreferredSize(new Dimension(330,50));
		emailIdText.setFont(new Font(null,Font.PLAIN,20));
		
		
		passwordText.setPreferredSize(new Dimension(330,50));
		passwordText.setFont(new Font(null,Font.PLAIN,20));
		
		
		submitButton.setPreferredSize(new Dimension(130,60));
		submitButton.setFont(new Font(null, Font.PLAIN, 22));
		submitButton.setFocusable(false);
		
		
		
		
		submitButton.addActionListener(this);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.lightGray);
		this.setSize(500,500);
		this.setLocation(300, 60);
		this.setLayout(new FlowLayout());
		
		this.add(title);
		this.add(firstName);
		this.add(firstNameText);
		this.add(lastName);
		this.add(lastNameText);
		this.add(userId);
		this.add(userIdText);
		this.add(password);
		this.add(passwordText);
		this.add(emailId);
		this.add(emailIdText);
		this.add(submitButton);
	
		
		this.setVisible(true);
	
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == submitButton)
		{
			
			 String firstname = firstNameText.getText();
			 String lastname = lastNameText.getText();
			 String userid = userIdText.getText();
			 String passWord = passwordText.getText();
			 String email = emailIdText.getText();
			 
			 
			 try {
				Connection con = CP.createConnection();
				PreparedStatement statement = con.prepareStatement("insert into signup(firstname, lastname, userid, password, email) values(?,?,?,?,?)");
				statement.setString(1, firstname);
				statement.setString(2, lastname);
				statement.setString(3, userid);
				statement.setString(4, passWord);
				statement.setString(5, email);
				
				statement.executeUpdate();
				
				JOptionPane.showMessageDialog(null, "Signup successful(data added)");
				
				firstNameText.setText("");
				lastNameText.setText("");
				userIdText.setText("");
				passwordText.setText("");
				emailIdText.setText("");
				
				new todo().setVisible(true);
				this.setVisible(false);
				
				
			} 
			 catch (Exception e2) {
				e2.printStackTrace();
			} 
			 
		}
		
//		else if(e.getSource() != submitButton)
//		{
//			
//			
//			this.setVisible(true);
//			
//		}
		
	}
	
//	public static void main(String[] args) {
//		
//		new Signup();
//	}

}
