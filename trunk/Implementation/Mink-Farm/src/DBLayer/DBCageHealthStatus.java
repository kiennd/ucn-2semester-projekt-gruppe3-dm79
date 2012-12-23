package DBLayer;
import ModelLayer.*;

import java.sql.*;
import java.util.ArrayList;

public class DBCageHealthStatus implements IFDBCageHealthStatus
{
	private Connection con;

	
// Creates a new instance of DBPlasmDisease 
	public DBCageHealthStatus()
	{
		con = DbConnection.getInstance().getDBcon();
	}
	
	@Override
	public ArrayList<CageHealthStatus> getAllCageHealthStatus(boolean retriveAssociation) 
	{
		return miscWhere("", retriveAssociation);
	}

	@Override
	public CageHealthStatus searchHealthStatusByCageNumber(int cageNo, boolean retriveAssociation) 
	{
    	String wClause = "  cageNumber = '" + cageNo + "'";
    	return singleWhere(wClause, retriveAssociation);
	}



	@Override
	public int insertHealthStatus(CageHealthStatus healthstatus) 
	{
        int rc = -1; 
        PreparedStatement pstmt = null;
        String insert = "insert into mfCageHealthStatus(cageNumber, plasmacytosisObserveret, bideSårObserveret, okayDate)"+"values(?,?,?,?)";
        System.out.println(insert);
        try
        {
            pstmt = con.prepareStatement(insert);
            pstmt.setInt(1,healthstatus.getCageNumber());
            pstmt.setString(2,healthstatus.getPlasmacytosisObserveret());
            pstmt.setString(3,healthstatus.getBideSårObserveret());
            pstmt.setString(4,healthstatus.getOkayDate());
            rc = pstmt.executeUpdate();
        }
        
        catch(SQLException sqlE)
        {
            System.out.println("SQL Error");
            System.out.println(sqlE.getMessage());   
        }
        catch(Exception e)
        {
            e.getMessage();
            
        }
        return rc;
	}

	@Override
	public int updateHealthStatus(CageHealthStatus healthstatus) 
	{
		CageHealthStatus cageHealthStatObj  = healthstatus;

			int rc=-1;

					String query="UPDATE mfCageHealthstatus SET "+
					"cageNumber ='"+ cageHealthStatObj.getCageNumber()+"', "+
					"plasmacytosisObserveret ='"+ cageHealthStatObj.getPlasmacytosisObserveret() + "', " +	
					"bideSårObserveret ='"+ cageHealthStatObj.getBideSårObserveret() + "', " + 
					"okayDate ='"+ cageHealthStatObj.getOkayDate();

		            System.out.println("Update query:" + query);
					try
					{
					//update mfHealthstatus.
					Statement stmt = con.createStatement();	
			 		stmt.setQueryTimeout(5);
			 		rc = stmt.executeUpdate(query);
			 	 	stmt.close();
					}//end try
					catch(Exception ex)
					{
					System.out.println("Update exception in Cage Health Status DB: "+ex);
					}
					return(rc);
			}
		
	
	//Singelwhere is used when we only select one CageHealthStatus.
	
	private CageHealthStatus singleWhere(String wClause, boolean retrieveAssociation)
	{
		ResultSet results;
		CageHealthStatus healthstatObj = new CageHealthStatus();
		
		String query =  buildQuery(wClause);
		System.out.println(query);
		try
		{
			//read the health status from the database.
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 		results = stmt.executeQuery(query);
	 		
	 		if( results.next() )
	 		{
	 			healthstatObj = buildCageHealthStatus(results);
	 			stmt.close();
	 		}
	 		else{ 
	 			//No health status info was found.
	 			healthstatObj = null;
	 		}
			
		}
		//end try.
		catch(Exception e){
			System.out.println("Query exception: "+e);
		}
		return healthstatObj;	
	}
	
	
	
	//michWere is used whenever we want to select more than one row of health status of a cage. 
	  private ArrayList<CageHealthStatus> miscWhere(String wClause, boolean retrieveAssociation)
	    {
	        ResultSet results;
	        ArrayList<CageHealthStatus> list = new ArrayList <CageHealthStatus>();

	        String query = buildQuery(wClause);
	        System.out.println(query);
	         try{ 
					// read the health status from the database
	            Statement stmt = con.createStatement();
	            stmt.setQueryTimeout(5);
	            results = stmt.executeQuery(query);

	            while(results.next())
				{
	            	CageHealthStatus cagehealthstatObj = new CageHealthStatus();
	            	cagehealthstatObj = buildCageHealthStatus(results);
	                list.add(cagehealthstatObj);
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

	
	
	//method to build the query
	
	private String buildQuery(String wClause)
	{
		String query = "SELECT cageNumber, plasmacytosisObserveret, bideSårObserveret, okayDate FROM mfCageHealthStatus";	
		if (wClause.length()>0)
			query=query+" WHERE "+ wClause;
		return query;
	}
	
	
	
	//method to build health status object.
	private CageHealthStatus buildCageHealthStatus(ResultSet results)
	{
		CageHealthStatus cagehealthstatObj = new CageHealthStatus();
		try
		{
			//use columns from mfCageHealthStatus table.
			cagehealthstatObj.setCageNumber(results.getInt("cageNumber"));
			cagehealthstatObj.setPlasmacytosisObserveret(results.getString("plasmacytosisObserveret"));
			cagehealthstatObj.setBideSårObserveret(results.getString("bideSårObserveret"));
			cagehealthstatObj.setOkayDate(results.getString("okayDate"));
		}
		
		catch (Exception e)
		{
			System.out.println("Error building the Health status object.");
		}
		return cagehealthstatObj;
	}


	
	@Override
	public int deleteHealthStatusWithCageNo(int cageNo)
	{
            int rc=-1;
		  	String query="delete from mfCageHealthStatus where cageNumber = '" +
				cageNo + "'";
            System.out.println(query);
            try
            { 
            	// delete from health status
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 	  	rc = stmt.executeUpdate(query);
	 	  	stmt.close();
            }//end try	
   	        catch(Exception ex)
   	        {
	 	  	System.out.println("Delete exception in cageHealthStatus db: "+ex);
   	        }
		return(rc);
	}
	

	}	//end of class DBCageHealthStatus

	

