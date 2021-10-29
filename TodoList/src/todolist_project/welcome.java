package todolist_project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class welcome extends JFrame implements ActionListener{
	
	JLabel appName ;
	JPanel panel;
	JButton todoBtn;
	
	public welcome() {
		appName = new JLabel("Todoist App");
		appName.setFont(new Font(null,Font.PLAIN,30));
		appName.setPreferredSize(new Dimension(400, 70));
		appName.setHorizontalTextPosition(JLabel.CENTER);
		appName.setVerticalTextPosition(JLabel.CENTER);
		appName.setHorizontalAlignment(JLabel.CENTER);
		appName.setVerticalAlignment(JLabel.CENTER);
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(500, 70));
		panel.setBackground(Color.LIGHT_GRAY);
		
		todoBtn = new JButton(" To-do's ");
		
		
		
		todoBtn.setPreferredSize(new Dimension(160,60));
		todoBtn.setFont(new Font(null, Font.PLAIN, 22));
		todoBtn.setFocusable(false);
		
		
		todoBtn.addActionListener(this);
	
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.lightGray);
		this.setSize(500,500);
		this.setLocation(300, 60);
		this.setLayout(new FlowLayout());
		
		this.add(panel);
		this.add(appName);
		
		this.add(todoBtn);
	
		
		this.setVisible(true);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== todoBtn)
		{
			new todo().setVisible(true);
			this.setVisible(false);
		}
		
		
	}
	
	
	public static void main(String[] args) {
		new welcome();
		
	}

}
