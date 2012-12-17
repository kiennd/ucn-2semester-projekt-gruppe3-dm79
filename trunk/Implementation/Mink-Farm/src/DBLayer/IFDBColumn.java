package DBLayer;
import ModelLayer.*;
import java.sql.*;
import java.util.ArrayList;

public interface IFDBColumn 
{
	//Get all cages.
	public ArrayList<Column> getAllColumn(boolean retriveAssociation);
	//Finds a cage by cage number.
	public Column findColumn(int colNo, boolean retriveAssociation);
	//Creates a new cage.
	public int createColumn(Column column) throws Exception;
	//Delete a cage.
	public int deleteColumn(int colNo);
	//Update existing cage.
	public int updateColumn(Column column);
}
