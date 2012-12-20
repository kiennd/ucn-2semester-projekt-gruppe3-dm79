package DBLayer;
import ModelLayer.*;

public interface IFDBPlasmaDisease 
{
	//Finds the disease having the given Id.
	public PlasmaDisease searchDiseaseById(int diseaseId, boolean retriveAssociation);
	
	//Finds the disease using the Name.
	public PlasmaDisease searchPlasmaDiseaseByName(String diseaseName, boolean retriveAssociation);
	
	
	//update PlasmaDisease information.
	public int updatePlasmaDisease(PlasmaDisease plasmadis);
	
	//inserts Plasma Disease.
    public int insertPlasmaDisease(PlasmaDisease plasmadis);
    
    //deletes Plasma Disease using transferId.
    public int deletePlasmaDisease(int plasmaId);
	
}
