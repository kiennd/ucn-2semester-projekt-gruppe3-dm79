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
    public ArrayList<ProductSalesOrder> getAllProductSalesOrder(boolean retriveAssociation);
    
    //finds ProductSalesOrder having the sales Id.
    public ProductSalesOrder searchBysalesId(int supId, boolean retriveAssociation);

    //finds ProductSalesOrder having the product Id.
    public ProductSalesOrder searchByprodId(int supId, boolean retriveAssociation);

}
