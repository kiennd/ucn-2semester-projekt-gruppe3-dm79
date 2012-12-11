package DBLayer;
import ModelLayer.*;
import java.sql.*;
import java.util.ArrayList;

public interface IFDBmfMink 
{
	//Creates a new mink
	public int createMink(mfMink mfmink) throws Exception;
	//Update mink
	public int updateMink(mfMink mfmink);
	//Delete mink
	public int deleteMink(int minkID);
}
