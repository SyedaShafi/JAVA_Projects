import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;

public class FeesSystem extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField fname;
	private JTextField timing;
	private JTextField fmobile;
	private JTextField fees;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FeesSystem frame = new FeesSystem();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FeesSystem() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1146, 674);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("   Fees Receipt System");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 48));
		lblNewLabel.setBounds(275, 41, 498, 50);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Student Name :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(29, 147, 221, 50);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Enter Father Name :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1_1.setBounds(29, 207, 221, 50);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Enter Batch Timing :");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1_2.setBounds(29, 267, 221, 50);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Enter Father Mobile :");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1_3.setBounds(29, 327, 221, 50);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Enter Fees Amount :");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1_4.setBounds(29, 396, 221, 50);
		contentPane.add(lblNewLabel_1_4);
		
		name = new JTextField();
		name.setFont(new Font("Tahoma", Font.PLAIN, 22));
		name.setBounds(297, 158, 329, 40);
		contentPane.add(name);
		name.setColumns(10);
		
		fname = new JTextField();
		fname.setFont(new Font("Tahoma", Font.PLAIN, 22));
		fname.setColumns(10);
		fname.setBounds(297, 217, 329, 40);
		contentPane.add(fname);
		
		timing = new JTextField();
		timing.setFont(new Font("Tahoma", Font.PLAIN, 22));
		timing.setColumns(10);
		timing.setBounds(297, 267, 329, 40);
		contentPane.add(timing);
		
		fmobile = new JTextField();
		fmobile.setFont(new Font("Tahoma", Font.PLAIN, 22));
		fmobile.setColumns(10);
		fmobile.setBounds(297, 327, 329, 40);
		contentPane.add(fmobile);
		
		fees = new JTextField();
		fees.setFont(new Font("Tahoma", Font.PLAIN, 22));
		fees.setColumns(10);
		fees.setBounds(297, 396, 329, 40);
		contentPane.add(fees);
		
		JTextArea area = new JTextArea();
		area.setFont(new Font("Tahoma", Font.BOLD, 18));
		area.setBounds(657, 134, 445, 469);
		contentPane.add(area);
		
		JButton btnNewButton = new JButton("Generate Receipt\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				area.setText("************************************\n");
				area.setText(area.getText()+"         *          Fees Receipt System            *\n");
				area.setText(area.getText()+"************************************\n");
				
				Date obj = new Date();
				String date = obj.toString();
				
				area.setText(area.getText()+ "\n" +date  +"\n\n");
				area.setText(area.getText()+ "Student Name : " +name.getText() +"\n\n");
				area.setText(area.getText()+ "Father Name : " +fname.getText() +"\n\n");
				area.setText(area.getText()+ "Batch Timing : " +timing.getText() +"\n\n");
				area.setText(area.getText()+ "Father Mobile : " +fmobile.getText() +"\n\n");
				area.setText(area.getText()+ "Fees Amount : " +fees.getText() +"\n\n");
				
				area.setText(area.getText()+"\n\t\tSignature");
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(29, 528, 178, 50);
		contentPane.add(btnNewButton);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				area.setText("");
				name.setText("");
				fname.setText("");
				timing.setText("");
				fmobile.setText("");
				fees.setText("");
				
				
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnReset.setBounds(257, 528, 178, 50);
		contentPane.add(btnReset);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					area.print();
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
			
			}
		});
		btnPrint.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnPrint.setBounds(469, 528, 178, 50);
		contentPane.add(btnPrint);
	}
}
