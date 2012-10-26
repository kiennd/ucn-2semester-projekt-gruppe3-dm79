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
    	String wClause = "  supplierid = '" + supId + "'";
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
          System.out.println("Employee ikke oprettet");
          throw new Exception ("Employee is not inserted correct");
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
        	prodObj.setProductId(results.getInt("productid"));
              prodObj.setPurchasePrice(results.getDouble("purchaseprice"));
              prodObj.setSalesPrice(results.getDouble("salesprice"));
              prodObj.setRentPrice(results.getDouble("rentprice"));
              prodObj.setCountryOfOrigin(results.getString("countryoforigin"));
              prodObj.setMinStock(results.getInt("minimumstock"));
              prodObj.setSize(results.getString("size"));
              prodObj.setColour(results.getString("colour"));
              prodObj.setType(results.getString("producttype"));
              prodObj.setDescription(results.getString("productdescription"));
              prodObj.setFabric(results.getString("fabric"));
              prodObj.setCalibre(results.getString("calbre"));
              prodObj.setSupplier(new Supplier(results.getInt("supplierid")));
        }
       catch(Exception e)
       {
           System.out.println("error in building product object");
       }
       return prodObj;
    }
     

				 
				 
}//end of DBProduct class.
