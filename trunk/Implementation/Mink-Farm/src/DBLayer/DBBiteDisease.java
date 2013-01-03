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
	
	@Override
	public BiteDisease searchBiteDiseaseById(int diseaseId, boolean retriveAssociation)
	{
		String  wClause = "diseaseId = '" + diseaseId + "'";
		System.out.println("SearchBiteDisease " + wClause);
		return singleWhere(wClause, retriveAssociation);
	}
	
	
	@Override
	// find bite disease using the name.
	public BiteDisease searchBiteDiseaseByName(String diseaseName, boolean retriveAssociation) 
	{
		String wClause = "diseaseName like '%" + diseaseName + "%'";
	    System.out.println("Search BiteDisease " + wClause);
	    return singleWhere(wClause, retriveAssociation);
	}
	
		
	@Override
	public int updateBiteDisease(BiteDisease bitedis)
	{
		BiteDisease biteObj  = bitedis;
		int rc=-1;

		String query="UPDATE mfBiteDisease SET "+
				"diseaseName ='"+ biteObj.getDiseaseName() + "' " +
				"WHERE diseaseId ='"+ biteObj.getDiseaseId()+"'";
				  
	    System.out.println("Update query:" + query);
		try
		{
			//update mfBiteDisease.
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
		 	rc = stmt.executeUpdate(query);
		 	stmt.close();
		}//end try
		catch(Exception ex)
		{
			System.out.println("Update exception in BiteDisease DB: "+ex);
		}
		
		return(rc);
	}
	
	
	@Override
	public int insertBiteDisease(BiteDisease bitedis)
    { 
        int rc = -1; 
        PreparedStatement pstmt = null;
        String insert = "INSERT INTO mfBiteDisease (diseaseId, diseaseName)" + "values (?,?)";
        System.out.println(insert);
        try
        {
        	pstmt = con.prepareStatement(insert);
            pstmt.setInt   ( 1, bitedis.getDiseaseId() );
            pstmt.setString( 2, bitedis.getDiseaseName() );
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
	public int deleteBiteDiseaseWithId(int diseaseId) 
    {
        int rc = -1;
        PreparedStatement pstmt = null;
        String delete = "DELETE FROM mfBiteDisease WHERE diseaseId = ?";
        System.out.println(delete);
        try
        {
        	pstmt = con.prepareStatement(delete);
            pstmt.setInt(1,diseaseId);
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
     
	
	//Singelwhere is used when we only select one BiteDisease.
	private BiteDisease singleWhere(String wClause, boolean retrieveAssociation)
	{
		ResultSet results;
		
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
	 			BiteDisease bitedisObj = buildBiteDisease(results);
	 			stmt.close();
	 			return bitedisObj;
	 		}
	 		else
	 		{ 
	 			//no Bite disease was found.
	 			return null;
	 		}
			
		}
		//end try.
		catch(Exception e){
			System.out.println("Query exception: "+e);
		}
		
		return null;	
	}
	
	
	//method to build the query
	private String buildQuery(String wClause)
	{
		String query = "SELECT diseaseId, diseaseName FROM mfBiteDisease";	
		if (wClause.length() > 0)
			query = query + " WHERE "+ wClause;
		return query;
	}
	
	
	//method to build a bite disease object.
	private BiteDisease buildBiteDisease(ResultSet results)
	{
		try
		{
			//use columns from mfBiteDisease table.
			BiteDisease bitedisObj = new BiteDisease(results.getInt("diseaseId"),results.getString("diseaseName"));
			return bitedisObj;
			
			// Alternativ way to do this.
			//return new BiteDisease(results.getInt("diseaseId"),results.getString("diseaseName"));
		}
		catch (Exception e)
		{
			System.out.println("Error building the Disease Bite object.");
		}
		
		return null;
	}

}// end of DBBiteDisease class.
