package BMSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Deposit extends JFrame implements ActionListener {

	JTextField t1, t2;
	JButton b1, b2, b3;
	JLabel l1, l2, l3;
	
	
	public Deposit() {
		this.setTitle("DEPOSIT");
		
		l1 = new JLabel("ENTER AMOUNT YOU WANT");
		l1.setFont(new Font("System", Font.BOLD, 35));
		
		l2 = new JLabel("TO DEPOSIT");
		l2.setFont(new Font("System", Font.BOLD, 35));
		
		l3 = new JLabel("ENTER PIN: ");
		l3.setFont(new Font("System", Font.BOLD, 14));
		
		t1 = new JTextField();
		t1.setFont(new Font("Raleway", Font.BOLD, 22));
		
		t2 = new JTextField();
		t2.setFont(new Font("Raleway", Font.BOLD, 14));
		
		
		b1 = new JButton("DEPOSIT");
		b1.setFont(new Font("System", Font.BOLD, 18));
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		
		
		b2 = new JButton("BACK");
		b2.setFont(new Font("System", Font.BOLD, 18));
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		
		b3 = new JButton("EXIT");
		b3.setFont(new Font("System", Font.BOLD, 18));
		b3.setBackground(Color.black);
		b3.setForeground(Color.white);
		
		
		this.setLayout(null);
		
		l3.setBounds(600, 10, 100, 30);
		this.add(l3);
		
		t2.setBounds(700, 10, 40, 30);
		this.add(t2);
		
		l1.setBounds(150, 150, 800, 60);
		this.add(l1);
		
		l2.setBounds(290, 210, 800, 60);
		this.add(l2);
		
		t1.setBounds(250, 300, 300, 50);
		this.add(t1);
		
		b1.setBounds(260, 380, 125, 50);
		this.add(b1);
		
		b2.setBounds(415, 380, 125, 50);
		this.add(b2);
		
		b3.setBounds(300, 550, 200, 50);
		this.add(b3);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		
		this.getContentPane().setBackground(Color.white);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 800);
		this.setLocation(300, 10);
		this.setVisible(true);
		
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			
			String a = t1.getText();
			String b = t2.getText();
			
			
			if(e.getSource() == b1)
			{
				if(t1.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please enter the Amount you want to DEPOSIT");
					
				}
				
				else {
					Connection con = CP.createConnection();
					Statement statement = con.createStatement();
					String q = "select * from bank where pin = '"+b+"'";
					
					ResultSet rs = statement.executeQuery(q);
					
					double balance = 0;
					
					if(rs.next())
					{
						String pin = rs.getString("pin");
						balance = rs.getDouble("balance");
						
						double d = Double.parseDouble(a);
						
						balance+=d;
						
						String q1 = "insert into bank values('"+pin+"', '"+d+"', null, '"+balance+"')";
						
						statement.executeUpdate(q1);
					}
					
					
					JOptionPane.showMessageDialog(null, "Rs:"+a+" Deposit successful");
					
					new Transcations().setVisible(true);
					this.setVisible(false);
					
					
				}
			}
			
			
			else if(e.getSource() == b2)
			{
				new Transcations().setVisible(true);
				this.setVisible(false);
			}
			
			else if(e.getSource() == b3)
			{
				System.exit(0);
			}
			
			
		} 
		catch (Exception e2) {
			e2.printStackTrace();
		}
		
	}
	
	
	
	public static void main(String[] args) {
		new Deposit().setVisible(true);
		
	}

}
