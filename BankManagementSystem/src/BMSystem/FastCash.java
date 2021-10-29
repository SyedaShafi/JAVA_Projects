package BMSystem;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class FastCash extends JFrame implements ActionListener{

	JLabel l1, l2;
	JButton b1, b2, b3, b4, b5, b6, b7;
	JTextField t1;
	
	public FastCash() {
		
		this.setTitle("FAST CASH");
		
		l1 = new JLabel("SELECT WITHDRAWL AMOUNT");
		l1.setFont(new Font("System", Font.BOLD, 38));
		
		l2 = new JLabel("Enter PIN");
		l2.setFont(new Font("System", Font.BOLD, 13));
		
		t1 = new JTextField();
		t1.setFont(new Font("System", Font.BOLD, 13));
		
		
		b1 = new JButton("Rs 100");
		b1.setFont(new Font("System", Font.BOLD, 18));
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		
		b2 = new JButton("Rs 500");
		b2.setFont(new Font("System", Font.BOLD, 18));
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		
		b3 = new JButton("Rs 1000");
		b3.setFont(new Font("System", Font.BOLD, 18));
		b3.setBackground(Color.black);
		b3.setForeground(Color.white);
		
		b4 = new JButton("Rs 2000");
		b4.setFont(new Font("System", Font.BOLD, 18));
		b4.setBackground(Color.black);
		b4.setForeground(Color.white);
		
		b5 = new JButton("Rs 5000");
		b5.setFont(new Font("System", Font.BOLD, 18));
		b5.setBackground(Color.black);
		b5.setForeground(Color.white);

		b6 = new JButton("Rs 10000");
		b6.setFont(new Font("System", Font.BOLD, 18));
		b6.setBackground(Color.black);
		b6.setForeground(Color.white);
		

		b7 = new JButton("BACK");
		b7.setFont(new Font("System", Font.BOLD, 18));
		b7.setBackground(Color.black);
		b7.setForeground(Color.white);
		
		this.setLayout(null);
		
		l2.setBounds(640, 10, 60, 40);
		this.add(l2);
		
		t1.setBounds(710, 10, 60, 40);
		this.add(t1);
		
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
		try {
			
			String a = t1.getText();
			double balance = 0;
			
			if(e.getSource() == b1)
			{
				Connection con = CP.createConnection();
				Statement statement = con.createStatement();
				
				ResultSet rs = statement.executeQuery("select * from bank where pin = '"+a+"'");
				if(rs.next())
				{
					String pin = rs.getString("pin");
					
					balance = rs.getDouble("balance");
					
					balance -= 100;
					String q1 = "insert into bank values('"+pin+"', null, 100, '"+balance+"')";
					statement.executeUpdate(q1);
					
				}
				
				JOptionPane.showMessageDialog(null, "Rs. 100 Debited Successfully");
				
				new Transcations().setVisible(true);
				this.setVisible(false);	
			}
			
			
			else if(e.getSource() == b2)
			{
				Connection con = CP.createConnection();
				Statement statement = con.createStatement();
				
				ResultSet rs = statement.executeQuery("select * from bank where pin = '"+a+"'");
				if(rs.next())
				{
					String pin = rs.getString("pin");
					
					balance = rs.getDouble("balance");
					
					balance -= 500;
					String q1 = "insert into bank values('"+pin+"', null, 100, '"+balance+"')";
					statement.executeUpdate(q1);
					
				}
				
				JOptionPane.showMessageDialog(null, "Rs. 500 Debited Successfully");
				
				new Transcations().setVisible(true);
				this.setVisible(false);	
				
			}
			

			else if(e.getSource() == b3)
			{
				Connection con = CP.createConnection();
				Statement statement = con.createStatement();
				
				ResultSet rs = statement.executeQuery("select * from bank where pin = '"+a+"'");
				if(rs.next())
				{
					String pin = rs.getString("pin");
					
					balance = rs.getDouble("balance");
					
					balance -= 1000;
					String q1 = "insert into bank values('"+pin+"', null, 100, '"+balance+"')";
					statement.executeUpdate(q1);
					
				}
				
				JOptionPane.showMessageDialog(null, "Rs. 1000 Debited Successfully");
				
				new Transcations().setVisible(true);
				this.setVisible(false);	
				
			}
			

			else if(e.getSource() == b4)
			{
				Connection con = CP.createConnection();
				Statement statement = con.createStatement();
				
				ResultSet rs = statement.executeQuery("select * from bank where pin = '"+a+"'");
				if(rs.next())
				{
					String pin = rs.getString("pin");
					
					balance = rs.getDouble("balance");
					
					balance -= 2000;
					String q1 = "insert into bank values('"+pin+"', null, 100, '"+balance+"')";
					statement.executeUpdate(q1);
					
				}
				
				JOptionPane.showMessageDialog(null, "Rs. 2000 Debited Successfully");
				
				new Transcations().setVisible(true);
				this.setVisible(false);	
				
			}
			
			

			else if(e.getSource() == b5)
			{
				Connection con = CP.createConnection();
				Statement statement = con.createStatement();
				
				ResultSet rs = statement.executeQuery("select * from bank where pin = '"+a+"'");
				if(rs.next())
				{
					String pin = rs.getString("pin");
					
					balance = rs.getDouble("balance");
					
					balance -= 5000;
					String q1 = "insert into bank values('"+pin+"', null, 100, '"+balance+"')";
					statement.executeUpdate(q1);
					
				}
				
				JOptionPane.showMessageDialog(null, "Rs. 5000 Debited Successfully");
				
				new Transcations().setVisible(true);
				this.setVisible(false);	
				
			}
			

			else if(e.getSource() == b6)
			{
				Connection con = CP.createConnection();
				Statement statement = con.createStatement();
				
				ResultSet rs = statement.executeQuery("select * from bank where pin = '"+a+"'");
				if(rs.next())
				{
					String pin = rs.getString("pin");
					
					balance = rs.getDouble("balance");
					
					balance -= 10000;
					String q1 = "insert into bank values('"+pin+"', null, 100, '"+balance+"')";
					statement.executeUpdate(q1);
					
				}
				
				JOptionPane.showMessageDialog(null, "Rs. 10000 Debited Successfully");
				
				new Transcations().setVisible(true);
				this.setVisible(false);	
				
			}
			
			else if(e.getSource() == b7)
			{
				System.exit(0);
			}
			
			
			
		} 
		catch (Exception e2) {
			e2.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		new FastCash().setVisible(true);
		
	}

}
