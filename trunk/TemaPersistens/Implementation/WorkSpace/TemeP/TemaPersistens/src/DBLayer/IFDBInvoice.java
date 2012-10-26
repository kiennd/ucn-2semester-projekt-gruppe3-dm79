package DBLayer;
import ModelLayer.*;

import java.util.ArrayList;
public interface IFDBInvoice 
{
	public Invoice findInvoice(int invoice, boolean retrieveAssociation);
	
	public ArrayList<Invoice> getAllInvoice(boolean retrieveAssociation);
	
	public int insertInvoice(Invoice inv) throws Exception;
	

}
