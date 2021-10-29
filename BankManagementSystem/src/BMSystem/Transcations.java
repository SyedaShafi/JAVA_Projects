package BMSystem;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Transcations extends JFrame implements ActionListener {
	
	JLabel l1;
	JButton b1,b2,b3,b4,b5,b6,b7;
	public Transcations() {
		
		this.setTitle("TRANSACTION");
		
		l1 = new JLabel("Please Select Your Transaction");
		l1.setFont(new Font("System", Font.BOLD, 38));
		
		b1 = new JButton("DEPOSIT");
		b1.setFont(new Font("System", Font.BOLD, 18));
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		
		
		b2 = new JButton("CASH WITHDRAWL");
		b2.setFont(new Font("System", Font.BOLD, 18));
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		
		
		b3 = new JButton("FAST CASH");
		b3.setFont(new Font("System", Font.BOLD, 18));
		b3.setBackground(Color.black);
		b3.setForeground(Color.white);
		
		
		b4 = new JButton("MINI STATEMENT");
		b4.setFont(new Font("System", Font.BOLD, 18));
		b4.setBackground(Color.black);
		b4.setForeground(Color.white);
		
		
		b5 = new JButton("PIN CHANGE");
		b5.setFont(new Font("System", Font.BOLD, 18));
		b5.setBackground(Color.black);
		b5.setForeground(Color.white);
		
		b6 = new JButton("BALANCE ENQUIRY");
		b6.setFont(new Font("System", Font.BOLD, 18));
		b6.setBackground(Color.black);
		b6.setForeground(Color.white);
		
		
		b7 = new JButton("EXIT");
		b7.setFont(new Font("System", Font.BOLD, 18));
		b7.setBackground(Color.black);
		b7.setForeground(Color.white);
		
		this.setLayout(null);
		
		
		l1.setBounds(100, 100, 700, 40);
		this.add(l1);
		
		
		b1.setBounds(40, 250, 300, 60);
		this.add(b1);
		
		b2.setBounds(440, 250, 300, 60);
		this.add(b2);
		
		b3.setBounds(40, 360, 300, 60);
		this.add(b3);
		
		b4.setBounds(440, 360, 300, 60);
		this.add(b4);
		
		b5.setBounds(40, 470, 300, 60);
		this.add(b5);
		
		b6.setBounds(440, 470, 300, 60);
		this.add(b6);
		
		b7.setBounds(240, 600, 300, 60);
		this.add(b7);
		
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);

		this.getContentPane().setBackground(Color.white);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 800);
		this.setLocation(300, 10);
		this.setVisible(true);
	
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == b1)
		{
			new Deposit().setVisible(true);
			this.setVisible(false);
		}
		
		else if (e.getSource() == b2)
		{
			new Withdrawl().setVisible(true);
			this.setVisible(false);
			
		}
		
		else if(e.getSource() == b3)
		{
			new FastCash().setVisible(true);
			this.setVisible(false);
		}
		
		else if(e.getSource() == b4)
		{
			new Login().setVisible(true);
			this.setVisible(false);
		}
		
		else if(e.getSource() == b5)
		{
			new Pin().setVisible(true);
			this.setVisible(false);
		}
		
		else if(e.getSource() == b6)
		{
			
			String pinn = JOptionPane.showInputDialog("Enter PIN");
			Connection con = CP.createConnection();
			
			
			try 
			{
				Statement statement = con.createStatement();
				String q = "select balance from bank order by pin = '"+pinn+"' DESC LIMIT 1";
				ResultSet rs = statement.executeQuery(q);
				
				if(rs.next())
				{
					String balance = rs.getString("balance");
					
					JOptionPane.showMessageDialog(null, "Your Account Balance is "+balance);
				}
				
			}
			
			catch (Exception e2)
			{
				e2.printStackTrace();
			}		
		}
		
		else if(e.getSource() == b7)
		{
			System.exit(0);
		}
		
	}
	
	
	public static void main(String[] args) {
		
		new Transcations().setVisible(true);
		
	}
	

}
