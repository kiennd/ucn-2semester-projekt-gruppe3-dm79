package DBLayer;

import ModelLayer.Supplier;
import java.sql.*;
import java.util.ArrayList;

public class DBSupplier  
{
	
	//create a connection object 
	private  Connection con;
	
	// Creates a new instance of DBProduct 
	public DBSupplier() 
	{
	      con = DbConnection1.getInstance().getDBcon();
	}
	

	
 	//get a supplier with the given id.
	public Supplier findSupplier(int suppliernum, boolean retrieveAssociation) 
	{
		String wClause = "supplierId = " + suppliernum;
		return singleWhere(wClause, retrieveAssociation);
	}
	
	
	
	
	//method to build supplier object
	private Supplier buildSupplier(ResultSet results)
    {   Supplier supplierObj = new Supplier();
        try
		  {
				// the columns from supplier table are used.
              supplierObj.setSupplierId(results.getInt("supplierid"));
              supplierObj.setName(results.getString("name"));
              supplierObj.setAddress(results.getString("address"));
              supplierObj.setCountry(results.getString("country"));
              supplierObj.setPhonenum(results.getInt("phonenumber"));
              supplierObj.setEmail(results.getString("email"));

        }
       catch(Exception e)
       {
           System.out.println("error in building supplier object");
       }
       return supplierObj;
    }
     

	
	//method to build the query.
	private String buildQuery(String wClause)
	{
		String query ="SELECT name, supplierid, address, country, phonenumber, email FROM Supplier";
		if (wClause.length()>0)
		query=query+" WHERE "+ wClause;
		return query;
	}

    //SingleWhere is used to select only one Supplier.
   private Supplier singleWhere(String wClause, boolean retrieveAssociation)
   {
        ResultSet results;
        Supplier supplierObj = new Supplier();
        String query = buildQuery(wClause);
        System.out.println(query);
        try{
		 //  read the Supplier from the database
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            results = stmt.executeQuery(query);
            if( results.next())
			 {
                supplierObj = buildSupplier(results);
			 }
                // association is to be built
                stmt.close();
				
			} //end try
			
		catch(Exception e)
		{
			System.out.println("Query exception: " + e);
		}
			
			return supplierObj;
     }
   
   
   
	//MicsWhere is used whenever we want to select more than one Supplier. 
	  private ArrayList<Supplier> miscWhere(String wClause, boolean retrieveAssociation)
	    {
	        ResultSet results;
	        ArrayList<Supplier> list = new ArrayList <Supplier>();

	        String query = buildQuery(wClause);

	         try{ 
					// read the Products from the database
	            Statement stmt = con.createStatement();
	            stmt.setQueryTimeout(5);
	            results = stmt.executeQuery(query);

	            while(results.next())
				{
	            	Supplier suplObj = new Supplier();
	            	suplObj = buildSupplier(results);
	                list.add(suplObj);
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
   

   

}
