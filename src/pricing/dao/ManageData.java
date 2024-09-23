package pricing.dao;

import java.util.List;

import pricing.model.CommandLine;
import pricing.model.Discount;
import pricing.model.PriceUnitProduct;
import pricing.model.Product;
import pricing.model.Unity;

//This interface indicate the methods which we need to manage the datas in a database 
public interface ManageData {
	
	void addProduct(Product prod);
	
	void addUnity(Unity unity);
	
	void addCommandLine(CommandLine commandLine);
	
	void addPriceUnitProduct(PriceUnitProduct priceUnitProduct);
	
	void addDiscount (Discount discount);
	
	Product getProduct(String nameProduct);
	
	double getPriceUnit(Product product, Unity unity);
	
	Discount getDiscountProduct(Product product, Unity unity);
	
	Unity getUnity(String nameUnity);
	
	CommandLine getCommandLine(long idCommandLine);
	
	long getQuantityOfProductInCommand(Product product);
	
	List<CommandLine> getAllCommands();
	
	

}
