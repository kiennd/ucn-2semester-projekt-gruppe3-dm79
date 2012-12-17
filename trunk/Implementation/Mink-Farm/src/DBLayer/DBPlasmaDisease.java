package DBLayer;
import ModelLayer.*;

import java.sql.*;


public class DBPlasmaDisease implements IFDBPlasmaDisease
{
	private Connection con;
	
// Creates a new instance of DBPlasmDisease 
	public DBPlasmaDisease()
	{
		con = DbConnection.getInstance().getDBcon();
	}
	
	
//method to find a disease using diseaseId.
    public PlasmaDisease searchDiseaseById(int disId, boolean retriveAssociation)
    {
    	String wClause = "  diseaseId = '" + disId + "'";
    	return singleWhere(wClause, retriveAssociation);
    }
    
    
//SingleWhere is used to select one disease. 	
	private PlasmaDisease singleWhere(String wClause, boolean retrieveAssociation)
	{
		ResultSet results;
		PlasmaDisease plasObj = new PlasmaDisease();        
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
	 			plasObj = buildPlasmaDisease(results);
                //association is to be build
                stmt.close();
			}
	 		else
	 		{
			//no disease info was found
	 			plasObj = null;
				}
		 		
			}//end try	
		 	catch(Exception e)
		 	{
		 		System.out.println("Query exception: "+e);
		 	}
			return plasObj;
			
	}		
//method to build the query
			
	private String buildQuery(String wClause)
	 {
		String query = "SELECT diseaseId, diseaseType, clinicName, nextTestDate, treatmentType, diagnosisDate, treatmentStartDate, testDate, FROM mfPlasmaDisease";	
		if (wClause.length()>0)
		query=query+" WHERE "+ wClause;
		return query;
	  }
					
			
	//method to build a plasma disease object.
	private PlasmaDisease buildPlasmaDisease(ResultSet results)
	{
		PlasmaDisease plasmadisObj = new PlasmaDisease();
		try
		{
			//use columns from mfPlasmaDisease table.
			plasmadisObj.setDiseaseId(results.getInt("diseaseId"));
			plasmadisObj.setDiseaseType(results.getString("diseaseType"));
			plasmadisObj.setClinicName(results.getString("clinicName"));
			plasmadisObj.setNextTestDate(results.getString("nextTestDate"));
			plasmadisObj.setTreatmentType(results.getString("treatmentType"));
			plasmadisObj.setDiagnosisDate(results.getString("diagnosisDate"));
			plasmadisObj.setTreatmentStartDate(results.getString("treatmentStartDate"));
			plasmadisObj.setTestDate(results.getString("testDate"));
		}
		catch (Exception e)
		{
			System.out.println("Error building the Disease Plasma object.");
		}
		return plasmadisObj;
	}	

	
    

}// end of class DBPlasmaDisease.
