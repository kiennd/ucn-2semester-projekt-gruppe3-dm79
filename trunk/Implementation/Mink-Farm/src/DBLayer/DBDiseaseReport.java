package DBLayer;
import ModelLayer.*;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class DBDiseaseReport implements IFDBDiseaseReport {

	private Connection con;

	
// Creates a new instance of DBPlasmDisease 
	public DBDiseaseReport()
	{
		con = DbConnection.getInstance().getDBcon();
	}
	
	@Override
	public ArrayList<DiseaseReport> getAllDiseaseReport(boolean retriveAssociation)
	{
		return miscWhere("", retriveAssociation);
	}

	@Override
	public DiseaseReport searchDiseaseReportByCageNumber(int cageNo, boolean retriveAssociation)
	{
    	String wClause = "  cageNumber = '" + cageNo + "'";
		return singleWhere(wClause, retriveAssociation);
	}

	@Override
	public int insertDiseaseReport(DiseaseReport diseasereport)
	{
	    int rc = -1; 
        PreparedStatement pstmt = null;
        String insert = "INSERT INTO mfDiseaseReport(cageNumber, diseaseId, reportDate)"+"values(?,?,?)";
        System.out.println(insert);
        try
        {
            pstmt = con.prepareStatement(insert);
            pstmt.setInt( 1, diseasereport.getCageNo() );
            pstmt.setInt( 2, diseasereport.getDiseaseId() );
            pstmt.setString( 3, getTodaysDate() );
            rc = pstmt.executeUpdate();
        } 
        catch(SQLException sqlE)
        {
            System.out.println(sqlE.getMessage());
            return rc;
        }
        catch(Exception e)
        {
        	System.out.println(e.getMessage());
        	return rc;
        }
        
        return rc;
	}

	
	//SingleWhere is used when we only select one DiseaseReport.
	
	private DiseaseReport singleWhere(String wClause, boolean retrieveAssociation)
	{
		ResultSet results;
		DiseaseReport diseasereportObj = null;
		String query =  buildQuery(wClause);
		System.out.println(query);
		try
		{
			//read the health status from the database.
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 		results = stmt.executeQuery(query);
	 		if( results.next() )
	 			diseasereportObj = buildDiseaseReport(results);
 			stmt.close();
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			return null;
		}
		
		return diseasereportObj;
	}
	
	
	
//michWere is used whenever we want to select more than one row of health status of a cage. 
private ArrayList<DiseaseReport> miscWhere(String wClause, boolean retrieveAssociation)
{
	ResultSet results;
	ArrayList<DiseaseReport> list = new ArrayList <DiseaseReport>();
 
	String query = buildQuery(wClause);
	System.out.println(query);
	try
	{
		// read the health status from the database
	    Statement stmt = con.createStatement();
	    stmt.setQueryTimeout(5);
	    results = stmt.executeQuery(query);

	    while(results.next())
	    {
	    	list.add(buildDiseaseReport(results));
	    }
	    stmt.close();
	          
	    return list;
	}
	catch(Exception ex)
	{
		System.out.println(ex.getMessage());
		return null;
	}
}
	
	
	//method to build the query
	private String buildQuery(String wClause)
	{
		String query = "SELECT cageNumber, diseaseId, reportDate FROM mfDiseaseReport";	
		if (wClause.length() > 0)
			query = query + " WHERE " + wClause;
		
		return query;
	}
	
	
	//method to build health status object.
	private DiseaseReport buildDiseaseReport(ResultSet results)
	{
		try
		{
		    DiseaseReport diseasereportObj = new DiseaseReport(
				results.getInt( "cageNumber" ),
				results.getInt( "diseaseId" ),
				results.getString( "reportDate" ));
		    
		    return diseasereportObj;
		}
		catch (Exception ex)
		{
			System.out.println(ex.getMessage());
			return null;
		}

	}


	
	@Override
	public int deleteDiseaseReportWithCageNo(int cageNo)
	{
        int rc=-1;
		String query="delete from mfDiseaseReport where cageNumber = '" + cageNo + "'";
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
   	       	System.out.println("Delete exception in DiseaseReport db: "+ex.getMessage());
   	    }
        
		return(rc);
	}
	
    public String getTodaysDate() 
    {
    	Calendar calendar = Calendar.getInstance();
    	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return dateFormat.format(calendar.getTime());
    }

}
