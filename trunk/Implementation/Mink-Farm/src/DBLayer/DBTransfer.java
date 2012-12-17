package DBLayer;
import ModelLayer.*;

import java.sql.*;
import java.util.ArrayList;

public class DBTransfer implements IFDBTransfer
{
	private Connection con;
	// Creates a new instance of DBPlasmDisease 
	public DBTransfer()
	{
		con = DbConnection.getInstance().getDBcon();
	}
	

	@Override
	public ArrayList<Transfer> getAllTransfer(boolean retriveAssociation) 
	{
		return miscWhere("", retriveAssociation);
	}

	@Override
	public Transfer searchTransfersByCageId(int id, boolean retriveAssociation) 
	{
    	String wClause = "  cageId = '" + id + "'";
    	return singleWhere(wClause, retriveAssociation);
	}

	@Override
	public Transfer findTransfersBydiseaseid(int disId, boolean retriveAssociation) 
	{
    	String wClause = "  diseaseId = '" + disId + "'";
    	return singleWhere(wClause, retriveAssociation);
	}


	@Override
	public Transfer findtransferByDate(String transdate, boolean retriveAssociation) 
	{
    	String wClause = "  transferDate = '" + transdate + "'";
    	return singleWhere(wClause, retriveAssociation);
	}


	//update transfer. 
	@Override
	public int updateTransfer(Transfer transfer) 
	{
		Transfer transferObj  = transfer;
		Cage cageObj = new Cage();
		Employee empObj = new Employee();
		PlasmaDisease plasmaObj = new PlasmaDisease();
		BiteDisease biteObj = new BiteDisease();
		
		int rc=-1;
		String query="UPDATE mfTransfer SET "+
		"tranferId ='"+ transferObj.getTransferId()+"', "+
		"transferDate ='"+ transferObj.getTransferDate() + "', " +
	    "cageNumber ='"+ cageObj.getCageNo() + "', " +
	    "diseaseId_p ='"+ plasmaObj.getDiseaseId() + "', " +
	    "diseaseId_b ='"+ biteObj.getDiseaseId() + "', " +
	    "employeeId ='"+ empObj.getEmployeeID();
	   
	    System.out.println("Update query:" + query);
	  	try
	  	{ 
	  	// update employee
		 	Statement stmt = con.createStatement();
		 	stmt.setQueryTimeout(5);
		 	rc = stmt.executeUpdate(query);
		 	stmt.close();
		}
	  	//slut try
		 	catch(Exception ex)
		 	{
		 	  System.out.println("Update exception in mfTransfer db: "+ex);
		  	}
			return(rc);
		}
		

	
	//delete from transfer using id.
	public int deleteTransfer(int transferId)
    {
        int rc = -1;
        PreparedStatement pstmt = null;
        String delete = "delete from mfTransfer where transferId = ?";
        System.out.println(delete);
          try{
             pstmt = con.prepareStatement(delete);
             pstmt.setInt(1,transferId);
             rc = pstmt.executeUpdate();                       
          }
          catch(SQLException sqlE)
          {
              System.out.println("SQL Error");
              System.out.println(sqlE.getMessage());   
          }
          catch(Exception e){
              e.getMessage();
              
          }
         return rc;
     }
     

	
	private Transfer singleWhere(String wClause, boolean retrieveAssociation)
	{
		ResultSet results;
		Transfer transferObj = new Transfer();
		
		String query =  buildQuery(wClause);
		System.out.println(query);
		try
		{
			//read the transfer from the database.
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 		results = stmt.executeQuery(query);
	 		
	 		if( results.next() )
	 		{
	 			transferObj = buildTransfer(results);
	 			stmt.close();
	 		}
	 		else{ 
	 			//No health status info was found.
	 			transferObj = null;
	 		}
			
		}
		//end try.
		catch(Exception e){
			System.out.println("Query exception: "+e);
		}
		return transferObj;	
	}
	
	
	
	//method to build the query
	
	private String buildQuery(String wClause)
	{
		String query = "SELECT transferId, transferDate, cageNumber, diseaseId_p, diseaseId_b, employeeId FROM mfTransfer";	
		if (wClause.length()>0)
			query=query+" WHERE "+ wClause;
		return query;
	}
	
	
	//method to build transfer object.
	private Transfer buildTransfer(ResultSet results)
	{
		Transfer transferObj = new Transfer();
		try
		{
			//use columns from transfer table.
			transferObj.setTransferId(results.getInt("transferId"));
			transferObj.setTransferDate(results.getString("transferDate"));
			transferObj.getCage().setCageNo(results.getInt("cageNumber"));
			transferObj.getDisease_p().setDiseaseId(results.getInt("diseaseId_p"));
			transferObj.getDisease_b().setDiseaseId(results.getInt("diseaseId_b"));
			transferObj.getEmployee().setEmployeeID(results.getInt("employeeId"));


		}
		catch (Exception e)
		{
			System.out.println("Error building transfer object.");
		}
		return transferObj;
	}	
	
	
	//michWere is used whenever we want to select more than one row in transfer table. 
	  private ArrayList<Transfer> miscWhere(String wClause, boolean retrieveAssociation)
	    {
	        ResultSet results;
	        ArrayList<Transfer> list = new ArrayList <Transfer>();

	        String query = buildQuery(wClause);
	        System.out.println(query);
	         try{ 
				// read transfer from the database
	            Statement stmt = con.createStatement();
	            stmt.setQueryTimeout(5);
	            results = stmt.executeQuery(query);

	            while(results.next())
				{
	            	Transfer transferObj = new Transfer();
	            	transferObj = buildTransfer(results);
	                list.add(transferObj);
	            }
	            stmt.close();
	            return list;
	         }

	         catch(Exception e)
	         {
	            System.out.println (e.getMessage());
	            return null;
	         }
	    }

	
	
	

}// end of class DBTransfer.
