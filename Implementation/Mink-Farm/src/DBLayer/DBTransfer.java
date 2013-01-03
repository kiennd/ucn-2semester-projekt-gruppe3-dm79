package DBLayer;
import ModelLayer.*;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

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
		try 
		{
			return miscWhere("", retriveAssociation);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;
	}
	

	@Override
	public Transfer searchTransfersByTransferId(int transferId, boolean retriveAssociation) 
	{
    	String wClause = "  transferId = '" + transferId + "'";
 		return singleWhere(wClause, retriveAssociation);
	}
	
	@Override
	public Transfer searchTransfersByCageNo(int cageNo, boolean retriveAssociation) 
	{
    	String wClause = "  cageNo = '" + cageNo + "'";
 		return singleWhere(wClause, retriveAssociation);
	}
	

	@Override
	public ArrayList<Transfer> findTransfersByEmployeeId(int employeeId, boolean retriveAssociation) 
	{
    	String wClause = "  employeeId = '" + employeeId + "'";
		return miscWhere(wClause, retriveAssociation);
	}
	
	
	@Override
	public ArrayList<Transfer> findTransfersBydiseaseId(int diseaseId, boolean retriveAssociation) 
	{
    	String wClause = "  diseaseId = '" + diseaseId + "'";
 		return miscWhere(wClause, retriveAssociation);
	}


	@Override
	public ArrayList<Transfer> findtransferByDate(String transdate, boolean retriveAssociation) 
	{
    	String wClause = "  transferDate = '" + transdate + "'";
			return miscWhere(wClause, retriveAssociation);
	}


	//update transfer. 
	@Override
	public int updateTransfer(Transfer transferObj) 
	{
		int rc = -1;
		Transfer transfer = transferObj;

		String query="UPDATE mfTransfer SET "+
				"cageNo ='" + transfer.getCage().getCageNo() + "', " +	
				"diseaseId ='" + getDiseaseValue(transfer) + "', " +
				"employeeId ='" + transfer.getEmployee().getEmployeeID() + "', " +
				"transferDate ='" + transfer.getTransferDate() + "' "  +
				"WHERE transferId = '" + transfer.getTransferId() + "' ";
	   
	    System.out.println("Update query:" + query);
	  	try
	  	{ 
		 	Statement stmt = con.createStatement();
		 	stmt.setQueryTimeout(5);
		 	rc = stmt.executeUpdate(query);
		 	stmt.close();
		}
	  	catch(Exception e)
	  	{
			System.out.println(e.getMessage());
		}
	  	
	  	return(rc);
	}
		

	
	//delete from transfer using id.
	public int deleteTransfer(int transferId)
    {
        int rc = -1;
        String delete = "DELETE FROM mfTransfer where transferId ='" + transferId + "'";
        System.out.println(delete);
        try {
        	Statement stmt = con.createStatement();
            //stmt.setQueryTimeout(5);
            rc = stmt.executeUpdate(delete);     
            stmt.close();
        } 
        catch(SQLException sqlE) 
        {
            System.out.println(sqlE.getMessage());   
        } 
        catch(Exception e)
        {
        	System.out.println(e.getMessage());
        }
        
        return rc;
     }
     

	
	@Override
	public int insertTransfer(Transfer transferObj)
	{
		//call to get next transferId.
		int nextTransferId = GetMax.getMaxId("Select max(transferId) from mfTRansfer");
        nextTransferId = nextTransferId + 1;
		System.out.println("next transferId = " +  nextTransferId);
		
        int rc = -1;
	  	int diseaseValue = getDiseaseValue(transferObj);
		String query="INSERT INTO mfTransfer(transferId, cageNo, diseaseId, employeeId, transferDate)  VALUES('"+
				nextTransferId  + "','"  +		
				transferObj.getCage().getCageNo() + "','" +
				diseaseValue + "','" +
				transferObj.getEmployee().getEmployeeID() + "','" +
				getTodaysDate() + "') ";
		System.out.println("insert : " + query);
		
		try 
		{
			//insert new transfer with cagenum, diseaseid, employeeId.
			Statement stmt = con.createStatement();
	        stmt.setQueryTimeout(5);
	     	rc = stmt.executeUpdate(query);
	        stmt.close();
	        
	        // Check if Cage number is in DiseaseReport DB, if so delete it in DiseaseReport DB. 
		  	int cagenumber = transferObj.getCage().getCageNo();
	        IFDBDiseaseReport diseasereport = new DBDiseaseReport();
	        try
	        {
				if(diseasereport.searchDiseaseReportByCageNumber(cagenumber, false) != null)
				{
					rc = diseasereport.deleteDiseaseReportWithCageNo(cagenumber);
				}
			}
	        catch (Exception e)
	        {
				System.out.println(e.getMessage());
			}
	        
		}//end try.
	    catch(SQLException ex)
	    {
            System.out.println("Transfer not created"+ex.getMessage());
	    }
		
        return rc;		
	}
	

	@Override
	public int deleteTransfer(Transfer transferObj)
	{   
		int rc=-1;
	  	String query="DELETE FROM mfTransfer WHERE cageNo = '" + transferObj.getCage().getCageNo() + "'";
	  	System.out.println(query);
	  	try
	  	{ // delete from Transfer
	  		Statement stmt = con.createStatement();
	  		stmt.setQueryTimeout(5);
	  		rc = stmt.executeUpdate(query);
	  		stmt.close();
	  	}//slut try	
	  	catch(Exception ex)
	  	{
	  		System.out.println("Delete exception in mfTransfer db: "+ex.getMessage());
	  	}
	  	
	  	return rc;
	}

	//alternative
/*	public int insertTransfer(Transfer transferObj) 
	{
        int rc = -1; 
        PreparedStatement pstmt = null;
        String insert = "INSERT INTO mfTransfer(transferId, cageNo, diseaseId, employeeId, transferDate)"+"values(?,?,?,?,?)";
        System.out.println(insert);
        try
        {
        	pstmt = con.prepareStatement(insert);
        	pstmt.setInt(1, transferObj.getTransferId());
        	pstmt.setInt(2, transferObj.getCageNo());
        	pstmt.setInt(3, transferObj.getDiseaseId());
        	pstmt.setInt(4, transferObj.getEmployeeId());
        	pstmt.setString(5, transferObj.getTransferDate());
        	rc = pstmt.executeUpdate();
        } catch(SQLException sqlE) {
            System.out.println("SQL Error");
            System.out.println(sqlE.getMessage());   
        } catch(Exception e) {
            e.getMessage();
        }
        return rc;
	}
        	*/
        

	
	//used when we select only one Transfer.
	private Transfer singleWhere(String wClause, boolean retrieveAssociation)
	{
		ResultSet results;
		Transfer transferObj = null;
		String query = buildQuery(wClause);
		System.out.println(query);
		
		try	{
			//read the transfer from the database.
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 		results = stmt.executeQuery(query);
	 		
	 		if( results.next() ) 
	 		{	
	 			transferObj = buildTransfer(results);

	 			if(retrieveAssociation) 
	 			{	       		
	 				// Based upon Cage number retreive a complete Cage object from DBCage
	 				IFDBCage dbcage = new DBCage();
	 				transferObj.setCage(dbcage.findCage(transferObj.getCage().getCageNo(), false));
	 				
	 				// Based upon Disease Id retreive a complete Disease object from DBDisease
            		if (transferObj.getBitedisease() != null) 
            		{
            			IFDBBiteDisease bitedisease = new DBBiteDisease();
            			transferObj.setBitedisease(bitedisease.searchBiteDiseaseById(transferObj.getBitedisease().getDiseaseId(), false));
            		}
            		else 
            		{
            			IFDBPlasmaDisease plasmadisease = new DBPlasmaDisease();
            			transferObj.setPlasmadisease(plasmadisease.searchDiseaseById(transferObj.getPlasmadisease().getDiseaseId(), false));
            		}
	 				
	 				// Based upon Employee Id retreive a complete Employee object from DBEmployee
            		IFDBEmployee employee = new DBEmployee();
	 				transferObj.setEmployee(employee.findEmployeeByID(transferObj.getEmployee().getEmployeeID(), false));	

	 				}
	 		}
	 		
 			stmt.close();
		}
		catch(Exception ex)
		{
			System.out.println("Query Exception " + ex.getMessage());
		}
		
	 	return transferObj;
	}
	 			
	 
	
	//method to build the query
	
	private String buildQuery(String wClause)
	{
		String query = "SELECT transferId, cageNo, diseaseId, employeeId, transferDate FROM mfTransfer";	
		if (wClause.length()>0)
			query=query+" WHERE "+ wClause;
		return query;
	}
	
	
	private Transfer buildTransfer(ResultSet results)
	{
		Transfer transObj = new Transfer();
	
		//columns from mfTransfer table are used.
		try
		{
			transObj.setTransferId(results.getInt("transferId"));
			transObj.setCage(new Cage(results.getInt("cageNo")));
			
			int valueOfDisease = results.getInt("diseaseId");
			if (valueOfDisease == 1600) 
			    transObj.setBitedisease(new BiteDisease(valueOfDisease));
			else 
				transObj.setPlasmadisease(new PlasmaDisease(valueOfDisease));
			
			transObj.setEmployee(new Employee(results.getInt("employeeID")));
			transObj.setTransferDate(results.getString("transferDate"));
		}
		catch (Exception ex)
		{
			System.out.println(ex.getMessage());
			return null;
		}
		
		return transObj;
	}
	
	
/*	//method to build transfer object.
	private Transfer buildTransfer(ResultSet results)
    {
		try {
			Transfer transferObj = new Transfer(
				results.getInt("transferId"),
				results.getInt("cageNo"),
				results.getInt("diseaseId"),
				results.getInt("employeeId"),
				results.getString("transferDate"));
			
			return transferObj;
			
		} catch (SQLException ex) {
		// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return null;
	}	
	*/
	
	private ArrayList<Transfer> miscWhere(String wClause, boolean retrieveAssociation)
	{
    	ResultSet results;
	    ArrayList<Transfer> listT = new ArrayList <Transfer>();
	    String query = buildQuery(wClause);
	    System.out.println(query);
	    try { 
				// read transfer from the database
	            Statement stmt = con.createStatement();
	            stmt.setQueryTimeout(5);
	            results = stmt.executeQuery(query);
	            
	            while(results.next())
				{
	            	Transfer transferObj = buildTransfer(results);
	            	           	
	 				listT.add(transferObj);
	 				
	            }//end while
	            
	            stmt.close();
	            if(retrieveAssociation)
	            {
	            	for(Transfer transferObj : listT)
	            	{
		 				// Based upon Cage number retreive a complete Cage object from DBCage
	            		IFDBCage dbcage = new DBCage();
		 				transferObj.setCage(dbcage.findCage(transferObj.getCage().getCageNo(), false));
		 				
		 				// Based upon Disease Id retreive a complete Disease object from DBDisease
	            		if (transferObj.getBitedisease() != null) 
	            		{
	            			IFDBBiteDisease bitedisease = new DBBiteDisease();
	            			transferObj.setBitedisease(bitedisease.searchBiteDiseaseById(transferObj.getBitedisease().getDiseaseId(), false));
	            		}
	            		else 
	            		{
	            			IFDBPlasmaDisease plasmadisease = new DBPlasmaDisease();
	            			transferObj.setPlasmadisease(plasmadisease.searchDiseaseById(transferObj.getPlasmadisease().getDiseaseId(), false));
	            		}
		 				
		 				// Based upon Employee Id retreive a complete Employee object from DBEmployee
	            		IFDBEmployee employee = new DBEmployee();
		 				transferObj.setEmployee(employee.findEmployeeByID(transferObj.getEmployee().getEmployeeID(), false));
		 				
		 			}
	            }//end if
	    }//end try
	    catch(Exception ex)
	    {
	 		System.out.println("Query exception - select: "+ ex.getMessage());
	 		ex.printStackTrace();
	 	}
	    
		return listT;
	}
	            
	
/*	//michWere is used whenever we want to select more than one row in transfer table. 
    private ArrayList<Transfer> miscWhere(String wClause, boolean retrieveAssociation) throws Exception
	{
    	ResultSet results;
	    ArrayList<Transfer> listT = new ArrayList <Transfer>();

	    String query = buildQuery(wClause);
	    System.out.println(query);
	    try { 
				// read transfer from the database
	            Statement stmt = con.createStatement();
	            stmt.setQueryTimeout(5);
	            results = stmt.executeQuery(query);

	            while(results.next())
				{
	                listT.add(buildTransfer(results));
	            }
	            stmt.close();
	            
	            if(retrieveAssociation)
	            {
	            	for(Transfer trans : listT)
	            	{
	            		
            		    DBCage dbcage = new DBCage();
	            		int cageNo = trans.getCageNo();
	            		if (cageNo != dbcage.findCage(cageNo, false).getCageNo())
	            		{
	            			throw new Exception("Case number:[" + cageNo + "] not found.");
	            		}
	            		System.out.println("Cage Id is selected");
	            		
	            		DBEmployee dbemp = new DBEmployee();
	            		int empId = trans.getEmployeeId(); 
	            		if (empId != dbemp.findEmployeeByID(empId, false).getEmployeeID())
	            		{
	            			throw new Exception("Employee Id:[" + empId + "] not found.");
	            		}
	            		System.out.println("Employee Id is selected");
	            		
	         		    int diseaseId = trans.getDiseaseId();
	            		if (diseaseId == 1600)
	            		{
	            		    DBBiteDisease dbbite = new DBBiteDisease();
	            		    BiteDisease bitedisease = dbbite.searchBiteDiseaseById(diseaseId, false);
	            		    System.out.println("BiteDisease Id is selected");
	            		}
	            		else if (diseaseId == 1500)
	            		{
	            			DBPlasmaDisease dbplasma = new DBPlasmaDisease();
	            			PlasmaDisease plasmadisease = dbplasma.searchDiseaseById(diseaseId, false);
	            		    System.out.println("PlasmaDisease Id is selected");
	            		}
	            		else
	            		{
	            			throw new Exception("DiseaseId:["+ diseaseId + "] not unknown.");
	            		}
	            	}
	            }
	            return listT;
	         }

	         catch(Exception e)
	         {
	            System.out.println (e.getMessage());
	            return null;
	         }
	    }*/

 
	//method for selecting disease type.
	private int getDiseaseValue(Transfer transferObj)
	{
		if(transferObj.getBitedisease() != null)
			return transferObj.getBitedisease().getDiseaseId();
		else
			return transferObj.getPlasmadisease().getDiseaseId();		
	}
    
    //method for getting today's date.
    private String getTodaysDate() 
    {
    	Calendar calendar = Calendar.getInstance();
    	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return dateFormat.format(calendar.getTime());
    }

}// end of class DBTransfer.
