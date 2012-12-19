package ModelLayer;


public class Mink {
	private String color;
	private int furLength;
	private int furDensity;
	private int birthDate;
	private String qualityType;
	private int cageNr;
	

	public Mink(String color, int furLength, int furDensity, int birthDate, String qualityType, int cageNr)
	{
		this.color = color;
		this.furLength = furLength;
		this.furDensity = furDensity;
		this.birthDate = birthDate;
		this.qualityType = qualityType;
		this.cageNr = cageNr;
		
	}
	public Mink()
	{
		
	}
	
	public int getCageNr() {
		return cageNr;
	}
	public void setCageNr(int cageNr) {
		this.cageNr = cageNr;
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
