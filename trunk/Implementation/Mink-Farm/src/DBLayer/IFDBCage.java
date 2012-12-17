package DBLayer;
import ModelLayer.*;
import java.sql.*;
import java.util.ArrayList;

public interface IFDBCage 
{
	//Get all cages.
	public ArrayList<Cage> getAllCages(boolean retriveAssociation);
	//Finds a cage by cage number.
	public Cage findCage(int cageNo, boolean retriveAssociation);
	//Creates a new cage.
	public int createCage(Cage mfcage) throws Exception;
	//Delete a cage.
	public int deleteCage(int cageNo);
	//Update existing cage.
	public int updateCage(Cage cage);

}
