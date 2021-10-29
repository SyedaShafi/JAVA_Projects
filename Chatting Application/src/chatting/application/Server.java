package chatting.application;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Server extends JFrame implements ActionListener
{
	JPanel p1;
	JTextField t1;
	JButton b1;
	static JTextArea a1;
	static ServerSocket skt;
	static Socket s;
	static DataInputStream din;
	static DataOutputStream dout;
	
	
	Server()
	{
		p1 = new JPanel();
		p1.setLayout(null);
		p1.setBackground(new Color(7,94,84));
		p1.setBounds(0,0,400,70);
		add(p1);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/3.png"));
		Image i2 = i1.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l1 = new JLabel(i3);
		l1.setBounds(5,17,30,30);
		p1.add(l1);
		
		l1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent ae) {
				System.exit(0);
			}
		});
		
		
		ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/1.png"));
		Image i5 = i4.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT);
		ImageIcon i6 = new ImageIcon(i5);
		JLabel l2 = new JLabel(i6);
		l2.setBounds(40,5,60,60);
		p1.add(l2);
		
		ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/video.png"));
		Image i8 = i7.getImage().getScaledInstance(40, 30, Image.SCALE_DEFAULT);
		ImageIcon i9 = new ImageIcon(i8);
		JLabel l3 = new JLabel(i9);
		l3.setBounds(270,20,40,30);
		p1.add(l3);
		
		ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/phone.png"));
		Image i11 = i10.getImage().getScaledInstance(33, 30, Image.SCALE_DEFAULT);
		ImageIcon i12 = new ImageIcon(i11);
		JLabel l4 = new JLabel(i12);
		l4.setBounds(328,20,33,30);
		p1.add(l4);
		
		ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/3icon.png"));
		Image i14 = i13.getImage().getScaledInstance(10, 26, Image.SCALE_DEFAULT);
		ImageIcon i15 = new ImageIcon(i14);
		JLabel l5 = new JLabel(i15);
		l5.setBounds(370,20,10,26);
		p1.add(l5);
		
		JLabel l6 = new JLabel("Gaitonde");
		l6.setFont(new Font("SAN_SERIF",Font.BOLD,18));
		l6.setForeground(Color.WHITE);
		l6.setBounds(110,15,100,20);
		p1.add(l6);
		
		JLabel l7 = new JLabel("Active Now");
		l7.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
		l7.setForeground(Color.WHITE);
		l7.setBounds(110,25,100,40);
		p1.add(l7);
		
		a1 = new JTextArea();
		a1.setBounds(5, 75, 390, 465 );
		a1.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
		a1.setEditable(false);
		a1.setLineWrap(true);
		a1.setWrapStyleWord(true);
		add(a1);
		
		t1 = new JTextField();
		t1.setBounds(5, 545, 300, 40);
		t1.setFont(new Font("SAN_SERIF",Font.PLAIN,18));
		add(t1);
		
		b1 = new JButton("Send");
		b1.setBounds(310, 545, 85, 40);
		b1.setBackground(new Color(7,94,84));
		b1.setForeground(Color.WHITE);
		b1.setFont(new Font("SAN_SERIF",Font.PLAIN,17));
		b1.addActionListener(this);
		add(b1);
		
		setLayout(null);
		setSize(400, 590);
		setLocation(300,190);
		setUndecorated(true);
		setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String out = t1.getText();
		a1.setText(a1.getText()+"\n\t\t\t"+out);
		
		try 
		{
			dout.writeUTF(out);
			System.out.println("S sent to client:"+out);
		} 
		
		catch (IOException e1)
		{
			e1.printStackTrace();
		}
		
		t1.setText("");
	}
	
	public static void main(String[] args) throws IOException {
		new Server().setVisible(true);
//		String msginput = "";
		
			skt = new ServerSocket(6001);
			
			while(true) {
			s = skt.accept();
			din = new DataInputStream(s.getInputStream());
			dout = new DataOutputStream(s.getOutputStream());
			while(true)
			{
				
				String msginput = din.readUTF();
				System.out.println("S from client: "+msginput);
				a1.setText(a1.getText()+"\n"+msginput);
			}
			
//			skt.close();
//			s.close();
			} 
	}


}
