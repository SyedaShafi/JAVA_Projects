package com.signup;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

public class MyFrame extends JFrame implements ActionListener{
	
	JLabel title;
	
	JLabel firstName;
	JLabel lastName;
	JLabel emailId;
	JLabel password;
	
	JTextField firstNameText;
	JTextField lastNameText;
	JTextField emailIdText;
	JTextField passwordText;
	
	JButton submitButton;
	
	MyFrame()
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
		emailId = new JLabel("Email ID");
		password = new JLabel("Password");
		
		firstNameText = new JTextField();
		lastNameText = new JTextField();
		emailIdText = new JTextField();
		passwordText = new JTextField();
		
		submitButton = new JButton("Submit");
		
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
		this.setLayout(new FlowLayout());
		
		this.add(title);
		this.add(firstName);
		this.add(firstNameText);
		this.add(lastName);
		this.add(lastNameText);
		this.add(emailId);
		this.add(emailIdText);
		this.add(password);
		this.add(passwordText);
		this.add(submitButton);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == submitButton)
		{
			boolean result = false;
			
			String firstName = firstNameText.getText();
			String lastName = lastNameText.getText();
			String emailId = emailIdText.getText();
			String password = passwordText.getText();
			
			try {
				result = DataBase.insertionOfData(firstName,lastName, emailId, password);
			}
			catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			

			 firstNameText.setText("");
			 lastNameText.setText("");
			 emailIdText.setText("");
			 passwordText.setText("");
			
			
			
			if( result )
			{			
				JOptionPane.showConfirmDialog(null, "You are successfully logged in", "Signup conformation", JOptionPane.DEFAULT_OPTION);
				
			}
			else {
				JOptionPane.showMessageDialog(null, "Something wrong :( ", "Error message", JOptionPane.ERROR_MESSAGE);
			}
			
		}
	}

}
