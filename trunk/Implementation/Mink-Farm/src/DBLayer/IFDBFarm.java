package DBLayer;

import ModelLayer.*;
import java.sql.*;
import java.util.ArrayList;

public interface IFDBFarm {
	
	
	//insert a new farm
	public int insertFarm(Farm farm) throws Exception;
	//update information about a farm
	public int updateFarm(Farm farm);

}
