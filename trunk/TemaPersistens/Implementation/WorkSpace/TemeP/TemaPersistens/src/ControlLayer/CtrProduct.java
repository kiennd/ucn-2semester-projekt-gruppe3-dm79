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
    
	public int updateProduct(int productId, String name, double purchasePrice, double salesPrice, double rentPrice, String countryOfOrigin, int minStock, String size, String colour, String type, String fabric, double calibre, String supplier, String description)
	{
		IFDBProduct ifdbPro = new DBProduct();
		Product pro = new Product();
		pro.setProductId(productId);
		pro.setName(name);
		pro.setPurchasePrice(purchasePrice);
		pro.setSalesPrice(salesPrice);
		pro.setRentPrice(rentPrice);
		pro.setCountryOfOrigin(countryOfOrigin);
		pro.setMinStock(minStock);
		pro.setSize(size);
		pro.setColour(colour);
		pro.setType(type);
		pro.setFabric(fabric);
		pro.setCalibre(calibre);
		pro.setSupplier(new Supplier());
		pro.setDescription(description);
		return ifdbPro.updateProduct(pro);	
	}
    
    public void insertNewProduct(int productId, String name, double purchasePrice, double salesPrice, double rentPrice, String countryOfOrigin, int minStock, String size, String colour, String type, String fabric, double calibre, String supplier, String description)
	{
		Product proObj = new Product();
		proObj.setProductId(productId);
		proObj.setName(name);
		proObj.setPurchasePrice(purchasePrice);
		proObj.setSalesPrice(salesPrice);
		proObj.setRentPrice(rentPrice);
		proObj.setCountryOfOrigin(countryOfOrigin);
		proObj.setMinStock(minStock);
		proObj.setSize(size);
		proObj.setColour(colour);
		proObj.setType(type);
		proObj.setFabric(fabric);
		proObj.setCalibre(calibre);
		proObj.setSupplier(new Supplier());
		proObj.setDescription(description);
		
	try
	{
		
	DbConnection1.startTransaction();
	DBProduct dbProd = new DBProduct();
	dbProd.insertProduct(proObj);
	DbConnection1.commitTransaction();
	}
	catch(Exception e)
	{
		DbConnection1.rollbackTransaction();
	}
		
	}
        
} //end of class CtrProduct. 
