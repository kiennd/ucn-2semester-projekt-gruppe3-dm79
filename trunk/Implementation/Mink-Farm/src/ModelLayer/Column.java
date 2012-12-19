package ModelLayer;
import java.util.ArrayList;

public class Column {
	
	private int colNo, hallNr;
	
	private ArrayList<Cage> myCage;
	
	
	public Column(int colNo, int hallNr)
	{
		this.colNo = colNo;
		this.hallNr = hallNr;
		ArrayList<Cage> myCage;
		
	}
	
	public Column()
	{
		
	}
	
	
	public void setMyCage(ArrayList<Cage> myCage) {
		this.myCage = myCage;
	}
	
	public void setColNo(int colNo) {
		this.colNo = colNo;
	}
	
	public int getColNo() {
		return colNo;
	}

	public int getHallNr() {
		return hallNr;
	}

	public void setHallNr(int hallNr) {
		this.hallNr = hallNr;
	}
	

}
