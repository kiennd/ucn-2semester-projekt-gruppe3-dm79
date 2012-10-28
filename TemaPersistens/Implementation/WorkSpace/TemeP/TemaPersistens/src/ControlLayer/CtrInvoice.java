package ControlLayer;
import ModelLayer.*;

public class CtrInvoice {

	/** Creates a new instance of CtrInvoice */
	public CtrInvoice {
		
	}

	// controller for getallinvoice.
	public ArrayList<Invoice> findAllInvoice()
	{
		IFDBInvoice ifdbInvoice = new DBInvoice();
		ArrayList<Invoice> allInvoice = new ArrayList<Invoice>();
		allInvoice = ifdbInvoice.getAllInvoice(false);
		return allInvoice;
	}
	
}