package DBLayer;
import ModelLayer.*;
import java.sql.*;
import java.util.ArrayList;

public interface IFDBmfCage 
{
	//Get all cages.
	public ArrayList<mfCage> getAllCages(boolean retriveAssociation);
	//Finds a cage by cage number.
	public mfCage findCage(int cageNo, boolean retriveAssociation);
	//Creates a new cage.
	public int createCage(mfCage mfcage) throws Exception;
	//Delete a cage.
	public int deleteCage(int cageID);
	//Update existing cage.
	public int updateCage(mfCage mfcage);

}
