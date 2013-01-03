package DBLayer;
import ModelLayer.*;

import java.util.ArrayList;


public interface IFDBTransfer 
{
	
		// Prints all transfer information.
		public ArrayList<Transfer> getAllTransfer(boolean retriveAssociation);
		
		//find a single transfer using the cage Id.
		public Transfer searchTransfersByTransferId(int transferId, boolean retriveAssociation);
		
		//find a single transfer using the cage Id.
		public Transfer searchTransfersByCageNo(int cageNo, boolean retriveAssociation);
		
		//find a single transfer using the disease id
		public ArrayList<Transfer> findTransfersByEmployeeId(int employeeId, boolean retriveAssociation);

		//find a single transfer using the disease id
		public ArrayList<Transfer> findTransfersBydiseaseId(int diseaseId, boolean retriveAssociation);
		
		//find a single transfer using the transfer date.
		public ArrayList<Transfer> findtransferByDate(String tranferdate, boolean retriveAssociation);
		
	    
	    //update transfer information.
	    public int updateTransfer(Transfer transfer);
	    
	    
	  //inserts a new transfer.
	    public int insertTransfer(Transfer transfer);

		public int deleteTransfer(Transfer transferObj);
	    
	
	}//end of interface 


