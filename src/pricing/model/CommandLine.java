package pricing.model;

// this class is to describe the commande of goods (for example 2 loafs of bread, 3 bags of apple...)
public class CommandLine {
	
	private long idLigneCommande;
	
	private Product product;
	
	private Unity unity;
	
	private long quantity;
	
	private Double price = 0.0;

	public CommandLine() {
		
	}

	public long getIdLigneCommande() {
		return idLigneCommande;
	}

	public void setIdLigneCommande(long idLigneCommande) {
		this.idLigneCommande = idLigneCommande;
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

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	
	
	
	

}
