package ControlLayer;
import ModelLayer.*;
import DBLayer.*;

import java.util.ArrayList;


public class CtrProductSalesOrder {
	
    /** Creates a new instance of CtrProductSalesOrder */
    public CtrProductSalesOrder() 
    {
        
    }
    
    
 // controller for getallproductssalesorder.

    public ArrayList<ProductSalesOrder> getAllProductSalesOrder()
        {
          IFDBProductSalesOrder  dbProdSalesorder = new DBProductSalesOrder();
          ArrayList<ProductSalesOrder> allprodsalesorder = new ArrayList<ProductSalesOrder>();
          allprodsalesorder = dbProdSalesorder.getAllProductSalesOrder(false);
          return allprodsalesorder;
        }
    

// controller to search for productsalesorder with a product id.
    public ProductSalesOrder searchByprodId(int productId)
    {
        IFDBProductSalesOrder  dbProductSalesOrder = new DBProductSalesOrder();
        return dbProductSalesOrder.searchByprodId(productId, true);
    }
    
//  controller to search for productsalesorder with a sales id.
    
    public ProductSalesOrder searchBysalesId(int salesId)
    {
    	IFDBProductSalesOrder  dbProdSalesorder = new DBProductSalesOrder();
    	return	dbProdSalesorder.searchBysalesId(salesId, true); 
    }
    

}
