package BMSystem;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Signup2 extends JFrame implements ActionListener{

	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
	JButton b;
	JRadioButton r1, r2, r3, r4;
	JTextField t1, t2, t3;
	JComboBox c1,c2,c3,c4,c5;
	
	
	
	public Signup2() {
		this.setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
		
		l1 = new JLabel("Page 2: Additinal Details");
		l1.setFont(new Font("Raleway", Font.BOLD, 22));

		
		l2 = new JLabel("Religion:");
		l2.setFont(new Font("Raleway", Font.BOLD, 18));

		l3 = new JLabel("Category:");
		l3.setFont(new Font("Raleway", Font.BOLD, 18));

		l4 = new JLabel("Income:");
		l4.setFont(new Font("Raleway", Font.BOLD, 18));

		l5 = new JLabel("Educational");
		l5.setFont(new Font("Raleway", Font.BOLD, 18));

		l11 = new JLabel("Qualification:");
		l11.setFont(new Font("Raleway", Font.BOLD, 18));

		l6 = new JLabel("Occupation:");
		l6.setFont(new Font("Raleway", Font.BOLD, 18));

		l7 = new JLabel("PAN Number:");
		l7.setFont(new Font("Raleway", Font.BOLD, 18));

		l8 = new JLabel("Aadhar Number:");
		l8.setFont(new Font("Raleway", Font.BOLD, 18));

		l9 = new JLabel("Senior Citizen:");
		l9.setFont(new Font("Raleway", Font.BOLD, 18));

		l10 = new JLabel("Existing Account:");
		l10.setFont(new Font("Raleway", Font.BOLD, 18));

		l12 = new JLabel("Form No:");
		l12.setFont(new Font("Raleway", Font.BOLD, 13));

		
		
		b = new JButton("Next");
		b.setFont(new Font("Raleway", Font.BOLD, 14));
		b.setBackground(Color.black);
		b.setForeground(Color.white);
		
		
		
		t1 = new JTextField();
		t1.setFont(new Font("Raleway", Font.BOLD, 14));
		
		t2 = new JTextField();
		t2.setFont(new Font("Raleway", Font.BOLD, 14));
		
		t3 = new JTextField();
		t3.setFont(new Font("Raleway", Font.BOLD, 13));
		
		
		r1 = new JRadioButton("Yes");
		r1.setFont(new Font("Raleway", Font.BOLD, 14));
		r1.setBackground(Color.white);
		
		r2 = new JRadioButton("No");
		r2.setFont(new Font("Raleway", Font.BOLD, 14));
		r2.setBackground(Color.white);
		
		r3 = new JRadioButton("Yes");
		r3.setFont(new Font("Raleway", Font.BOLD, 14));
		r3.setBackground(Color.white);
		
		r4 = new JRadioButton("No");
		r4.setFont(new Font("Raleway", Font.BOLD, 14));
		r4.setBackground(Color.white);
		
		
		
		
		
		String religion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Others"}; 
		c1 = new JComboBox(religion);
		c1.setBackground(Color.white);
		c1.setFont(new Font("Raleway", Font.BOLD, 14));
		
		String category[] = {"General", "OBC", "SC", "ST", "Others"}; 
		c2 = new JComboBox(category);
		c2.setBackground(Color.white);
		c2.setFont(new Font("Raleway", Font.BOLD, 14));
		
		String income[] = {"Null", "<1,50,000", "<2,50,000", "<5,00,000", "Upto 10,00,000","Above 10,00,000"}; 
		c3 = new JComboBox(income);
		c3.setBackground(Color.white);
		c3.setFont(new Font("Raleway", Font.BOLD, 14));
		
		String education[] = {"Non-Graduate", "Post-Graduate", "Doctrate", "Others"}; 
		c4 = new JComboBox(education);
		c4.setBackground(Color.white);
		c4.setFont(new Font("Raleway", Font.BOLD, 14));
		
		String occupation[] = {"Salaried", "Self-Employed", "Business", "Student", "Retired","Others"}; 
		c5 = new JComboBox(occupation);
		c5.setBackground(Color.white);
		c5.setFont(new Font("Raleway", Font.BOLD, 14));
		
		
		setLayout(null);
		
		l12.setBounds(700, 10, 60, 30);
		this.add(l12);
		
		t3.setBounds(760, 10, 60, 30);
		this.add(t3);
		
		l1.setBounds(280, 30, 600, 40);
		this.add(l1);
		
		l2.setBounds(100, 120, 100, 30);
		this.add(l2);
		
		c1.setBounds(350, 120, 320, 30);
		this.add(c1);
		
		l3.setBounds(100, 170, 100, 30);
		this.add(l3);
		
		c2.setBounds(350, 170, 320, 30);
		this.add(c2);
		
		l4.setBounds(100, 220, 100, 30);
		this.add(l4);
		
		c3.setBounds(350, 220, 320, 30);
		this.add(c3);
		
		l5.setBounds(100, 270, 150, 30);
		this.add(l5);
		
		c4.setBounds(350, 270, 320, 30);
		this.add(c4);
		
		l11.setBounds(100, 290, 150, 30);
		this.add(l11);
		
		l6.setBounds(100, 340, 150, 30);
		this.add(l6);	
		
		c5.setBounds(350, 340, 320, 30);
		this.add(c5);
		
		l7.setBounds(100, 390, 150, 30);
		this.add(l7);
		
		t1.setBounds(350, 390, 320, 30);
		this.add(t1);
		
		l8.setBounds(100, 440, 180, 30);		
		this.add(l8);
		
		t2.setBounds(350, 440, 320, 30);
		this.add(t2);
		
		l9.setBounds(100, 490, 150, 30);
		this.add(l9);
		
		r1.setBounds(350, 490, 100, 30);
		this.add(r1);
		
		r2.setBounds(460, 490, 100, 30);
		this.add(r2);
		
		l10.setBounds(100, 540, 180, 30);
		this.add(l10);
		
		r3.setBounds(350, 540, 100, 30);
		this.add(r3);
		
		r4.setBounds(460, 540, 100, 30);
		this.add(r4);
		
		b.setBounds(570, 600, 100, 30);
		this.add(b);
		
		b.addActionListener(this);
		
		this.getContentPane().setBackground(Color.white);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(850, 850);
		this.setLocation(300, 10);
		this.setVisible(true);
		
	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String a = (String)c1.getSelectedItem();
		String b = (String)c2.getSelectedItem();
		String c = (String)c3.getSelectedItem();
		String d = (String)c4.getSelectedItem();
		String ee = (String)c5.getSelectedItem();
		
		String f = t1.getText();
		String g = t2.getText();
		
		
		String h = "";
		
		if(r1.isSelected())
		{
			h = "Yes";
		}
		else if(r2.isSelected())
		{
			h = "No";
		}
		
		
		String i = "";
		if(r3.isSelected())
		{
			i = "Yes";
		}
		
		else if(r4.isSelected())
		{
			i = "No";
		}
		
		
		String j = t3.getText();
		
		
		
		try 
		{
			if(t2.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "Fill all the required fields");
				
			}
			
			else
			{
				Connection con = CP.createConnection();
				Statement statement = con.createStatement();
				String q1 = "insert into signup2 values('"+a+"', '"+b+"', '"+c+"', '"+d+"', '"+ee+"', '"+f+"', '"+g+"', '"+h+"', '"+i+ "', '"+j+"')";
				statement.executeUpdate(q1);
				
				new Signup3().setVisible(true);
				this.setVisible(false);
				
			}
			
		}
		
		
		catch (Exception e2) {
			e2.printStackTrace();
		}
		
		
	}
	public static void main(String[] args) {
		new Signup2().setVisible(true);
	}

}
