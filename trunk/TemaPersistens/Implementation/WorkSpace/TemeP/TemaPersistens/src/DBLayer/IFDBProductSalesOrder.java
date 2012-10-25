package DBLayer;

import ModelLayer.*;

import java.util.ArrayList;

/**
 * 
 * Interface for DBProductSalesOrder.
 *
 */

public interface IFDBProductSalesOrder {
	
    //gets all productsalesorder.
    public ArrayList<DBProductSalesOrder> getAllProductSalesOrder(boolean retriveAssociation);
    
    //finds ProductSalesOrder having the sales Id.
    public Product searchBysalesId(int supId, boolean retriveAssociation);

    //finds ProductSalesOrder having the product Id.
    public Product searchByprodId(int supId, boolean retriveAssociation);

}
