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
	private PreparedStatement pStmtSelect;
	
	public DBBiteDisease()
	{
		con = DbConnection.getInstance().getDBcon();
	}
	
	
	public BiteDisease searchBiteDiseaseById(int attValue, boolean retriveAssociation)
	{
		//String  wClause = "diseaseId like '%" + attValue + "%'";
		String  wClause = "diseaseId =" + attValue;
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
		
	
	public int updateBiteDisease(BiteDisease bitedis)
	{
		BiteDisease biteObj  = bitedis;
		int rc=-1;

		String query="UPDATE bitedis SET "+
				"diseaseId ='"+ biteObj.getDiseaseId()+"', "+
				"bitelocation ='"+ biteObj.getBitelocation() + "', " +	
				"diagnosisDate ='"+ biteObj.getDiagnosisDate() + "', " +
	            "treatmentStartDate ='"+ biteObj.getTreatmentStartDate() + "', " +
			    "treatmentType ='"+ biteObj.getTreatmentType() + "', " +
				"description ='"+ biteObj.getDescription() + "', " +
				"diseaseName ='"+ biteObj.getDiseaseName() + "', ";
				  
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
         String insert = "insert into mfBiteDisease (diseaseId, bitelocation, diagnosisDate, treatmentStartDate, treatmentType, description, diseaseName )"+
		 		"values (?,?,?,?,?,?,?)";
         System.out.println(insert);
         try{
            pstmt = con.prepareStatement(insert);
            pstmt.setInt(1,bitedis.getDiseaseId());
            pstmt.setString(2, bitedis.getBitelocation());
            pstmt.setString(3,bitedis.getDiagnosisDate());
			pstmt.setString(4,bitedis.getTreatmentStartDate());
			pstmt.setString(5,bitedis.getTreatmentType());
            pstmt.setString(6,bitedis.getDescription());
            pstmt.setString(7,bitedis.getDiseaseName());
		
           
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
	public int deleteBiteDisease(int bitedisId) 
    {
        int rc = -1;
        PreparedStatement pstmt = null;
        String delete = "delete from mfBiteDisease where diseaseId = ?";
        System.out.println(delete);
          try{
             pstmt = con.prepareStatement(delete);
             pstmt.setInt(1,bitedisId);
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
		String query = "SELECT diseaseId, bitelocation, diagnosisDate, treatmentStartDate, treatmentType, description, diseaseName  FROM mfBiteDisease";	
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
			System.out.println("bite disease"+bitedisObj.getDiseaseName());
			bitedisObj.setBitelocation(results.getString("bitelocation"));
			bitedisObj.setDiagnosisDate(results.getString("diagnosisDate"));
			bitedisObj.setTreatmentStartDate(results.getString("treatmentStartDate"));
			bitedisObj.setTreatmentType(results.getString("treatmentType"));
			bitedisObj.setBitelocation(results.getString("description"));
		}
		catch (Exception e)
		{
			System.out.println("Error building the Disease Bite object.");
		}
		return bitedisObj;
	}





}// end of DBBiteDisease class.
