package GUILayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;

import ControlLayer.CtrProduct;
import ModelLayer.Product;

public class GuiCreateProduct extends JFrame {

	private JPanel contentPane;
	private JTextField textProductId;
	private JTextField textProductName;
	private JTextField textPurchasePrice;
	private JTextField textSalesPrice;
	private JTextField textRentPrice;
	private JTextField textCountryOfOrigin;
	private JTextField textMinStock;
	private JTextField textSize;
	private JTextField textColour;
	private JTextField textType;
	private JTextField textFabric;
	private JTextField textCalibre;
	private JTextField textSupplier;
	private JTextField textDescription;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiCreateProduct frame = new GuiCreateProduct();
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
	public GuiCreateProduct() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 631);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Products", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 414, 571);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblProductId = new JLabel("Product ID");
		lblProductId.setBounds(10, 24, 51, 14);
		panel.add(lblProductId);
		
		textProductId = new JTextField();
		textProductId.setBounds(105, 21, 86, 20);
		panel.add(textProductId);
		textProductId.setColumns(10);
		
		JLabel lblProductName = new JLabel("Product Name");
		lblProductName.setBounds(10, 55, 70, 14);
		panel.add(lblProductName);
		
		textProductName = new JTextField();
		textProductName.setBounds(105, 52, 160, 20);
		panel.add(textProductName);
		textProductName.setColumns(10);
		
		JLabel lblPurchasePrice = new JLabel("Purchase Price");
		lblPurchasePrice.setBounds(10, 86, 70, 14);
		panel.add(lblPurchasePrice);
		
		textPurchasePrice = new JTextField();
		textPurchasePrice.setBounds(105, 83, 86, 20);
		panel.add(textPurchasePrice);
		textPurchasePrice.setColumns(10);
		
		JLabel lblSalesPrice = new JLabel("Sales Price");
		lblSalesPrice.setBounds(10, 117, 70, 14);
		panel.add(lblSalesPrice);
		
		textSalesPrice = new JTextField();
		textSalesPrice.setBounds(105, 114, 86, 20);
		panel.add(textSalesPrice);
		textSalesPrice.setColumns(10);
		
		JLabel lblCountryOfOrigin = new JLabel("Country of Origin");
		lblCountryOfOrigin.setBounds(10, 179, 86, 14);
		panel.add(lblCountryOfOrigin);
		
		textRentPrice = new JTextField();
		textRentPrice.setBounds(105, 145, 86, 20);
		panel.add(textRentPrice);
		textRentPrice.setColumns(10);
		
		JLabel lblRentPrice = new JLabel("Rent Price");
		lblRentPrice.setBounds(10, 148, 70, 14);
		panel.add(lblRentPrice);
		
		textCountryOfOrigin = new JTextField();
		textCountryOfOrigin.setBounds(105, 176, 160, 20);
		panel.add(textCountryOfOrigin);
		textCountryOfOrigin.setColumns(10);
		
		JLabel lblMinStock = new JLabel("Min Stock");
		lblMinStock.setBounds(10, 210, 46, 14);
		panel.add(lblMinStock);
		
		textMinStock = new JTextField();
		textMinStock.setBounds(105, 207, 86, 20);
		panel.add(textMinStock);
		textMinStock.setColumns(10);
		
		JLabel lblSize = new JLabel("Size");
		lblSize.setBounds(10, 241, 46, 14);
		panel.add(lblSize);
		
		textSize = new JTextField();
		textSize.setBounds(105, 238, 86, 20);
		panel.add(textSize);
		textSize.setColumns(10);
		
		JLabel lblColour = new JLabel("Colour");
		lblColour.setBounds(10, 272, 46, 14);
		panel.add(lblColour);
		
		textColour = new JTextField();
		textColour.setBounds(105, 269, 86, 20);
		panel.add(textColour);
		textColour.setColumns(10);
		
		JLabel lblType = new JLabel("Type");
		lblType.setBounds(10, 303, 46, 14);
		panel.add(lblType);
		
		textType = new JTextField();
		textType.setBounds(105, 300, 86, 20);
		panel.add(textType);
		textType.setColumns(10);
		
		JLabel lblFabric = new JLabel("Fabric");
		lblFabric.setBounds(10, 335, 46, 14);
		panel.add(lblFabric);
		
		textFabric = new JTextField();
		textFabric.setBounds(105, 332, 160, 20);
		panel.add(textFabric);
		textFabric.setColumns(10);
		
		JLabel lblCalibre = new JLabel("Calibre");
		lblCalibre.setBounds(10, 366, 46, 14);
		panel.add(lblCalibre);
		
		textCalibre = new JTextField();
		textCalibre.setBounds(105, 363, 86, 20);
		panel.add(textCalibre);
		textCalibre.setColumns(10);
		
		JLabel lblSupplier = new JLabel("Supplier");
		lblSupplier.setBounds(10, 397, 46, 14);
		panel.add(lblSupplier);
		
		textSupplier = new JTextField();
		textSupplier.setBounds(105, 394, 160, 20);
		panel.add(textSupplier);
		textSupplier.setColumns(10);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(10, 428, 70, 14);
		panel.add(lblDescription);
		
		textDescription = new JTextField();
		textDescription.setBounds(105, 427, 299, 99);
		panel.add(textDescription);
		textDescription.setColumns(10);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.setBounds(216, 537, 89, 23);
		panel.add(btnCreate);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(315, 537, 89, 23);
		panel.add(btnCancel);
	}
	
    private void createProduct(java.awt.event.ActionEvent evt) {
    	try {
    	
        CtrProduct ctrProduct = new CtrProduct();
  
        int productId = Integer.parseInt(textProductId.getText());
        String name = textProductName.getText();
        double purchasePrice = Double.parseDouble(textPurchasePrice.getText());
        double salesPrice = Double.parseDouble(textSalesPrice.getText());
        double rentPrice = Double.parseDouble(textRentPrice.getText());
        String countryOfOrigin = textCountryOfOrigin.getText();
        int minStock = Integer.parseInt(textMinStock.getText());
        String size = textSize.getText();
        String colour = textColour.getText();
        String type = textType.getText();
        String fabric = textFabric.getText();
        double calibre = Double.parseDouble(textCalibre.getText());
        String supplier = textSupplier.getText();
        String description = textDescription.getText();
        
        ctrProduct.insertNewProduct(productId, name, purchasePrice, salesPrice, rentPrice, countryOfOrigin, minStock, size, colour, type, fabric, calibre, supplier, description);
    	}
    	catch(Exception e) {
    		System.out.println("Error!");
    	}
    }

}
