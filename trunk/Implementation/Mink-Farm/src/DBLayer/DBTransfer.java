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
     

	
	
	@Override
	public int insertTransfer(Transfer transfer) throws Exception 
	{
	    {  
	    	//call to get the next transfer Id 
	            int nexttransferId = GetMax.getMaxId("Select max(transferId) from mfTransfer");
	            nexttransferId = nexttransferId + 1;
	            System.out.println("next transferId = " +  nexttransferId);
	      
	           int rc = -1;
	    	   String query="INSERT INTO mfTransfer(transferId, transferDate, cageNumber, diseaseId_p, diseaseId_b, employeeId)  " +
	    	   		"VALUES('"+
	    	   nexttransferId  + "','"  +
	    	   transfer.getTransferDate()  + "','"  +
	    	   transfer.getCage().getCageNo()  + "','"  +
	    	   transfer.getdiseaseId_p()  + "','"  +
	    	   transfer.getDisease_b()  + "','"  +
	    	   transfer.getEmployee().getEmployeeID();
	    	   
	           System.out.println("insert : " + query);
	           try{ 
	        	   
	               Statement stmt = con.createStatement();
	               stmt.setQueryTimeout(5);
	          	   rc = stmt.executeUpdate(query);
	               stmt.close();
	           }//end try
	            catch(SQLException ex){
	               System.out.println("Transfer not created");
	               throw new Exception ("Transfer is not inserted correctly");
	            }
	            return(rc);
	    }
			   
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
	 			if(retrieveAssociation)
	 			{
            		DBCage dbcage = new DBCage();
            		Cage cageObj = transferObj.getCage();
            		transferObj.setCage(dbcage.findCage(cageObj.getCageNo(), false));
            		
            		
            		DBEmployee dbemp = new DBEmployee();
            		transferObj.setEmployee(dbemp.findEmployeeByID(transferObj.getEmployee().getEmployeeID(), false));
            		System.out.println("Employee Id is selected");
            		
            		
            		DBBiteDisease dbbite = new DBBiteDisease();
            		transferObj.setDisease_b(dbbite.searchBiteDiseaseById(transferObj.getDisease_b().getDiseaseId(), false));
            		
            		
            		DBPlasmaDisease dbplasma = new DBPlasmaDisease();
            		transferObj.setdiseaseId_p(dbplasma.searchDiseaseById(transferObj.getdiseaseId_p().getDiseaseId(), false));
            		
	 				
	 			}
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
    {   Transfer transferObj = new Transfer();
        try{ 
        	// the columns from the table transfer are used
              transferObj.setTransferId(results.getInt("transferId"));
              transferObj.setTransferDate(results.getString("transferDate"));
              transferObj.setCage(new Cage(results.getInt("cageNumber")));
              transferObj.setdiseaseId_p(new PlasmaDisease(results.getInt("diseaseId_p")));
              transferObj.setDisease_b(new BiteDisease(results.getInt("diseaseId_b")));
              transferObj.setEmployee(new Employee(results.getInt("employeeId")));
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
	        ArrayList<Transfer> listT = new ArrayList <Transfer>();

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
	                listT.add(transferObj);
	            }
	            stmt.close();
	            
	            if(retrieveAssociation)
	            {
	            		
	            		for(Transfer trans : listT)
	            		{
	            		
	            		DBCage dbcage = new DBCage();
	            		trans.setCage(dbcage.findCage(trans.getCage().getCageNo(), false));
	            		System.out.println("Employee Id is selected");
	            		
	            		DBEmployee dbemp = new DBEmployee();
	            		trans.setEmployee(dbemp.findEmployeeByID(trans.getEmployee().getEmployeeID(), false));
	            		System.out.println("Employee Id is selected");
	            		
	            		
	            		DBBiteDisease dbbite = new DBBiteDisease();
	            		trans.setDisease_b(dbbite.searchBiteDiseaseById(trans.getDisease_b().getDiseaseId(), false));
	            		System.out.println("Employee Id is selected");
	            		
	            		
	            		DBPlasmaDisease dbplasma = new DBPlasmaDisease();
	            		trans.setdiseaseId_p(dbplasma.searchDiseaseById(trans.getdiseaseId_p().getDiseaseId(), false));
	            		System.out.println("Employee Id is selected");
	            		
	            	}
	            }
	            return listT;
	         }

	         catch(Exception e)
	         {
	            System.out.println (e.getMessage());
	            return null;
	         }
	    }




}// end of class DBTransfer.
