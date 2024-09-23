package pricing.data;

import pricing.dao.ManageData;
import pricing.dao.ManageDataImpl;
import pricing.model.CommandLine;
import pricing.model.Discount;
import pricing.model.PriceUnitProduct;
import pricing.model.Product;
import pricing.model.Unity;

public class InitData {
	
	private ManageData manageData;

	public InitData() {
		
		manageData = new ManageDataImpl();
	}
	
	public void init() {
		
		Product soup = new Product(1,"Soup");
		
		Product bread = new Product(2,"Bread");
		
		Product milk = new Product(3,"Milk");
		
		Product apple = new Product(4,"Apple");
		
		manageData.addProduct(soup);
		manageData.addProduct(bread);
		manageData.addProduct(milk);
		manageData.addProduct(apple);
		
		Unity tin = new Unity(1,"Tin");
		Unity loaf = new Unity(2,"Loaf");
		Unity bottle = new Unity(3,"Bottle");
		Unity bag = new Unity(4,"Bag");
		
		manageData.addUnity(tin);
		manageData.addUnity(loaf);
		manageData.addUnity(bottle);
		manageData.addUnity(bag);
		
		
		PriceUnitProduct tinOfSoup = new PriceUnitProduct(1,soup,tin,0.65);
		
		PriceUnitProduct loafOfBread = new PriceUnitProduct(2,bread,loaf,0.80);
		
		PriceUnitProduct bottleOfMilk = new PriceUnitProduct(3,milk,bottle,1.30);
		
		PriceUnitProduct bagOfApple = new PriceUnitProduct(4,apple,bag,1.00);
		
		manageData.addPriceUnitProduct(tinOfSoup);
		manageData.addPriceUnitProduct(loafOfBread);
		manageData.addPriceUnitProduct(bottleOfMilk);
		manageData.addPriceUnitProduct(bagOfApple);
		
		CommandLine soupCommand =new CommandLine();
		soupCommand.setIdLigneCommande(1);
		soupCommand.setProduct(soup);
		soupCommand.setUnity(tin);
		soupCommand.setQuantity(5);
		
		CommandLine breadCommand =new CommandLine();
		breadCommand.setIdLigneCommande(2);
		breadCommand.setProduct(bread);
		breadCommand.setUnity(loaf);
		breadCommand.setQuantity(5);
		
		CommandLine milkCommand =new CommandLine();
		milkCommand.setIdLigneCommande(3);
		milkCommand.setProduct(milk);
		milkCommand.setUnity(bottle);
		milkCommand.setQuantity(5);
		
		CommandLine appleCommand =new CommandLine();
		appleCommand.setIdLigneCommande(4);
		appleCommand.setProduct(apple);
		appleCommand.setUnity(bag);
		appleCommand.setQuantity(6);
		
		manageData.addCommandLine(soupCommand);
		manageData.addCommandLine(breadCommand);
		manageData.addCommandLine(milkCommand);
		manageData.addCommandLine(appleCommand);
		
			
		Discount customDiscountBread = new Discount();
		customDiscountBread.setIdDiscount(1);
		customDiscountBread.setProductToDiscount(bread);
		customDiscountBread.setUnityToDiscount(loaf);
		customDiscountBread.setProductGivingDiscount(soup);
		customDiscountBread.setUnityOfGivingDiscount(tin);
		customDiscountBread.setQuantityGivendiscount(2);
		customDiscountBread.setQuantityToDiscount(1);
		customDiscountBread.setPercentageOfDiscount(50);
		
		
		Discount customDiscountApple = new Discount();
		customDiscountApple.setIdDiscount(2);
		customDiscountApple.setProductToDiscount(apple);
		customDiscountApple.setUnityToDiscount(bag);
		customDiscountApple.setProductGivingDiscount(apple);
		customDiscountApple.setUnityOfGivingDiscount(bag);
		customDiscountApple.setQuantityGivendiscount(1);
		customDiscountApple.setQuantityToDiscount(1);
		customDiscountApple.setPercentageOfDiscount(10); // percentage of discount of the product
				
				
		
		manageData.addDiscount(customDiscountBread);
		manageData.addDiscount(customDiscountApple);
	}

}
