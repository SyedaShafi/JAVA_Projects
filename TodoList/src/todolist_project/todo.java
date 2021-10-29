package todolist_project;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class todo extends JFrame implements ActionListener {

	JLabel header;
	JLabel importantTask;
	JLabel otherTasks;
	
	JTextField otherTasksTextArea;
	
	JTextField importantTaskText;
	
	JButton addButton, editButton, deleteButton, closeButton;
	
	JTable table;
	
	DefaultTableModel tableModel ;
	
	int id ;
	
	public todo() {
		
		header = new JLabel("My To-Do List");
		header.setFont(new Font(null, Font.BOLD, 28));
		
		importantTask = new JLabel("Important Task");
		importantTask.setFont(new Font(null, Font.BOLD, 16));
		
		importantTaskText = new JTextField();
		importantTaskText.setFont(new Font(null, Font.PLAIN, 16));
		
		
		otherTasks = new JLabel("Other Tasks");
		otherTasks.setFont(new Font(null, Font.BOLD, 16));
		
		otherTasksTextArea = new JTextField();
		otherTasksTextArea.setFont(new Font(null, Font.PLAIN, 16));
		
		addButton = new JButton("Add");
		addButton.setFont(new Font(null, Font.BOLD, 14));
		addButton.setBackground(Color.WHITE);
		addButton.setFocusable(false);
		
		editButton = new JButton("Update");
		editButton.setFont(new Font(null, Font.BOLD, 14));
		editButton.setBackground(Color.WHITE);
		editButton.setFocusable(false);
		
		deleteButton = new JButton("Delete");
		deleteButton.setFont(new Font(null, Font.BOLD, 14));
		deleteButton.setBackground(Color.WHITE);
		deleteButton.setFocusable(false);

		closeButton = new JButton("Close");
		closeButton.setFont(new Font(null, Font.BOLD, 14));
		closeButton.setBackground(Color.WHITE);
		closeButton.setFocusable(false);
		
		Object [] columnNames = { "id","Important", "Other"};
		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(columnNames);
		
		table = new JTable();
		table.setModel(tableModel);
		
		JScrollPane pane = new JScrollPane(table);
		
		header.setBounds(400, 30, 200, 60);
		importantTask.setBounds(20, 120, 130, 50);
		importantTaskText.setBounds(165, 130, 210, 60);
		otherTasks.setBounds(20, 235, 130, 50);
		otherTasksTextArea.setBounds(165, 240, 210, 60);
		addButton.setBounds(20, 420, 100, 30);
		editButton.setBounds(150, 420, 100, 30);
		deleteButton.setBounds(280, 420, 100, 30);
		closeButton.setBounds(820, 520, 100, 30);
		pane.setBounds(450, 125, 470, 370);
		
		
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.lightGray);
		this.setSize(990,650);
		this.setLocation(300, 60);
		this.setLayout(null);
		
		
		this.add(header);
		this.add(importantTask);		
		this.add(importantTaskText);
		this.add(otherTasks);
		this.add(otherTasksTextArea);
		this.add(addButton);
		this.add(editButton);
		this.add(deleteButton);
		this.add(closeButton);
		this.add(pane);
		
		
		
		// adding the mouse listener to the frame
		table.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int selectedRow = table.getSelectedRow();
				id =Integer.parseInt(tableModel.getValueAt(selectedRow, 0).toString());
				importantTaskText.setText(tableModel.getValueAt(selectedRow, 1).toString());
				otherTasksTextArea.setText(tableModel.getValueAt(selectedRow, 2).toString());
				
			}
			
			
		});
		
		
		
		
		
		
		
		
		
		//adding data which are available in the database at the beginning
		try {
			int a ;
			Connection conn = CP.createConnection();
			String q = "select * from todo";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(q);
			ResultSetMetaData rsMeatData = rs.getMetaData();
			a = rsMeatData.getColumnCount();
			tableModel.setRowCount(0);
			
			while(rs.next())
			{
				Vector v2 = new Vector();
				 for(int i=1; i<=a;i++) {
					 v2.add(rs.getString(i));				
				 }

				tableModel.addRow(v2);		
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		closeButton.addActionListener(this);
		deleteButton.addActionListener(this);
		addButton.addActionListener(this);
		editButton.addActionListener(this);
		
		this.setVisible(true);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == closeButton)
		{
			dispose();
		}
		
		else if(e.getSource() == addButton)
		{
			
			if(importantTaskText.getText().equals("") && otherTasksTextArea.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "Please enter all the required fields.");
			}
			
			else
			{
			
				try 
				{
					//adding data to the database
					Connection con  = CP.createConnection();
					
					String important = importantTaskText.getText();
					String others = otherTasksTextArea.getText();
					
					PreparedStatement pstmt = con.prepareStatement("insert into todo(important, other) values(?,?)");
					pstmt.setString(1, important);
					pstmt.setString(2, others);
					
					pstmt.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Task added");
					importantTaskText.setText("");
					otherTasksTextArea.setText("");
					
					//adding data to the JTable 
	
					String q = "select * from todo";
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery(q);
	
					tableModel.setRowCount(0);
					
					while(rs.next())
					{
						Vector v2 = new Vector();
						
	
							v2.add(rs.getString("id"));
							v2.add(rs.getString("important"));
							v2.add(rs.getString("other"));
	
						tableModel.addRow(v2);
							
					}
					
				}
				
				catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			
			}
		}
		
		else if(e.getSource() == editButton)
		{
			if(table.getSelectedRow()==-1)
			{
				JOptionPane.showMessageDialog(null, "Please Select a Row to Edit");
			}
			else
			{
				
				try 
				{
					//adding data to the database
					Connection con  = CP.createConnection();
					
					String important = importantTaskText.getText();
					String others = otherTasksTextArea.getText();
					
					PreparedStatement pstmt = con.prepareStatement("update todo set important=?,other=? where id = ?");
					pstmt.setString(1, important);
					pstmt.setString(2, others);
					pstmt.setInt(3, id);
					
					pstmt.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "List Updated");
					importantTaskText.setText("");
					otherTasksTextArea.setText("");
					
					//adding data to the JTable 

					String q = "select * from todo";
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery(q);

					tableModel.setRowCount(0);
					
					while(rs.next())
					{
						Vector v2 = new Vector();
						
						
						v2.add(rs.getString("id"));
						v2.add(rs.getString("important"));
						v2.add(rs.getString("other"));

						tableModel.addRow(v2);
						
					}
					
				}
				
				catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		}
		
		
		else if(e.getSource() == deleteButton)
		{
			if(table.getSelectedRow()==-1)
			{
				JOptionPane.showMessageDialog(null, "Please Select a Row to Delete");
			}
			
			else {
				
				int selectedOption = JOptionPane.showConfirmDialog(null, "Do you want to delete this selected row", "Confirm", JOptionPane.YES_NO_OPTION);
				
				if(selectedOption==JOptionPane.YES_OPTION)
				{
					
					try {
						Connection con  = CP.createConnection();
						PreparedStatement pstmt = con.prepareStatement("delete from todo where id = ?");
						pstmt.setInt(1, id);
						pstmt.executeUpdate();
						JOptionPane.showMessageDialog(null, "Selected row deleted");
						importantTaskText.setText("");
						otherTasksTextArea.setText("");
						
					}
					
					catch (Exception e2) {
						
						e2.printStackTrace();
					}
					
					tableModel.removeRow(table.getSelectedRow());
				}
			}
			
		}
		
		
	}
	
//	public static void main(String[] args) {
//		new todo();	
//	}

}
