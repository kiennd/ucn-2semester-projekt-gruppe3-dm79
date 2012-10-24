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
	private String calibre;
	private Supplier supplier;
	
	
	/**
	 * Constructor for objects of class Product.
	 */
	
	public Product(int productId, String name, double purchasePrice, double salesPrice, double rentPrice, String countryOfOrigin, int minStock, String size, String colour, String type, String description, String fabric, String calibre, Supplier supplier)
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
		supplier = new Supplier();
	}

}//end of class Product.
