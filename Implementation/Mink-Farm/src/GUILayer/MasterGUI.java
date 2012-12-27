package GUILayer;

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
import ModelLayer.*;
import ControlLayer.*;

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
		setBounds(100, 100, 1199, 536);
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
		textField.setBounds(10, 35, 116, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnSg = new JButton("Update");
		btnSg.setBounds(10, 119, 89, 23);
		panel.add(btnSg);
		
		JButton btnOpret = new JButton("Opret");
		btnOpret.setBounds(104, 119, 89, 23);
		panel.add(btnOpret);
		
		JLabel lblHalNr = new JLabel("Hal nr:");
		lblHalNr.setBounds(10, 22, 46, 14);
		panel.add(lblHalNr);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setToolTipText("Create hall");
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Opret Column", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(233, 11, 203, 166);
		contentPane.add(panel_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 37, 116, 20);
		panel_1.add(textField_1);
		
		JButton btnUpdate_1 = new JButton("Update");
		btnUpdate_1.setBounds(10, 119, 89, 23);
		panel_1.add(btnUpdate_1);
		
		JButton button_1 = new JButton("Opret");
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
		textField_2.setBounds(10, 85, 116, 20);
		panel_1.add(textField_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setToolTipText("Create hall");
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Opret Bur", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(446, 11, 203, 166);
		contentPane.add(panel_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(10, 37, 116, 20);
		panel_2.add(textField_3);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(10, 119, 89, 23);
		panel_2.add(btnUpdate);
		
		JButton button_3 = new JButton("Opret");
		button_3.setBounds(104, 119, 89, 23);
		panel_2.add(button_3);
		
		JLabel lblBurNr = new JLabel("Bur nr:");
		lblBurNr.setBounds(10, 22, 46, 14);
		panel_2.add(lblBurNr);
		
		JLabel label_2 = new JLabel("Column nr:");
		label_2.setBounds(10, 68, 71, 14);
		panel_2.add(label_2);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(10, 85, 116, 20);
		panel_2.add(textField_4);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setToolTipText("Create hall");
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Opret Mink", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(654, 11, 454, 166);
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
		txtQuality.setBounds(148, 85, 86, 20);
		panel_3.add(txtQuality);
		txtQuality.setColumns(10);
	}
	public void createMink()
	{
		try
		{
			CTRMink ctr = new CTRMink();
			ctr.createMink(txtColor.getText(),Integer.parseInt(txtFur.getText()), Integer.parseInt(txtDensity.getText()), txtDate.getText(), txtQuality.getText(), Integer.parseInt(txtCageMink.getText()));
			
		}
		catch(Exception e)
		{
			System.out.println("ERROR");
		}
	
	}
}
