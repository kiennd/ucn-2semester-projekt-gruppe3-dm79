package DBLayer;

import ModelLayer.*;

import java.util.ArrayList;

/**
 * 
 * Interface for DBSupplier.
 *
 */

public interface IFDBSupplier 
{
 	//get a supplier with the given id.
	public Supplier findSupplier(int suppliernum, boolean retrieveAssociation); 
	

}
