package DBLayer;
import ModelLayer.*;

import java.sql.*;
import java.util.ArrayList;

public class DBSaleOrder implements IFDBSalesOrder
{
private Connection con;

public DBSaleOrder()
{
	con = DbConnection1.getInstance().getDBcon();
}

public SalesOrder findSaleOrder(int salID, boolean retriveAssociation)
{
	String wClause = " salesOrderID = '" + salID + "'";
	return singleWhere(wClause, retriveAssociation);
}

public ArrayList<SalesOrder> getAllSaleOrders(boolean retriveAssociation)
{
	return miscwhere("", retriveAssociation);
}

public int insertSaleOrder(SalesOrder saO) throws Exception
{
	int rc = -1;
	String query= "INSERT INTO SalesOrder(salesorderid, creationdate, deliverydate, deliverystatus, totalamount, customer, invoice) VALUES('"+
	saO.getSalesOrderID() + "','" + 
	saO.getCreationDate() + "','" + 
	saO.getDeliveryDate() + "','" + 
	saO.getDeliveryStatus() + "','" + 
	saO.getTotalAmount() + "','" + "', 2, 5)";
	System.out.println("insert : " + query);
	
	try{ // insert new employee +  dependent
        Statement stmt = con.createStatement();
        stmt.setQueryTimeout(5);
   	  rc = stmt.executeUpdate(query);
        stmt.close();
	}
        catch(SQLException ex){
            System.out.println("SaleOrder ikke oprettet");
            throw new Exception ("SaleOrder is not inserted correct");
         }
         return(rc);
      }


private ArrayList<SalesOrder> miscwhere(String wClause, boolean retrieveAssociation)
{
	ResultSet results;
	ArrayList<SalesOrder> list = new ArrayList<SalesOrder>();
	
	String query = buildQuery(wClause);
	System.out.println("DBSalesOrder" + query);
	try{ // read from salesorder
 		Statement stmt = con.createStatement();
 		stmt.setQueryTimeout(5);
 		results = stmt.executeQuery(query);
 		 System.out.println("DBSalesOrder 2" );  
 		 while(results.next())
 		 {
 			 SalesOrder salobj = new SalesOrder();
 			 salobj = buildSaleOrder(results);
 			 list.add(salobj);
 		 }
 		 stmt.close();
 		 return list;
	}
	catch(Exception e)
	{
		System.out.println(e.getMessage());
		return null;
	}
 		 
}

private SalesOrder singleWhere(String wClause, boolean retrieveAssociation)
{
	ResultSet results;
	SalesOrder salobj = new SalesOrder();
	String query = buildQuery(wClause);
	System.out.println(query);
	
	try
	{
		Statement stmt = con.createStatement();
 		stmt.setQueryTimeout(5);
 		results = stmt.executeQuery(query);
	
	if(results.next())
	{
		salobj = buildSaleOrder(results);
		stmt.close();
		if(retrieveAssociation)
		{
			DBInvoice dbI = new DBInvoice();
			salobj.setInvoice(dbI.findInvoice(salobj.getInvoice().getInvoiceNo(),false));
			DBCustomer dbC = new DBCustomer();
			salobj.setCustomer(dbC.findCustomerByPno(salobj.getCustomer().getPno(), false));
		}
	}
                                  
		else 
		{
	 //no product was found
			salobj = null;
	}
		
}//end try	
	catch(Exception e)
	{
		System.out.println("Query exception: "+e);
	}
return salobj;
}



private SalesOrder buildSaleOrder(ResultSet results)
{
	SalesOrder salobj = new SalesOrder();
	Invoice invobj = new Invoice();
	Customer cusobj = new Customer();
	salobj.setInvoice(invobj);
	salobj.setCustomer(cusobj);
	try
	{
		salobj.setSalesOrderID(results.getInt("salesorderid"));
		salobj.setCreationDate(results.getString("creationdate"));
		salobj.setDeliveryDate(results.getString("deliverydate"));
		salobj.setDeliveryStatus(results.getString("deliverystatus"));
		salobj.setTotalAmount(results.getDouble("totalamount"));
		cusobj.setCustID(results.getInt("customer"));
		invobj.setInvoiceNo(results.getInt("invoice"));

	}
	catch(Exception e)
	{
		System.out.println("Error in buildinng sale order");
	}
	return salobj;
}

private String buildQuery(String wClause)
{
	String query="SELECT salesOrder, creationDate, deliveryDate, deliveryStatus, status, totalAmount";
	if(wClause.length()>0)
		query=query+" WHERE "+ wClause;
	return query;

}




}
