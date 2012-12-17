package DBLayer;
import ModelLayer.*;

/**
 * @author DM79_group 3
 *  @version December 2012.
 */

/**
 * 
 * Interface to DBBiteDisease.
 *
 */
public interface IFDBBiteDisease 
{
	public BiteDisease searchBiteDiseaseById(int diseaseId, boolean retriveAssociation);

}
