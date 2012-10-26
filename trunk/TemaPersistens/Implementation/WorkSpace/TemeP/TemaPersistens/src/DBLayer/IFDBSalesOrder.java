package DBLayer;
import ModelLayer.*;

import java.sql.*;
import java.util.ArrayList;

public interface IFDBSalesOrder 
{
	//Finder en salgsordre
	public ArrayList<SalesOrder> findSaleOrder(String salesOrderID);
	
	public int createSalesOrder(SalesOrder sal) throws Exception;
	
}
