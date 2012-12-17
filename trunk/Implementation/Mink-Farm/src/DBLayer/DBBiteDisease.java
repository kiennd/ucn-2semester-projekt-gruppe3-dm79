package DBLayer;
import ModelLayer.*;
import java.sql.*;

/**
 * @author DM79_group 3
 *  @version December 2012.
 */


public class DBBiteDisease implements IFDBBiteDisease
{
	private Connection con;
	
	public DBBiteDisease()
	{
		con = DbConnection.getInstance().getDBcon();
	}
	
	
	public BiteDisease searchBiteDiseaseById(int attValue, boolean retriveAssociation)
	{
		String  wClause = "diseaseId like '%" + attValue + "%'";
		System.out.println("SearchBiteDisease " + wClause);
		return singleWhere(wClause, retriveAssociation);
	}
	
	
	//Singelwhere is used when we only select one BiteDisease.
	
	private BiteDisease singleWhere(String wClause, boolean retrieveAssociation)
	{
		ResultSet results;
		BiteDisease bitedisObj = new BiteDisease();
		
		String query =  buildQuery(wClause);
		System.out.println(query);
		try
		{
			//read the disease from the database.
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 		results = stmt.executeQuery(query);
	 		
	 		if( results.next() )
	 		{
	 			bitedisObj = buildBiteDisease(results);
	 			stmt.close();
	 		}
	 		else{ 
	 			//no Bite disease was found.
	 			bitedisObj = null;
	 		}
			
		}
		//end try.
		catch(Exception e){
			System.out.println("Query exception: "+e);
		}
		return bitedisObj;	
	}
	
	
	//method to build the query
	
	private String buildQuery(String wClause)
	{
		String query = "SELECT diseaseId, diseaseType, bitelocation, diagnosisDate, treatmentStartDate, treatmentType, description FROM mfBiteDisease";	
		if (wClause.length()>0)
			query=query+" WHERE "+ wClause;
		return query;
	}
	
	
	//method to build a bite disease object.
	private BiteDisease buildBiteDisease(ResultSet results)
	{
		BiteDisease bitedisObj = new BiteDisease();
		try
		{
			//use columns from mfBiteDisease table.
			bitedisObj.setDiseaseId(results.getInt("diseaseId"));
			bitedisObj.setDiseaseType(results.getString("diseaseType"));
			bitedisObj.setBitelocation(results.getString("bitelocation"));
			bitedisObj.setDiagnosisDate(results.getString("diagnosisDate"));
			bitedisObj.setTreatmentStartDate(results.getString("treatmentStartDate"));
			bitedisObj.setDiseaseType(results.getString("treatmentType"));
			bitedisObj.setBitelocation(results.getString("description"));
		}
		catch (Exception e)
		{
			System.out.println("Error building the Disease Bite object.");
		}
		return bitedisObj;
	}	

}// end of DBBiteDisease class.
