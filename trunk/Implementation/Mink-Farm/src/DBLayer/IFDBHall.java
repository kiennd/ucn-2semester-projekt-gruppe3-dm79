package DBLayer;
import ModelLayer.*;
import java.sql.*;
import java.util.ArrayList;

public interface IFDBHall 
{
	//list all halls
	public ArrayList<Hall> getAllHalls (boolean retriveAssociation);
	//find hall
	public Hall findHall(int hallNo, boolean retriveAssociation);
	//create new hall.
	public int createHall(Hall hall) throws Exception;
	//delete hall
	public int deleteHall(int hallNo);
	//update hall
	public int updateHall(Hall hall);

}
