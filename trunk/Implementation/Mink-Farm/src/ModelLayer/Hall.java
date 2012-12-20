package ModelLayer;
import java.util.ArrayList;

public class Hall 
{
	private int hallNo, farmCvr;
	private ArrayList<Column> myColumn;
	
	public Hall(int hallNo, int farmCvr)
	{
		this.hallNo = hallNo;
		this.farmCvr = farmCvr;
		
		ArrayList<Column> myColumn;
	}
	public Hall()
	{
		
	}

	public int getFarmCvr() {
		return farmCvr;
	}

	public void setFarmCvr(int farmCvr) {
		this.farmCvr = farmCvr;
	}

	public int getHallNo() {
		return hallNo;
	}

	public void setHallNo(int hallNo) {
		this.hallNo = hallNo;
	}

	public ArrayList<Column> getMyColumn() {
		return myColumn;
	}

	public void setMyColumn(ArrayList<Column> myColumn) {
		this.myColumn = myColumn;
	}

	
}

