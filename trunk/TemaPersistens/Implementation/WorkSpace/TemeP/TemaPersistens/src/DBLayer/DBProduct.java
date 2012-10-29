package DBLayer;
import ModelLayer.*;

import java.sql.*;
import java.util.ArrayList;


public class DBProduct implements IFDBProduct
{
	//create a connection object 
	private  Connection con;
	
	// Creates a new instance of DBProduct 
	public DBProduct() 
	{
	      con = DbConnection1.getInstance().getDBcon();
	}
	
	
	/**
	 * Implementation of the methods from IFDBProduct interface.
	 */
	
	//method to get a list of all products.
    public ArrayList<Product> getAllProducts(boolean retriveAssociation)
    {
        return miscWhere("", retriveAssociation);
    }
    
    
    
    //method to find a single product using id.
    public Product findProduct(int prodid, boolean retriveAssociation)
    {
    	String wClause = "  productid = '" + prodid + "'";
    	return singleWhere(wClause, retriveAssociation);
    }
    
    
    //method to find one product having the name.
    public Product searchProductname(String prodname, boolean retriveAssociation)
    {
        String wClause = "name like '%" + prodname + "%'";
        System.out.println("SearchProduct " + wClause);
        return singleWhere(wClause, retriveAssociation);
    }
    
    
    //method to find one product having the supplier Id.
    public Product searchProductSupId(int supId, boolean retriveAssociation)
    {
    	String wClause = "  supplier = '" + supId + "'";
    	return singleWhere(wClause, retriveAssociation);
    }
    


    
    //method to insert a new product
	public int insertProduct(Product prod) throws Exception
    {  
       int rc = -1;
	   String query="INSERT INTO Product(name, productid, purchaseprice, salesprice, rentprice, countryoforigin, minimumstock, size, colour, producttype, productdescription, fabric, calibre, supplier)  VALUES('"+
	  		prod.getName()  + "','"  +
			prod.getProductId() + "','"  +
	  		prod.getPurchasePrice() + "','"  +
			prod.getSalesPrice() + "','"  +
	  		prod.getRentPrice() + "','"  +
			prod.getCountryOfOrigin() + "','"  +
	  		prod.getMinStock() + "','"  +
			prod.getSize() + "','"  +
	  		prod.getType() + "','"  +
			prod.getColour() + "','"  +
			prod.getDescription() + "','"  +
			prod.getFabric() + "','"  +
			prod.getCalibre() + "','"  +
			prod.getSupplier() + "','"  + "', 1234)";

       System.out.println("insert : " + query);
      try{ // insert new employee +  dependent
          Statement stmt = con.createStatement();
          stmt.setQueryTimeout(5);
     	  rc = stmt.executeUpdate(query);
          stmt.close();
      }//end try
       catch(SQLException ex){
          System.out.println("Product not created");
          throw new Exception ("Product is not inserted correctly");
       }
       return(rc);
    }
			

    
    
    //method to update product information.
    public int updateProduct(Product prod)
    {
    	return 0;
    }
    
    
    //method to delete a product with this id
    public int deleteProduct(int prod)
    {
    	return 0;
    }
    
    
    
	//SingleWhere is used to select one product. 	
	private Product singleWhere(String wClause, boolean retrieveAssociation)
	{
		ResultSet results;
		Product prodObj = new Product();        
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
				prodObj = buildProduct(results);
                //association is to be build
                stmt.close();
                if(retrieveAssociation)
					{   
					//The supplier is to be selected & built as well.
                      DBSupplier dbsupplier = new DBSupplier();
                      prodObj.setSupplier(dbsupplier.findSupplier(prodObj.getSupplier().getSupplierId(), false));
					}
			}
                                          
	 		else 
	 		{
			 //no product was found
	 			prodObj = null;
			}
	 		
		}//end try	
	 	catch(Exception e)
	 	{
	 		System.out.println("Query exception: "+e);
	 	}
		return prodObj;
	}
    
	
	
	//michWere is used whenever we want to select more than one Product. 
	  private ArrayList<Product> miscWhere(String wClause, boolean retrieveAssociation)
	    {
	        ResultSet results;
	        ArrayList<Product> list = new ArrayList <Product>();

	        String query = buildQuery(wClause);
	        System.out.println(query);
	         try{ 
					// read the Products from the database
	            Statement stmt = con.createStatement();
	            stmt.setQueryTimeout(5);
	            results = stmt.executeQuery(query);

	            while(results.next())
				{
	                Product prodObj = new Product();
	                prodObj = buildProduct(results);
	                list.add(prodObj);
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
		String query ="SELECT name, productid, purchaseprice, salesprice, rentprice, countryoforigin, minimumstock, size, colour, producttype, productdescription, fabric, calibre, supplier FROM Product";
		
		if (wClause.length()>0)
		query=query+" WHERE "+ wClause;
			
		return query;
	}
    
    
    
    
	//method to build product object
	private Product buildProduct(ResultSet results)
    {   Product prodObj = new Product();
        try
		  {
				// the columns from product table are used.
        	prodObj.setName(results.getString("name"));
        	System.out.println("1");
        	prodObj.setProductId(results.getInt("productid"));
        	System.out.println("2");
              prodObj.setPurchasePrice(results.getDouble("purchaseprice"));
              System.out.println("3");
              prodObj.setSalesPrice(results.getDouble("salesprice"));
              System.out.println("4");
              prodObj.setRentPrice(results.getDouble("rentprice"));
              System.out.println("5");
              prodObj.setCountryOfOrigin(results.getString("countryoforigin"));
              System.out.println("6");
              prodObj.setMinStock(results.getInt("minimumstock"));
              System.out.println("7");
              prodObj.setSize(results.getString("size"));
              System.out.println("8");
              prodObj.setColour(results.getString("colour"));
              System.out.println("9");
              prodObj.setType(results.getString("producttype"));
              System.out.println("10");
              prodObj.setDescription(results.getString("productdescription"));
              System.out.println("11");
              prodObj.setFabric(results.getString("fabric"));
              System.out.println("12");
              prodObj.setCalibre(results.getDouble("calibre"));
             System.out.println("13");
             prodObj.setSupplier(new Supplier(results.getInt("supplier")));
        }
       catch(Exception e)
       {
           System.out.println("error in building product object");
       }
       return prodObj;
    }
     

				 
				 
}//end of DBProduct class.
