package GUILayer;
import ModelLayer.*;
import ControlLayer.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUICustomer extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel label_1;
	private JTextField textField_3;
	private JLabel label_2;
	private JTextField textField_4;
	private JLabel label_3;
	private JTextField textField_5;
	private JLabel label_4;
	private JTextField textField_6;
	private JLabel label_5;
	private JTextField textField_7;
	private JLabel label_6;
	private JTextField textField_8;
	private JLabel label_7;
	private JButton button_1;
	private JButton btnUpdate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUICustomer frame = new GUICustomer();
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
	public GUICustomer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 407, 258);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("CustomerID:");
		lblName.setBounds(10, 25, 86, 14);
		contentPane.add(lblName);
		
		textField = new JTextField();
		textField.setBounds(10, 42, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("First name:");
		label.setBounds(112, 25, 80, 14);
		contentPane.add(label);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(106, 42, 86, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(202, 42, 86, 20);
		contentPane.add(textField_2);
		
		label_1 = new JLabel("Last name:");
		label_1.setBounds(202, 25, 86, 14);
		contentPane.add(label_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(10, 93, 86, 20);
		contentPane.add(textField_3);
		
		label_2 = new JLabel("Address:");
		label_2.setBounds(10, 76, 86, 14);
		contentPane.add(label_2);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(106, 93, 86, 20);
		contentPane.add(textField_4);
		
		label_3 = new JLabel("Zipcode:");
		label_3.setBounds(106, 76, 86, 14);
		contentPane.add(label_3);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(202, 93, 86, 20);
		contentPane.add(textField_5);
		
		label_4 = new JLabel("City:");
		label_4.setBounds(202, 76, 86, 14);
		contentPane.add(label_4);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(10, 141, 86, 20);
		contentPane.add(textField_6);
		
		label_5 = new JLabel("Phoneno:");
		label_5.setBounds(10, 124, 86, 14);
		contentPane.add(label_5);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(106, 141, 86, 20);
		contentPane.add(textField_7);
		
		label_6 = new JLabel("E-Mail:");
		label_6.setBounds(106, 124, 86, 14);
		contentPane.add(label_6);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(202, 141, 86, 20);
		contentPane.add(textField_8);
		
		label_7 = new JLabel("Type:");
		label_7.setBounds(202, 124, 86, 14);
		contentPane.add(label_7);
		
		JButton btnOpretKunde = new JButton("Insert");
		btnOpretKunde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				
					try
					{
						
					
					CTRCustomer ctrCus = new CTRCustomer();
					String fname = textField_1.getText();
					String lname = textField_2.getText();
					int id = Integer.parseInt(textField.getText());
					String address = textField_3.getText();
					String zipcode = textField_4.getText();
					String city = textField_5.getText();
					String pno = textField_6.getText();
					String email = textField_7.getText();
					String type = textField_8.getText();
					ctrCus.insertNewCustomer(fname, lname, id, address, zipcode, city, pno, email, type);
					}
					catch(Exception e)
					{
						System.out.println("FEJL!!!!!!!");
					}
				}
			
		});
		btnOpretKunde.setBounds(298, 186, 86, 23);
		contentPane.add(btnOpretKunde);
		
		JButton button = new JButton("Find");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				
				
			}
		});
		button.setBounds(202, 186, 86, 23);
		contentPane.add(button);
		
		button_1 = new JButton("Delete");
		button_1.setBounds(10, 186, 86, 23);
		contentPane.add(button_1);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				CTRCustomer ctrCus = new CTRCustomer();
				String fname = textField.getText();
				System.out.println("+" + fname + "+");
				String lname = textField_1.getText();
				System.out.println("+" + lname + "+");
				int id = Integer.parseInt(textField_2.getText());
				System.out.println("+" + id + "+");
				String address = textField_3.getText();
				System.out.println("+" + address + "+");
				String zipcode = textField_4.getText();
				System.out.println("+" + zipcode + "+");
				String city = textField_5.getText();
				System.out.println("+" + city + "+");
				String pno = textField_6.getText();
				System.out.println("+" + pno + "+");
				String email = textField_7.getText();
				System.out.println("+" + email + "+");
				String type = textField_8.getText();
				System.out.println("+" + type + "+");
				int result = ctrCus.updateCustomer(fname, lname, id, address, zipcode, city, pno, email, type);
				
				
			}
		});
		btnUpdate.setBounds(106, 186, 86, 23);
		contentPane.add(btnUpdate);
	}
	private void insertCustomer(java.awt.event.ActionEvent evt)
	{
		try
		{
			
		
		CTRCustomer ctrCus = new CTRCustomer();
		String fname = textField_1.getText();
		String lname = textField_2.getText();
		int id = Integer.parseInt(textField.getText());
		String address = textField_3.getText();
		String zipcode = textField_4.getText();
		String city = textField_5.getText();
		String pno = textField_6.getText();
		String email = textField_7.getText();
		String type = textField_8.getText();
		ctrCus.insertNewCustomer(fname, lname, id, address, zipcode, city, pno, email, type);
		}
		catch(Exception e)
		{
			System.out.println("FEJL!!!!!!!");
		}
	}
}
