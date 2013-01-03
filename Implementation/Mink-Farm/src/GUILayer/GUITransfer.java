package GUILayer;

import ControlLayer.*;
import ModelLayer.*;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUITransfer extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel     mainPane;
	private JPanel     backPane;
	private JPanel     transferPane;
	private JPanel     reportedPane;
	
	private JTextField cageno_transferfield;
	private JTextField cageno_reportfield;
	private JTextField disease_field;
	private JTextField employee_field;
	private JTextField date_field;
	private JTextField status_field;
	
	JButton SaveReportButton;
	JButton CancelReportButton;
	JButton SaveTransferButton;
	JButton CancelTransferButton;
	JButton SearchTransferButton;
	JButton DeleteTransferButton;
	
	JLabel lblTransferdato;

	int diseaseId = 0;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUITransfer frame = new GUITransfer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the main frame.
	 */
	public GUITransfer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 600);
		mainPane = new JPanel();
		mainPane.setBorder(new EmptyBorder(5, 15, 5, 5));
		mainPane.setLayout(new BorderLayout(0, 0));
		setContentPane(mainPane);

		JLabel lblDiceaseTransfereMenu = new JLabel("Rapport og Transfer Vindue");
		mainPane.add(lblDiceaseTransfereMenu, BorderLayout.NORTH);
		
		backPane = new JPanel();
		backPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		mainPane.add(backPane, BorderLayout.CENTER);
		backPane.setLayout(null);
		
		createTransferPane();
		createReportedPane();
		
		// Status
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setBounds(10, 500, 46, 14);
		backPane.add(lblStatus);

		refreshScreen();
		
		status_field = new JTextField();
		status_field.setText("test");
		status_field.setEditable(false);
		status_field.setBounds(60, 497, 916, 20);
		backPane.add(status_field);
		status_field.setColumns(10);
		
	}
	
	/**
	 * Create the Transfer frame.
	 */
	private void createTransferPane() {
		transferPane = new JPanel();
		transferPane.setBorder(new TitledBorder(null, "Transfer Vindue", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		transferPane.setBounds(496, 10, 500, 490);
		transferPane.setBounds(500, 10, 480, 480);
		backPane.add(transferPane);
		transferPane.setLayout(null);

	    // CageNo
		JLabel lblNewLabel_1 = new JLabel("Indtast Bur Nummer:");
	    lblNewLabel_1.setBounds(10, 71, 137, 14);
	    lblNewLabel_1.setEnabled(true);
	    transferPane.add(lblNewLabel_1);
	    
	    cageno_transferfield = new JTextField();
	    cageno_transferfield.setEnabled(false);
	    cageno_transferfield.setEditable(false);
	    cageno_transferfield.setBounds(147, 68, 86, 20);
	    transferPane.add(cageno_transferfield);
	    cageno_transferfield.setColumns(10);
	    transferPane.setVisible(true);	

	    // Disease Id
	    JLabel lblNewLabel = new JLabel("Indtast Sygdom Id :");
		lblNewLabel.setBounds(10, 96, 137, 14);
		transferPane.add(lblNewLabel);

		disease_field = new JTextField();
		disease_field.setEditable(false);
		disease_field.setEnabled(false);
		disease_field.setBounds(147, 96, 86, 20);
		transferPane.add(disease_field);
		disease_field.setColumns(10);
		
		// Employee Id
		JLabel lblEmployeeId = new JLabel("Indtast Medarbejder Id:");
		lblEmployeeId.setBounds(10, 133, 137, 14);
		transferPane.add(lblEmployeeId);
		
		employee_field = new JTextField();
		employee_field.setBounds(147, 130, 86, 20);
		employee_field.setEnabled(false);
		employee_field.setEditable(false);
		transferPane.add(employee_field);
		employee_field.setColumns(10);
		
	    lblTransferdato = new JLabel("TransferDato:");
	    lblTransferdato.setVisible(false);
	    lblTransferdato.setBounds(10, 167, 114, 14);
	    transferPane.add(lblTransferdato);
	    
	    date_field = new JTextField();
	    date_field.setEditable(false);
		date_field.setVisible(false);
	    date_field.setBounds(147, 161, 86, 20);
	    transferPane.add(date_field);
	    date_field.setColumns(10);

	    JButton btnNewButton_3 = new JButton("Starte Ny Transfer");
	    btnNewButton_3.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		cageno_transferfield.setText("");
	    		disease_field.setText("");
	    		employee_field.setText("");
	    		
	    		cageno_transferfield.setEditable(true);
	    		cageno_transferfield.setEnabled(true);
	    		disease_field.setEditable(true);
	    		disease_field.setEnabled(true);
	    		employee_field.setEnabled(true);
	    		employee_field.setEditable(true);
	    		
	    	    SaveTransferButton.setEnabled(true);
	    	    CancelTransferButton.setEnabled(true);
	    	    SearchTransferButton.setEnabled(false);
	    	    DeleteTransferButton.setEnabled(false);
	    	    
	    	    status_field.setForeground(Color.BLACK);
	    		status_field.setText("");
	    		
	    	}
	    });
	    
	    btnNewButton_3.setBounds(10, 24, 154, 23);
	    transferPane.add(btnNewButton_3);
	    
	    JButton btnFindTransfer = new JButton("Find Transfer");
	    btnFindTransfer.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent arg0) {
	    		cageno_transferfield.setText("");
	    		disease_field.setText("");
	    		employee_field.setText("");
	    		date_field.setText("");

	    		cageno_transferfield.setEditable(true);
	    		cageno_transferfield.setEnabled(true);
	    		
	    		SaveTransferButton.setEnabled(false);
	    		CancelTransferButton.setEnabled(false);
	    		SearchTransferButton.setEnabled(true);
	    		DeleteTransferButton.setEnabled(false);
	    		
	    		status_field.setText("");
	    		
	        }
	    });
	    
	    btnFindTransfer.setBounds(174, 24, 147, 23);
	    transferPane.add(btnFindTransfer);

	    SaveTransferButton = new JButton("Gem");
	    SaveTransferButton.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		cageno_transferfield.setEditable(false);
	    		cageno_transferfield.setEnabled(false);
	    		disease_field.setEditable(false);
	    		disease_field.setEnabled(false);
	    		employee_field.setEnabled(false);
	    		employee_field.setEditable(false);
	    		
	    		SaveTransferButton.setEnabled(false);
	    		CancelTransferButton.setEnabled(false);
	    		SearchTransferButton.setEnabled(false);
	    		DeleteTransferButton.setEnabled(false);
	    		
	    		insertTransfer();
	    		refreshScreen();

	    		cageno_transferfield.setText("");
	    		disease_field.setText("");
	    		employee_field.setText("");
	    		date_field.setText("");
	    		
	    	}
	    });
	    
	    SaveTransferButton.setBounds(35, 192, 89, 23);
	    SaveTransferButton.setEnabled(false);
	    transferPane.add(SaveTransferButton);
	    
	    CancelTransferButton = new JButton("Annullere");
	    CancelTransferButton.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		cageno_transferfield.setEditable(false);
	    		cageno_transferfield.setEnabled(false);
	    		disease_field.setEditable(false);
	    		disease_field.setEnabled(false);
	    		employee_field.setEnabled(false);
	    		employee_field.setEditable(false);
	    		date_field.setVisible(false);
	    	    lblTransferdato.setVisible(false);
	    	    
	    		SaveTransferButton.setEnabled(false);
	    		CancelTransferButton.setEnabled(false);
	    		SearchTransferButton.setEnabled(false);
	    		DeleteTransferButton.setEnabled(false);
	    		
	    		cageno_transferfield.setText("");
	    		disease_field.setText("");
	    		employee_field.setText("");
	    		date_field.setText("");
	    		
	    	}
	    });
	    CancelTransferButton.setBounds(134, 192, 89, 23);
	    CancelTransferButton.setEnabled(false);
	    transferPane.add(CancelTransferButton);
	    
	    SearchTransferButton = new JButton("S\u00F8g");
	    SearchTransferButton.setEnabled(false);
	    SearchTransferButton.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		if((cageno_transferfield.getText().length() > 2) && findTransfer())
	    		{
		    	    status_field.setForeground(Color.BLACK);
		    		status_field.setText("KLAR TIL AT SLETTE VIST TRANSFER POST.");
		    		DeleteTransferButton.setEnabled(true);
	    		}
	    		else
	    		{
		    	    status_field.setForeground(Color.RED);
		    		status_field.setText("FEJL BUR NUMMER MANGLER AT BLIVE ANGIVET ELLER FINDES IKKE I TRANSFER.");
	    		}
	    		SaveTransferButton.setEnabled(false);
	    		CancelTransferButton.setEnabled(true);
	    		SearchTransferButton.setEnabled(false);
	    		
	    		disease_field.setEnabled(true);
	    		employee_field.setEnabled(true);
	    		date_field.setVisible(true);
	    		lblTransferdato.setVisible(true);	    
	    		
	    	}
	    });
	    SearchTransferButton.setBounds(266, 192, 89, 23);
	    transferPane.add(SearchTransferButton);

	    DeleteTransferButton = new JButton("Slet");
	    DeleteTransferButton.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		if(DeleteTransferButton.isEnabled())
	    		{
		    		cageno_transferfield.setEditable(false);
		    		cageno_transferfield.setEnabled(false);
		    		disease_field.setEnabled(false);
		    		employee_field.setEnabled(false);
		    		date_field.setVisible(false);
		    	    lblTransferdato.setVisible(false);
		    	    
		    		SaveTransferButton.setEnabled(false);
		    		CancelTransferButton.setEnabled(false);
		    		SearchTransferButton.setEnabled(false);
		    		DeleteTransferButton.setEnabled(false);
	
		    		deleteTransfer();
		    		//createTransferList();
		    		
		    		cageno_transferfield.setText("");
		    		disease_field.setText("");
		    		employee_field.setText("");
		    		date_field.setText("");

	    		}
	    		
	    		createTransferList();
	    	}
	    });
	    DeleteTransferButton.setEnabled(false);
	    DeleteTransferButton.setBounds(365, 192, 89, 23);
	    transferPane.add(DeleteTransferButton);
	    
	}
	
	
	// method to insert a Transfer record into the database
    private void insertTransfer() 
    {
        CTRTransfer ctrtrans = new CTRTransfer();
		int cagenumber = Integer.parseInt(cageno_transferfield.getText());
		int disease = Integer.parseInt(disease_field.getText());
		int employee = Integer.parseInt(employee_field.getText());
		
        if((checkCage(cagenumber) != null) &&
           (checkEmployee(employee) != null) && 
           ((checkBite(disease) != null) || (checkPlasma(disease) != null))
          )
        {
        	if(ctrtrans.insertTransfer(cagenumber, disease, employee) == 1)
        	{
        		status_field.setForeground(Color.BLACK);
    			status_field.setText("NY TRANSFER OPRETTET.");
        	}
        	else
        	{
        		status_field.setForeground(Color.RED);
    			status_field.setText("EN FEJL OPSTOD UNDER OPRETTELSE AF TRANSFER. SE KONSOL VINDUE.");
        	}
        		
        }
        else
        {
    		status_field.setForeground(Color.RED);
			status_field.setText("FEJL I EN ELLER FLERE NØGLER. TRANSFER IKKE OPRETTET. SE KONSOL VINDUE.");
        }
     }
        	
    private void deleteTransfer()
    {
        CTRTransfer ctrtrans = new CTRTransfer();
		int cagenumber = Integer.parseInt(cageno_transferfield.getText());
		if(ctrtrans.deleteTransfer(cagenumber) == 1)
		{
       		status_field.setForeground(Color.BLACK);
   			status_field.setText("TRANSFER POST SLETTET.");
   			
		}
		else
		{
       		status_field.setForeground(Color.RED);
   			status_field.setText("EN FEJL OPSTOD UNDER SLETNINGEN AF TRANSFER. SE KONSOL VINDUE.");
		}
   	
    }
    
	// method to create a scroll list of all Transfers.
	private void createTransferList()
	{
		CTRTransfer ctrTransfer = new CTRTransfer();
		ArrayList<Transfer> TransferList = ctrTransfer.getAllTransfer();
		
		Collection<Transfer> TransferColList = TransferList;
	    Iterator<Transfer> itr = TransferColList.iterator();
	    int itemSize = TransferColList.size();
	    String tabledata[][] = new String[itemSize][5];
	    int i = 0;
	    while( itr.hasNext() ) {
	    	
	    	Transfer TransferObj = itr.next();
	    	Integer TransferIdInt = TransferObj.getTransferId();
    		Integer CageNoInt = TransferObj.getCage().getCageNo();
    		Integer DiseaseIdInt;
    		if(TransferObj.getBitedisease() != null)
    			DiseaseIdInt = TransferObj.getBitedisease().getDiseaseId();
    		else if (TransferObj.getPlasmadisease() != null)
    			DiseaseIdInt = TransferObj.getPlasmadisease().getDiseaseId();
    		else
    			DiseaseIdInt = 0;
    		Integer EmployeeIdInt = TransferObj.getEmployee().getEmployeeID();
    		
    		String line[] = { 
    				TransferIdInt.toString(),
    				CageNoInt.toString(),
    				DiseaseIdInt.toString(),
    				EmployeeIdInt.toString(),
    				TransferObj.getTransferDate()
    				};
    		
    		tabledata[i] = line;
    		i++;
	    }

	    String headers[] = { "Transfer ID", "Cage No", "Disease ID", "Employee ID", "Transfer Date" };
	    // Create a new table instance
	    DefaultTableModel model = new DefaultTableModel(tabledata, headers);
	    // And line color shift in table
	    JTable table = new JTable(model) {
	        private static final long serialVersionUID = 1L;
	 
	        public Component prepareRenderer(TableCellRenderer renderer, int Index_row, int Index_col) {
	            Component comp = super.prepareRenderer(renderer, Index_row, Index_col);
	            // if not selected then change background color for every second row
	            if (!isCellSelected(Index_row, Index_col)) {
	                if (Index_row % 2 == 0)
	                    comp.setBackground(Color.WHITE);
	                else
	                    comp.setBackground(Color.LIGHT_GRAY);
	            }
	            return comp;
	       }
	    }; // end of creating JTable table
	    
	    table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    table.setEnabled(false);
	    
	    JScrollPane scrollPane = new JScrollPane(table);
	    scrollPane.setViewportBorder(new TitledBorder(null, "Transfer list", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	    scrollPane.setBounds(10, 226, 460, 244);
	    transferPane.add(scrollPane, BorderLayout.CENTER);
	    	    	    
	}
	

	/**
	 * Create the DiseaseReport frame.
	 */
	private void createReportedPane() {
		reportedPane = new JPanel();
		reportedPane.setBorder(new TitledBorder(null, "Rapport Vindue", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		reportedPane.setBounds(10, 10, 480, 480);
		backPane.add(reportedPane);
		reportedPane.setLayout(null);

		// Cage No
	    JLabel lblNewLabel = new JLabel("Indtast Bur Nummer:");
		lblNewLabel.setBounds(10, 113, 131, 14);
		lblNewLabel.setEnabled(true);
		reportedPane.add(lblNewLabel);
		
		cageno_reportfield = new JTextField();
		cageno_reportfield.setBounds(144, 110, 92, 20);
		cageno_reportfield.setEnabled(false);
		cageno_reportfield.setEditable(false);
		reportedPane.add(cageno_reportfield);
		cageno_reportfield.setColumns(10);
		
	    JButton btnNewButton = new JButton("Registrere Ny Plasmacytosis ");
	    btnNewButton.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent arg0) {
	    		diseaseId = 1500;
	    		cageno_reportfield.setText("");
	    		cageno_reportfield.setEnabled(true);
	    		cageno_reportfield.setEditable(true);
	    		
	    		SaveReportButton.setEnabled(true);
	    		CancelReportButton.setEnabled(true);

	    		status_field.setForeground(Color.BLACK);
	    		status_field.setText("KLAR TIL AT OPRETTE EN DISEASE REPORT PÅ ET BUR MED SYGDOM PLASMACYTOSIS.");
	    	}
	    });
	    
	    btnNewButton.setBounds(10, 23, 210, 23);
	    reportedPane.add(btnNewButton);
	    
	    JButton btnNewButton_1 = new JButton("Registrere Ny Bides\u00E5r");
	    btnNewButton_1.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		diseaseId = 1600;
	    		cageno_reportfield.setText("");
	    		cageno_reportfield.setEnabled(true);
	    		cageno_reportfield.setEditable(true);
	    		
	    		SaveReportButton.setEnabled(true);
	    		CancelReportButton.setEnabled(true);
	    		
	    		status_field.setForeground(Color.BLACK);
	    		status_field.setText("KLAR TIL AT OPRETTE EN DISEASEREPORT PÅ ET BUR MED SYGDOM BIDESÅR.");
	    	}
	    });
	    
	    btnNewButton_1.setBounds(10, 57, 173, 23);
	    reportedPane.add(btnNewButton_1);
	    
	    SaveReportButton = new JButton("Gem");
	    SaveReportButton.setEnabled(false);
	    SaveReportButton.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		cageno_reportfield.setEnabled(false);
	    		cageno_reportfield.setEditable(false);
	    		SaveReportButton.setEnabled(false);
	    		CancelReportButton.setEnabled(false);
	    		
	    		createDiseaseReport();
	    		refreshScreen();
	    		
	    		cageno_reportfield.setText("");	    	
	    	}
	    });
	    
	    SaveReportButton.setBounds(95, 193, 83, 23);
	    reportedPane.add(SaveReportButton);
	    
	    CancelReportButton = new JButton("Annullere");
	    CancelReportButton.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		cageno_reportfield.setEnabled(false);
	    		cageno_reportfield.setEditable(false);
	    		
	    		SaveReportButton.setEnabled(false);
	    		CancelReportButton.setEnabled(false);
	    		
	    		cageno_reportfield.setText("");
	    		diseaseId = 0;
	    	}
	    });
	    
	    CancelReportButton.setEnabled(false);
	    CancelReportButton.setBounds(188, 193, 89, 23);
	    reportedPane.add(CancelReportButton);
		
	}
	
	
	// method to insert a DiseaseReport record into the database	
	private void createDiseaseReport()
	{
		CTRDiseaseReport ctrDiseaseReport = new CTRDiseaseReport();
		int cagenumber = Integer.parseInt(cageno_reportfield.getText());
		
		if((checkCage(cagenumber) != null) &&
		   ((checkBite(diseaseId) != null) || (checkPlasma(diseaseId) != null))
		  )
		{
			if(checkCageNoTransfer(cagenumber) == null)
			{
				if(ctrDiseaseReport.insertDiseaseReport(cagenumber, diseaseId) == 1)
				{
			    	status_field.setForeground(Color.BLACK);
					status_field.setText("NY DISEASE REPORT OPRETTET.");
				}
				else
				{
					status_field.setForeground(Color.RED);
					status_field.setText("FEJL OPSTOD UNDER OPRETTELSE AF DISEASE REPORT. SE KONSOL VINDUE.");
				}
			}
			else
			{
				status_field.setForeground(Color.RED);
				status_field.setText("FEJL BUR NUMMER EKSISTER I FORVEJN I TRANSFER. DISEASE REPORT IKKE OPRETTET.");
			}
		}
		else
		{
    		status_field.setForeground(Color.RED);
			status_field.setText("FEJL I EN ELLER FLERE NØGLER. DISEASE REPORT IKKE OPRETTET. SE KONSOL VINDUE.");
		}
	}

	
	// method to create a scroll list of all DiseaseReports.
	private void createReportList()
	{
		//HashMap<Integer, Transfer> TransferList;
		//TransferList = new HashMap<Integer, Transfer>();
		CTRDiseaseReport ctrDiseaseReport = new CTRDiseaseReport();
		ArrayList<DiseaseReport> DiseaseReportList;

		DiseaseReportList = ctrDiseaseReport.getAllDiseaseReport();
		Collection<DiseaseReport> DiseaseReportColList = DiseaseReportList;
	    Iterator<DiseaseReport> itr = DiseaseReportColList.iterator();
	    int itemSize = DiseaseReportColList.size();
	    String tabledata[][] = new String[itemSize][3];
	    int i = 0;
	    while( itr.hasNext() ) {
	    	
	    	DiseaseReport DiseaseReportObj = itr.next();
    		Integer CageNoInt = DiseaseReportObj.getCageNo();
    		Integer DiseaseIdInt = DiseaseReportObj.getDiseaseId();
    		
    		String line[] = { 
    				CageNoInt.toString(),
    				DiseaseIdInt.toString(),
    				DiseaseReportObj.getReportDate()
    				};
    		
    		tabledata[i] = line;
    		i++;
	    }

	    String headers[] = { "Cage No", "Disease ID", "Report Date" };
	    // Create a new table instance
	    DefaultTableModel model = new DefaultTableModel(tabledata, headers);
	    // And line color shift in table
	    JTable table = new JTable(model) {
	        private static final long serialVersionUID = 1L;
	 
	        public Component prepareRenderer(TableCellRenderer renderer, int Index_row, int Index_col) {
	            Component comp = super.prepareRenderer(renderer, Index_row, Index_col);
	            // if not selected then change background color for every second row
	            if (!isCellSelected(Index_row, Index_col)) {
	                if (Index_row % 2 == 0)
	                    comp.setBackground(Color.WHITE);
	                else
	                    comp.setBackground(Color.LIGHT_GRAY);
	            }
	            return comp;
	       }
	    }; // end of creating JTable table
	    
	    table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    table.setEnabled(false);
	    
	    JScrollPane scrollPane = new JScrollPane(table);
	    scrollPane.setViewportBorder(new TitledBorder(null, "DiseaseReport list", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	    scrollPane.setBounds(10, 227, 460, 243);
	    reportedPane.add(scrollPane, BorderLayout.CENTER);
		  			    
	}
	
	// method to refresh the two list tables after an operation.
	private void refreshScreen()
	{
		createReportList();
		createTransferList();
	}
	
	//method to find cage
    private Cage checkCage(int key)
    {
        CTRCage ctrEmp = new CTRCage();
        return ctrEmp.findCage(key);
    }
    
	//method to find employee
    private Employee checkEmployee(int key)
    {
        CTREmployee ctrEmp = new CTREmployee();
        return ctrEmp.findEmployeeByID(key);
    }
    
  //method to find bitedisease
    private BiteDisease checkBite(int key)
    {
        CTRBiteDisease ctrBite = new CTRBiteDisease();
        return ctrBite.findDiseaseById(key);
    }
   
    //method to find plasmadisease
    private PlasmaDisease checkPlasma(int key)
    {
        CTRPlasmaDisease ctrplasma = new CTRPlasmaDisease();
        return ctrplasma.findDiseaseById(key);
    }

    //method to find Cage number in Transfer
    private Transfer checkCageNoTransfer(int key)
    {
        CTRTransfer ctrtransfer = new CTRTransfer();
        return ctrtransfer.searchTransfersByCageId(key);
    }
    
  //method a Transfer with given Cage number and put it into display fields.
    private boolean findTransfer()
    {
    	if(cageno_transferfield.getText().length() > 2)
    	{
	    	int cagenumber = Integer.parseInt(cageno_transferfield.getText());
	    	Transfer transfer = checkCageNoTransfer(cagenumber);
	    	if(transfer != null)
	    	{
	    		employee_field.setText(String.valueOf(transfer.getEmployee().getEmployeeID()));
	    		if(transfer.getBitedisease() != null)
	    			disease_field.setText(String.valueOf(transfer.getBitedisease().getDiseaseId()));
	    		else if(transfer.getPlasmadisease() != null)
	    			disease_field.setText(String.valueOf(transfer.getPlasmadisease().getDiseaseId()));
	    		else
	    			disease_field.setText("NOT GIVEN");
	    		date_field.setText(transfer.getTransferDate());
	    		return true;
	    	}
    	}
    	return false;
    }
    
}
