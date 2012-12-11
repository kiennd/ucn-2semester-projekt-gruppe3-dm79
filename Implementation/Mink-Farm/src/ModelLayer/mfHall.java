package ModelLayer;
import java.util.ArrayList;

public class mfHall 
{
	private int hallID;
	private int hallNo;
	private ArrayList<mfColumn> myColumn;
	private int numbOfCages;
	
	public mfHall(int hallID, int hallNo, int numbOfCages)
	{
		this.hallID = hallID;
		this.hallNo = hallNo;
		this.numbOfCages = numbOfCages;
		ArrayList<mfColumn> myColumn;
	}

	public int getHallID() {
		return hallID;
	}

	public void setHallID(int hallID) {
		this.hallID = hallID;
	}

	public int getHallNo() {
		return hallNo;
	}

	public void setHallNo(int hallNo) {
		this.hallNo = hallNo;
	}

	public ArrayList<mfColumn> getMyColumn() {
		return myColumn;
	}

	public void setMyColumn(ArrayList<mfColumn> myColumn) {
		this.myColumn = myColumn;
	}

	public int getNumbOfCages() {
		return numbOfCages;
	}

	public void setNumbOfCages(int numbOfCages) {
		this.numbOfCages = numbOfCages;
	}
	
	
	
	
	
}
