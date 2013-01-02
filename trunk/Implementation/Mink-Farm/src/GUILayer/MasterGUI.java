package GUILayer;

import GUILayer.*;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.JTextComponent;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import ModelLayer.*;
import ControlLayer.*;
import javax.swing.JList;
import javax.swing.JTable;

public class MasterGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField txtColor;
	private JTextField txtFur;
	private JTextField txtDate;
	private JTextField txtCageMink;
	private JTextField txtDensity;
	private JTextField txtQuality;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTable table_1;
	private JLabel lblNewLabel;
	private CTRCage cagCTR;
	private Cage cag;
	private Hall hal;
	private Column col;
	private Mink mink;
	private JTextField textField_8;
	private JTextField textField_9;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MasterGUI frame = new MasterGUI();
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
	public MasterGUI() {
		setTitle("Adminq");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1116, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(20, 11, 203, 166);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Opret hal", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setToolTipText("Create hall");
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 35, 183, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnSg = new JButton("Update");
		btnSg.setBounds(10, 119, 89, 23);
		panel.add(btnSg);
		
		JButton btnOpret = new JButton("Opret");
		btnOpret.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				addHall();
			}
		});
		btnOpret.setBounds(104, 119, 89, 23);
		panel.add(btnOpret);
		
		JLabel lblHalNr = new JLabel("Hal nr:");
		lblHalNr.setBounds(10, 22, 46, 14);
		panel.add(lblHalNr);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(10, 79, 183, 20);
		panel.add(textField_9);
		
		JLabel label_4 = new JLabel("Hal nr:");
		label_4.setBounds(10, 66, 46, 14);
		panel.add(label_4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setToolTipText("Create hall");
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Opret fag", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(233, 11, 203, 166);
		contentPane.add(panel_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 37, 183, 20);
		panel_1.add(textField_1);
		
		JButton btnUpdate_1 = new JButton("Update");
		btnUpdate_1.setBounds(10, 119, 89, 23);
		panel_1.add(btnUpdate_1);
		
		JButton button_1 = new JButton("Opret");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				createColumn();
			}
		});
		button_1.setBounds(104, 119, 89, 23);
		panel_1.add(button_1);
		
		JLabel lblColumnNr_1 = new JLabel("Column nr:");
		lblColumnNr_1.setBounds(10, 22, 116, 14);
		panel_1.add(lblColumnNr_1);
		
		JLabel lblColumnNr = new JLabel("Hal nr:");
		lblColumnNr.setBounds(10, 68, 71, 14);
		panel_1.add(lblColumnNr);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(10, 85, 183, 20);
		panel_1.add(textField_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setToolTipText("Create hall");
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Bur information", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(446, 11, 203, 205);
		contentPane.add(panel_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(10, 37, 183, 20);
		panel_2.add(textField_3);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(10, 164, 89, 23);
		panel_2.add(btnUpdate);
		
		JButton button_3 = new JButton("Opret");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				createCage();
			}
		});
		button_3.setBounds(104, 164, 89, 23);
		panel_2.add(button_3);
		
		JLabel lblBurNr = new JLabel("Bur nr:");
		lblBurNr.setBounds(10, 22, 46, 14);
		panel_2.add(lblBurNr);
		
		JLabel label_2 = new JLabel("Column nr:");
		label_2.setBounds(10, 68, 71, 14);
		panel_2.add(label_2);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(10, 85, 183, 20);
		panel_2.add(textField_4);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(10, 133, 183, 20);
		panel_2.add(textField_8);
		
		JLabel lblBurType = new JLabel("Bur type:");
		lblBurType.setBounds(10, 116, 71, 14);
		panel_2.add(lblBurType);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setToolTipText("Create hall");
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Opret Mink", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(654, 11, 423, 166);
		contentPane.add(panel_3);
		
		txtColor = new JTextField();
		txtColor.setColumns(10);
		txtColor.setBounds(10, 37, 116, 20);
		panel_3.add(txtColor);
		
		JLabel lblColor = new JLabel("Color:");
		lblColor.setBounds(10, 22, 46, 14);
		panel_3.add(lblColor);
		
		JLabel lblPelsLngde = new JLabel("Pels l\u00E6ngde:");
		lblPelsLngde.setBounds(10, 68, 116, 14);
		panel_3.add(lblPelsLngde);
		
		txtFur = new JTextField();
		txtFur.setColumns(10);
		txtFur.setBounds(10, 85, 116, 20);
		panel_3.add(txtFur);
		
		JLabel lblPelsTthed = new JLabel("F\u00F8de\u00E5r:");
		lblPelsTthed.setBounds(288, 22, 71, 14);
		panel_3.add(lblPelsTthed);
		
		txtDate = new JTextField();
		txtDate.setColumns(10);
		txtDate.setBounds(288, 37, 116, 20);
		panel_3.add(txtDate);
		
		txtCageMink = new JTextField();
		txtCageMink.setColumns(10);
		txtCageMink.setBounds(288, 85, 116, 20);
		panel_3.add(txtCageMink);
		
		JLabel lblBurNr_1 = new JLabel("Bur nr:");
		lblBurNr_1.setBounds(288, 68, 71, 14);
		panel_3.add(lblBurNr_1);
		
		JLabel lblKvalitet = new JLabel("Kvalitet:");
		lblKvalitet.setBounds(148, 68, 71, 14);
		panel_3.add(lblKvalitet);
		
		txtDensity = new JTextField();
		txtDensity.setColumns(10);
		txtDensity.setBounds(148, 37, 116, 20);
		panel_3.add(txtDensity);
		
		JLabel lblFdselsr = new JLabel("Pels t\u00E6thed");
		lblFdselsr.setBounds(148, 22, 84, 14);
		panel_3.add(lblFdselsr);
		
		JButton btnNewButton = new JButton("Opret");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				createMink();
			}
		});
		btnNewButton.setBounds(316, 116, 89, 23);
		panel_3.add(btnNewButton);
		
		JButton btnSg_1 = new JButton("Update");
		btnSg_1.setBounds(217, 116, 89, 23);
		panel_3.add(btnSg_1);
		
		txtQuality = new JTextField();
		txtQuality.setBounds(148, 85, 116, 20);
		panel_3.add(txtQuality);
		txtQuality.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setToolTipText("Create hall");
		panel_4.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "S\u00F8g hal", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_4.setBounds(20, 188, 203, 101);
		contentPane.add(panel_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(10, 35, 183, 20);
		panel_4.add(textField_5);
		
		JButton btnSg_2 = new JButton("S\u00F8g");
		btnSg_2.setBounds(104, 66, 89, 23);
		panel_4.add(btnSg_2);
		
		JLabel label = new JLabel("Hal nr:");
		label.setBounds(10, 22, 46, 14);
		panel_4.add(label);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setToolTipText("Create hall");
		panel_5.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "S\u00F8g fag", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5.setBounds(233, 188, 203, 101);
		contentPane.add(panel_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(10, 35, 183, 20);
		panel_5.add(textField_6);
		
		JButton btnSg_3 = new JButton("S\u00F8g");
		btnSg_3.setBounds(104, 66, 89, 23);
		panel_5.add(btnSg_3);
		
		JLabel label_1 = new JLabel("Hal nr:");
		label_1.setBounds(10, 22, 46, 14);
		panel_5.add(label_1);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setToolTipText("Create hall");
		panel_6.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "S\u00F8g bur", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_6.setBounds(446, 227, 203, 101);
		contentPane.add(panel_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(10, 35, 183, 20);
		panel_6.add(textField_7);
		
		JButton btnSg_4 = new JButton("S\u00F8g");
		btnSg_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				findCage();
			}
		});
		btnSg_4.setBounds(104, 66, 89, 23);
		panel_6.add(btnSg_4);
		
		JLabel label_3 = new JLabel("Hal nr:");
		label_3.setBounds(10, 22, 46, 14);
		panel_6.add(label_3);
		
		table_1 = new JTable();
		table_1.setBounds(20, 305, 203, 233);
		contentPane.add(table_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(233, 305, 393, 14);
		contentPane.add(lblNewLabel);
	}
	
	public void createCage()
	{
		CTRCage ctr = new CTRCage();
		int nr = Integer.parseInt(textField_3.getText());
		int column = Integer.parseInt(textField_4.getText());
		String cageType = textField_8.getText();
		try
		{
			ctr.createCage(nr, column, cageType);
			textField_3.setText("");
			textField_4.setText("");
			textField_8.setText("");
		}
		catch(Exception e)
		{
			System.out.println("ERROR!!!");
		}
		
		
	}
	
	public void createMink()
	{
		CTRMink ctr = new CTRMink();
		
		String color = txtColor.getText();
		int fur = Integer.parseInt(txtFur.getText());
		int density =  Integer.parseInt(txtDensity.getText());
		String date = txtDate.getText();
		String quality = txtQuality.getText();
		int cage = Integer.parseInt(txtCageMink.getText());
		
		try
		{
			ctr.createMink(color, fur, density, date, quality, cage);
		}
		catch(Exception e)
		{
			System.out.println("FEJL!!!!");
		}
		
			
	}
	
	public void createColumn()
	{
		CTRColumn ctr = new CTRColumn();
		int col = Integer.parseInt(textField_1.getText());
		int hal = Integer.parseInt(textField_2.getText());
		try
		{
			ctr.createColumn(col, hal);
		}
		catch(Exception e)
		{
			System.out.println("ERROR!!");
		}
		
	}
//	private void findCageTest()
//	{
//		try
//		{
//			Cage cagObj = cagCTR.findCage(Integer.parseInt(textField_7.getText()));
//			textField_3.setText(Integer.parseInt(cag.getCageNo()));
//			
//			
//		}
//		catch(Exception e)
//		{
//			System.out.println("FEJL!!!!");
//		}
//	}
	
	
	
	private void findCage()
	{
		int nr = Integer.parseInt(textField_5.getText());
		CTRCage ctr = new CTRCage();
		Cage cagobj = ctr.findCage(nr);
		if(cagobj != null)
		{
			putValueOnScreen(cagobj);
		}
		else
		{
			System.out.println("FEJL");
		}
	}
	
	public void addHall()
	{
		CTRHall ctr = new CTRHall();
		int hallnr = Integer.parseInt(textField.getText());
		int cvr = Integer.parseInt(textField_9.getText());
		try
		{
			ctr.insertHall(hallnr, cvr);
		}
		catch(Exception e)
		{
			System.out.println("ERROR!!");
		}
	}
	public void putValueOnScreen(Cage cagobj)
	{
		ArrayList<Mink> minkList = cagobj.getMyMink();
		System.out.println(minkList.size());
		BurData burobj = new BurData();
		burobj.setData(minkList);
		table_1.setModel(burobj);
		lblNewLabel.setText(String.valueOf(cagobj.getCageNo()));
		this.setVisible(true);
	}
	public void findCage(java.awt.event.ActionEvent evt)
	{
		try
		{
			CTRCage ctr = new CTRCage();
			int findCage = Integer.parseInt(textField_7.getText());
			ArrayList<Cage> cagobj = ctr.find(findCage);
			System.out.println("VIRKER");
		}
		catch(Exception e)
		{
			System.out.println("ERROR!!");
		}
	}
}
