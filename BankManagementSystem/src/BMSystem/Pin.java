package BMSystem;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;



public class Pin extends JFrame implements ActionListener{

	JPasswordField t1, t2, t3;
	JButton b1, b2;
	JLabel l1, l2, l3, l4;
	
	public Pin() {
		this.setTitle("PIN CHANGE");
		
		l1 = new JLabel("Change Your PIN");
		l1.setFont(new Font("System", Font.BOLD, 35));
		
		l2 = new JLabel("Current PIN:");
		l2.setFont(new Font("System", Font.BOLD, 22));
		
		l3 = new JLabel("New PIN:");
		l3.setFont(new Font("System", Font.BOLD, 22));
		
		l4 = new JLabel("Re-enter New PIN:");
		l4.setFont(new Font("System", Font.BOLD, 22));
		
		
		t1 = new JPasswordField();
		t1.setFont(new Font("Raleway", Font.BOLD, 22));
		
		t2 = new JPasswordField();
		t2.setFont(new Font("Raleway", Font.BOLD, 22));
		
		t3 = new JPasswordField();
		t3.setFont(new Font("Raleway", Font.BOLD, 22));
		
		
		b1 = new JButton("SAVE");
		b1.setFont(new Font("System", Font.BOLD, 18));
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		

		b2 = new JButton("BACK");
		b2.setFont(new Font("System", Font.BOLD, 18));
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		
		this.setLayout(null);
		
		l1.setBounds(220, 130, 800, 60);
		this.add(l1);
		
		l2.setBounds(100, 240, 150, 40);
		this.add(l2);
		
		l3.setBounds(100, 300, 150, 40);
		this.add(l3);
		
		l4.setBounds(100, 360, 200, 40);
		this.add(l4);
		
		t1.setBounds(310, 240, 360, 40);
		this.add(t1);
		
		t2.setBounds(310, 300, 360, 40);
		this.add(t2);
		
		t3.setBounds(310, 360, 360, 40);
		this.add(t3);
		
		b1.setBounds(220, 460, 160, 50);
		this.add(b1);
		
		b2.setBounds(400, 460, 160, 50);
		this.add(b2);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.white);
		this.setSize(800, 800);
		this.setLocation(300, 10);
		this.setVisible(true);
		
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		try 
		{
			String a = t1.getText();
			String b = t2.getText();
			String c = t3.getText();
			
			if(e.getSource() == b1)
			{
				if(t1.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please enter current PIN");
					
				}
				
				if(t2.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Enter New PIN");
					
				}
				
				if(t3.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Re-enter new PIN");
				}
					
					
				if(t2.getText().equals(t3.getText()))	
				{
					Connection con = CP.createConnection();
					Statement statement = con.createStatement();
					String q1 = "update bank set pin = '"+b+"' where pin = '"+a+"' ";
					String q2 = "update login set pin = '"+b+"' where pin = '"+a+"' ";
					String q3 = "update signup3 set pin = '"+b+"' where pin = '"+a+"' ";
					
					statement.executeUpdate(q1);
					statement.executeUpdate(q2);
					statement.executeUpdate(q3);
					
					JOptionPane.showMessageDialog(null, "PIN changed successfully");
					
					
					new Transcations().setVisible(true);
					this.setVisible(false);
					
				}
				
				else
				{
					
					JOptionPane.showMessageDialog(null, "PIN entered doesn't match");
					
				}
					
			}
			
			else if(e.getSource() == b2)
			{
				new Transcations().setVisible(true);
				this.setVisible(false);
			}
			
		} 
		
		
		catch (Exception e2) 
		{
			e2.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		new Pin().setVisible(true);
		
	}

}
