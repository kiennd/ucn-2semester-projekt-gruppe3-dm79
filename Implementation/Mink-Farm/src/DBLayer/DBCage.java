package DBLayer;
import java.sql.*;
import java.util.ArrayList;
import ModelLayer.*;

public class DBCage implements IFDBCage
{
	private Connection con;
	
	public DBCage()
	{
		con = DbConnection.getInstance().getDBcon();
	}
	
	
	public ArrayList<Cage> getAllCages(boolean retriveAssociation)
	{
		return miscWhere("", retriveAssociation);
	}
	
	public Cage findCage(int cageNo, boolean retrieveAssociation)
	{
		String wClause = " cageNo = ' " + cageNo + "'";
		return singleWhere(wClause, retrieveAssociation);
	}
	
	//Creates a new cage
	public int createCage(Cage cag) throws Exception
	{
		int rc = -1;
		String query = "INSERT INTO mfCage(cageNo, colNr, CageType) VALUES ('"+
				cag.getCageNo() + "', '" +
				cag.getColNr() + "', '" +
				cag.getCageType() + "')";
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
			System.out.println("Cage er ikke oprettet");
			throw new Exception("Cage er ikke tilføjet");
		}
		return (rc);
		
	}
	
	public int deleteCage(int cageNo)
	{
		int rc =-1;
		
		String qry = "DELETE FROM mfCage WHERE cageNo = '" + cageNo + "'";
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
		 	  	System.out.println("Delete exception in Cage db: "+ex);
	   	 }
		return(rc);
	}
	
	public int updateCage(Cage cage)
	{
		Cage cagekobj = cage;
		int rc= -1;
		
		String qry = "UPDATE mfCage SET" + 
				"cageNo = '" + cagekobj.getCageNo()+"', " +
				"colNr ='" + cagekobj.getColNr() + "', " +
				"CageType ='" + cagekobj.getCageType() + "', ";
				
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
	
	
	
	//Method will build cage object
	private Cage buildCage(ResultSet results)
	{
		Cage cageObj = new Cage();
		try
		{
			cageObj.setCageNo(results.getInt("cageNo"));
			cageObj.setColNr(results.getInt("colNr"));
			cageObj.setCageType(results.getString("CageType"));
		}
		catch(Exception e)
		{
			System.out.println("Error in building cage");
		}
		return cageObj;
		
	}
	
	private String buildquery(String wClause)
	{
		String query = "SELECT cageNo, colNr, CageType FROM mfCage";
		if(wClause.length()>0)
			query=query + " WHERE " + wClause;
		return query;
	}
	
	private Cage singleWhere(String wClause, boolean retrieveAssociation)
	{
		ResultSet results;
		Cage cageobj = new Cage();
		String query = buildquery(wClause);
		System.out.println(query);
		
		try
		{
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			results = stmt.executeQuery(query);
			
			if(results.next())
			{
				cageobj = buildCage(results);
			}
			stmt.close();
		}
		catch(Exception e)
		{
			System.out.println("Query exception: " + e);
		}
		return cageobj;
	}

	private ArrayList<Cage> miscWhere(String wClause, boolean retrieveAssociation)
	{
		ResultSet results;
		ArrayList<Cage> cages = new ArrayList<Cage>();
		
		String query = buildquery(wClause);
	
		try
		{
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			results = stmt.executeQuery(query);
		
		while(results.next())
		{
			Cage cageobj = new Cage();
			cageobj = buildCage(results);
			cages.add(cageobj);
		}
		stmt.close();
		return cages;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return null;
		}
		
		
	}
	
	
}
