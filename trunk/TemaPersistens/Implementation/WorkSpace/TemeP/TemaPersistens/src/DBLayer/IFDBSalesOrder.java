package DBLayer;
import ModelLayer.*;
import java.sql.*;
import java.util.ArrayList;

public interface IFDBSalesOrder 
{
	public ArrayList<SalesOrder> findSaleOrder(String salesOrderID);
	
}
