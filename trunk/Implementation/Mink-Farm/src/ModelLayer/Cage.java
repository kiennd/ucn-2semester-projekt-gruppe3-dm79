package ModelLayer;
import java.util.ArrayList;

public class Cage {
	private int cageNo;
	private String cageType;
	private ArrayList<Mink> myMink;

	public Cage(int cageNo, String cageType)
	{
		this.cageNo = cageNo;
		this.cageType = cageType;
		ArrayList<Mink> myMink;
	}
	public Cage()
	{
		
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
