package pricing.model;

//This class is to managed discount to apply 
public class Discount {
	
	private long idDiscount;
	
    private Product productToDiscount;
	
	private Unity unityToDiscount;
	
    private Product productGivingDiscount;
	
	private Unity unityOfGivingDiscount;
	
	private long quantityGivendiscount;
	
	private long quantityToDiscount;
	
	private double percentageOfDiscount;

	public Discount() {
		super();
	
	}

	public Discount(long idDiscount, Product productToDiscount, Unity unityToDiscount,
			Product productGivingDiscount, Unity unityOfGivingDiscount, long quantityGivendiscount,
			long quantityToDiscount, double percentageOfDiscount) {
		super();
		this.idDiscount = idDiscount;
		this.productToDiscount = productToDiscount;
		this.unityToDiscount = unityToDiscount;
		this.productGivingDiscount = productGivingDiscount;
		this.unityOfGivingDiscount = unityOfGivingDiscount;
		this.quantityGivendiscount = quantityGivendiscount;
		this.quantityToDiscount = quantityToDiscount;
		this.percentageOfDiscount = percentageOfDiscount;
	}

	public long getIdDiscount() {
		return idDiscount;
	}

	public void setIdDiscount(long idDiscount) {
		this.idDiscount = idDiscount;
	}

	public Product getProductToDiscount() {
		return productToDiscount;
	}

	public void setProductToDiscount(Product productToDiscount) {
		this.productToDiscount = productToDiscount;
	}

	public Unity getUnityToDiscount() {
		return unityToDiscount;
	}

	public void setUnityToDiscount(Unity unityToDiscount) {
		this.unityToDiscount = unityToDiscount;
	}

	public Product getProductGivingDiscount() {
		return productGivingDiscount;
	}

	public void setProductGivingDiscount(Product productGivingDiscount) {
		this.productGivingDiscount = productGivingDiscount;
	}

	public Unity getUnityOfGivingDiscount() {
		return unityOfGivingDiscount;
	}

	public void setUnityOfGivingDiscount(Unity unityOfGivingDiscount) {
		this.unityOfGivingDiscount = unityOfGivingDiscount;
	}

	public long getQuantityGivendiscount() {
		return quantityGivendiscount;
	}

	public void setQuantityGivendiscount(long quantityGivendiscount) {
		this.quantityGivendiscount = quantityGivendiscount;
	}

	public long getQuantityToDiscount() {
		return quantityToDiscount;
	}

	public void setQuantityToDiscount(long quantityToDiscount) {
		this.quantityToDiscount = quantityToDiscount;
	}

	public double getPercentageOfDiscount() {
		return percentageOfDiscount;
	}

	public void setPercentageOfDiscount(double percentageOfDiscount) {
		this.percentageOfDiscount = percentageOfDiscount;
	}
	
	
	
	
	
	

}
