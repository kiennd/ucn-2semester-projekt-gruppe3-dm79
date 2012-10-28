package DBLayer;
import ModelLayer.*;

import java.sql.*;
import java.util.ArrayList;


public class DBProductSalesOrder implements IFDBProductSalesOrder 
{
	//create a connection object 
	private  Connection con;
	
	// Creates a new instance of DBProduct 
	public DBProductSalesOrder() 
	{
	      con = DbConnection1.getInstance().getDBcon();
	}
	
	
	/**
	 * Implementation of the methods from IFDBProductSalesOrder interface.
	 */    
	
	//method to list all productsalesorder.
    public ArrayList<ProductSalesOrder> getAllProductSalesOrder(boolean retriveAssociation)
    {   
    	return miscWhere("", retriveAssociation);   
    }
    
    //method to find salesorders having the sales Id.
    public ProductSalesOrder searchBysalesId(int salesId, boolean retriveAssociation)
    {
    	String wClause = "  salesOrder = '" + salesId + "'";
    	return singleWhere(wClause, retriveAssociation);
    }

    //method to find Products with product Id.
    public ProductSalesOrder searchByprodId(int prodId, boolean retriveAssociation)
    {
    	String wClause = "  product = '" + prodId + "'";
    	return singleWhere(wClause, retriveAssociation);
    }

    
    
    
	//SingleWhere is used to select one product. 	
	private ProductSalesOrder singleWhere(String wClause, boolean retrieveAssociation)
	{
		ResultSet results;
		ProductSalesOrder prodsalesorderObj = new ProductSalesOrder();        
	    String query =  buildQuery(wClause);
        System.out.println(query);
		
		try
		{ 
		//read the product from the database
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 		results = stmt.executeQuery(query);

	 		if( results.next() ){
	 			prodsalesorderObj = buildProductSalesOrder(results);
                //association is to be build
                stmt.close();
                if(retrieveAssociation)
					{   
					//The productId is to be selected & built as well.
                      DBProduct dbprod = new DBProduct();
                      prodsalesorderObj.setProduct(dbprod.findProduct(prodsalesorderObj.getProduct().getProductId(), false));
                      
  					//The salesOrderId is to be selected & built as well.
                      DBSaleOrder dbsalesOrder = new DBSaleOrder();
                      prodsalesorderObj.setSalesOrder(dbsalesOrder.findSaleOrder(prodsalesorderObj.getSalesOrder().getSalesOrderID(), false));
					}
	 		}
	 		else{
			 //no product was found
	 			prodsalesorderObj = null;
	 			}
		}//end try	

	 	catch(Exception e)
	 	{
	 		System.out.println("Query exception: "+e);
	 	}
		return prodsalesorderObj;
	}
    
	
	 		
	 		

		
//method to build ProductSalesOrder object
 		private ProductSalesOrder buildProductSalesOrder(ResultSet results)
 	    {   
 			ProductSalesOrder prodsalesorderObj = new ProductSalesOrder();
			Product prodobj = new Product();
			SalesOrder salesorderObj = new SalesOrder();
 	        try
 			  {

 //The columns from ProductSalesOrder table are used. 
 //The variable names & order in the get methods must correspond with those in the database.
 	        	salesorderObj.setSalesOrderID(results.getInt("salesid"));
 	        	System.out.println("getting salesId");
 	        	prodobj.setProductId(results.getInt("productid"));
 	        	System.out.println("getting productId");
 	        	prodsalesorderObj.setQuantity(results.getInt("quantity"));
 	            System.out.println("getting quantity");
 			  }
			
			catch(Exception e){
								System.out.println("Error in buildinng sale order");
								}
 	        return prodsalesorderObj;
 	     }

	 
	 		
	 		
	 		
//michWere is used whenever we want to select more than one ProductSalesOrder. 
	 		 private ArrayList<ProductSalesOrder> miscWhere(String wClause, boolean retrieveAssociation)
	 		    {
	 		        ResultSet results;
	 		        ArrayList<ProductSalesOrder> list = new ArrayList <ProductSalesOrder>();

	 		        String query = buildQuery(wClause);

	 		         try{ 
	 						// read the Products from the database
	 		            Statement stmt = con.createStatement();
	 		            stmt.setQueryTimeout(5);
	 		            results = stmt.executeQuery(query);

	 		            while(results.next())
	 					{
	 		            	ProductSalesOrder prodSalesOrderObj = new ProductSalesOrder();
	 		            	prodSalesOrderObj = buildProductSalesOrder(results);
	 		                list.add(prodSalesOrderObj);
	 		            }
	 		            stmt.close();
	 		            return list;
	 		         }

	 		         catch(Exception e)
	 		         {
	 		            System.out.println (e.getMessage());
	 		            return null;
	 		         }
	 		    }
	 		
	 		
	
	
    //method to build the query.
    private String buildQuery(String wClause)
	{
		String query ="SELECT prodid, salesid, quantity FROM ProductSalesOrder";
		
		if (wClause.length()>0)
		query=query+" WHERE "+ wClause;
			
		return query;
	}
    
    

	

	
	
}//end of class DBProductSalesOrder.
