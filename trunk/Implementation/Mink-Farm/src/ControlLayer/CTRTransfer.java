package ControlLayer;
import ModelLayer.*;
import DBLayer.*;

import java.sql.Statement;
import java.util.ArrayList;

public class CTRTransfer 
{
    public CTRTransfer() 
    {
        
    }
    
    
    public ArrayList<Transfer> getAllTransfer()
    {
      IFDBTransfer dbtrans = new DBTransfer();
      ArrayList<Transfer> allTrans = new ArrayList<Transfer>();
      allTrans = dbtrans.getAllTransfer(false);
      return allTrans;
    }
    
    
    public Transfer searchTransfersByCageId(int id)
    {
    	IFDBTransfer dbtrans = new DBTransfer();
    	return dbtrans.searchTransfersByCageNo(id, true);
    }
    
    
    public ArrayList<Transfer> findTransfersByEmployeeId(int employeeId)
    {
    	IFDBTransfer dbtrans = new DBTransfer();
    	return dbtrans.findTransfersByEmployeeId(employeeId, true);
    }
    
    
    public ArrayList<Transfer> findTransfersBydiseaseid(int disId)
    {
    	IFDBTransfer dbtrans = new DBTransfer();
    	return dbtrans.findTransfersBydiseaseId(disId, true);
    }
    
    
    public ArrayList<Transfer> findtransferByDate(String transdate)
    {
    	IFDBTransfer dbtrans = new DBTransfer();
    	return dbtrans.findtransferByDate(transdate, true);
    }
    
    
 /* 
    public int updateTransfer(int cageNo, int diseaseId, int employeeId)
    {
    	IFDBTransfer dbtrans = new DBTransfer();
    	Transfer trans = dbtrans.searchTransfersByCageNo(cageNo, false);
    	trans.setCage(new Cage(cageNo));
	  	int diseaseValue = getDiseaseValue(trans);
		if (diseaseValue == 1500) 
		{
			trans.setBitedisease(new BiteDisease(diseaseId));
		}
		else if (diseaseValue == 1600) 
		{
			trans.setPlasmadisease(new PlasmaDisease(diseaseId));
		}
		trans.setEmployee(new Employee(employeeId));
		trans.setTransferDate(transferDate);
		return dbtrans.updateTransfer(trans);
    	
    }
*/    	
    	
    public int insertTransfer(int cageNo, int diseaseId, int employeeId)
    {
        int rc = -1;
    	IFDBTransfer dbtrans = new DBTransfer();
    	Transfer transObj = new Transfer();
    	
    	transObj.setCage(new Cage(cageNo));
    	if (diseaseId == 1600)
    	{
    		transObj.setBitedisease(new BiteDisease(diseaseId));
    	}
    	else 
    	{
    		transObj.setPlasmadisease(new PlasmaDisease(diseaseId));
    	}
    	transObj.setEmployee(new Employee(employeeId));

	    try
	    {
	        DbConnection.startTransaction();
	        rc = dbtrans.insertTransfer(transObj);
	        DbConnection.commitTransaction();
	    }
        catch(Exception e)
        {
            DbConnection.rollbackTransaction();
            System.out.println(e.getMessage());
        }
	    
	    return rc;
    }
    
    
/*	public void insertTransfer(int transferId, int cageNo, int diseaseId, int employeeId, String transferDate)
	{
		try
		{
        	int rc = -1;
			Transfer trans = new Transfer(
					transferId,
					cageNo,
					diseaseId,
					employeeId,
					transferDate);
			
			DbConnection.startTransaction();
			DBTransfer dbtrans = new DBTransfer();
			rc = dbtrans.insertTransfer(trans);
			DbConnection.commitTransaction();
		}
		catch(Exception e)
		{
			DbConnection.rollbackTransaction();
            System.out.println(e.getMessage());
		}
		
		return rc;
	}
	
*/
    
    public int deleteTransfer(int cageNo)
    {
        int rc = -1;
    	IFDBTransfer dbtrans = new DBTransfer();
    	Transfer transObj = dbtrans.searchTransfersByCageNo(cageNo, false);
	    if(transObj != null)
	    {
	    	try
		    {
		        DbConnection.startTransaction();
		        rc = dbtrans.deleteTransfer(transObj);
		        DbConnection.commitTransaction();
		    }
	        catch(Exception e)
	        {
	            DbConnection.rollbackTransaction();
	            System.out.println(e.getMessage());
	        }
	    }
	    
	    return rc;
    }
    

 }// end of class CTRTransfer.
