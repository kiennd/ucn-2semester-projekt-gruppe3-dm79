package ModelLayer;
import java.util.ArrayList;

public class Cage {
	private int cageNo;
	private int colNr;
	private String cageType;
	private ArrayList<Mink> myMink;

	public Cage(int cageNo, int colNr, String cageType)
	{
		this.cageNo = cageNo;
		this.colNr = colNr;
		this.cageType = cageType;
		ArrayList<Mink> myMink;
	}
	
	//Cage constructor, used in some classes in DBlayer for constructing objects of cage when reading from fk tables.
	
	public Cage(int cageNo)
	{
		this.cageNo = cageNo;
	}
	
	public int getColNr() {
		return colNr;
	}
	public void setColNr(int colNr) {
		this.colNr = colNr;
	}
	public Cage()
	{
		//TOM
	}

	public int getCageNo() {
		return cageNo;
	}

	public void setCageNo(int cageNo) {
		this.cageNo = cageNo;
	}

	public ArrayList<Mink> getMyMink() {
		return myMink;
	}

	public void setMyMink(ArrayList<Mink> myMink) {
		this.myMink = myMink;
	}

	public String getCageType() {
		return cageType;
	}

	public void setCageType(String cageType) {
		this.cageType = cageType;
	}
	
	
}
