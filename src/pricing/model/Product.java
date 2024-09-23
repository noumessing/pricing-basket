package pricing.model;

import java.util.Objects;

//This class describe goods
public class Product {
	
	private long idProduct;
	
	private String productName;
	
	

	public Product() {
		super();
		
	}
	
	

	public Product(long idProduct, String productName) {
		super();
		this.idProduct = idProduct;
		this.productName = productName;
	}



	public long getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(long idProduct) {
		this.idProduct = idProduct;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}



	@Override
	public int hashCode() {
		return Objects.hash(idProduct, productName);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return idProduct == other.idProduct && Objects.equals(productName, other.productName);
	}
	
	
	
	
}
