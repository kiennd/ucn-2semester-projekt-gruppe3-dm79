package GUILayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class GUIMink extends JFrame {

	private JPanel contentPane;
	private JTextField txtComboBoxItem;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIMink frame = new GUIMink();
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
	public GUIMink() {
		setTitle("Mink");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 485, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JComboBox comboOne = new JComboBox();
		comboOne.setBackground(new Color(255, 255, 255));
		comboOne.setModel(new DefaultComboBoxModel(new String[] {"White", "Silver", "Mahogny"}));
		comboOne.setBounds(104, 29, 85, 20);
		contentPane.add(comboOne);
		
		JButton btnComboBox = new JButton("V\u00E6lg");
		btnComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String itemText = (String)comboOne.getSelectedItem( );
				txtComboBoxItem.setText( itemText );
			}
		});
		btnComboBox.setBounds(212, 28, 99, 23);
		contentPane.add(btnComboBox);
		
		txtComboBoxItem = new JTextField();
		txtComboBoxItem.setBounds(336, 29, 99, 23);
		contentPane.add(txtComboBoxItem);
		txtComboBoxItem.setColumns(10);
		
		JLabel lblArt = new JLabel("Art:");
		lblArt.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblArt.setBounds(29, 31, 46, 14);
		contentPane.add(lblArt);
		
		JLabel lblFurLength = new JLabel("Fur length:");
		lblFurLength.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFurLength.setBounds(29, 68, 63, 14);
		contentPane.add(lblFurLength);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(336, 63, 99, 23);
		contentPane.add(textField);
		
		JLabel lblFurDensity = new JLabel("Fur density:");
		lblFurDensity.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFurDensity.setBounds(29, 106, 76, 14);
		contentPane.add(lblFurDensity);
		
		JLabel lblBirthYear = new JLabel("Birth year:");
		lblBirthYear.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblBirthYear.setBounds(29, 136, 76, 14);
		contentPane.add(lblBirthYear);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(336, 97, 99, 23);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(336, 133, 99, 23);
		contentPane.add(textField_2);
	}
}
