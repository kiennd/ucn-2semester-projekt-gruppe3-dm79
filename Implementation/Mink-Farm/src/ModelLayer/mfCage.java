package ModelLayer;
import java.util.ArrayList;

public class mfCage {
	private int cageNo;
	private ArrayList<mfMink> myMink;
	private String cageType;

	public mfCage(int cageNo, String cageType)
	{
		this.cageNo = cageNo;
		this.cageType = cageType;
		ArrayList<mfMink> myMink;
	}

	public int getCageNo() {
		return cageNo;
	}

	public void setCageNo(int cageNo) {
		this.cageNo = cageNo;
	}

	public ArrayList<mfMink> getMyMink() {
		return myMink;
	}

	public void setMyMink(ArrayList<mfMink> myMink) {
		this.myMink = myMink;
	}

	public String getCageType() {
		return cageType;
	}

	public void setCageType(String cageType) {
		this.cageType = cageType;
	}
	
	
}
