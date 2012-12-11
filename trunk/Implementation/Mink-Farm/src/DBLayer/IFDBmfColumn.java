package DBLayer;
import ModelLayer.*;
import java.sql.*;
import java.util.ArrayList;

public interface IFDBmfColumn 
{
	//Get all cages.
	public ArrayList<mfColumn> getAllColumn(boolean retriveAssociation);
	//Finds a cage by cage number.
	public mfCage findColumn(int colNo, boolean retriveAssociation);
	//Creates a new cage.
	public int createColumn(mfColumn mfcolumn) throws Exception;
	//Delete a cage.
	public int deleteColumn(int colNo);
	//Update existing cage.
	public int updateColumn(mfColumn mfcolumn);
}
