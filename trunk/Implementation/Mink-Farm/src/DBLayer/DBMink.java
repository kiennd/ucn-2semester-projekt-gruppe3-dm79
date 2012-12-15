package DBLayer;
import java.sql.*;
import java.util.ArrayList;
import ModelLayer.*;

	public class DBMink implements IFDBMink
	{
	private Connection con;
	
	public int createMink(Mink mink) throws Exception
	{
		int rc = -1;
		String query = "INSERT INTO mfMink(color, furLength, furDensity, qualityType) VALUES ('"+
				mink.getColor() + "', '" +
				mink.getFurLength() + "', '" +
				mink.getFurDensity() + "', '" +
				mink.getBirthDate() + "')";
		System.out.println("insert : " + query);
		
		try
		{
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			rc = stmt.executeUpdate(query);
			stmt.close();
		}
		catch(SQLException ex)
		{
			System.out.println("Mink er ikke oprettet");
			throw new Exception("Mink er ikke tilføjet");
		}
		return (rc);
	}

	public int updateMink(Mink mink)
	{
		Mink minkobj = mink;
		int rc= -1;
		
		String qry = "UPDATE mfMink SET" + 
				"color = '" + minkobj.getColor()+"', " +
				"furLength ='" + minkobj.getFurLength() + "', " +
				"furDensity ='" + minkobj.getFurDensity() + "', " +
				"birthdate ='" + minkobj.getBirthDate() + "', " +
				"qualityType ='" + minkobj.getQualityType() + "', " +
				"cageNr ='" + minkobj.getCageNr() + "',";
				
				System.out.println("Update query: " + qry);
				try
				{
					Statement stmt = con.createStatement();
			 		stmt.setQueryTimeout(5);
			 	 	rc = stmt.executeUpdate(qry);

			 	 	stmt.close();
				}
				catch(Exception ex)
				{
					System.out.println("Update exception in Mink db: " + ex);
				}
				return(rc);
	}
	
	public int deleteMink(int cageNr)
	{
		int rc =-1;
		
		String qry = "DELETE FROM mfMink WHERE phoneno = '" + cageNr + "'";
		System.out.println(qry);
		try
		{
			Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 	  	rc = stmt.executeUpdate(qry);
	 	  	stmt.close();
		}
		 catch(Exception ex)
		 {
		 	  	System.out.println("Delete exception in Mink db: "+ex);
	   	 }
		return(rc);
	}
	
	public String buildQuery(String wClause)
	{
		String qry = "SELECT color, furLength, furDensity, birthDate, qualityType";
		if(wClause.length()>0)
			qry=qry + "WHERE" + wClause;
		return qry;
	}
	
	public Mink singleWhere(String wClause, boolean retrieveAssociation)
	{
		ResultSet results;
		Mink minkobj = new Mink();
		String query = buildQuery(wClause);
		System.out.println(query);
		
		try
		{
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			results = stmt.executeQuery(query);
			
			if(results.next())
			{
				minkobj = buildMink(results);
			}
			stmt.close();
		}
		catch(Exception e)
		{
			System.out.println("Query exception: " + e);
		}
		return minkobj;
	}

	private Mink buildMink(ResultSet results)
	{
		Mink minkObj = new Mink();
		try
		{
			minkObj.setColor(results.getString("color"));
			minkObj.setFurLength(results.getInt("furLength"));
			minkObj.setFurDensity(results.getInt("furDensity"));
			minkObj.setBirthDate(results.getInt("birthDate"));
			minkObj.setQualityType(results.getString("qualityType"));
		}
		catch(Exception e)
		{
			System.out.println("Error in building cage");
		}
		return minkObj;
		
	}
}