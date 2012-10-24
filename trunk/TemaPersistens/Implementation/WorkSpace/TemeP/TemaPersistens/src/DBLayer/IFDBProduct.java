package DBLayer;

import ModelLayer.*;

import java.util.ArrayList;

/**
 * 
 * Interface for DBProduct.
 *
 */

public interface IFDBProduct 
{
	//gets one product having the product id.
    public Product findProduct(int prodid, boolean retriveAssociation);
    //gets all products
    public ArrayList<Product> getAllProducts(boolean retriveAssociation);
    //finds one product having the name.
    public Product searchProductname(String name, boolean retriveAssociation);
    //finds one product having the supplier Id.
    public Product searchProductSupId(int supId, boolean retriveAssociation);
    //inserts a new product
    public int insertProduct(Product prod) throws Exception;
    //updates information about a product
    public int updateProduct(Product prod);
    //deletes a product with this id
    public int deleteProduct(int prod);

}
