package src.ControlLayer;
import ModelLayer.*;

public class CtrInvoice {

	/** Creates a new instance of CtrInvoice */
	public CtrInvoice {
		
	}

	// controller for getallinvoice.
	public ArrayList<Invoice> findAllInvoice()
	{
		IFDBInvoice ifdbInvoice = new DBInvoice();
		ArrayList<Invoice> allInv = new ArrayList<Invoice>();
		allInv = ifdbInvoice.getAllInv(false);
		return allInv;
	}
	
}