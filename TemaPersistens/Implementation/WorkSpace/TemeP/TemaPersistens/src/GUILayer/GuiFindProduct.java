package GUILayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import ControlLayer.CtrProduct;
import GUILayer.TableProduct;
import ModelLayer.Product;
// import Model.Nummer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class GuiFindProduct extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnSearch;
	private JButton btnCancel;
	private JPanel panel_1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiFindProduct frame = new GuiFindProduct();
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
	public GuiFindProduct() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Find Product", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 414, 160);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblFindProductBy = new JLabel("Find Product by ID");
		lblFindProductBy.setBounds(10, 32, 89, 14);
		panel.add(lblFindProductBy);
		
		textField = new JTextField();
		textField.setBounds(160, 29, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblFindProductBy_1 = new JLabel("Find Product by Name");
		lblFindProductBy_1.setBounds(10, 94, 117, 14);
		panel.add(lblFindProductBy_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(160, 91, 160, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblFindProductBy_2 = new JLabel("Find Product by Supplier ID");
		lblFindProductBy_2.setBounds(10, 63, 137, 14);
		panel.add(lblFindProductBy_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(160, 60, 86, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				findProduct();
			}
		});
		btnSearch.setBounds(216, 126, 89, 23);
		panel.add(btnSearch);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(315, 126, 89, 23);
		panel.add(btnCancel);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "List of Products", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 182, 401, 219);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Product Name", "Supplier ID", "Product Name"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(85);
		table.getColumnModel().getColumn(2).setPreferredWidth(82);
		table.setBounds(10, 37, 381, 128);
		panel_1.add(table);
	}
	
	private void findProduct()
	{
		String titel = textField.getText();
		CtrProduct productCtr = new CtrProduct();
		Product productObj = productCtr.findProduct(titel);
		if(productObj != null)
		{
			putValueOnScreen(productObj);
		}
		else{
			textField.setText("Product is not found");
		}
		
		
	}
	private void putValueOnScreen(Product productObj)
	{
		 ArrayList<Product> productList = productObj.getAlleNumre();
	     System.out.println(productList.size());
         Products productsObj = new Products();
         productsObj.setData(pList);
         table.setModel(productsObj);
         lblNewLabel.setText(String.valueOf(productObj.getNr()));
         this.setVisible(true);
	}
}
