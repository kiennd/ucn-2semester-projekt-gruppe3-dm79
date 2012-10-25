package ModelLayer;

public class ProductSalesOrder 
{
	private SalesOrder salesOrder;
	private Product product;
	private int quantity;
	
	
	/**
	 * Constructor for objects of class ProductSalesOrder.
	 */
	
	public ProductSalesOrder(SalesOrder salesOrder, Product product, int quantity)
	{
		this.salesOrder = salesOrder;
		this.product = product;
		this.quantity = quantity;
	}

	
	public ProductSalesOrder()
	{
		
	}

	
	// setters and getters.
	
	public SalesOrder getSalesOrder() 
	{
		return salesOrder;
	}


	public void setSalesOrder(SalesOrder salesOrder) 
	{
		this.salesOrder = salesOrder;
	}


	public Product getProduct() 
	{
		return product;
	}


	public void setProduct(Product product) 
	{
		this.product = product;
	}


	public int getQuantity() 
	{
		return quantity;
	}


	public void setQuantity(int quantity) 
	{
		this.quantity = quantity;
	}
	
	
}//end of class ProductSalesOrder.
