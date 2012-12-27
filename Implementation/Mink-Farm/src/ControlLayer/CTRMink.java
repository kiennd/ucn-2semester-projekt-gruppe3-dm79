package ControlLayer;
import ModelLayer.*;
import DBLayer.*;

public class CTRMink 
{
	public  CTRMink()
	{
		
	}
	
	public void createMink(String color, int furLength, int furDensity, String birthDate, String qualityType, int cageNr)
	{
		Mink minkobj = new Mink();
		minkobj.setColor(color);
		minkobj.setFurLength(furLength);
		minkobj.setFurDensity(furDensity);
		minkobj.setBirthDate(birthDate);
		minkobj.setQualityType(qualityType);
		minkobj.setCageNr(cageNr);
		try
		{
		 DbConnection.startTransaction();
		 DBMink dbMink = new DBMink();
		 dbMink.createMink(minkobj);
		 DbConnection.commitTransaction();
		}
		catch(Exception e)
		{
			DbConnection.rollbackTransaction();
		}

	}

	public int updateMink(String color, int furLength, int furDensity, String birthDate, String qualityType, int cageNr)
	{
		IFDBMink ifmink = new DBMink();
		Mink minkobj = new Mink();
		minkobj.setColor(color);
		minkobj.setFurLength(furLength);
		minkobj.setFurDensity(furDensity);
		minkobj.setBirthDate(birthDate);
		minkobj.setQualityType(qualityType);
		minkobj.setCageNr(cageNr);
		return ifmink.updateMink(minkobj);

	}
}
