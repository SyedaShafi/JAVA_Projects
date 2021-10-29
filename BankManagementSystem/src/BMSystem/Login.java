package BMSystem;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;


public class Login extends JFrame implements ActionListener{

	JLabel l1,l2,l3;
	JTextField tf1;
	JPasswordField pf2;
	JButton b1,b2,b3;
	
	public Login() {
		
		

		this.setTitle("AUTOMATED TELLER MACHINE");
		
		l1 = new JLabel("WELCOME TO ATM");
		l1.setFont(new Font("Osward", Font.BOLD, 38));
		
		l2 = new JLabel("Card No :");
		l2.setFont(new Font("Raleway", Font.BOLD, 28));
		
		l3 = new JLabel("PIN :");
		l3.setFont(new Font("Raleway", Font.BOLD, 28));
		
		tf1 = new JTextField(15);
		pf2 = new JPasswordField(15);
		
		
		b1 = new JButton("SIGN IN");
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		
		b2 = new JButton("CLEAR");
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		
		
		b3 = new JButton("SIGN UP");
		b3.setBackground(Color.black);
		b3.setForeground(Color.white);
		
		setLayout(null);
		
		l1.setBounds(175,50,450,200);
		add(l1);
		
		l2.setBounds(125,150,375,200);
		add(l2);
		
		l3.setBounds(125,225,375,200);
		add(l3);
		
		
		tf1.setFont(new Font("Arial", Font.BOLD, 14));
		tf1.setBounds(300,235,230,30);
		add(tf1);
		
		
		pf2.setFont(new Font("Arial", Font.BOLD, 14));
		pf2.setBounds(300,310,230,30);
		add(pf2);
		
		

		b1.setFont(new Font("Arial", Font.BOLD, 14));
		b1.setBounds(300,400,100,30);
		add(b1);
		

		b2.setFont(new Font("Arial", Font.BOLD, 14));
		b2.setBounds(430,400,100,30);
		add(b2);
		

		b3.setFont(new Font("Arial", Font.BOLD, 14));
		b3.setBounds(300,450,230,30);
		add(b3);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);

		getContentPane().setBackground(Color.white);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(750,750);
		setLocation(400,70);
		setVisible(true);
		
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			Connection conn = CP.createConnection();
			String a = tf1.getText();
			String b = pf2.getText();
			String q = "select * from login where cardno = '"+a+"' and pin = '"+b+"' ";
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(q);
			
			if(e.getSource() == b1)
			{
				if(rs.next())
				{
					new Transcations().setVisible(true);
					this.setVisible(false);
				}
				
				else {
					JOptionPane.showMessageDialog(null, "Incorrect Card no or Password");
				}
				
			}
			else if(e.getSource() == b2)
			{
				tf1.setText("");
				pf2.setText("");
			}
			
			else if(e.getSource() == b3)
			{
				new Signup().setVisible(true);
				this.setVisible(false);
			}
			
		} 
		catch (Exception e2) {
			e2.printStackTrace();
		}
		
		
		
	}
	public static void main(String[] args)
	{
		new Login().setVisible(true);;
	}

}
