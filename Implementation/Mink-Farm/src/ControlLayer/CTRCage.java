package ControlLayer;
import ModelLayer.*;
import DBLayer.*;

import java.util.ArrayList;

public class CTRCage 
{
	public CTRCage()
	{
		
	}
	public ArrayList<Cage> getAllCages()
	{
		IFDBCage dbCage = new DBCage();
		ArrayList<Cage> allCage = new ArrayList<Cage>();
		allCage = dbCage.getAllCages(false);
		return allCage;
	}
	
	public Cage findCage(int cageNo)
	{
		IFDBCage dbCage = new DBCage();
		return dbCage.findCage(cageNo, true);
	}
	
	public void createCage(int cageNo, String cageType)
	{
		Cage cageObj = new Cage();
		cageObj.setCageNo(cageNo);
		cageObj.setCageType(cageType);
		try
		{
			DbConnection.startTransaction();
			DBCage dbCuge = new DBCage();
			dbCuge.createCage(cageObj);
			DbConnection.commitTransaction();
		}
		catch(Exception e)
		{
			DbConnection.rollbackTransaction();
		}
	}
	
	public int updateCage(int cageNo, String cageType)
	{
		IFDBCage ifdbCage = new DBCage();
		Cage cag = new Cage();
		cag.setCageNo(cageNo);
		cag.setCageType(cageType);
		return ifdbCage.updateCage(cag);
	}
	
	
	
	

}
