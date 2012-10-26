package DBLayer;
import ModelLayer.*;
import java.sql.*;
import java.util.ArrayList;

public class DBInvoice implements IFDBInvoice
{
	private Connection con;
	
	public DBInvoice() 
	{
		con = DbConnection1.getInstance().getDBcon();
	}
	
	public Invoice findInvoice(int invoice, boolean retrieveAssociation)
	{
		String wClause = "invoiceNo = " + invoice;
		return singleWhere(wClause, retrieveAssociation);
	}
	public ArrayList<Invoice> getAllInvoice(boolean retrieveAssociation)
	{
		return miscWhere("", retrieveAssociation);
	}
	
	public int insertInvoice(Invoice inv) throws Exception
	{
		int rc = -1;
				String qry = "INSERT INTO Invoice(invoiceNo, paymentDate, totalAmount) VALUES '"+
		inv.getInvoiceNo() + "', '" +
		inv.getPaymentDate() + "', '" +
		inv.getTotalAmount() + "', '" + "', 1234)";
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
			System.out.println("Invoice er ikke oprettet");
			throw new Exception("Invoice er ikke tilføjet");
		}
		return (rc);
	}
	
	
	
	
	private Invoice buildInvoice(ResultSet results)
	{
		Invoice invobj = new Invoice();
		try
		{
			invobj.setInvoiceNo(results.getInt("invoiceNo"));
			invobj.setPaymentDate(results.getString("paymentDate"));
			invobj.setTotalAmount(results.getDouble("totalAmount"));
		}
		catch(Exception e)
		{
			System.out.println("error in building invoice");
		}
		return invobj;
	}
	
	private String buildQuery(String wClause)
	{
		String query = "SELECT invoiceNo, paymentDate, totalAmount";
				if(wClause.length()<0)
					query = query + " WHERE " + wClause;
		return query;
	}
	
	private ArrayList<Invoice> miscWhere(String wClause, boolean retrieveAssociation)
	{
		ResultSet result;
		ArrayList<Invoice> invoices = new ArrayList<Invoice>();
		String qry = buildQuery(wClause);
		
		try
		{
			 Statement stmt = con.createStatement();
	         stmt.setQueryTimeout(5);
	         result = stmt.executeQuery(qry);
		
		while(result.next())
		{
			Invoice invobj = new Invoice();
			invobj = buildInvoice(result);
			invoices.add(invobj);
		}
		stmt.close();
		return invoices;
	}
	catch(Exception e)
	{
		System.out.println(e.getMessage());
		return null;
	}
	}
	
	private Invoice singleWhere(String wClause, boolean retrieveAssociation)
	{
		ResultSet results;
		Invoice invobj = new Invoice();
		String qry = buildQuery(wClause);
		System.out.println(qry);
		try
		{
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			results = stmt.executeQuery(qry);
			if(results.next())
			{
				invobj = buildInvoice(results);
			}
			stmt.close();
		}
		catch(Exception e)
		{
			System.out.println("Query exception: " + e);
		}
		return invobj;
	}
	
	
	
	
	
	
}
