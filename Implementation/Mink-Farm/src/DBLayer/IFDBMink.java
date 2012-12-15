package DBLayer;
import ModelLayer.*;
import java.sql.*;
import java.util.ArrayList;

public interface IFDBMink 
{
	//Creates a new mink
	public int createMink(Mink mfmink) throws Exception;
	//Update mink
	public int updateMink(Mink mfmink);
	//Delete mink
	public int deleteMink(int minkID);
}
