package GUILayer;
import ModelLayer.*;
import ControlLayer.*;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JDesktopPane;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;


public class GUIEmployee {

	private JFrame frame;
	private JTextField txtWriteID;
	private JTextField txtWriteFname;
	private JTextField txtWriteLname;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIEmployee window = new GUIEmployee();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUIEmployee() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 500);
		frame.setTitle("Employee");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel Opret = new JPanel();
		Opret.setBorder(new TitledBorder(null, "Opret medarbejder", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		Opret.setBounds(10, 11, 414, 295);
		frame.getContentPane().add(Opret);
		Opret.setLayout(null);
		
		JLabel lblID = new JLabel("ID:");
		lblID.setBounds(10, 22, 103, 14);
		Opret.add(lblID);
		
		JLabel lblFname = new JLabel("Fornavn:");
		lblFname.setBounds(10, 47, 103, 14);
		Opret.add(lblFname);
		
		JLabel lblLname = new JLabel("Efternavn:");
		lblLname.setBounds(10, 72, 103, 14);
		Opret.add(lblLname);
		
		JLabel lblAddress = new JLabel("Adresse:");
		lblAddress.setBounds(10, 97, 103, 14);
		Opret.add(lblAddress);
		
		JLabel lblZipCode = new JLabel("Post Nr.:");
		lblZipCode.setBounds(10, 122, 103, 14);
		Opret.add(lblZipCode);
		
		JLabel lblCity = new JLabel("By:");
		lblCity.setBounds(10, 147, 103, 14);
		Opret.add(lblCity);
		
		JLabel lblPhoneNo = new JLabel("Telefon Nr.:");
		lblPhoneNo.setBounds(10, 172, 103, 14);
		Opret.add(lblPhoneNo);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(10, 197, 103, 14);
		Opret.add(lblEmail);
		
		textField = new JTextField();
		textField.setBounds(123, 19, 86, 20);
		Opret.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(123, 44, 214, 20);
		Opret.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(123, 69, 214, 20);
		Opret.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(123, 94, 281, 20);
		Opret.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(123, 119, 86, 20);
		Opret.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(123, 144, 140, 20);
		Opret.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(123, 169, 140, 20);
		Opret.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(123, 194, 281, 20);
		Opret.add(textField_7);
		textField_7.setColumns(10);
		
		JButton btnOpret = new JButton("Opret");
		btnOpret.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					CTREmployee ctrEmp = CTREmployee();
					int employeeID = Integer.parseInt(textField.getText());
					String fname = textField_1.getText();
					String lname = textField_2.getText();
					String address = textField_3.getText();
					int zipCode = Integer.parseInt(textField.getText());
					String city = textField_4.getText();
					int phoneNo = Integer.parseInt(textField.getText());
					String email = textField_5.getText();
					ctrEmp.insertEmployee(employeeID, fname, lname, address, zipCode, city, phoneNo, email);
				}
				catch(Exception e)
				{
					System.out.println("Fejl");
				}
			}
		});
		
		btnOpret.setBounds(315, 261, 89, 23);
		Opret.add(btnOpret);
		
		JButton btnOpdater = new JButton("Opdater");
		btnOpdater.setBounds(216, 261, 89, 23);
		Opret.add(btnOpdater);
		
		JPanel search = new JPanel();
		search.setBorder(new TitledBorder(null, "S\u00F8g medarbejder", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		search.setBounds(10, 317, 414, 134);
		frame.getContentPane().add(search);
		search.setLayout(null);
		
		JLabel lblSearchID = new JLabel("S\u00F8g efter ID:");
		lblSearchID.setBounds(10, 22, 106, 14);
		search.add(lblSearchID);
		
		JLabel lblSearchFname = new JLabel("S\u00F8g efter fornavn:");
		lblSearchFname.setBounds(10, 47, 106, 14);
		search.add(lblSearchFname);
		
		JLabel lblSearchLname = new JLabel("S\u00F8g efter efternavn:");
		lblSearchLname.setBounds(10, 71, 106, 14);
		search.add(lblSearchLname);
		
		txtWriteID = new JTextField();
		txtWriteID.setText("Skriv ID");
		txtWriteID.setBounds(126, 19, 106, 20);
		search.add(txtWriteID);
		txtWriteID.setColumns(10);
		
		txtWriteFname = new JTextField();
		txtWriteFname.setText("Skriv fornavn");
		txtWriteFname.setBounds(126, 44, 278, 20);
		search.add(txtWriteFname);
		txtWriteFname.setColumns(10);
		
		txtWriteLname = new JTextField();
		txtWriteLname.setText("Skriv efternavn");
		txtWriteLname.setBounds(126, 68, 278, 20);
		search.add(txtWriteLname);
		txtWriteLname.setColumns(10);
		
		JButton btnSg = new JButton("S\u00F8g");
		btnSg.setBounds(315, 99, 89, 23);
		search.add(btnSg);
	}
}
