package ControlLayer;

import ModelLayer.*;
import DBLayer.*;

import java.util.ArrayList;

public class CtrProduct 
{
    /** Creates a new instance of CtrEmp */
    public CtrProduct() 
    {
        
    }
    
    
    //gets all Product.
    public ArrayList<Product> getAllProducts()
    {
      IFDBProduct dbProd = new DBProduct();
      ArrayList<Product> allProd = new ArrayList<Product>();
      allProd = dbProd.getAllProducts(false);
      return allProd;
    }
    
    //find a product by id.
    public Product findProduct(int prodid)
    {
    	IFDBProduct dbProd = new DBProduct();
        return dbProd.findProduct(prodid, true);
    }
    
    //find a product by name.
    public Product searchProductname(String prodname)
    {
        IFDBProduct dbProd = new DBProduct();
        return dbProd.searchProductname(prodname, true);
    }
    
    
    //find a product using the supplier's id.
    public Product searchProductSupId(int supId)
    {
    	 IFDBProduct dbProd = new DBProduct();
    	 return dbProd.searchProductSupId(supId, true);
    }
        
} //end of class CtrProduct. 
