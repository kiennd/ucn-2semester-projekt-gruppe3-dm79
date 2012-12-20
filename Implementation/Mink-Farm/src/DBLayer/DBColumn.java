package DBLayer;
import java.sql.*;
import java.util.ArrayList;
import ModelLayer.*;

public class DBColumn implements IFDBColumn
{
	private Connection con;
	
	public DBColumn()
	{
		con = DbConnection.getInstance().getDBcon();
	}
	
	public ArrayList<Column> getAllColumn(boolean retriveAssociation)
	{
		return miscWhere("", retriveAssociation);
	}
	
	public Column findColumn(int colNo, boolean retriveAssociation)
	{
		String wClause = "colNo" + colNo;
		return singleWhere(wClause, retriveAssociation);
	}
	
	public int createColumn(Column column) throws Exception
	{
		int rc = -1;
		String query = "INSERT INTO mfColumn(colNo, numOfCol) VALUES ('"+
				column.getColNo() + "', '" +
				column.getHallNr() + "')";
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
			System.out.println("Column er ikke oprettet");
			throw new Exception("Column er ikke tilføjet");
		}
		return (rc);
	}
	
	public int deleteColumn(int colNo)
	{
		int rc =-1;
		
		String qry = "DELETE FROM mfColumn WHERE colNo = '" + colNo + "'";
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
		 	  	System.out.println("Delete exception in Column db: "+ex);
	   	 }
		return(rc);
	}
	
	public int updateColumn(Column column)
	{
		Column colkobj = column;
		int rc= -1;
		
		String qry = "UPDATE mfColumn SET" + 
				"colNo = '" + colkobj.getColNo() +"', " +
				"hallNr ='" + colkobj.getHallNr() + "', ";
				
				
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
					System.out.println("Update exception in Column db: " + ex);
				}
				return(rc);
	}
	
	private String buildquery(String wClause)
	{
		String query = "SELECT colNo, hallNr";
		if(wClause.length()>0)
			query=query + "WHERE" + wClause;
		return query;
	}
	
	private ArrayList<Column> miscWhere(String wClause, boolean retrieveAssociation)
	{
		ResultSet results;
		ArrayList<Column> colums = new ArrayList<Column>();
		
		String query = buildquery(wClause);
		
		try
		{
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			results = stmt.executeQuery(query);
		
		while(results.next())
		{
			Column colobj = new Column();
			colobj = buildColums(results);
			colums.add(colobj);
		}
		stmt.close();
		return colums;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return null;
		}
		
		
	}
	
	private Column singleWhere(String wClause, boolean retrieveAssociation)
	{
		ResultSet results;
		Column colobj = new Column();
		String query = buildquery(wClause);
		System.out.println(query);
		
		try
		{
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			results = stmt.executeQuery(query);
			
			if(results.next())
			{
				colobj = buildColums(results);
			}
			stmt.close();
		}
		catch(Exception e)
		{
			System.out.println("Query exception: " + e);
		}
		return colobj;
	}
	
	private Column buildColums(ResultSet results)
	{
		Column colObj = new Column();
		try
		{
			colObj.setColNo(results.getInt("colNo"));
			colObj.setHallNr(results.getInt("hallNr"));
		}
		catch(Exception e)
		{
			System.out.println("Error in building column");
		}
		return colObj;
		
	}
	
	
	
}
