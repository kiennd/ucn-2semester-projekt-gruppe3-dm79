package ControlLayer;

import ModelLayer.*;
import DBLayer.*;

import java.util.ArrayList;

public class CtrSalesOrder {
	
	
    /** Creates a new instance of CtrSalesOrder */
    public CtrSalesOrder() 
    {
        
    }
    
    
    
// controller for getallsaleorders.
    public ArrayList<SalesOrder> getAllSaleOrders()
           {
             IFDBSalesOrder  dbSaleorder = new DBSaleOrder();
             ArrayList<SalesOrder> allsaleorders = new ArrayList<SalesOrder>();
             allsaleorders = dbSaleorder.getAllSaleOrders(false);
             return allsaleorders; 
           }
    
 
	
	
    public Product searchProductSupId(int supId)
    {
    	 IFDBProduct dbProd = new DBProduct();
    	 return dbProd.searchProductSupId(supId, true);
    }
	

}
