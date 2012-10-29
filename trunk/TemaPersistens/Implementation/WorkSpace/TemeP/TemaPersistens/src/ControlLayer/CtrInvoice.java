package ControlLayer;

import ModelLayer.*;
import DBLayer.*;
import java.util.ArrayList;


public class CtrInvoice {

	/** Creates a new instance of CtrInvoice */
	public CtrInvoice ()
	{
		
	}

	public Invoice findInvoiceNo(int invoiceNo)
	{
		IFDBInvoice ifdbInvoice = new DBInvoice();
		return ifdbInvoice.findInvoice(invoiceNo, true);
	}
	
    public ArrayList<Invoice> getAllInvoice()
    {
      IFDBInvoice  dbInvoice = new DBInvoice();
      ArrayList<Invoice> allvoice = new ArrayList<Invoice>();
      allvoice = dbInvoice.getAllInvoice(false);
      return allvoice;
    }

	public void insertNewInvoice(int invoiceNo, String paymentDate, double totalAmount)
	{
		Invoice invobj = new Invoice();
		invobj.setInvoiceNo(invoiceNo);
		invobj.setPaymentDate(paymentDate);
		invobj.setTotalAmount(totalAmount);
		
	try
	{
		
	DbConnection1.startTransaction();
	DBInvoice dbInvoice = new DBInvoice();
	dbInvoice.insertInvoice(invobj);
	DbConnection1.commitTransaction();
	}
	catch(Exception e)
	{
		DbConnection1.rollbackTransaction();
	}
		
	}
}