package ControlLayer;
import src.ModelLayer.String;
import ModelLayer.*;

public class CtrInvoice {

	/** Creates a new instance of CtrInvoice */
	public CtrInvoice {
		
	}

	public Invoice findInvoiceNo(int invoiceNo)
	{
		IFDBInvoice ifdbInvoice = new DBInvoice();
		return ifdbInvoice.findInvoiceNo(invoiceNo, true);
	}
	
    public ArrayList<Invoice> getAllInvoice()
    {
      IFDBInvoice  dbInvoice = new DBInvoice();
      ArrayList<Invoice> allvoice = new ArrayList<Invoice>();
      allinvoice = dbInvoice.getAllInvoice(false);
      return allinvoice;
    }

	public void insertNewCustomer(int invoiceNo, String paymentDate, double totalAmount)
	{
		Invoice invobj = new Invoice();
		invobj.setInvoiceNo(invoiceNo);
		invobj.setPaymentDate(paymentDate);
		invobj.setTotalAmount(totalAmount);
		
	try
	{
		
	DbConnection1.startTransaction();
	DBCustomer dbInvoice = new DBInvoice();
	dbCus.insertInvoice(invobj);
	DbConnection1.commitTransaction();
	}
	catch(Exception e)
	{
		DbConnection1.rollbackTransaction();
	}
		
	}
}