package pricing.data;

import java.util.ArrayList;
import java.util.List;

import pricing.model.PriceUnitProduct;
import pricing.model.Product;
import pricing.model.CommandLine;
import pricing.model.Discount;
import pricing.model.Unity;

// This is to store data when executing the program. 
public class Market {
	
	public static final String CURRENCY = "£";
	
	public static List<Product> products = new ArrayList<>();
	
	public static List<Unity> unities = new ArrayList<>();
	
	public static List<PriceUnitProduct> priceUnitProducts = new ArrayList<>();
	
	public static List<CommandLine> commands = new ArrayList<>();
	
	public static List<Discount> discounts = new ArrayList<>();

}
