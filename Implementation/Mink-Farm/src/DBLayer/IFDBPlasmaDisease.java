package DBLayer;
import ModelLayer.*;

public interface IFDBPlasmaDisease 
{
	//get one disease having the Id diseaseId.
	public PlasmaDisease searchDiseaseById(int diseaseId, boolean retriveAssociation);
	
}
