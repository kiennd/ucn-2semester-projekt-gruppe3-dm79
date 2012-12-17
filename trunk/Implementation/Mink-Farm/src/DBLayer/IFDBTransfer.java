package DBLayer;
import ModelLayer.*;

import java.util.ArrayList;


public interface IFDBTransfer 
{
	
		// Prints all transfer information.
		public ArrayList<Transfer> getAllTransfer(boolean retriveAssociation);
		
		//find a single transfer using the cage Id.
		public Transfer searchTransfersByCageId(int cageId, boolean retriveAssociation);
		
		//find a single transfer using the disease id
		public Transfer findTransfersBydiseaseid(int diseaseId_p, boolean retriveAssociation);
		
		
		//find a single transfer using the transfer date.
		public Transfer findtransferByDate(String tranferdate, boolean retriveAssociation);
		
	    
	    //update transfer information.
	    public int updateTransfer(Transfer transfer);
	
	}//end of interface 


