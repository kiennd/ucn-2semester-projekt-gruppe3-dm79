
package ModelLayer;

/**
*
* @author DM79_group 3
* @version December 2012.
*/


/*
 * Objects of this class are created whenever Bites or Plasmacytosis disease is found in a cage.  
 */

public class Transfer
{
	private int transferId;
	private String transferDate; 
	private Cage cage;
	private BiteDisease bitedisease;
	private PlasmaDisease plasmadisease;
	private Employee employee;
	
	
//setters and getters.
	public int getTransferId() {
		return transferId;
	}

	public void setTransferId(int transferId) {
		this.transferId = transferId;
	}

	public String getTransferDate() {
		return transferDate;
	}

	public void setTransferDate(String transferDate) {
		this.transferDate = transferDate;
	}

	public Cage getCage() {
		return cage;
	}

	public void setCage(Cage cage) {
		this.cage = cage;
	}

	public BiteDisease getBitedisease() {
		return bitedisease;
	}

	public void setBitedisease(BiteDisease bitedisease) {
		this.bitedisease = bitedisease;
	}

	public PlasmaDisease getPlasmadisease() {
		return plasmadisease;
	}

	public void setPlasmadisease(PlasmaDisease plasmadisease) {
		this.plasmadisease = plasmadisease;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	//this constructor is called when there is plasmacytosis.
	public Transfer(int transferId, Cage cage, BiteDisease bitedisease, Employee employee, String transferDate) 
	{	
		this.transferId = transferId;
		this.cage = cage;
		this.bitedisease = bitedisease;
		this.employee = employee;
		this.transferDate = transferDate;
	}
	
	//constructor is called when there is bite Sår.
	public Transfer(int transferId, Cage cage, PlasmaDisease plasmadisease, Employee employee, String transferDate) 
	{	
		this.transferId = transferId;
		this.cage = cage;
		this.plasmadisease = plasmadisease;
		this.employee = employee;
		this.transferDate = transferDate;
	}
	
	//Empty Parameter Constructor.
	public Transfer()
	{
			
	}
	
	//constructor with only transferId.
	public Transfer(int transferId)
	{
		this.transferId = transferId;
	}




}//end of Transfer class.
