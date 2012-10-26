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
 		 if(retrieveAssociation)
 		 {
 			 IFDBInvoice invPro = new DBInvoice();
 			 for(SalesOrder salobj : list)
 			 {
 				 int invoiceNo = salobj.getInvoice().getInvoiceNo();
 				 Invoice invobj = saProject.findSaleOrder(invoiceNo);
 				 
 				 
 			 }
 		 }
 		 
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
		salobj.setSalesOrderID(results.getInt("salesOrderID"));
		salobj.setCreationDate(results.getString("creationDate"));
		salobj.setDeliveryDate(results.getString("deliveryDate"));
		salobj.setDeliveryStatus(results.getString("deliveryStatus"));
		salobj.setStatus(results.getString("status"));
		salobj.setTotalAmount(results.getDouble("totalAmount"));
		cusobj.setCustID(results.getInt("custID"));
		invobj.setInvoiceNo(results.getInt("invoiceNo"));

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
