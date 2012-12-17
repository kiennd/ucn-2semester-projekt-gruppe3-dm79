package DBLayer;
import ModelLayer.*;
import java.sql.*;
import java.util.ArrayList;


public class DBFarm implements IFDBFarm {
	
	private Connection con;
	
	public DBFarm() {
	con = DbConnection.getInstance().getDBcon();
	}
	
	public int insertFarm (Farm farm) throws Exception
	{
	int rc = -1;
	String qry = "INSERT INTO mfFarm(cvrNo, name, address, zipCode, city, phoneNo, email) VALUES('"+
			farm.getCvrNo() + "', '" +
			farm.getName() + "', '" +
			farm.getAddress() + "', '" +
			farm.getZipCode() + "', '" +
			farm.getCity() + "', '" +
			farm.getPhoneNo() + "', '" +
			farm.getEmail() + "')";

		System.out.println("insert : " + qry);
		try
		{
			Statement stmt = con.createStatement();
	        stmt.setQueryTimeout(5);
	   	    rc = stmt.executeUpdate(qry);
	        stmt.close();
		}
		catch(SQLException ex)
		{
			System.out.println("Farm er ikke oprettet");
			throw new Exception("Farm er ikke tilføjet");
		}
		return (rc);
			
	}
	
	public int updateFarm(Farm farm)
	{
		Farm farmObj = farm;
		int rc= -1;
		
		String qry = "UPDATE Customer SET" + 
				"cvrNo = '" + farmObj.getCvrNo()+"', " +
				"name ='" + farmObj.getName() + "', " +
				"address ='" + farmObj.getAddress() + "', " +
				"zipCode ='" + farmObj.getZipCode() + "', " +
				"city ='" + farmObj.getCity() + "', " +
				"phoneNo ='" + farmObj.getPhoneNo() + "', " +
				"email ='" + farmObj.getEmail() + "',";
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
					System.out.println("Update exception in mfFarm db: " + ex);
				}
				return(rc);
				
	}

}
