package DBLayer;

import ModelLayer.*;
import java.sql.*;
import java.util.ArrayList;


public class DBmfEmployee implements IFDBmfEmployee {
	
	private Connection con;
	
	public DBmfEmployee()
	{
		//**Opretter en ny instance af DBmfEmployee
		con = DbConnection.getInstance().getDBcon();
	}
	
	public mfEmployee findEmployeeByFname(String fname, boolean retrieveAssociation) {
		String wClause = "fname like '%" + fname + "%'";
		System.out.println("SearchEmployee" + wClause);
		return singleWhere(wClause, retrieveAssociation);
	}

	public mfEmployee findEmployeeByLname(String lname, boolean retrieveAssociation)
	{
		String wClause = "lname like '%" + lname + "%'";
		System.out.println("SearchCustomer" + wClause);
		return singleWhere(wClause, retrieveAssociation);
	}
	
	public mfEmployee findEmployeeByID(int employeeID, boolean retrieveAssociation)
	{
		String wClause = "employeeID = " + employeeID;
		return singleWhere(wClause, retrieveAssociation);
	}
	
	public int insertEmployee (mfEmployee emp) throws Exception
	{
	int rc = -1;
	String qry = "INSERT INTO Employee(fname, lname, custID, address, zipcode, city, phoneno, email, type) VALUES('"+
			emp.getEmployeeID() + "', '" +
			emp.getFname() + "', '" +
			emp.getLname() + "', '" +
			emp.getAddress() + "', '" +
			emp.getZipCode() + "', '" +
			emp.getCity() + "', '" +
			emp.getPhoneNo() + "', '" +
			emp.getEmail() + "')";

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
			System.out.println("Customer er ikke oprettet");
			throw new Exception("Customer er ikke tilføjet");
		}
		return (rc);
			
	}
	
	public int updateEmployee(mfEmployee emp)
	{
		mfEmployee empObj = emp;
		int rc= -1;
		
		String qry = "UPDATE Customer SET" + 
				"employeeID ='" + empObj.getEmployeeID() + "', " +
				"fname = '" + empObj.getFname()+"', " +
				"lname ='" + empObj.getLname() + "', " +
				"address ='" + empObj.getAddress() + "', " +
				"zipCode ='" + empObj.getZipCode() + "', " +
				"city ='" + empObj.getCity() + "', " +
				"phoneNo ='" + empObj.getPhoneNo() + "', " +
				"email ='" + empObj.getEmail() + "', ";
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
					System.out.println("Update exception in Employee db: " + ex);
				}
				return(rc);
				
	}

	private int deleteEmployee(int employeeID)
	{
		int rc =-1;
				
				String qry = "DELETE FROM Employee WHERE employeeID = '" + employeeID + "'";
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
				 	  	System.out.println("Delete exception in Employee db: "+ex);
			   	 }
				return(rc);
	}
	
	private mfEmployee buildEmployee(ResultSet results)
	{
		mfEmployee empObj = new mfEmployee();
		try
		{
			empObj.setEmployeeID(results.getInt("employeeID"));
			empObj.setFname(results.getString("fname"));
			empObj.setLname(results.getString("lname"));
			empObj.setAddress(results.getString("address"));
			empObj.setZipCode(results.getInt("zipcode"));
			empObj.setCity(results.getString("city"));
			empObj.setPhoneNo(results.getInt("phoneNo"));
			empObj.setEmail(results.getString("email"));
			
			
		}
		catch(Exception e)
		{
			System.out.println("error in building employee obj");
		}
		return empObj;
	}
	
	private String buildQuery(String wClause)
	{
		String query = "SELECT employeeID, fname, lname, address, zipcode, city, phoneNo, email FROM mfEmployee";
		if (wClause.length()>0)
			query = query + " WHERE " + wClause;
		return query;
	}
	
	private ArrayList<mfEmployee> miscWhere(String wClause, boolean retrieveAssociation)
	{
		ResultSet results;
		ArrayList<mfEmployee> employees = new ArrayList<mfEmployee>();
		
		String qry = buildQuery(wClause);
		
		try
		{
			 Statement stmt = con.createStatement();
	         stmt.setQueryTimeout(5);
	         results = stmt.executeQuery(qry);
		
		
		while(results.next())
		{
			mfEmployee empObj = new mfEmployee();
			empObj = buildEmployee(results);
			employees.add(empObj);
		}
		stmt.close();
		return employees;
	}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	private mfEmployee singleWhere(String wClause, boolean retrieveAssociation)
	{
		ResultSet results;
		mfEmployee empObj = new mfEmployee();
		String qry = buildQuery(wClause);
		System.out.println(qry);
		try
		{
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			results = stmt.executeQuery(qry);
			if(results.next())
			{
				empObj = buildEmployee(results);
			}
			stmt.close();
		}
		catch(Exception e)
		{
			System.out.println("Query exception: " + e);
		}
		return empObj;
	}

}
