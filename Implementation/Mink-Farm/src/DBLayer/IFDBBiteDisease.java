package DBLayer;
import ModelLayer.*;

/**
 * @author DM79_group 3
 *  @version December 2012.
 */

/**
 * Interface to DBBiteDisease.
 */
public interface IFDBBiteDisease 
{
	//Finds the disease using the Id.
	public BiteDisease searchBiteDiseaseById(int attValue, boolean retriveAssociation);
	
	//Finds the disease using the Name.
	public BiteDisease searchBiteDiseaseByName(String diseaseName, boolean retriveAssociation);

	
	//update bite Disease information.
	public int updateBiteDisease(BiteDisease bitedis);
	
	//inserts bite Disease.
	public int insertBiteDisease(BiteDisease bitedis);
    
    //deletes bite disease using the Id.
    public int deleteBiteDisease(int disId);

	

}
