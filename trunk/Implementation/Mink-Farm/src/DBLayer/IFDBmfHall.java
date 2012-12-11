package DBLayer;
import ModelLayer.*;
import java.sql.*;
import java.util.ArrayList;

public interface IFDBmfHall 
{
	//list all halls
	public ArrayList<mfHall> getAllHalls (boolean retriveAssociation);
	//find hall
	public mfHall findHall(int hallNo, boolean retriveAssociation);
	//create new hall.
	public int createHall(mfHall mfhall) throws Exception;
	//delete hall
	public int deleteHall(int hallNo);
	//update hall
	public int updateHall(mfHall mfhall);

}
