package pricing.model;

//This class is to describe the price of o good depending for the unity 
// (for example the price of one tin of soup, the price of one bottle of milk ...)
public class PriceUnitProduct {
	
	private long idPriceUnitProduct;
	
	private Product product;
	
	private Unity unity;
	
	private Double unitPrice;
	
	

	public PriceUnitProduct() {
	
	}
	
	

	public PriceUnitProduct(long idPriceUnitProduct, Product product, Unity unity, Double unitPrice) {
		super();
		this.idPriceUnitProduct = idPriceUnitProduct;
		this.product = product;
		this.unity = unity;
		this.unitPrice = unitPrice;
	}



	public long getIdPriceUnitProduct() {
		return idPriceUnitProduct;
	}

	public void setIdPriceUnitProduct(long idPriceUnitProduct) {
		this.idPriceUnitProduct = idPriceUnitProduct;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Unity getUnity() {
		return unity;
	}

	public void setUnity(Unity unity) {
		this.unity = unity;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	

}
