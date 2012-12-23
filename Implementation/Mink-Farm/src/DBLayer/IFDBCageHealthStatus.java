package DBLayer;
import ModelLayer.*;

import java.util.ArrayList;


public interface IFDBCageHealthStatus 
{
	// Prints health status information for all the cages.
	public ArrayList<CageHealthStatus> getAllCageHealthStatus(boolean retriveAssociation);
	

	//find a single health status using the cage Id.
	public CageHealthStatus searchHealthStatusByCageNumber(int cageNo, boolean retriveAssociation);
	
	
	//inserts a new health record.
    public int insertHealthStatus(CageHealthStatus healthstatus) throws Exception;
    
    //update information about a health status
    public int updateHealthStatus(CageHealthStatus healthstatus);
    
    //delete a health record using a CageNo.
    public int deleteHealthStatusWithCageNo(int cageNo);
    
    
    
}