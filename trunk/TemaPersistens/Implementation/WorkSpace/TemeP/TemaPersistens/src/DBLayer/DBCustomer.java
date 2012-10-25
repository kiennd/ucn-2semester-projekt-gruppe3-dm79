package DBLayer;
import ModelLayer.*;

import java.sql.*;
import java.util.ArrayList;

public class DBCustomer implements IFDBCustomer
{
private Connection con;

public DBCustomer()
{
	//**Opretter en ny instance af DBCustomer
	con = DbConnection1.getInstance().getDBcon();
}

public Customer findCustomerByPno(String pno, boolean retrieveAssociation)
{
	String wClause = "pno = " + pno;
	return singleWhere(wClause, retrieveAssociation);
}

public Customer findCustomerByFname(String fname, boolean retrieveAssociation)
{
	String wClause = "fname like '%" + fname + "%'";
	System.out.println("SearchCustomer" + wClause);
	return singleWhere(wClause, retrieveAssociation);
}

public Customer findCustomerByLname(String lname, boolean retrieveAssociation)
{
	String wClause = "fname like '%" + lname + "%'";
	System.out.println("SearchCustomer" + wClause);
	return singleWhere(wClause, retrieveAssociation);
}

public ArrayList<Customer> getAllCustomer(boolean retrieveAssociation)
{
	return miscWhere("", retrieveAssociation);
}

public int insertCustomer (Customer cus) throws Exception
{
int rc = -1;
String qry = "INSERT INTO Customer(custID, fname, lname, address, pno, email, custType, zipcode, city) VALUES('"+
		cus.getCity() + "', '" +
		cus.getFname() + "', '" +
		cus.getLname() + "', '" +
		cus.getAddress() + "', '" +
		cus.getPno() + "', '" +
		cus.getEmail() + "', '" +
		cus.getCustType() + "', '" +
		cus.getZipCode() + "', '" +
		cus.getCity() + "', '" + "', 1234)";

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

public int updateCustomer(Customer cus)
{
	Customer cusobj = cus;
	int rc= -1;
	
	String qry = "UPDATE Customer SET" + "fname = '" + cusobj.getFname()+"', " +
			"lname ='" + cusobj.getLname() + "', " +
			"address ='" + cusobj.getAddress() + "', " +
			"pno ='" + cusobj.getPno() + "', " +
			"email ='" + cusobj.getEmail() + "', " +
			"custType ='" + cusobj.getCustID() + "', " +
			"zipCode ='" + cusobj.getZipCode() + "', " +
			"city ='" + cusobj.getCity() + "',";
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
				System.out.println("Update exception in Customer db: " + ex);
			}
			return(rc);
			
}

private int deleteCustomer(String pno)
{
	int rc =-1;
			
			String qry = "DELETE FROM Customer WHERE pno = '" + pno + "'";
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
			 	  	System.out.println("Delete exception in Customer db: "+ex);
		   	 }
			return(rc);
}

private Customer buildCustomer(ResultSet results)
{
	Customer cusobj = new Customer();
	try
	{
		cusobj.setCustID(results.getInt("custID"));
		cusobj.setFname(results.getString("fname"));
		cusobj.setLname(results.getString("lname"));
		cusobj.setAddress(results.getString("address"));
		cusobj.setPno(results.getString("pno"));
		cusobj.setEmail(results.getString("email"));
		cusobj.setCustType(results.getString("custType"));
		cusobj.setZipCode(results.getString("zipcode"));
		cusobj.setCity(results.getString("city"));
		
		
	}
	catch(Exception e)
	{
		System.out.println("error in building customer obj");
	}
	return cusobj;
}

private String buildQuery(String wClause)
{
	String query = "SELECT custID, fname, lname, address, pno, email, custType, zipcode, city FROM Customer";
	if (wClause.length()>0)
		query = query + " WHERE " + wClause;
	return query;
}

private ArrayList<Customer> miscWhere(String wClause, boolean retrieveAssociation)
{
	ResultSet results;
	ArrayList<Customer> customers = new ArrayList<Customer>();
	
	String qry = buildQuery(wClause);
	
	try
	{
		 Statement stmt = con.createStatement();
         stmt.setQueryTimeout(5);
         results = stmt.executeQuery(qry);
	
	
	while(results.next())
	{
		Customer cusobj = new Customer();
		cusobj = buildCustomer(results);
		customers.add(cusobj);
	}
	stmt.close();
	return customers;
}
	catch(Exception e)
	{
		System.out.println(e.getMessage());
		return null;
	}
}

private Customer singleWhere(String wClause, boolean retrieveAssociation)
{
	ResultSet results;
	Customer cusobj = new Customer();
	String qry = buildQuery(wClause);
	System.out.println(qry);
	try
	{
		Statement stmt = con.createStatement();
		stmt.setQueryTimeout(5);
		results = stmt.executeQuery(qry);
		if(results.next())
		{
			cusobj = buildCustomer(results);
		}
		stmt.close();
	}
	catch(Exception e)
	{
		System.out.println("Query exception: " + e);
	}
	return cusobj;
}



}







