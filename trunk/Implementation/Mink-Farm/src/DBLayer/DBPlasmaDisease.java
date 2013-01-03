package DBLayer;
import ModelLayer.*;

import java.sql.*;


public class DBPlasmaDisease implements IFDBPlasmaDisease
{
	private Connection con;
	//private PreparedStatement pStmtSelect;
	
	// Creates a new instance of DBPlasmDisease 
	public DBPlasmaDisease()
	{
		con = DbConnection.getInstance().getDBcon();
	}
	
	
	@Override
	//method to find the disease using diseaseId.
    public PlasmaDisease searchDiseaseById(int diseaseId, boolean retriveAssociation)
    {
    	String wClause = "  diseaseId = '" + diseaseId + "'";
    	return singleWhere(wClause, retriveAssociation);
    }
    
    
	@Override
	// find plasma disease using the name.
	public PlasmaDisease searchPlasmaDiseaseByName(String diseaseName, boolean retriveAssociation) 
	{
		String wClause = "diseaseName like '%" + diseaseName + "%'";
        System.out.println("Search PlasmaDisease " + wClause);
        return singleWhere(wClause, retriveAssociation);
	}

	
	@Override
	public int updatePlasmaDisease(PlasmaDisease plasmadis)
	{
		PlasmaDisease plasObj  = plasmadis;
		int rc=-1;

		String query="UPDATE plasmadis SET "+
				"clinicName ='"+ plasObj.getClinicName() + "', " +	
				"clinicCVR ='"+ plasObj.getClinicCVR() + "', " +
				"diseaseName ='"+ plasObj.getDiseaseName()+"' " +
				"WHERE diseaseId ='"+ plasObj.getDiseaseId()+"' ";
		
	    System.out.println("Update query:" + query);
		try
		{
		   // update employee
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
		 	rc = stmt.executeUpdate(query);
		 	stmt.close();
		}//end try
		catch(Exception ex)
		{
			System.out.println("Update exception in PlasmaDisease DB: "+ex);
		}
		return(rc);
	}


	@Override
	public int insertPlasmaDisease(PlasmaDisease plasmadis)
    { 
        int rc = -1; 
        PreparedStatement pstmt = null;
        String insert = "INSERT INTO mfPlasmaDisease (diseaseId, clinicName, clinicCVR, diseaseName)"+
		 		"values (?,?,?,?)";
        System.out.println(insert);
        try
        {
            pstmt = con.prepareStatement(insert);
            pstmt.setInt   ( 1, plasmadis.getDiseaseId() );
            pstmt.setString( 2, plasmadis.getClinicName() );
            pstmt.setString( 3, plasmadis.getClinicCVR() );
            pstmt.setString( 4, plasmadis.getDiseaseName() );
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
	public int deletePlasmaDisease(int plasmaId) 
    {
        int rc = -1;
        PreparedStatement pstmt = null;
        String delete = "DELETE FROM mfPlasmaDisease WHERE diseaseId = ?";
        System.out.println(delete);
        try
        {
        	pstmt = con.prepareStatement(delete);
            pstmt.setInt( 1, plasmaId);
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

    
	//SingleWhere is used to select one disease. 	
	private PlasmaDisease singleWhere(String wClause, boolean retrieveAssociation)
	{
		ResultSet results;
	    String query =  buildQuery(wClause);
        System.out.println(query);
		
		try
		{ 
			//read the disease from the database
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 		results = stmt.executeQuery(query);

	 		if( results.next() )
			{
	 			PlasmaDisease plasObj = buildPlasmaDisease(results);
                stmt.close();
                return plasObj;
			}
	 		else
	 		{
	 			//no disease info was found
	 			return null;
			}
		 		
		}//end try	
		catch(Exception e)
		{
			System.out.println("Query exception: "+e);
		}
		
		return null;
	}
	
	
	//method to build the query	
	private String buildQuery(String wClause)
	{
		String query = "SELECT diseaseId, clinicName, clinicCVR, diseaseName FROM mfPlasmaDisease";	
		if (wClause.length()>0)
		query = query + " WHERE "+ wClause;
		return query;
	}
					
			
	//method to build a plasma disease object.
	private PlasmaDisease buildPlasmaDisease(ResultSet results)
	{
		try
		{
			//use columns from mfPlasmaDisease table.
			PlasmaDisease plasmadisObj = new PlasmaDisease(
					results.getInt("diseaseId"),
					results.getString("clinicName"),
					results.getString("clinicCVR"),
					results.getString("diseaseName"));
			
			return plasmadisObj;

		}
		catch (Exception e)
		{
			System.out.println("Error building the Disease Plasma object.");
		}
		
		return null;
	}

}// end of class DBPlasmaDisease.
