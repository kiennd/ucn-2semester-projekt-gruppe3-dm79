package DBLayer;

import java.sql.*;
import java.util.ArrayList;
import ModelLayer.*;

import ModelLayer.Cage;

public class DBHall implements IFDBHall
{
	private Connection con;
	public DBHall()
	{
		con = DbConnection.getInstance().getDBcon();
	}
	
	public ArrayList<Hall> getAllHalls (boolean retriveAssociation)
	{
		return miscWhere("", retriveAssociation);
	}
	
	public Hall findHall(int hallNo, boolean retriveAssociation)
	{
		String wClause = "hallNo" + hallNo;
		return singleWhere(wClause, retriveAssociation);
	}
	
	public int createHall(Hall hall) throws Exception
	{
		int rc = -1;
		String query = "INSERT INTO mfHall(hallNo, farmCvr) VALUES ('"+
				hall.getHallNo() + "', '" +
				hall.getFarmCvr() + "')";
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
			System.out.println("Hall er ikke oprettet");
			throw new Exception("Hall er ikke tilføjet");
		}
		return (rc);
		
	}
	
	public int deleteHall(int hallNo)
	{
int rc =-1;
		
		String qry = "DELETE FROM mfCage WHERE hallNo = '" + hallNo + "'";
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
		 	  	System.out.println("Delete exception in Hall db: "+ex);
	   	 }
		return(rc);
	}
	
	public int updateHall(Hall hall)
	{
		Hall hallkobj = hall;
		int rc= -1;
		
		String qry = "UPDATE mfHall SET" + 
				"cageNo = '" + hallkobj.getHallNo()+"', " +
				"CageType ='" + hallkobj.getFarmCvr() + "', ";
				
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
					System.out.println("Update exception in Hall db: " + ex);
				}
				return(rc);
	}
	
	
	
	
	private ArrayList<Hall> miscWhere(String wClause, boolean retrieveAssociation)
	{
		ResultSet results;
		ArrayList<Hall> hall = new ArrayList<Hall>();
		
		String query = buildquery(wClause);
		
		try
		{
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			results = stmt.executeQuery(query);
		
		while(results.next())
		{
			Hall hallobj = new Hall();
			hallobj = buildHall(results);
			hall.add(hallobj);
		}
		stmt.close();
		return hall;
		} 
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return null;
		}
	}
	private Hall buildHall(ResultSet results)
	{
		Hall hallObj = new Hall();
		try
		{
			hallObj.setHallNo(results.getInt("hallNo"));
			hallObj.setFarmCvr(results.getInt("farmCvr"));
		
		}
		catch(Exception e)
		{
			System.out.println("Error in building hall");
		}
		return hallObj;
		
	}
	private String buildquery(String wClause)
	{
		String query = "SELECT hallNo, farmCvr";
		if(wClause.length()>0)
			query=query + "WHERE" + wClause;
		return query;
	}
	private Hall singleWhere(String wClause, boolean retrieveAssociation)
	{
		ResultSet results;
		Hall hallobj = new Hall();
		String query = buildquery(wClause);
		System.out.println(query);
		
		try
		{
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			results = stmt.executeQuery(query);
			
			if(results.next())
			{
				hallobj = buildHall(results);
			}
			stmt.close();
		}
		catch(Exception e)
		{
			System.out.println("Query exception: " + e);
		}
		return hallobj;
	}
	
	
}
