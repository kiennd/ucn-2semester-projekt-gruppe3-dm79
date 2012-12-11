package DBLayer;
import ModelLayer.*;
import java.sql.*;
import java.util.ArrayList;

public interface IFDBmfCage 
{
	//Get all cages.
	public ArrayList<mfCage> getAllCages(boolean retriveAssociation);
	//Creates a new cage.
	public int createCage(mfCage mfcage) throws Exception;
	//Delete a cage.
	public int deleteCage(int cageID);
	//Update excisting cage.
	public int updateCage(mfCage mfcage);

}
