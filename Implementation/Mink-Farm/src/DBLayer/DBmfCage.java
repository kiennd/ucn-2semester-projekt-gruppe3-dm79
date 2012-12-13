package DBLayer;
import java.sql.*;
import java.util.ArrayList;
import ModelLayer.*;

public class DBmfCage implements IFDBmfCage
{
	private Connection con;
	
	public DBmfCage()
	{
		con = DbConnection.getInstance().getDBcon();
	}
	
	public ArrayList<mfCage> getAllCages(boolean retriveAssociation)
	{
		return miscWhere("", retriveAssociation);
	}
	public mfCage findCage(int cageNo, boolean retrieveAssociation)
	{
		String wClause = "cageNo" + cageNo;
		return singleWhere(wClause, retrieveAssociation);
	}
	//Creates a new cage
	public int createCage(mfCage cag) throws Exception
	{
		int rc = -1;
		String query = "INSERT INTO mfCage(cageNo, CageType) VALUES ('"+
				cag.getCageNo() + "', '" +
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
	
	//Method will build cage object
	private mfCage buildCage(ResultSet results)
	{
		mfCage cageObj = new mfCage();
		try
		{
			cageObj.setCageNo(results.getInt("cageNo"));
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
		String query = "SELECT cageNo, CageType";
		if(wClause.length()>0)
			query=query + "WHERE" + wClause;
		return query;
	}
	
	private mfCage singleWhere(String wClause, boolean retrieveAssociation)
	{
		ResultSet results;
		mfCage cageobj = new mfCage();
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

	private ArrayList<mfCage> miscWhere(String wClause, boolean retrieveAssociation)
	{
		ResultSet results;
		ArrayList<mfCage> cages = new ArrayList<mfCage>();
		
		String query = buildquery(wClause);
		
		try
		{
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			results = stmt.executeQuery(query);
		
		while(results.next())
		{
			mfCage cageobj = new mfCage();
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
