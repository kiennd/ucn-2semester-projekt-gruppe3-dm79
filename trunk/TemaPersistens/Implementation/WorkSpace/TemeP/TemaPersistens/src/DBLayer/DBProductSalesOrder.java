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
    public ArrayList<DBProductSalesOrder> getAllProductSalesOrder(boolean retriveAssociation)
    {   
    	return miscWhere("", retriveAssociation);   
    }
    
    //method to find salesorders having the sales Id.
    public SalesOrder searchBysalesId(int salesId, boolean retriveAssociation)
    {
    	String wClause = "  salesOrder = '" + salesId + "'";
    	return singleWhere(wClause, retriveAssociation);
    }

    //method to find Products with product Id.
    public Product searchByprodId(int prodId, boolean retriveAssociation)
    {
    	String wClause = "  product = '" + prodId + "'";
    	return singleWhere(wClause, retriveAssociation);
    }

    
	//SingleWhere is used to select one product. 	
	private Product singleWhere(String wClause, boolean retrieveAssociation)
	{
		ResultSet results;
		ProductSalesOrder prodObj = new ProductSalesOrder();        
	    String query =  buildQuery(wClause);
        System.out.println(query);
		
		try
		{ 
		//read the product from the database
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 		results = stmt.executeQuery(query);

	 		if( results.next() )
			{
				prodObj = ProductSalesOrder(results);
                //association is to be build
                stmt.close();
                if(retrieveAssociation)
					{   
					//The productId is to be selected & built as well.
                      DBProduct dbprod = new DBProduct();
                      dbprod.  // TODO !!!
                      
  					//The salesOrderId is to be selected & built as well.
                      DBSalesOrder dbsalesOrder = new DBSalesOrder();
                      dbsalesOrder.  //  !!!TODO
                      
					}
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
    
    
	//method to build productsalesorder object.
	private ProductSalesOrder buildProductSalesOrder(ResultSet results)
    {
		ProductSalesOrder prodSalesOrderObj = new ProductSalesOrder();
        try
		  {
				// the columns from product table are used.
        	prodSalesOrderObj.setSalesOrder(new SalesOrder(results.getInt("salesid")));
        	prodSalesOrderObj.setProduct(new Product(results.getInt("prodid")));
        	prodSalesOrderObj.setQuantity(results.getInt("quantity"));
		  }
            
       catch(Exception e)
       {
           System.out.println("error in building Productsalesorder object");
       }
       return prodSalesOrderObj;
    }
     
	
	
	
	
	
}//end of class DBProductSalesOrder.
