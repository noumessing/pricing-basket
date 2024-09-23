package pricing.service.interfaces;

import pricing.model.CommandLine;
import pricing.model.Discount;
import pricing.model.PriceUnitProduct;
import pricing.model.Product;
import pricing.model.Unity;

public interface CommandLineService {
	
	void addProduct(Product prod);
	
	void addUnity(Unity unity);
	
	void addCommandLine(CommandLine commandLine);
	
	void addPriceUnitProduct(PriceUnitProduct priceUnitProduct);
	
	void addDiscount (Discount discount);
	
	

	//This method computes the percentage of a product
	double getPercentageDiscount(Product prod, Unity inity);
	
	////This method computes the amount of discount of a product in a basket
	double getAmountDiscount(CommandLine commandLine);
	
	//double getCustomAmountDiscount(CommandLine commandLine);
	
	//This method indicate the quantity of good in a basket
	long getQuantityCommanded(Product product);
	
	//This method indicate the price of good in a basket
	double getCommandLinePrice(CommandLine commandLine);
	
	double getCommandLinePriceWithDiscount(CommandLine commandLine);

}
