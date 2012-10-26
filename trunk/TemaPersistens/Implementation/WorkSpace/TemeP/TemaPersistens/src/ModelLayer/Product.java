package ModelLayer;

public class Product
{
	private int productId;
	private String name;
	private double purchasePrice;
	private double salesPrice;
	private double rentPrice;
	private String countryOfOrigin;
	private int minStock;
	private String size;
	private String colour;
	private String type;
	private String description;
	private String fabric;
	private double calibre;
	private Supplier supplier;
	
	
	/**
	 * Constructor for objects of class Product.
	 */
	
	public Product(int productId, String name, double purchasePrice, double salesPrice, double rentPrice, String countryOfOrigin, int minStock, String size, String colour, String type, String description, String fabric, double calibre, Supplier supplier)
	{
		this.productId = productId;
		this.name = name;
		this.purchasePrice = purchasePrice;
		this.salesPrice = salesPrice;
		this.rentPrice = rentPrice;
		this.countryOfOrigin = countryOfOrigin;
		this.minStock = minStock;
		this.size = size;
		this.colour = colour;
		this.type = type;
		this.description = description;
		this.fabric = fabric;
		this.calibre = calibre;
		this.supplier = supplier;
	}
	
	
	/**
	 * 
	 * Empty constructor for creating objects of Product class. 
	 */
	
	public Product()
	{
		
	}


	//setters and getters
	
	public int getProductId() 
	{
		return productId;
	}


	public void setProductId(int productId) 
	{
		this.productId = productId;
	}


	public String getName() 
	{
		return name;
	}


	public void setName(String name) 
	{
		this.name = name;
	}


	public double getPurchasePrice() 
	{
		return purchasePrice;
	}


	public void setPurchasePrice(double purchasePrice) 
	{
		this.purchasePrice = purchasePrice;
	}


	public double getSalesPrice() 
	{
		return salesPrice;
	}


	public void setSalesPrice(double salesPrice) 
	{
		this.salesPrice = salesPrice;
	}


	public double getRentPrice() 
	{
		return rentPrice;
	}


	public void setRentPrice(double rentPrice) 
	{
		this.rentPrice = rentPrice;
	}


	public String getCountryOfOrigin() 
	{
		return countryOfOrigin;
	}


	public void setCountryOfOrigin(String countryOfOrigin) 
	{
		this.countryOfOrigin = countryOfOrigin;
	}


	public int getMinStock() 
	{
		return minStock;
	}


	public void setMinStock(int minStock) 
	{
		this.minStock = minStock;
	}


	public String getSize() 
	{
		return size;
	}


	public void setSize(String size) 
	{
		this.size = size;
	}


	public String getColour() 
	{
		return colour;
	}


	public void setColour(String colour) 
	{
		this.colour = colour;
	}


	public String getType() 
	{
		return type;
	}


	public void setType(String type) 
	{
		this.type = type;
	}


	public String getDescription() 
	{
		return description;
	}


	public void setDescription(String description) 
	{
		this.description = description;
	}


	public String getFabric() 
	{
		return fabric;
	}


	public void setFabric(String fabric) 
	{
		this.fabric = fabric;
	}






	public Supplier getSupplier() 
	{
		return supplier;
	}


	public void setSupplier(Supplier supplier) 
	{
		this.supplier = supplier;
	}


	public void setCalibre(double calibre) 
	{
		this.calibre = calibre;
		
	}
	
	public double getCalibre()

	{
		return calibre;
	}
	
	
	
}//end of class Product.
