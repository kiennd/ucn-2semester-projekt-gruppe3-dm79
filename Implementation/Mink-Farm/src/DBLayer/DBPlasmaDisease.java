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


	public int updatePlasmaDisease(PlasmaDisease plasmadis)
	{
		PlasmaDisease plasObj  = plasmadis;
		int rc=-1;

		String query="UPDATE plasmadis SET "+
				"diseaseId ='"+ plasObj.getDiseaseId()+"', "+
				"clinicName ='"+ plasObj.getClinicName() + "', " +	
				"nextTestDate ='"+ plasObj.getNextTestDate() + "', " +
	              "treatmentType ='"+ plasObj.getTreatmentType() + "', " +
				  "diagnosisDate ='"+ plasObj.getDiagnosisDate() + "', " +
				  "treatmentstartDate ='"+ plasObj.getTreatmentStartDate() + "', " +
				  "testDate ='"+ plasObj.getTestDate() + "', " +
				  "diseaseName ='"+ plasObj.getDiseaseName()+"', ";
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
         String insert = "insert into mfPlasmaDisease (diseaseId, clinicName, nextTestDate, treatmentType, diagnosisDate, treatmentStartDate,"+ 
		 "testDate, diseaseName)"+
		 		"values (?,?,?,?,?,?,?,?)";
         System.out.println(insert);
         try{
            pstmt = con.prepareStatement(insert);
            pstmt.setInt(1,plasmadis.getDiseaseId());
            pstmt.setString(2, plasmadis.getClinicName());
            pstmt.setString(3,plasmadis.getNextTestDate());
			pstmt.setString(4,plasmadis.getTreatmentType());
            pstmt.setString(5, plasmadis.getDiagnosisDate());
            pstmt.setString(6,plasmadis.getTreatmentStartDate());
			pstmt.setString(7,plasmadis.getTestDate());
            pstmt.setString(8, plasmadis.getDiseaseName());
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
	public int deletePlasmaDisease(int plasmaId) 
    {
        int rc = -1;
        PreparedStatement pstmt = null;
        String delete = "delete from mfPlasmaDisease where diseaseId = ?";
        System.out.println(delete);
          try{
             pstmt = con.prepareStatement(delete);
             pstmt.setInt(1,plasmaId);
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
		String query = "SELECT diseaseId, clinicName, nextTestDate, treatmentType, diagnosisDate, treatmentStartDate, testDate, diseaseName FROM mfPlasmaDisease";	
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
			plasmadisObj.setClinicName(results.getString("clinicName"));
			plasmadisObj.setNextTestDate(results.getString("nextTestDate"));
			plasmadisObj.setTreatmentType(results.getString("treatmentType"));
			plasmadisObj.setDiagnosisDate(results.getString("diagnosisDate"));
			plasmadisObj.setTreatmentStartDate(results.getString("treatmentStartDate"));
			plasmadisObj.setTestDate(results.getString("testDate"));
			plasmadisObj.setDiseaseName(results.getString("diseaseName"));
		}
		catch (Exception e)
		{
			System.out.println("Error building the Disease Plasma object.");
		}
		return plasmadisObj;
	}


	
    

}// end of class DBPlasmaDisease.
