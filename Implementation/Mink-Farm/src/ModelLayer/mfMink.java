package ModelLayer;
import java.util.ArrayList;

public class mfMink {
	private String color;
	private int furLength;
	private int furDensity;
	private int birthDate;
	private String qualityType;

	
	public mfMink(String color, int furLength, int furDensity, int birthDate, String qualityType)
	{
		this.color = color;
		this.furLength = furLength;
		this.furDensity = furDensity;
		this.qualityType = qualityType;
	}
	public mfMink()
	{
		
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public int getFurLength() {
		return furLength;
	}


	public void setFurLength(int furLength) {
		this.furLength = furLength;
	}


	public int getFurDensity() {
		return furDensity;
	}


	public void setFurDensity(int furDensity) {
		this.furDensity = furDensity;
	}


	public int getBirthDate() {
		return birthDate;
	}


	public void setBirthDate(int birthDate) {
		this.birthDate = birthDate;
	}


	public String getQualityType() {
		return qualityType;
	}


	public void setQualityType(String qualityType) {
		this.qualityType = qualityType;
	}
}
