package DBLayer;
import ModelLayer.*;

import java.sql.*;
import java.util.ArrayList;

public interface IFDBSalesOrder 
{
	//Finder en salgsordre
	public SalesOrder findSaleOrder(int salID, boolean retriveAssociation);
	
	public int insertSaleOrder(SalesOrder saO) throws Exception;
	
	public ArrayList<SalesOrder> getAllSaleOrders(boolean retriveAssociation);
	
	
}
